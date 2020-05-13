package com.jqlmh.nano.config;

import com.jqlmh.nano.web.interceptor.InstallInterceptor;
import com.jqlmh.nano.web.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器和静态资源路径
 *
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 12:29
 */
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.jqlmh.nano.web.controller")
@PropertySource(value = "classpath:application.yaml", ignoreResourceNotFound = true, encoding = "UTF-8")
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Autowired
	private InstallInterceptor installInterceptor;

	/**
	 * 注册拦截器
	 *
	 * @param registry registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/admin/**")
				.excludePathPatterns("/admin/login")
				.excludePathPatterns("/admin/getLogin")
				.excludePathPatterns("/static/**");
		registry.addInterceptor(installInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/install")
				.excludePathPatterns("/install/do")
				.excludePathPatterns("/static/**");
	}

	/**
	 * 配置静态资源路径
	 *
	 * @param registry registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/templates/themes/")
				.addResourceLocations("classpath:/robots.txt");
		registry.addResourceHandler("/upload/**")
				.addResourceLocations("classpath:/upload/");
	}
}
