package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Options;
import com.jqlmh.nano.repository.OptionsRepository;
import com.jqlmh.nano.service.OptionsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:42
 */
@Service
public class OptionsServiceImpl implements OptionsService {

	@Autowired
	private OptionsRepository optionsRepository;

	/**
	 * 根据key获得指定设置的值
	 *
	 * @param theme 设置的key
	 * @return 设置选项的值
	 */
	@Override
	public String findOneOption(String theme) {
		Options options = optionsRepository.findOptionsByOptionName(theme);
		if (options != null) {
			return options.getOptionValue();
		}
		return null;
	}

	/**
	 * 获取所有的设置选项
	 *
	 * @return Map
	 */
	@Override
	public Map<String, String> findAllOptions() {
		Map<String, String> options = new HashMap<>();
		List<Options> optionsList = optionsRepository.findAll();
		if (optionsList != null) {
			for (Options option : optionsList) {
				options.put(option.getOptionName(), option.getOptionValue());
			}
		}
		return options;
	}


	/**
	 * 保存单个设置选项
	 *
	 * @param key   key
	 * @param value value
	 */
	@Override
	public void saveOption(String key, String value) {
		//value为空,删除该设置
		Options options = null;
		if (StringUtils.equals(value, "")) {
			options = new Options();
			options.setOptionName(key);
			removeOption(options);
		} else {
			if (StringUtils.isNotEmpty(key)) {
				//如果查询到有该设置选项则做更新操作，反之保存新的设置选项
				if (null == optionsRepository.findOptionsByOptionName(key)) {
					options = new Options();
					options.setOptionName(key).setOptionValue(value);
					optionsRepository.save(options);
				} else {
					options = optionsRepository.findOptionsByOptionName(key);
					options.setOptionValue(value);
					optionsRepository.save(options);
				}
			}
		}
	}


	/**
	 * 移除单个设置项
	 *
	 * @param options options
	 */
	@Override
	public void removeOption(Options options) {
		optionsRepository.delete(options);
	}


	/**
	 * 保存多个设置选项
	 *
	 * @param options options
	 */
	@Override
	public void saveOptions(Map<String, String> options) {
		if (null != options && !options.isEmpty()) {

			//lambda表达式
			options.forEach(this::saveOption);

			// Set<String> keySet = options.keySet();
			// for (String key : keySet) {
			// 	this.saveOption(key, options.get(key));
			// }
		}
	}
}
