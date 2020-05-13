package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.User;

import java.util.Date;
import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:07
 */
public interface UserService {


	/**
	 * 查询所有用户 :实际上我们的博客用户就只有一个
	 *
	 * @return List
	 */
	User findAllUser();

	/**
	 * 保存个人资料
	 *
	 * @param user user
	 */
	User saveByUser(User user);

	/**
	 * 根据邮箱和密码查询，用户登录
	 *
	 * @param userEmail userEmail
	 * @param userPass  userPass
	 * @return list
	 */
	List<User> userLoginByEmail(String userEmail, String userPass);

	/**
	 * 根据用户名和密码查询，用于登录
	 *
	 * @param userName userName
	 * @param userPass userPass
	 * @return User
	 */
	List<User> userLoginByName(String userName, String userPass);


	/**
	 * 修改用户的状态为正常
	 */
	User updateUserNormal();

	/**
	 * 增加登录错误次数
	 */
	Integer updateUserLoginError();

	/**
	 * 修改用户的状态为禁用
	 *
	 * @param enable enable
	 */
	User updateUserLoginEnable(String enable);

	/**
	 * 修改最后登录时间
	 *
	 * @param date lastDate
	 */
	User updateUserLoginLast(Date date);


	/**
	 * 根据用户编号和密码查询
	 *
	 * @param userId userId
	 * @param pwdMd5 pwdMd5
	 * @return user
	 */
	User findByUserIdAndUserPass(Long userId, String pwdMd5);
}
