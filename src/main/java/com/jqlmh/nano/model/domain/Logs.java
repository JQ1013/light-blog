package com.jqlmh.nano.model.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 博客日志实体类
 *
 * @author LMH
 * @version 1.0
 * @create 2019-05-12 12:33
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "nano_logs")
public class Logs implements Serializable {

	private static final long serialVersionUID = 3050670751950031510L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;

	/**
	 * 标题
	 */
	private String logTitle;

	/**
	 * 内容
	 */
	private String logContent;

	/**
	 * 产生日志的ip
	 */
	private String logIp;

	/**
	 * 产生的时间
	 */
	private Date logCreated;

	public Logs() {
	}

	public Logs(String logTitle, String logContent, String logIp, Date logCreated) {
		this.logTitle = logTitle;
		this.logContent = logContent;
		this.logIp = logIp;
		this.logCreated = logCreated;
	}
}
