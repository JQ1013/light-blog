package com.jqlmh.nano.web.controller.admin;

import com.jqlmh.nano.model.domain.Post;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.PostService;
import com.jqlmh.nano.util.NanoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.List;


/**
 * 备份系统控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2020-2-12 16:36
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/backup")
public class BackupController {

	@Autowired
	private PostService postService;

	/**
	 * 渲染备份页面
	 *
	 * @return 模板路径admin/admin_backup
	 */
	@GetMapping
	public String backup() {
		return "admin/admin_backup";
	}

	/**
	 * 备份数据库
	 *
	 * @return 重定向到/admin/backup
	 */
	@GetMapping(value = "/backupDb")
	public String backupDatabase() {
		String fileName = "db_backup_" + NanoUtil.getStringDate("yyyy_MM_dd_HH_mm_ss") + ".sql";
		try {
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			String savePath = path.getAbsolutePath() + "/backup/database";
			NanoUtil.exportDatabase("localhost", "root", "123456", savePath, fileName, "testdb");
		} catch (Exception e) {
			log.error("未知错误：{0}", e.getMessage());
		}
		return "redirect:/admin/backup";
	}

	/**
	 * 备份资源文件 重要
	 *
	 * @return return
	 */
	@GetMapping(value = "/backupRe")
	public String backupResources() {
		return null;
	}

	/**
	 * 备份文章，导出markdown文件
	 *
	 * @return 重定向到/admin/backup
	 */
	@GetMapping(value = "/backupPost")
	public String backupPosts() {
		List<Post> posts = postService.findAllPosts(NanoConst.POST_TYPE_POST);
		try {
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			String savePath = path.getAbsolutePath() + "/backup/posts/posts_backup_" + NanoUtil.getStringDate("yyyy_MM_dd_HH_mm_ss");
			for (Post post : posts) {
				NanoUtil.dbToFile(post.getPostContentMd(), savePath, post.getPostTitle() + ".md");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/backup";
	}
}
