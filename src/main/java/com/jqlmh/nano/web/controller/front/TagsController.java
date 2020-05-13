package com.jqlmh.nano.web.controller.front;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.domain.Tag;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.PostService;
import com.jqlmh.nano.service.TagService;
import com.jqlmh.nano.web.controller.core.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-03-18 17:16
 */
@Controller
@RequestMapping(value = "/tags")
public class TagsController extends BaseController {

	@Autowired
	private TagService tagService;

	@Autowired
	private PostService postService;

	/**
	 * 标签
	 *
	 * @param model model
	 * @return 模板路径/themes/{THEME}/tags
	 */
	@GetMapping
	public String tags(Model model) {
		//所有标签
		List<Tag> tags = tagService.findAllTags();
		model.addAttribute("tags", tags);
		return this.render("tags");
	}

	/**
	 * 根据标签路径查询所有文章
	 *
	 * @param tagUrl 标签路径
	 * @param model  model
	 * @return string
	 */
	@GetMapping(value = "{tagUrl}")
	public String tags(Model model,
					   @PathVariable("tagUrl") String tagUrl) {
		return this.tags(model, tagUrl, 1);
	}

	/**
	 * 根据标签路径查询所有文章 分页
	 *
	 * @param model  model
	 * @param tagUrl 标签路径
	 * @param page   页码
	 * @return string
	 */
	@GetMapping(value = "{tagUrl}/page/{page}")
	public String tags(Model model,
					   @PathVariable("tagUrl") String tagUrl,
					   @PathVariable("page") Integer page) {
		Tag tag = tagService.findByTagUrl(tagUrl);
		Sort sort = new Sort(Sort.Direction.DESC, "postDate");
		Integer size = 10;
		if (!StringUtils.isBlank(NanoConst.OPTIONS.get("index_posts"))) {
			size = Integer.parseInt(NanoConst.OPTIONS.get("index_posts"));
		}
		Pageable pageable = PageRequest.of(page - 1, size, sort);
		Page<Post> posts = postService.findPostsByTags(tag, pageable);
		model.addAttribute("posts", posts);
		model.addAttribute("tag", tag);
		return this.render("index");
	}
}
