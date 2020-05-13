package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.domain.Tag;
import com.jqlmh.nano.model.dto.Archive;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.repository.PostRepository;
import com.jqlmh.nano.service.PostService;
import com.jqlmh.nano.util.NanoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:04
 */
@Service
public class PostServiceImpl implements PostService {


	@Autowired
	private PostRepository postRepository;

	/**
	 * 新增文章
	 *
	 * @param post Post
	 * @return Post
	 */
	@Override
	public Post saveByPost(Post post) {
		return postRepository.save(post);
	}


	/**
	 * 获取文章列表 不分页
	 *
	 * @param postType post or page
	 * @return List<Post></>
	 */
	@Override
	public List<Post> findAllPosts(String postType) {
		return postRepository.findPostsByPostType(postType);
	}


	/**
	 * 查询归档信息 根据年份和月份分组
	 *
	 * @return List
	 */
	@Override
	public List<Archive> findPostGroupByYearAndMonth() {
		List<Object[]> postGroupByYearAndMonth = postRepository.findPostGroupByYearAndMonth();

		List<Archive> archives = new ArrayList<>();
		Archive archive = null;
		for (Object[] objects : postGroupByYearAndMonth) {
			archive = new Archive();
			archive.setYear(objects[0].toString());
			archive.setMonth(objects[1].toString());
			archive.setCount(objects[2].toString());
			archive.setPosts(findPostByYearAndMonth(objects[0].toString(), objects[1].toString()));
			archives.add(archive);
		}
		return archives;
	}


	/**
	 * 根据年份和月份查询文章
	 *
	 * @param year  year
	 * @param month month
	 * @return list
	 */
	@Override
	public List<Post> findPostByYearAndMonth(String year, String month) {
		return postRepository.findPostByYearAndMonth(year, month);
	}

	/**
	 * 查询归档信息 根据年份
	 *
	 * @return list
	 */
	@Override
	public List<Archive> findPostGroupByYear() {
		List<Object[]> objects = postRepository.findPostGroupByYear();
		List<Archive> archives = new ArrayList<>();
		Archive archive = null;
		for (Object[] object : objects) {
			archive = new Archive();
			archive.setYear(object[0].toString());
			archive.setCount(object[1].toString());
			archive.setPosts(findPostByYear(object[0].toString()));
			archives.add(archive);
		}
		return archives;
	}

	/**
	 * 根据年份查询文章
	 *
	 * @param year year
	 * @return list
	 */
	@Override
	public List<Post> findPostByYear(String year) {
		return postRepository.findPostByYear(year);
	}


	/**
	 * 根据文章状态查询 分页
	 *
	 * @param postStatus 0，1，2
	 * @param postType   post or page
	 * @param pageable   分页信息
	 * @return Page<Post></>
	 */
	@Override
	public Page<Post> findPostByStatus(Integer postStatus, String postType, Pageable pageable) {
		return postRepository.findPostsByPostStatusAndPostType(postStatus, postType, pageable);
	}

	/**
	 * 查询前五条数据
	 *
	 * @return List
	 */
	@Override
	public List<Post> findPostLatest() {
		return postRepository.getTopFive();
	}


	/**
	 * 根据文章路径查询这篇文章
	 *
	 * @param postUrl  路径
	 * @param postType post or page
	 * @return Post
	 */
	@Override
	public Post findByPostUrl(String postUrl, String postType) {
		return postRepository.findPostsByPostUrlAndPostType(postUrl, postType);
	}

	/**
	 * 查询该篇文章发布之前的所有文章
	 *
	 * @param postDate postDate
	 * @return list
	 */
	@Override
	public List<Post> findByPostDateBefore(Date postDate) {
		return postRepository.findByPostDateBeforeAndPostStatusAndPostTypeOrderByPostDateAsc(
				postDate, 0, NanoConst.POST_TYPE_POST);
	}

	/**
	 * 查询该篇文章发布之后的所有文章
	 *
	 * @param postDate postDate
	 * @return list
	 */
	@Override
	public List<Post> findByPostDateAfter(Date postDate) {
		return postRepository.findByPostDateAfterAndPostStatusAndPostTypeOrderByPostDateDesc(
				postDate, 0, NanoConst.POST_TYPE_POST);
	}


	/**
	 * 根据编号查询文章
	 *
	 * @param postId postId
	 * @return Post
	 */
	@Override
	public Optional<Post> findByPostId(Long postId) {
		return postRepository.findById(postId);
	}


	/**
	 * 根据关键字模糊查询文章,分页
	 *
	 * @param keyWord  keyword
	 * @param pageable pageable
	 * @return list
	 */
	@Override
	public List<Post> searchPosts(String keyWord, Pageable pageable) {

		return postRepository.findByPostTitleLike(keyWord, pageable);
	}

	/**
	 * 修改文章状态
	 *
	 * @param postId postId
	 * @param status status
	 * @return Post
	 */
	@Override
	public Post updatePostStatus(Long postId, Integer status) {
		Optional<Post> optional = findByPostId(postId);
		if (!optional.isPresent()) {
			return null;
		}
		Post post = optional.get();
		post.setPostStatus(status);
		postRepository.save(post);
		return post;
	}


	/**
	 * 根据编号删除文章
	 *
	 * @param postId postId
	 * @return Post
	 */
	@Override
	public Post removeByPostId(Long postId) {
		Optional<Post> optional = findByPostId(postId);
		if (!optional.isPresent()) {
			return null;
		}
		postRepository.delete(optional.get());
		return optional.get();
	}


	/**
	 * 批量修改摘要[后台博客设置的时候可以一键更新]
	 *
	 * @param postSummary postSummary
	 */
	@Override
	public void updateAllSummary(Integer postSummary) {
		List<Post> posts = findAllPosts(NanoConst.POST_TYPE_POST);
		for (Post post : posts) {
			if (!(NanoUtil.htmlToText(post.getPostContent()).length() < postSummary)) {
				post.setPostSummary(NanoUtil.getSummary(post.getPostContent(), postSummary));
				postRepository.save(post);
			}
		}
	}

	/**
	 * 生成rss
	 *
	 * @param posts posts
	 * @return string
	 */
	@Override
	public String buildRss(List<Post> posts) {
		String rss = "";
		try {
			rss = NanoUtil.getRss(posts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}

	/**
	 * 生成sitemap
	 *
	 * @param posts posts
	 * @return string
	 */
	@Override
	public String buildSiteMap(List<Post> posts) {
		return NanoUtil.getSiteMap(posts);
	}

	/**
	 * 根据标签查询文章
	 *
	 * @param tag      tag
	 * @param pageable pageable
	 * @return page
	 */
	@Override
	public Page<Post> findPostsByTags(Tag tag, Pageable pageable) {
		return postRepository.findPostsByTags(tag, pageable);
	}
}
