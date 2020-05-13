package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:11
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * 根据邮箱和密码查询用户，用户登录
	 *
	 * @param userEmail userEmail
	 * @param userPass  userPass
	 * @return list
	 */
	List<User> findUserByUserEmailAndUserPass(String userEmail, String userPass);


	/**
	 * 根据用户名和密码查询，用于登录
	 *
	 * @param userName userName
	 * @param userPass userPass
	 * @return User
	 */
	List<User> findUserByUserNameAndUserPass(String userName, String userPass);


	/**
	 * 根据用户编号和密码查询
	 *
	 * @param userId userId
	 * @param pwdMd5 pwdMd5
	 * @return user
	 */
	User findByUserIdAndUserPass(Long userId, String pwdMd5);
}
