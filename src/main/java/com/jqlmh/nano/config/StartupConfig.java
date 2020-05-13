package com.jqlmh.nano.config;

import com.jqlmh.nano.model.domain.Attachment;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.model.dto.Theme;
import com.jqlmh.nano.service.AttachmentService;
import com.jqlmh.nano.service.OptionsService;
import com.jqlmh.nano.util.NanoUtil;
import com.jqlmh.nano.web.controller.core.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;
import java.util.Map;

/**
 * 应用启动后做的一下加载工作:启用的主题、设置、附件、所有的主题加载进来
 * 使用BaseController.THEME属性接受启用主题
 * Map接受设置参数
 * List接受附件和所有主题
 *
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:30
 */
@Slf4j
@Configuration
public class StartupConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private OptionsService optionsService;

	@Autowired
	private AttachmentService attachmentService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		this.loadActiveTheme();
		this.loadOptions();
		this.loadFiles();
		this.loadThemes();
	}

	/**
	 * 加载主题设置
	 */
	private void loadThemes() {
		try {
			String themeValue = optionsService.findOneOption("theme");
			if (NanoUtil.isNotNull(themeValue)) {
				BaseController.THEME = themeValue;
			}
		} catch (Exception e) {
			log.error("加载主题设置失败!", e.getMessage());
		}
	}

	/**
	 * 加载设置选项
	 */
	private void loadFiles() {
		try {
			Map<String, String> options = optionsService.findAllOptions();
			if (options != null && !options.isEmpty()) {
				NanoConst.OPTIONS = options;
			}
		} catch (Exception e) {
			log.error("加载设置选项失败!", e.getMessage());
		}

	}

	/**
	 * 加载所有文件
	 */
	private void loadOptions() {
		try {
			List<Attachment> attachments = attachmentService.findAllAttachments();
			if (null != attachments) {
				NanoConst.ATTACHMENTS = attachments;
			}
		} catch (Exception e) {
			log.error("加载所有文件失败!", e.getMessage());
		}
	}

	/**
	 * 加载所有主题
	 */
	private void loadActiveTheme() {
		try {
			NanoConst.THEMES.clear();
			List<Theme> themes = NanoUtil.getThemes();
			if (null != themes) {
				NanoConst.THEMES = themes;
			}
		} catch (Exception e) {
			log.error("加载主题失败：{0}", e.getMessage());
		}
	}
}
