package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:44
 */
public interface CategoryService {

	/**
	 * 保存/修改分类目录
	 *
	 * @param category 分类目录
	 * @return category
	 */
	Category saveByCategory(Category category);

	/**
	 * 获取所有分类目录
	 *
	 * @return 返回List集合
	 */
	List<Category> findAllCategories();


	/**
	 * 将元素为字符串类型的list转换为元素为Category的List
	 *
	 * @param cateList 传入的分类目录的cateId的List
	 * @return List<Category>
	 */
	List<Category> strListToCateList(List<String> cateList);

	/**
	 * 根据分类目录路径查询，用于验证是否已经存在该路径
	 *
	 * @param cateUrl cateUrl
	 * @return category
	 */
	Category findByCateUrl(String cateUrl);

	/**
	 * 根据编号查询单个分类
	 *
	 * @param cateId 分类编号
	 * @return 返回category实体
	 */
	Optional<Category> findByCateId(Long cateId);

	/**
	 * 根据编号删除单个分类
	 *
	 * @param cateId 分类编号
	 * @return 返回category实体
	 */
	Category removeByCateId(Long cateId);
}
