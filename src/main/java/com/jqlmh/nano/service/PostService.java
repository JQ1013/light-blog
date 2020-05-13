package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.domain.Tag;
import com.jqlmh.nano.model.dto.Archive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:03
 */
public interface PostService {

	/**
	 * 新增文章
	 *
	 * @param post Post
	 * @return Post
	 */
	Post saveByPost(Post post);

	/**
	 * 获取文章列表 不分页
	 *
	 * @param postType post or page
	 * @return List<Post></>
	 */
	List<Post> findAllPosts(String postType);

	/**
	 * 查询归档信息 根据年份和月份
	 *
	 * @return List
	 */
	List<Archive> findPostGroupByYearAndMonth();


	/**
	 * 根据年份和月份查询文章
	 *
	 * @param year  year
	 * @param month month
	 * @return list
	 */
	List<Post> findPostByYearAndMonth(String year, String month);

	/**
	 * 查询归档信息 根据年份
	 *
	 * @return list
	 */
	List<Archive> findPostGroupByYear();


	/**
	 * 根据年份查询文章
	 *
	 * @param year year
	 * @return list
	 */
	List<Post> findPostByYear(String year);

	/**
	 * 根据文章状态查询 分页
	 *
	 * @param postStatus 0，1，2
	 * @param postType   post or page
	 * @param pageable   分页信息
	 * @return Page<Post></>
	 */
	Page<Post> findPostByStatus(Integer postStatus, String postType, Pageable pageable);

	/**
	 * 查询前五条数据
	 *
	 * @return List
	 */
	List<Post> findPostLatest();

	/**
	 * 根据文章路径查询这篇文章
	 *
	 * @param postUrl  路径
	 * @param postType post or page
	 * @return Post
	 */
	Post findByPostUrl(String postUrl, String postType);

	/**
	 * 查询该篇文章发布之前的所有文章
	 *
	 * @param postDate postDate
	 * @return list
	 */
	List<Post> findByPostDateBefore(Date postDate);

	/**
	 * 查询该篇文章发布之后的所有文章
	 *
	 * @param postDate postDate
	 * @return list
	 */
	List<Post> findByPostDateAfter(Date postDate);

	/**
	 * 根据编号查询文章
	 *
	 * @param postId postId
	 * @return Post
	 */
	Optional<Post> findByPostId(Long postId);

	/**
	 * 根据关键字模糊查询文章,分页
	 *
	 * @param keyWord  keyword
	 * @param pageable pageable
	 * @return list
	 */
	List<Post> searchPosts(String keyWord, Pageable pageable);

	/**
	 * 修改文章状态
	 *
	 * @param postId postId
	 * @param status status
	 * @return Post
	 */
	Post updatePostStatus(Long postId, Integer status);

	/**
	 * 根据编号删除文章
	 *
	 * @param postId postId
	 * @return Post
	 */
	Post removeByPostId(Long postId);

	/**
	 * 批量修改摘要
	 *
	 * @param postSummary postSummary
	 */
	void updateAllSummary(Integer postSummary);

	/**
	 * 生成rss
	 *
	 * @param posts posts
	 * @return string
	 */
	String buildRss(List<Post> posts);

	/**
	 * 生成sitemap
	 *
	 * @param posts posts
	 * @return string
	 */
	String buildSiteMap(List<Post> posts);

	/**
	 * 根据标签查询文章
	 *
	 * @param tag      tag
	 * @param pageable pageable
	 * @return page
	 */
	Page<Post> findPostsByTags(Tag tag, Pageable pageable);
}
