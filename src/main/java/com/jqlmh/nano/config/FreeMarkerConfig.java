package com.jqlmh.nano.config;

import com.jqlmh.nano.model.tag.ArticleTagDirective;
import com.jqlmh.nano.model.tag.CommonTagDirective;
import com.jqlmh.nano.service.OptionsService;
import com.jqlmh.nano.service.UserService;
import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * FreeMarker配置
 *
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 12:27
 */
@Slf4j
@Configuration
public class FreeMarkerConfig {

	@Autowired
	private freemarker.template.Configuration configuration;

	@Autowired
	private OptionsService optionsService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommonTagDirective commonTagDirective;

	@Autowired
	private ArticleTagDirective articleTagDirective;

	@PostConstruct
	public void setSharedVariable() {
		configuration.setSharedVariable("commonTag", commonTagDirective);
		configuration.setSharedVariable("articleTag", articleTagDirective);
		try {
			configuration.setSharedVariable("options", optionsService.findAllOptions());
			configuration.setSharedVariable("user", userService.findAllUser());
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
	}
}
