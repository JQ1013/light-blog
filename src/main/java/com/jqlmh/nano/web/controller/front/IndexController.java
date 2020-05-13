package com.jqlmh.nano.web.controller.front;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.PostService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 17:07
 */
@Controller
@RequestMapping(value = {"/", "index"})
public class IndexController extends BaseController {

	@Autowired
	private PostService postService;


	/**
	 * 请求首页
	 *
	 * @param model model
	 * @return 模板路径
	 */
	@GetMapping
	public String index(Model model) {
		//调用方法渲染首页
		return this.index(model, 1);
	}

	/**
	 * 首页分页
	 *
	 * @param model model
	 * @param page  当前页码
	 * @return 模板路径/themes/{THEME}/index
	 */
	@GetMapping(value = "page/{page}")
	public String index(Model model,
						@PathVariable(value = "page") Integer page) {
		//默认显示10条
		int size = 10;
		//尝试加载设置选项，用于设置显示条数
		String index_posts = NanoConst.OPTIONS.get("index_posts");
		if (!StringUtils.isBlank(index_posts)) {
			size = Integer.parseInt(index_posts);
		}
		//所有文章数据，分页[根据发表时间,降序]
		Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "postDate");
		Page<Post> posts = postService.findPostByStatus(0, NanoConst.POST_TYPE_POST, pageable);
		model.addAttribute("posts", posts);

		return this.render("index");
	}

	/**
	 * ajax分页
	 *
	 * @param page page 当前页码
	 * @return List<Post>集合</>
	 */
	@GetMapping(value = "next")
	@ResponseBody
	public List<Post> ajaxIndex(@PathParam(value = "page") Integer page) {
		Sort sort = new Sort(Sort.Direction.DESC, "postDate");
		//默认显示10条
		Integer size = 10;
		//尝试加载设置选项，用于设置显示条数
		if (!StringUtils.isBlank(NanoConst.OPTIONS.get("index_posts"))) {
			size = Integer.parseInt(NanoConst.OPTIONS.get("index_posts"));
		}

		//文章数据，只获取文章，没有分页
		Pageable pageable = PageRequest.of(page - 1, size, sort);
		return postService.findPostByStatus(0, NanoConst.POST_TYPE_POST, pageable).getContent();
	}
}
