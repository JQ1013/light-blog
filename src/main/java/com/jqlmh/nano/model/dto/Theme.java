package com.jqlmh.nano.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 主题数据
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:44
 */
@Data
public class Theme implements Serializable {

	private static final long serialVersionUID = -2383589684136488369L;
	/**
	 * 主题名称
	 */
	private String themeName;

	/**
	 * 是否支持设置
	 */
	private boolean hasOptions;
}
