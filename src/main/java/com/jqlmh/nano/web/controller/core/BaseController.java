package com.jqlmh.nano.web.controller.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:38
 */
@Slf4j
@Controller
public class BaseController {

	/**
	 * 定义默认主题
	 */
	public static String THEME = "anatole";

	/**
	 * 根据主题名称渲染页面
	 *
	 * @param pageName pageName
	 * @return 返回拼接好的模板路径
	 */
	public String render(String pageName) {
		System.out.println(THEME);
		return "themes/" + THEME + "/" + pageName;
	}
}
