package com.jqlmh.nano.model.tag;

import com.jqlmh.nano.service.CategoryService;
import com.jqlmh.nano.service.CommentService;
import com.jqlmh.nano.service.MenuService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * FreeMarker配置
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:27
 */
@Component
public class CommonTagDirective implements TemplateDirectiveModel {

	private static final String METHOD_KEY = "method";

	@Autowired
	private MenuService menuService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	@Override
	public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
		DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		if (map.containsKey(METHOD_KEY)) {
			String method = map.get(METHOD_KEY).toString();
			switch (method) {
				case "menus":
					environment.setVariable("menus", builder.build().wrap(menuService.findAllMenus()));
					break;
				case "categories":
					environment.setVariable("categories", builder.build().wrap(categoryService.findAllCategories()));
					break;
				case "newComments":
					environment.setVariable("newComments", builder.build().wrap(commentService.findAllComments(1)));
					break;
				default:
					break;
			}
		}
		templateDirectiveBody.render(environment.getOut());
	}
}
