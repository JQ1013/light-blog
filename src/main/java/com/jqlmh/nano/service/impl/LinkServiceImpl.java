package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Link;
import com.jqlmh.nano.repository.LinkRepository;
import com.jqlmh.nano.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 21:47
 */
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkRepository linkRepository;

	/**
	 * 查询所有友链
	 *
	 * @return List
	 */
	@Override
	public List<Link> findAllLinks() {
		return linkRepository.findAll();
	}

	/**
	 * 根据编号查询单个链接
	 *
	 * @param linkId linkId
	 * @return Link
	 */
	@Override
	public Optional<Link> findByLinkId(Long linkId) {
		return linkRepository.findById(linkId);
	}


	/**
	 * 新增/修改友情链接
	 *
	 * @param link link
	 * @return Link
	 */
	@Override
	public Link saveByLink(Link link) {
		return linkRepository.save(link);
	}

	/**
	 * 根据编号删除
	 *
	 * @param linkId linkId
	 * @return Link
	 */
	@Override
	public Link removeByLinkId(Long linkId) {
		Optional<Link> link = this.findByLinkId(linkId);
		if (!link.isPresent()) {
			return null;
		}
		linkRepository.delete(link.get());
		return link.get();
	}
}
