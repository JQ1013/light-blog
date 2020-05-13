package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 19:03
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	/**
	 * 根据标签名称查询
	 *
	 * @param tagName tagName
	 * @return tag
	 */
	Tag findTagByTagName(String tagName);

	/**
	 * 检查是否已经有该url的标签
	 *
	 * @param tagUrl 要查询的url
	 * @return Tag
	 */
	Tag findByTagUrl(String tagUrl);
}
