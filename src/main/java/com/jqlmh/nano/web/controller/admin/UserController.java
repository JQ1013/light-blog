package com.jqlmh.nano.web.controller.admin;

import com.jqlmh.nano.model.domain.Logs;
import com.jqlmh.nano.model.domain.User;
import com.jqlmh.nano.model.dto.LogsRecord;
import com.jqlmh.nano.model.dto.NanoConst;
import com.jqlmh.nano.service.LogsService;
import com.jqlmh.nano.service.UserService;
import com.jqlmh.nano.util.NanoUtil;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户信息系统控制器
 *
 * @author LMH
 * @version 1.0
 * @create 2020-02-12 16:46
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/profile")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private LogsService logsService;

	@Autowired
	private Configuration configuration;


	/**
	 * 获取用户信息并跳转
	 *
	 * @return 模板路径admin/admin_profile
	 */
	@GetMapping
	public String profile() {
		return "admin/admin_profile";
	}

	/**
	 * 处理修改用户资料的请求
	 *
	 * @param user    user
	 * @param session session
	 * @return true：修改成功，false：修改失败
	 */
	@PostMapping(value = "save")
	@ResponseBody
	public boolean saveProfile(@ModelAttribute User user, HttpSession session) {
		try {
			if (null != user) {
				User dbUser = userService.saveByUser(user);
				configuration.setSharedVariable("user", userService.findAllUser());
				User sessionUser = (User) session.getAttribute(NanoConst.USER_SESSION_KEY);
				sessionUser.setUserName(dbUser.getUserName())
						.setUserAvatar(dbUser.getUserAvatar())
						.setUserEmail(dbUser.getUserEmail())
						.setUserDisplayName(dbUser.getUserDisplayName())
						.setUserDesc(dbUser.getUserDesc());
			} else {
				return false;
			}
		} catch (Exception e) {
			log.error("未知错误：{0}", e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 处理修改密码的请求
	 *
	 * @param beforePass 旧密码
	 * @param newPass    新密码
	 * @param userId     用户编号
	 * @param session    session
	 * @return true：修改密码成功，false：修改密码失败
	 */
	@PostMapping(value = "changePass")
	@ResponseBody
	public boolean changePass(@ModelAttribute("beforePass") String beforePass,
							  @ModelAttribute("newPass") String newPass,
							  @ModelAttribute("userId") Long userId,
							  HttpSession session,
							  HttpServletRequest request) {
		try {
			User user = userService.findByUserIdAndUserPass(userId, NanoUtil.getMD5(beforePass));
			if (null != user) {
				user.setUserPass(NanoUtil.getMD5(newPass));
				userService.saveByUser(user);
				session.invalidate();
				logsService.saveByLogs(new Logs(
						LogsRecord.UPDATE_PASSWORD,
						LogsRecord.UPDATE_PASSWORD_SUCCESS + "[" + user.getUserEmail()+","+newPass + "]",
						NanoUtil.getIpAddr(request),
						NanoUtil.getDate()));
			} else {
				return false;
			}
		} catch (Exception e) {
			log.error("修改密码：未知错误!", e.getMessage());
			return false;
		}
		return true;
	}
}
