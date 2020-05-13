package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Logs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:04
 */
public interface LogsService {

	/**
	 * 保存日志
	 *
	 * @param logs logs
	 * @return logs
	 */
	Logs saveByLogs(Logs logs);

	/**
	 * 查询最新的五条日志
	 *
	 * @return list
	 */
	List<Logs> findLogsLatest();

	/**
	 * 查询所有日志并分页
	 *
	 * @param pageable pageable
	 * @return page
	 */
	Page<Logs> findAllLogs(Pageable pageable);

	/**
	 * 移除所有日志
	 */
	void removeAllLogs();
}
