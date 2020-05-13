package com.jqlmh.nano.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:33
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_post")
public class Post implements Serializable {
	private static final long serialVersionUID = -742038150687660659L;

	/**
	 * 文章编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;

	/**
	 * 发表用户,多对一
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * 文章标题
	 */
	private String postTitle;

	/**
	 * 文章类型
	 * 文章:post
	 * 页面:page
	 */
	private String postType = "post";

	/**
	 * 文章格式:MarkDown格式
	 */
	private String postContentMd;

	/**
	 * 文章格式:html格式
	 */
	private String postContent;

	/**
	 * 文章路径
	 */
	@Column(unique = true)
	private String postUrl;

	/**
	 * 文章摘要
	 */
	private String postSummary;

	/**
	 * 文章所属分类:多对多
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "nano_posts_categories",
			joinColumns = {@JoinColumn(name = "post_id", nullable = false)},
			inverseJoinColumns = {@JoinColumn(name = "cate_id", nullable = false)})
	private List<Category> categories = new ArrayList<>();

	/**
	 * 文章所属标签:多对多
	 */
	@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinTable(name = "nano_posts_tags",
			joinColumns = {@JoinColumn(name = "post_id", nullable = false)},
			inverseJoinColumns = {@JoinColumn(name = "tag_id", nullable = false)})
	private List<Tag> tags = new ArrayList<>();

	/**
	 * 文章的评论:一对多
	 */
	@OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Comment> comments = new ArrayList<>();

	/**
	 * 缩略图
	 */
	private String postThumbnail;

	/**
	 * 发表日期
	 */
	private Date postDate;

	/**
	 * 0 已发布
	 * 1 草稿
	 * 2 回收站
	 */
	private Integer postStatus = 0;
}
