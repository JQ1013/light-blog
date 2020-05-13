package com.jqlmh.nano.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 安装博客的拦截器:判断是否已经安装
 *
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 12:30
 */
@Component
public class InstallInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
		File installFile = new File(basePath.getAbsolutePath(), "install.lock");
		if (installFile.exists()) {
			return true;
		}
		response.sendRedirect("/install");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
