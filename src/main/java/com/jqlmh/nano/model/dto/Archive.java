package com.jqlmh.nano.model.dto;

import com.jqlmh.nano.model.domain.Post;
import lombok.Data;

import java.util.List;

/**
 * 文章归档数据
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:44
 */
@Data
public class Archive {

	/**
	 * 年份
	 */
	private String year;

	/**
	 * 月份
	 */
	private String month;

	/**
	 * 对应的文章数
	 */
	private String count;

	/**
	 * 对应的文章
	 */
	private List<Post> posts;
}
