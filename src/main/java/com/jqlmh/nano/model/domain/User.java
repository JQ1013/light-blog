package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 11:38
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_user")
public class User implements Serializable {
	private static final long serialVersionUID = 5761073942577667792L;

	/**
	 * 编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 显示昵称
	 */
	private String userDisplayName;

	/**
	 * 密码
	 */
	private String userPass;

	/**
	 * 邮箱
	 */
	private String userEmail;

	/**
	 * 头像
	 */
	private String userAvatar;

	/**
	 * 说明
	 */
	private String userDesc;

	/**
	 * 是否禁用登录
	 */
	private String loginEnable;

	/**
	 * 最后一次登录时间
	 */
	private Date loginLast;

	/**
	 * 登录错误次数记录
	 */
	private Integer loginError;
}
