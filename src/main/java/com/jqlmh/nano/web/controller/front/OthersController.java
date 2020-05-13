package com.jqlmh.nano.web.controller.front;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-03-15 22:16
 */
@Controller
public class OthersController {

	@Autowired
	private PostService postService;

	/**
	 * 获取文章rss
	 *
	 * @return rss
	 */
	@GetMapping(value = {"feed", "feed.xml", "atom", "atom.xml"}, produces = "application/rss+xml;charset=UTF-8")
	@ResponseBody
	public String feed() {
		String rssPosts = NanoConst.OPTIONS.get("rss_posts");
		if (StringUtils.isBlank(rssPosts)) {
			rssPosts = "20";
		}
		//获取文章列表并根据时间排序
		Sort sort = new Sort(Sort.Direction.DESC, "postDate");
		Pageable pageable = PageRequest.of(0, Integer.parseInt(rssPosts), sort);
		Page<Post> postsPage = postService.findPostByStatus(0, NanoConst.POST_TYPE_POST, pageable);
		List<Post> posts = postsPage.getContent();
		return postService.buildRss(posts);
	}

	/**
	 * 获取sitemap
	 *
	 * @return sitemap
	 */
	@GetMapping(value = {"sitemap", "sitemap.xml"}, produces = "application/xml;charset=UTF-8")
	@ResponseBody
	public String siteMap() {
		//获取文章列表并根据时间排序
		Sort sort = new Sort(Sort.Direction.DESC, "postDate");
		Pageable pageable = PageRequest.of(0, 999, sort);
		Page<Post> postsPage = postService.findPostByStatus(0, NanoConst.POST_TYPE_POST, pageable);
		List<Post> posts = postsPage.getContent();
		return postService.buildSiteMap(posts);
	}
}
