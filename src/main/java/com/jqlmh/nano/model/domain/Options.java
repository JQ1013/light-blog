package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 博客设置项:博客名称、是否启动邮件等
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:24
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_options")
public class Options implements Serializable {

	private static final long serialVersionUID = 1526411202887466904L;

	/**
	 * 设置项名称
	 */
	@Id
	private String optionName;

	/**
	 * 设置项的值
	 */
	@Lob
	private String optionValue;
}
