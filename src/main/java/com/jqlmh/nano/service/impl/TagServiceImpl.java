package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Tag;
import com.jqlmh.nano.repository.TagRepository;
import com.jqlmh.nano.service.TagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 17:05
 */
@Service
public class TagServiceImpl implements TagService {


	@Autowired
	private TagRepository tagRepository;

	/**
	 * 获取所有标签
	 *
	 * @return list
	 */
	@Override
	public List<Tag> findAllTags() {
		return tagRepository.findAll();
	}

	/**
	 * 新增/修改标签
	 *
	 * @param tag tag
	 * @return Tag
	 */
	@Override
	public Tag saveByTag(Tag tag) {
		return tagRepository.save(tag);
	}

	/**
	 * 根据标签名称查询
	 *
	 * @param tagName tagName
	 * @return tag
	 */
	@Override
	public Tag findTagByTagName(String tagName) {
		return tagRepository.findTagByTagName(tagName);
	}

	/**
	 * 转换标签字符串为Category的List
	 *
	 * @param tagList 传入了包含了所有tag名字的字符串
	 * @return List<Tag>
	 */
	@Override
	public List<Tag> strListToTagList(String tagList) {

		if (StringUtils.isEmpty(tagList)) {
			return null;
		}

		ArrayList<Tag> list = new ArrayList<>();
		String[] tags = tagList.split(",");
		for (String tag : tags) {
			Tag tagDb = findTagByTagName(tag);
			if (tagDb != null) {
				list.add(tagDb);
			} else {
				tagDb = new Tag();
				tagDb.setTagName(tag);
				tagDb.setTagUrl(tag);
				list.add(saveByTag(tagDb));
			}
		}
		return list;
	}

	/**
	 * 检查是否已经有该url的标签
	 *
	 * @param tagUrl 要查询的url
	 * @return Tag
	 */
	@Override
	public Tag findByTagUrl(String tagUrl) {
		return tagRepository.findByTagUrl(tagUrl);
	}

	/**
	 * 根据编号查询标签
	 *
	 * @param tagId tagId
	 * @return Link
	 */
	@Override
	public Optional<Tag> findByTagId(Long tagId) {
		return tagRepository.findById(tagId);
	}


	/**
	 * 根据编号删除标签
	 *
	 * @param tagId tagId
	 * @return Link
	 */
	@Override
	public Tag removeByTagId(Long tagId) {
		Optional<Tag> optional = findByTagId(tagId);
		if (!optional.isPresent()) {
			return null;
		}

		tagRepository.delete(optional.get());
		return optional.get();
	}


}
