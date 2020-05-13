package com.jqlmh.nano.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章标签实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:58
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_tag")
public class Tag implements Serializable {
	private static final long serialVersionUID = -2233592900775260130L;

	/**
	 * 标签编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;

	/**
	 * 标签名称
	 */
	private String tagName;

	/**
	 * 标签路径
	 */
	private String tagUrl;

	/**
	 * 标签下的所有文章:多对多:由Post的属性tags维护关系
	 */
	@ManyToMany(mappedBy = "tags")
	@JsonIgnore
	private List<Post> posts = new ArrayList<>();
}
