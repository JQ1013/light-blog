package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Comment;
import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.repository.CommentRepository;
import com.jqlmh.nano.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:04
 */
@Service
public class CommentServiceImpl implements CommentService {


	@Autowired
	private CommentRepository commentRepository;

	/**
	 * 新增评论
	 *
	 * @param comment comment
	 */
	@Override
	public void saveByComment(Comment comment) {
		commentRepository.save(comment);
	}

	/**
	 * 根据评论状态查询评论:不分页
	 *
	 * @param status 评论状态
	 * @return list
	 */
	@Override
	public List<Comment> findAllComments(Integer status) {
		return commentRepository.findCommentsByCommentStatus(status);
	}


	/**
	 * 查询所有评论，不分页
	 *
	 * @return list
	 */
	@Override
	public List<Comment> findAllComments() {
		return commentRepository.findAll();
	}


	/**
	 * 查询最新的前五条评论
	 *
	 * @return list
	 */
	@Override
	public List<Comment> findCommentsLatest() {
		return commentRepository.getTopFive();
	}

	/**
	 * 根据状态查询所有的评论，要分页
	 *
	 * @param status   status
	 * @param pageable pageable
	 * @return page
	 */
	@Override
	public Page<Comment> findAllComments(Integer status, Pageable pageable) {
		return commentRepository.findCommentsByCommentStatus(status, pageable);
	}

	/**
	 * 根据评论id更改评论的状态
	 *
	 * @param commentId commentId
	 * @param status    status
	 * @return comment
	 */
	@Override
	public Comment updateCommentStatus(Long commentId, Integer status) {
		Optional<Comment> optional = this.findCommentById(commentId);
		if (optional.isPresent()) {
			optional.get().setCommentStatus(status);
		}
		return commentRepository.save(optional.get());
	}

	/**
	 * 根据评论编号查询评论
	 *
	 * @param commentId commentId
	 * @return comment
	 */
	@Override
	public Optional<Comment> findCommentById(Long commentId) {
		return commentRepository.findById(commentId);
	}


	/**
	 * 根据commentId删除评论
	 *
	 * @param commentId commentId
	 * @return Optional<Comment>
	 */
	@Override
	public Optional<Comment> removeByCommentId(Long commentId) {
		Optional<Comment> optional = this.findCommentById(commentId);
		commentRepository.delete(optional.get());
		return optional;
	}

	/**
	 * 根据postId查出的文章和评论状态查询评论
	 *
	 * @param post     post
	 * @param pageable pageable
	 * @param status   status
	 * @return page
	 */
	@Override
	public Page<Comment> findCommentsByPostAndCommentStatus(Post post, Pageable pageable, Integer status) {
		return commentRepository.findCommentsByPostAndCommentStatus(post,status,pageable);
	}


}
