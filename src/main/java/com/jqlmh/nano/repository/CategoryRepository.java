package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:09
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	/**
	 * 根据分类目录路径查询，用于验证是否已经存在该路径
	 *
	 * @param cateUrl cateUrl
	 * @return category
	 */
	Category findByCateUrl(String cateUrl);
}
