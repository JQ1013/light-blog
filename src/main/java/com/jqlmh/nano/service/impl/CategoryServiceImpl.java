package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Category;
import com.jqlmh.nano.repository.CategoryRepository;
import com.jqlmh.nano.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:45
 */
@Service
public class CategoryServiceImpl implements CategoryService {


	@Autowired
	private CategoryRepository categoryRepository;


	/**
	 * 保存/修改分类目录
	 *
	 * @param category 分类目录
	 * @return category
	 */
	@Override
	public Category saveByCategory(Category category) {
		return categoryRepository.save(category);
	}

	/**
	 * 获取所有分类目录
	 *
	 * @return 返回List集合
	 */
	@Override
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}


	/**
	 * 将元素为字符串类型的list转换为元素为Category的List
	 *
	 * @param cateList 传入的分类目录的cateId的List
	 * @return List<Category>
	 */
	@Override
	public List<Category> strListToCateList(List<String> cateList) {
		if (null == cateList || cateList.isEmpty()) {
			return null;
		}

		ArrayList<Category> list = new ArrayList<>();
		Optional<Category> optional;
		for (String cateId : cateList) {
			optional = categoryRepository.findById(Long.parseLong(cateId));
			if (optional.isPresent()) {
				list.add(optional.get());
			}
		}
		return list;
	}


	/**
	 * 根据分类目录路径查询，用于验证是否已经存在该路径
	 *
	 * @param cateUrl cateUrl
	 * @return category
	 */
	@Override
	public Category findByCateUrl(String cateUrl) {
		return categoryRepository.findByCateUrl(cateUrl);
	}

	/**
	 * 根据编号查询单个分类
	 *
	 * @param cateId 分类编号
	 * @return 返回category实体
	 */
	@Override
	public Optional<Category> findByCateId(Long cateId) {
		return categoryRepository.findById(cateId);
	}

	/**
	 * 根据编号删除单个分类
	 *
	 * @param cateId 分类编号
	 * @return 返回category实体
	 */
	@Override
	public Category removeByCateId(Long cateId) {
		Optional<Category> optional = findByCateId(cateId);
		if (!optional.isPresent()) {
			return null;
		}
		categoryRepository.delete(optional.get());
		return optional.get();
	}
}
