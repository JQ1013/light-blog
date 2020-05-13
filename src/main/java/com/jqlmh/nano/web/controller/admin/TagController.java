package com.jqlmh.nano.web.controller.admin;

import com.jqlmh.nano.model.domain.Tag;
import com.jqlmh.nano.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 标签系统控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2020-3-18 16:36
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/tag")
public class TagController {

	@Autowired
	private TagService tagService;

	/**
	 * 渲染标签管理页面
	 *
	 * @param model model
	 * @return 模板路径admin/admin_tag
	 */
	@GetMapping
	public String tags(Model model) {
		List<Tag> tags = tagService.findAllTags();
		model.addAttribute("tags", tags);
		model.addAttribute("statusName", "新增");
		return "admin/admin_tag";
	}

	/**
	 * 新增/修改标签
	 *
	 * @param tag tag
	 * @return 重定向到/admin/tag
	 */
	@PostMapping(value = "/save")
	public String saveTag(Tag tag) {
		try {
			tagService.saveByTag(tag);
		} catch (Exception e) {
			log.error("未知错误", e.getMessage());
		}
		return "redirect:/admin/tag";
	}

	/**
	 * 验证是否存在该路径
	 *
	 * @param tagUrl 标签路径名
	 * @return true：存在，false：不存在
	 */
	@GetMapping(value = "/checkUrl")
	@ResponseBody
	public boolean checkTagUrlExists(@RequestParam("tagUrl") String tagUrl) {
		Tag tag = tagService.findByTagUrl(tagUrl);
		return null != tag;
	}

	/**
	 * 跳转到修改标签页面
	 *
	 * @param model model
	 * @param tagId 标签编号
	 * @return 模板路径admin/admin_tag
	 */
	@GetMapping(value = "/edit")
	public String toEditTag(Model model, @PathParam("tagId") Long tagId) {
		List<Tag> tags = tagService.findAllTags();
		Tag tag = tagService.findByTagId(tagId).get();
		model.addAttribute("statusName", "修改");
		model.addAttribute("updateTag", tag);
		model.addAttribute("tags", tags);
		return "admin/admin_tag";
	}

	/**
	 * 处理删除标签的请求
	 *
	 * @param tagId 标签编号
	 * @return 重定向到/admin/tag
	 */
	@GetMapping(value = "/remove")
	public String removeTag(@PathParam("tagId") Long tagId) {
		try {
			Tag tag = tagService.removeByTagId(tagId);
			log.info("删除的标签：" + tag);
		} catch (Exception e) {
			log.error("未知错误", e.getMessage());
		}
		return "redirect:/admin/tag";
	}


}
