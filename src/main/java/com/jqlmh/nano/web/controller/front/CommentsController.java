package com.jqlmh.nano.web.controller.front;

import com.jqlmh.nano.model.domain.Comment;
import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.CommentService;
import com.jqlmh.nano.service.MailService;
import com.jqlmh.nano.service.PostService;
import com.jqlmh.nano.service.UserService;
import com.jqlmh.nano.util.NanoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-04-16 10:38
 */
@Slf4j
@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	/**
	 * 获取文章的评论
	 *
	 * @param postId postId 文章编号
	 * @return List<Comment>集合</>
	 */
	@GetMapping(value = "/getComment/{postId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<Comment> getComment(@PathVariable Long postId) {
		Optional<Post> post = postService.findByPostId(postId);
		Sort sort = new Sort(Sort.Direction.DESC, "commentDate");
		Pageable pageable = PageRequest.of(0, 10, sort);
		List<Comment> comments = commentService.findCommentsByPostAndCommentStatus(post.get(), pageable, 0).getContent();
		if (null == comments) {
			return null;
		}
		return comments;
	}

	/**
	 * 提交新评论
	 *
	 * @param comment comment实体
	 * @param post    post实体
	 * @param request request
	 * @return true：评论成功，false：评论失败
	 */
	@PostMapping(value = "/newComment")
	@ResponseBody
	public boolean newComment(@ModelAttribute("comment") Comment comment,
							  @ModelAttribute("post") Post post,
							  HttpServletRequest request) {
		if (StringUtils.isBlank(comment.getCommentAuthor())) {
			comment.setCommentAuthor("Anonymous");
		}
		comment.setCommentAuthorEmail(comment.getCommentAuthorEmail().toLowerCase());
		comment.setPost(post);
		comment.setCommentDate(new Date());
		comment.setCommentAuthorIp(NanoUtil.getIpAddr(request));
		comment.setIsAdmin(0);
		commentService.saveByComment(comment);

		if (StringUtils.equals(NanoConst.OPTIONS.get("smtp_email_enable"), "true") && StringUtils.equals(NanoConst.OPTIONS.get("new_comment_notice"), "true")) {
			try {
				//发送邮件到博主
				Map<String, Object> map = new HashMap<>();
				map.put("author", userService.findAllUser().getUserDisplayName());
				map.put("pageName", postService.findByPostId(post.getPostId()).get().getPostTitle());
				map.put("blogUrl", NanoConst.OPTIONS.get("blog_url"));
				map.put("visitor", comment.getCommentAuthor());
				map.put("commentContent", comment.getCommentContent());
				mailService.sendTemplateMail(userService.findAllUser().getUserEmail(), "有新的评论", map, "common/mail/mail_admin.ftl");
			} catch (Exception e) {
				log.error("邮件服务器未配置!!!", e.getMessage());
			}
		}
		return true;
	}
}
