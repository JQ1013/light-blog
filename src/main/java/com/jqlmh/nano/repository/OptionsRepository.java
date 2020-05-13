package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Options;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 设置选项的持久层
 *
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:45
 */
public interface OptionsRepository extends JpaRepository<Options, Long> {

	/**
	 * 根据key获得指定设置的值
	 *
	 * @param key 设置的key
	 * @return Options 设置选项对象
	 */
	Options findOptionsByOptionName(String key);
}
