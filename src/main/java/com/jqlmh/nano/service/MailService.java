package com.jqlmh.nano.service;

import java.util.Map;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 22:51
 */
public interface MailService {

	/**
	 * 发送模板邮件
	 *
	 * @param to           接收者
	 * @param subject      主题
	 * @param content      内容
	 * @param templateName 模板路径
	 */
	void sendTemplateMail(String to, String subject, Map<String, Object> content, String templateName);


	/**
	 * 发送邮件
	 *
	 * @param to      to 接收者
	 * @param subject subject 标题
	 * @param content content 内容
	 */
	void sendMail(String to, String subject, String content);
}
