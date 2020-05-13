package com.jqlmh.nano.model.tag;

import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.PostService;
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
public class ArticleTagDirective implements TemplateDirectiveModel {

	private static final String METHOD_KEY = "method";

	@Autowired
	private PostService postService;

	@Override
	public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
		DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		if (map.containsKey(METHOD_KEY)) {
			String method = map.get(METHOD_KEY).toString();
			switch (method) {
				case "postsCount":
					environment.setVariable("postsCount", builder.build().wrap(postService.findAllPosts(NanoConst.POST_TYPE_POST).size()));
					break;
				case "archives":
					environment.setVariable("archives", builder.build().wrap(postService.findPostGroupByYearAndMonth()));
					break;
				case "archivesLess":
					environment.setVariable("archivesLess", builder.build().wrap(postService.findPostGroupByYear()));
					break;
				default:
					break;
			}
		}
		templateDirectiveBody.render(environment.getOut());
	}
}