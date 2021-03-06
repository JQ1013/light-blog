package com.jqlmh.nano.web.controller.admin;

import com.jqlmh.nano.model.domain.*;
import com.jqlmh.nano.model.dto.LogsRecord;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.CategoryService;
import com.jqlmh.nano.service.LogsService;
import com.jqlmh.nano.service.PostService;
import com.jqlmh.nano.service.TagService;
import com.jqlmh.nano.util.NanoUtil;
import com.jqlmh.nano.web.controller.core.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * 文章系统控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2020-4-12 16:36
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/posts")
public class PostController extends BaseController {

	@Autowired
	private PostService postService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TagService tagService;

	@Autowired
	private LogsService logsService;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 处理后台获取文章列表的请求
	 *
	 * @param model model
	 * @param page  当前页码
	 * @param size  每页显示的条数
	 * @return 模板路径admin/admin_post
	 */
	@GetMapping
	public String posts(Model model,
						@RequestParam(value = "status", defaultValue = "0") Integer status,
						@RequestParam(value = "page", defaultValue = "0") Integer page,
						@RequestParam(value = "size", defaultValue = "10") Integer size) {
		Sort sort = new Sort(Sort.Direction.DESC, "postDate");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Post> posts = postService.findPostByStatus(status, NanoConst.POST_TYPE_POST, pageable);
		model.addAttribute("posts", posts);
		model.addAttribute("publishCount", postService.findPostByStatus(0, NanoConst.POST_TYPE_POST, pageable).getTotalElements());
		model.addAttribute("draftCount", postService.findPostByStatus(1, NanoConst.POST_TYPE_POST, pageable).getTotalElements());
		model.addAttribute("trashCount", postService.findPostByStatus(2, NanoConst.POST_TYPE_POST, pageable).getTotalElements());
		model.addAttribute("status", status);
		return "admin/admin_post";
	}

	/**
	 * 模糊查询文章
	 *
	 * @param model   Model
	 * @param keyword keyword 关键字
	 * @param page    page 当前页码
	 * @param size    size 每页显示条数
	 * @return 模板路径admin/admin_post
	 */
	@PostMapping(value = "/search")
	public String searchPost(Model model,
							 @RequestParam(value = "keyword") String keyword,
							 @RequestParam(value = "page", defaultValue = "0") Integer page,
							 @RequestParam(value = "size", defaultValue = "10") Integer size) {
		try {
			//排序规则
			Sort sort = new Sort(Sort.Direction.DESC, "postId");
			Pageable pageable = PageRequest.of(page, size, sort);
			model.addAttribute("posts", postService.searchPosts(keyword, pageable));
		} catch (Exception e) {
			log.error("未知错误!", e.getMessage());
		}
		return "admin/admin_post";
	}


	/**
	 * 处理跳转到新建文章页面
	 *
	 * @param model model
	 * @return 模板路径admin/admin_editor
	 */
	@GetMapping(value = "/new")
	public String newPost(Model model) {
		List<Category> categories = categoryService.findAllCategories();
		List<Tag> tags = tagService.findAllTags();
		model.addAttribute("categories", categories);
		model.addAttribute("tags", tags);
		return "admin/admin_post_md_editor";
	}

	/**
	 * 添加文章
	 *
	 * @param post     Post实体
	 * @param cateList 分类列表
	 * @param tagList  标签列表
	 * @param session  session
	 */
	@PostMapping(value = "/new/push")
	@ResponseBody
	public void pushPost(@ModelAttribute Post post, @RequestParam("cateList") List<String> cateList, @RequestParam("tagList") String tagList, HttpSession session) {
		try {
			//提取摘要
			int postSummary = 50;
			if (NanoUtil.isNotNull(NanoConst.OPTIONS.get("post_summary"))) {
				postSummary = Integer.parseInt(NanoConst.OPTIONS.get("post_summary"));
			}
			if (NanoUtil.htmlToText(post.getPostContent()).length() > postSummary) {
				String summary = NanoUtil.getSummary(post.getPostContent(), postSummary);
				post.setPostSummary(summary);
			} else {
				post.setPostSummary(NanoUtil.htmlToText(post.getPostContent()));
			}
			post.setPostDate(NanoUtil.getDate());

			//发表用户
			User user = (User) session.getAttribute(NanoConst.USER_SESSION_KEY);
			post.setUser(user);
			List<Category> categories = categoryService.strListToCateList(cateList);
			post.setCategories(categories);
			if (StringUtils.isNotEmpty(tagList)) {
				List<Tag> tags = tagService.strListToTagList(StringUtils.trim(tagList));
				post.setTags(tags);
			}
			postService.saveByPost(post);
			log.info("已发表新文章：" + post.getPostTitle());
			logsService.saveByLogs(new Logs(LogsRecord.PUSH_POST, post.getPostTitle(), NanoUtil.getIpAddr(request), NanoUtil.getDate()));
		} catch (Exception e) {
			log.error("未知错误", e.getMessage());
		}
	}


