package com.jqlmh.nano.web.controller.core;

import com.jqlmh.nano.model.domain.*;
import com.jqlmh.nano.model.dto.LogsRecord;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.*;
import com.jqlmh.nano.util.NanoUtil;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 初始化博客的控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:17
 */
@Slf4j
@Controller
@RequestMapping(value = "/install")
public class InstallController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private OptionsService optionsService;

	@Autowired
	private LogsService logsService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private Configuration configuration;

	/**
	 * 处理去初始化博客页面的请求
	 *
	 * @param model model
	 * @return common/install
	 */
	@RequestMapping
	public String install(Model model) {
		try {
			File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
			File installFile = new File(basePath.getAbsolutePath(), "install.lock");
			if (installFile.exists()) {
				model.addAttribute("isInstall", true);
			} else {
				model.addAttribute("isInstall", false);
			}
		} catch (FileNotFoundException e) {
			log.error("找不到文件!", e.getMessage());
		}

		return "common/install";
	}


	/**
	 * 处理初始化博客的请求
	 *
	 * @param blogTitle       博客标题
	 * @param blogUrl         博客的url
	 * @param userEmail       用户邮箱
	 * @param userName        用户名
	 * @param userDisplayName 显示昵称
	 * @param userPwd         用户密码
	 * @param request         request
	 * @return 是否初始化成功, 用于页面判断
	 */
	@RequestMapping(value = "/do")
	@ResponseBody
	public boolean install(String blogTitle,
						   String blogUrl,
						   String userEmail,
						   String userName,
						   String userDisplayName,
						   String userPwd,
						   HttpServletRequest request,
						   Model model) {
		try {
			//创建install.lock文件
			File basePath = new File(ResourceUtils.getURL("classpath:").getPath());
			File installFile = new File(basePath.getAbsolutePath(), "install.lock");
			if (installFile.exists()) {
				return false;
			} else {
				boolean newFile = installFile.createNewFile();
				if (newFile) {
					log.info(NanoUtil.getStringDate("yyyy/MM/dd") + "创建install.lock文件成功");
				}
			}

			//创建新用户并保存
			User user = new User();
			if (StringUtils.isBlank(userDisplayName)) {
				userDisplayName = userName;
			}
			user.setUserName(userName)
					.setUserEmail(userEmail)
					.setUserPass(NanoUtil.getMD5(userPwd))
					.setUserDisplayName(userDisplayName);
			userService.saveByUser(user);

			//默认分类
			Category category = new Category();
			category.setCateName("未分类");
			category.setCateUrl("default");
			category.setCateDesc("未分类");
			categoryService.saveByCategory(category);

			//默认文章
			Post post = new Post();
			List<Category> categories = new ArrayList<>();
			categories.add(category);
			post.setCategories(categories);
			post.setPostTitle("Hello Nano!");
			post.setPostContentMd("#Hello Nano!\n" +
					"Nano[ˈnɑnoʊ]，意思是毫微；纤（10的负九次方。");
			post.setPostContent("<h1 id=\"h1-hello-Nano-\">" +
					"<a name=\"Hello Nano!\" class=\"reference-link\">" +
					"</a>" +
					"<span class=\"header-link octicon octicon-link\"></span>" +
					"Hello Nano!" +
					"</h1>" +
					"<p>欢迎使用Nano,开始你的博客之旅吧.这些残暴的欢愉 , 终将以残暴为结局 ——莎士比亚 《罗密欧与朱丽叶》</p>\n");
			post.setPostSummary("这些残暴的欢愉 , 终将以残暴为结局 ——莎士比亚 《罗密欧与朱丽叶》");
			post.setPostStatus(0);
			post.setPostDate(new Date());
			post.setPostUrl("hello-nano");
			post.setUser(user);
			postService.saveByPost(post);

			//第一个评论
			Comment comment = new Comment();
			comment.setPost(post);
			comment.setCommentAuthor("LMH");
			comment.setCommentAuthorEmail("459296228@qq.com");
			comment.setCommentAuthorUrl("https://jqlmh.com");
			comment.setCommentAuthorIp("127.0.0.1");
			comment.setCommentAuthorAvatarMd5("e5f38406566a3f4df2ca711b7f9c9673");
			comment.setCommentDate(new Date());
			comment.setCommentContent("欢迎来到nano");
			comment.setCommentAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36");
			comment.setIsAdmin(0);
			commentService.saveByComment(comment);

			//保存博客标题和博客地址设置
			optionsService.saveOption("blog_title", blogTitle);
			optionsService.saveOption("blog_url", blogUrl);
			//设置默认主题
			optionsService.saveOption("theme", BaseController.THEME);
			//建立网站时间
			optionsService.saveOption("blog_start", NanoUtil.getStringDate("yyyy-MM-dd"));
			//默认评论系统
			optionsService.saveOption("comment_system", "native");
			//默认不配置邮件系统
			optionsService.saveOption("smtp_email_enable", "false");
			//新评论，审核通过，回复，默认不通知
			optionsService.saveOption("new_comment_notice", "false");
			optionsService.saveOption("comment_pass_notice", "false");
			optionsService.saveOption("comment_reply_notice", "false");

			//更新日志
			logsService.saveByLogs(
					new Logs(
							LogsRecord.INSTALL,
							"安装成功，欢迎使用Halo。",
							NanoUtil.getIpAddr(request),
							NanoUtil.getDate()
					)
			);

			//初始化前台菜单栏
			Menu menuIndex = new Menu();
			menuIndex.setMenuName("首页");
			menuIndex.setMenuUrl("/");
			menuIndex.setMenuSort(1);
			menuIndex.setMenuIcon("");
			menuService.saveByMenu(menuIndex);

			Menu menuArchive = new Menu();
			menuArchive.setMenuName("归档");
			menuArchive.setMenuUrl("/archives");
			menuArchive.setMenuSort(2);
			menuArchive.setMenuIcon("");
			menuService.saveByMenu(menuArchive);

			//清除保存设置选项的map,重新查询所有保存到OPTIONS中
			NanoConst.OPTIONS.clear();
			NanoConst.OPTIONS = optionsService.findAllOptions();

			//设置FreeMarker在页面的共享变量
			configuration.setSharedVariable("options", optionsService.findAllOptions());
			configuration.setSharedVariable("user", userService.findAllUser());
		} catch (Exception e) {
			log.error("初始化博客出现错误!", e.getMessage());
			return false;
		}
		return true;
	}


}
