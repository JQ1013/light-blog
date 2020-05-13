package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Comment;
import com.jqlmh.nano.model.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:04
 */
public interface CommentService {
	/**
	 * 新增评论
	 *
	 * @param comment comment
	 */
	void saveByComment(Comment comment);

	/**
	 * 根据评论状态查询该状态的所有评论
	 *
	 * @param status 评论状态
	 * @return list
	 */
	List<Comment> findAllComments(Integer status);

	/**
	 * 查询所有评论，不分页
	 *
	 * @return list
	 */
	List<Comment> findAllComments();

	/**
	 * 查询最新的前五条评论
	 *
	 * @return list
	 */
	List<Comment> findCommentsLatest();

	/**
	 * 根据状态查询所有的评论，用于后台管理
	 *
	 * @param status   status
	 * @param pageable pageable
	 * @return page
	 */
	Page<Comment> findAllComments(Integer status, Pageable pageable);

	/**
	 * 根据评论id更改评论的状态
	 *
	 * @param commentId commentId
	 * @param status    status
	 * @return comment
	 */
	Comment updateCommentStatus(Long commentId, Integer status);


	/**
	 * 根据评论编号查询评论
	 *
	 * @param commentId commentId
	 * @return comment
	 */
	Optional<Comment> findCommentById(Long commentId);

	/**
	 * 根据commentId删除评论
	 *
	 * @param commentId commentId
	 * @return comment
	 */
	Optional<Comment> removeByCommentId(Long commentId);

	/**
	 * 根据postId查出的文章和评论状态查询评论
	 *
	 * @param post     post
	 * @param pageable pageable
	 * @param status   status
	 * @return page
	 */
	Page<Comment> findCommentsByPostAndCommentStatus(Post post, Pageable pageable, Integer status);
}
