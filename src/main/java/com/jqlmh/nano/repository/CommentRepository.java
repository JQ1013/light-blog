package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Comment;
import com.jqlmh.nano.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:13
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


	/**
	 * 根据评论状态查询所有评论 不分页
	 *
	 * @param status 文章状态
	 * @return list
	 */
	List<Comment> findCommentsByCommentStatus(Integer status);

	/**
	 * 查询最新的前五条评论
	 *
	 * @return list
	 */
	@Query(value = "SELECT * FROM nano_comment ORDER BY comment_date DESC LIMIT 5", nativeQuery = true)
	List<Comment> getTopFive();


	/**
	 * 根据状态查询所有的评论，要分页
	 *
	 * @param status   status
	 * @param pageable pageable
	 * @return page
	 */
	Page<Comment> findCommentsByCommentStatus(Integer status, Pageable pageable);

	/**
	 * 根据postId查出的文章和评论状态查询评论
	 *
	 * @param post     post
	 * @param pageable pageable
	 * @param status   status
	 * @return page
	 */
	Page<Comment> findCommentsByPostAndCommentStatus(Post post, Integer status, Pageable pageable);
}
