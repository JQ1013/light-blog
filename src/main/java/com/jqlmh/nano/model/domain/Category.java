package com.jqlmh.nano.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章分类目录实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:45
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_category")
public class Category implements Serializable {

	private static final long serialVersionUID = 3308033359004748661L;

	/**
	 * 分类编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cateId;

	/**
	 * 分类名称
	 */
	private String cateName;

	/**
	 * 分类路径
	 */
	private String cateUrl;

	/**
	 * 分类描述
	 */
	private String cateDesc;

	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private List<Post> posts = new ArrayList<>();
}
