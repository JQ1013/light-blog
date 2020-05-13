package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 博客图库实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:34
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_gallery")
public class Gallery implements Serializable {

	private static final long serialVersionUID = 8639596238773099048L;

	/**
	 * 图片编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long galleryId;

	/**
	 * 图片名称
	 */
	private String galleryName;

	/**
	 * 图片描述
	 */
	private String galleryDesc;

	/**
	 * 图片日期/拍摄日期
	 */
	private String galleryDate;

	/**
	 * 图片拍摄地点
	 */
	private String galleryLocation;

	/**
	 * 图片缩略图地址
	 */
	private String galleryThumbnailUrl;

	/**
	 * 图片地址
	 */
	private String galleryUrl;
}
