package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Options;

import java.util.Map;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:40
 */
public interface OptionsService {

	/**
	 * 根据key获得指定设置的值
	 *
	 * @param theme 设置的key
	 * @return 设置选项的值
	 */
	String findOneOption(String theme);


	/**
	 * 获取所有的设置选项
	 *
	 * @return Map
	 */
	Map<String, String> findAllOptions();


	/**
	 * 保存单个设置选项
	 *
	 * @param key   key
	 * @param value value
	 */
	void saveOption(String key, String value);

	/**
	 * 移除单个设置项
	 *
	 * @param options options
	 */
	void removeOption(Options options);

	/**
	 * 保存多个设置选项
	 *
	 * @param options options
	 */
	void saveOptions(Map<String, String> options);
}
