package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.User;
import com.jqlmh.nano.repository.UserRepository;
import com.jqlmh.nano.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:07
 */
@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserRepository userRepository;

	/**
	 * 查询所有用户 :实际上我们的博客用户就只有一个
	 *
	 * @return List
	 */
	@Override
	public User findAllUser() {
		List<User> userList = userRepository.findAll();
		//有就返回第一个用户
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		} else {
			//没有就新建一个User
			return new User();
		}
	}

	/**
	 * 保存个人资料
	 *
	 * @param user user
	 */
	@Override
	public User saveByUser(User user) {
		Long userId = user.getUserId();
		Optional<User> optional = userRepository.findById(userId);
		if (optional.isPresent()) {
			User userFromDb = optional.get();
			if (StringUtils.isEmpty(user.getUserName())) {
				user.setUserName(userFromDb.getUserName());
			}
			if (StringUtils.isEmpty(user.getUserDisplayName())) {
				user.setUserDisplayName(userFromDb.getUserDisplayName());
			}
			if (StringUtils.isEmpty(user.getUserEmail())) {
				user.setUserEmail(userFromDb.getUserEmail());
			}
			if (StringUtils.isEmpty(user.getUserAvatar())) {
				user.setUserAvatar(userFromDb.getUserAvatar());
			}
		}
		return userRepository.save(user);
	}

	/**
	 * 根据邮箱和密码查询用户，用户登录
	 *
	 * @param userEmail userEmail
	 * @param userPass  userPass
	 * @return list
	 */
	@Override
	public List<User> userLoginByEmail(String userEmail, String userPass) {
		return userRepository.findUserByUserEmailAndUserPass(userEmail, userPass);
	}

	/**
	 * 根据用户名和密码查询，用于登录
	 *
	 * @param userName userName
	 * @param userPass userPass
	 * @return User
	 */
	@Override
	public List<User> userLoginByName(String userName, String userPass) {
		return userRepository.findUserByUserNameAndUserPass(userName, userPass);
	}

	/**
	 * 修改用户的状态为正常
	 */
	@Override
	public User updateUserNormal() {
		User user = this.findAllUser();
		user.setLoginEnable("true").setLoginError(0).setLoginLast(new Date());
		this.saveByUser(user);
		return user;
	}

	/**
	 * 增加登录错误次数
	 */
	@Override
	public Integer updateUserLoginError() {
		User user = this.findAllUser();
		user.setLoginError(user.getLoginError() == null ? 0 : user.getLoginError() + 1);
		this.saveByUser(user);
		return user.getLoginError();
	}

	/**
	 * 修改用户的状态为禁用
	 *
	 * @param enable enable
	 */
	@Override
	public User updateUserLoginEnable(String enable) {
		User user = this.findAllUser();
		user.setLoginEnable(enable);
		this.saveByUser(user);
		return user;
	}

	/**
	 * 修改最后登录时间
	 *
	 * @param date lastDate
	 */
	@Override
	public User updateUserLoginLast(Date date) {
		User user = this.findAllUser();
		user.setLoginLast(date);
		this.saveByUser(user);
		return user;
	}


	/**
	 * 根据用户编号和密码查询
	 *
	 * @param userId userId
	 * @param pwdMd5 pwdMd5
	 * @return user
	 */
	@Override
	public User findByUserIdAndUserPass(Long userId, String pwdMd5) {
		return userRepository.findByUserIdAndUserPass(userId, pwdMd5);
	}
}
