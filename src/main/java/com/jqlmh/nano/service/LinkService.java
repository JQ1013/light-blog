package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Link;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 21:47
 */
public interface LinkService {

	/**
	 * 查询所有友链
	 *
	 * @return List
	 */
	List<Link> findAllLinks();

	/**
	 * 根据编号查询单个链接
	 *
	 * @param linkId linkId
	 * @return Link
	 */
	Optional<Link> findByLinkId(Long linkId);

	/**
	 * 新增/修改友情链接
	 *
	 * @param link link
	 * @return Link
	 */
	Link saveByLink(Link link);


	/**
	 * 根据编号删除
	 *
	 * @param linkId linkId
	 * @return Link
	 */
	Link removeByLinkId(Long linkId);
}
