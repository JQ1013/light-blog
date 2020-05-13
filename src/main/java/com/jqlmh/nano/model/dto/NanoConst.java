package com.jqlmh.nano.model.dto;


import com.jqlmh.nano.model.domain.Attachment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常量类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:44
 */
public class NanoConst {

	/**
	 * 所有设置选项（key,value）
	 */
	public static Map<String, String> OPTIONS = new HashMap<>();

	/**
	 * 所有文件
	 */
	public static List<Attachment> ATTACHMENTS = new ArrayList<>();

	/**
	 * 所有主题
	 */
	public static List<Theme> THEMES = new ArrayList<>();

	/**
	 * user_session
	 */
	public static String USER_SESSION_KEY = "user_session";

	public static String POST_TYPE_POST = "post";

	public static String POST_TYPE_PAGE = "page";
}
