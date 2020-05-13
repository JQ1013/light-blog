package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:44
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_attachment")
public class Attachment implements Serializable {

	private static final long serialVersionUID = 1861915393250224146L;

	/**
	 * 附件编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attachId;

	/**
	 * 附件名
	 */
	private String attachName;

	/**
	 * 附件路径
	 */
	private String attachPath;

	/**
	 * 附件缩略图路径
	 */
	private String attachSmallPath;

	/**
	 * 附件类型
	 */
	private String attachType;

	/**
	 * 附件后缀
	 */
	private String attachSuffix;

	/**
	 * 上传时间
	 */
	private Date attachCreated;
}
