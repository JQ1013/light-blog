package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Logs;
import com.jqlmh.nano.repository.LogsRepository;
import com.jqlmh.nano.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:04
 */
@Service
public class LogsServiceImpl implements LogsService {

	@Autowired
	private LogsRepository logsRepository;

	/**
	 * 保存日志
	 *
	 * @param logs logs
	 * @return logs
	 */
	@Override
	public Logs saveByLogs(Logs logs) {
		return logsRepository.save(logs);
	}

	/**
	 * 查询最新的五条日志
	 *
	 * @return list
	 */
	@Override
	public List<Logs> findLogsLatest() {
		return logsRepository.getTopFive();
	}

	/**
	 * 查询所有日志并分页
	 *
	 * @param pageable pageable
	 * @return page
	 */
	@Override
	public Page<Logs> findAllLogs(Pageable pageable) {
		return logsRepository.findAll(pageable);
	}

	/**
	 * 移除所有日志
	 */
	@Override
	public void removeAllLogs() {
		logsRepository.deleteAll();
	}
}
