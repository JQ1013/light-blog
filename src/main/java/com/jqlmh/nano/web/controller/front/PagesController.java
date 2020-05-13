package com.jqlmh.nano.web.controller.front;

import com.jqlmh.nano.model.domain.Gallery;
import com.jqlmh.nano.model.domain.Link;
import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.GalleryService;
import com.jqlmh.nano.service.LinkService;
import com.jqlmh.nano.service.PostService;
import com.jqlmh.nano.web.controller.core.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-03-18 17:23
 */
@Controller
public class PagesController extends BaseController {

	@Autowired
	private GalleryService galleryService;

	@Autowired
	private PostService postService;

	@Autowired
	private LinkService linkService;

	/**
	 * 跳转到图库页面
	 *
	 * @return 模板路径/themes/{THEME}/gallery
	 */
	@GetMapping(value = "/gallery")
	public String gallery(Model model) {
		List<Gallery> galleries = galleryService.findAllGalleries();
		model.addAttribute("galleries", galleries);
		return this.render("gallery");
	}

	/**
	 * 友情链接
	 *
	 * @param model model
	 * @return 模板路径/themes/{THEME}/links
	 */
	@GetMapping(value = "/links")
	public String links(Model model) {
		//所有友情链接
		List<Link> links = linkService.findAllLinks();
		model.addAttribute("links", links);
		return this.render("links");
	}

	/**
	 * 渲染自定义页面
	 *
	 * @param postUrl 页面路径
	 * @param model   model
	 * @return 模板路径/themes/{THEME}/post
	 */
	@GetMapping(value = "/p/{postUrl}")
	public String getPage(@PathVariable(value = "postUrl") String postUrl, Model model) {
		Post post = postService.findByPostUrl(postUrl, NanoConst.POST_TYPE_PAGE);
		model.addAttribute("post", post);
		return this.render("post");
	}
}