	/**
	 * 跳转到编辑文章页面
	 *
	 * @param postId 文章编号
	 * @param model  model
	 * @return 模板路径admin/admin_editor
	 */
	@GetMapping(value = "/edit")
	public String editPost(@PathParam("postId") Long postId, Model model) {
		Optional<Post> post = postService.findByPostId(postId);
		model.addAttribute("post", post.get());
		List<Category> categories = categoryService.findAllCategories();
		model.addAttribute("categories", categories);
		return "admin/admin_post_md_editor";
	}


	/**
	 * 处理移至回收站的请求
	 *
	 * @param postId 文章编号
	 * @return 重定向到/admin/posts
	 */
	@GetMapping("/throw")
	public String moveToTrash(@RequestParam("postId") Long postId,
							  @RequestParam("status") Integer status) {
		try {
			postService.updatePostStatus(postId, 2);
			log.info("编号为" + postId + "的文章已被移到回收站");
		} catch (Exception e) {
			log.error("未知错误：{0}", e.getMessage());
		}
		return "redirect:/admin/posts?status=" + status;
	}

	/**
	 * 处理预览文章的请求
	 *
	 * @param postId 文章编号
	 * @param model  model
	 * @return 模板路径/themes/{THEME}/post
	 */
	@GetMapping(value = "/view")
	public String viewPost(@PathParam("postId") Long postId, Model model) {
		Optional<Post> post = postService.findByPostId(postId);
		model.addAttribute("post", post.get());
		return this.render("post");
	}

	/**
	 * 处理状态改为发布的请求
	 *
	 * @param postId 文章编号
	 * @return 重定向到/admin/posts
	 */
	@GetMapping("/revert")
	public String moveToPublish(@RequestParam("postId") Long postId,
								@RequestParam("status") Integer status) {
		try {
			postService.updatePostStatus(postId, 0);
			log.info("编号为" + postId + "的文章已改变为发布状态");
		} catch (Exception e) {
			log.error("未知错误：{0}", e.getMessage());
		}
		return "redirect:/admin/posts?status=" + status;
	}

	/**
	 * 处理删除文章/页面的请求
	 *
	 * @param postId 文章编号
	 * @return 重定向到/admin/posts
	 */
	@GetMapping(value = "/remove")
	public String removePost(@PathParam("postId") Long postId, @PathParam("postType") String postType) {
		try {
			Optional<Post> post = postService.findByPostId(postId);
			postService.removeByPostId(postId);
			logsService.saveByLogs(new Logs(
					LogsRecord.REMOVE_POST,
					post.get().getPostTitle(),
					NanoUtil.getIpAddr(request),
					NanoUtil.getDate()));
		} catch (Exception e) {
			log.error("未知错误：{0}", e.getMessage());
		}
		if (StringUtils.equals(NanoConst.POST_TYPE_POST, postType)) {
			return "redirect:/admin/posts?status=2";
		}
		return "redirect:/admin/page";
	}


	/**
	 * 更新所有摘要
	 *
	 * @param postSummary 文章摘要字数
	 * @return true：更新成功，false：更新失败
	 */
	@GetMapping(value = "/updateSummary")
	@ResponseBody
	public boolean updateSummary(@PathParam("postSummary") Integer postSummary) {
		try {
			postService.updateAllSummary(postSummary);
			return true;
		} catch (Exception e) {
			log.error("未知错误!!", e.getMessage());
			return false;
		}
	}


	/**
	 * 验证文章路径是否已经存在
	 *
	 * @param postUrl 文章路径
	 * @return true：存在，false：不存在
	 */
	@GetMapping(value = "/checkUrl")
	@ResponseBody
	public boolean checkUrlExists(@PathParam("postUrl") String postUrl) {
		Post post = postService.findByPostUrl(postUrl, NanoConst.POST_TYPE_POST);
		return null != post;
	}
}
