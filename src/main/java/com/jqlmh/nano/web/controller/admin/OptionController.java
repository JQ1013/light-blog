package com.jqlmh.nano.web.controller.admin;

import com.jqlmh.nano.service.OptionsService;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统设置控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2020-03-12 8:36
 */
@Slf4j
@Controller
@RequestMapping("/admin/option")
public class OptionController {

	@Autowired
	private OptionsService optionsService;

	@Autowired
	private Configuration configuration;

	/**
	 * 请求跳转到option页面并完成渲染
	 *
	 * @return 模板路径admin/admin_option
	 */
	@GetMapping
	public String options() {
		return "admin/admin_option";
	}

	/**
	 * 保存设置选项
	 *
	 * @param options options
	 * @return true：保存成功，false：保存失败
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public boolean saveOptions(@RequestParam Map<String, String> options) {
		try {
			optionsService.saveOptions(options);
			//刷新options
			configuration.setSharedVariable("options", optionsService.findAllOptions());
			log.info("所保存的设置选项列表：" + options);
			return true;
		} catch (Exception e) {
			log.error("未知错误", e.getMessage());
			return false;
		}
	}
}
