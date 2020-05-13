package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Tag;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 17:04
 */
public interface TagService {

	/**
	 * 获取所有标签
	 *
	 * @return list
	 */
	List<Tag> findAllTags();


	/**
	 * 新增/修改标签
	 *
	 * @param tag tag
	 * @return Tag
	 */
	Tag saveByTag(Tag tag);

	/**
	 * 转换标签字符串为Category的List
	 *
	 * @param tagList 传入了包含了所有tag名字的字符串
	 * @return List<Tag>
	 */
	List<Tag> strListToTagList(String tagList);

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

	/**
	 * 根据编号查询标签
	 *
	 * @param tagId tagId
	 * @return Link
	 */
	Optional<Tag> findByTagId(Long tagId);


	/**
	 * 根据编号删除标签
	 *
	 * @param tagId tagId
	 * @return Link
	 */
	Tag removeByTagId(Long tagId);
}
