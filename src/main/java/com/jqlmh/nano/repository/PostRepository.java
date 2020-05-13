package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:12
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	/**
	 * 查询所有文章 根据文章类型
	 *
	 * @param postType post or page
	 * @return List<Post></>
	 */
	List<Post> findPostsByPostType(String postType);


	/**
	 * 查询文章归档信息 根据年份和月份分组
	 *
	 * @return List<Object [ ]></>
	 */
	@Query(value = "select year(post_date) as year,month(post_date) as month,count(*) as count from nano_post where post_status=0 and post_type='post' group by year(post_date),month(post_date) order by year desc,month desc", nativeQuery = true)
	List<Object[]> findPostGroupByYearAndMonth();


	/**
	 * 根据年份和月份查询文章
	 *
	 * @param year  year
	 * @param month month
	 * @return List<Post></>
	 */
	@Query(value = "select *,year(post_date) as year,month(post_date) as month from nano_post where post_status=0 and post_type='post' and year(post_date)=:year and month(post_date)=:month order by post_date desc", nativeQuery = true)
	List<Post> findPostByYearAndMonth(@Param("year") String year, @Param("month") String month);


	/**
	 * 查询文章归档信息 根据年份
	 *
	 * @return List<Object [ ]></>
	 */
	@Query(value = "select year(post_date) as year,count(*) as count from nano_post where post_status=0 and post_type='post' group by year(post_date) order by year desc", nativeQuery = true)
	List<Object[]> findPostGroupByYear();


	/**
	 * 根据年份查询文章
	 *
	 * @param year year
	 * @return list
	 */
	@Query(value = "select *,year(post_date) as year from nano_post where post_status=0 and post_type='post' and year(post_date)=:year order by post_date desc", nativeQuery = true)
	List<Post> findPostByYear(@Param("year") String year);


	/**
	 * 根据文章状态查询 分页
	 *
	 * @param postStatus 0，1，2
	 * @param postType   post or page
	 * @param pageable   分页信息
	 * @return Page<Post></>
	 */
	Page<Post> findPostsByPostStatusAndPostType(Integer postStatus, String postType, Pageable pageable);

	/**
	 * 查询前五条文章
	 *
	 * @return list
	 */
	@Query(value = "SELECT * FROM nano_post where post_type='post' ORDER BY post_date DESC LIMIT 5", nativeQuery = true)
	List<Post> getTopFive();


	/**
	 * 根据文章路径查询这篇文章
	 *
	 * @param postUrl  路径
	 * @param postType post or page
	 * @return Post
	 */
	Post findPostsByPostUrlAndPostType(String postUrl, String postType);

	/**
	 * 查询该篇文章发布之前的所有文章
	 *
	 * @param postDate postDate
	 * @return list
	 */
	List<Post> findByPostDateBeforeAndPostStatusAndPostTypeOrderByPostDateAsc(Comparable<Date> postDate, Integer postStatus, String postType);

	/**
	 * 查询之后文章
	 *
	 * @param postDate   发布时间
	 * @param postStatus 0，1，2
	 * @param postType   post or page
	 * @return List<Post></>
	 */
	List<Post> findByPostDateAfterAndPostStatusAndPostTypeOrderByPostDateDesc(Date postDate, Integer postStatus, String postType);

	/**
	 * 根据关键字模糊查询文章,分页
	 *
	 * @param keyWord  keyword
	 * @param pageable pageable
	 * @return list
	 */
	List<Post> findByPostTitleLike(String keyWord, Pageable pageable);

	/**
	 * 根据标签查询文章
	 *
	 * @param tag      tag
	 * @param pageable pageable
	 * @return page
	 */
	Page<Post> findPostsByTags(Tag tag, Pageable pageable);
}
