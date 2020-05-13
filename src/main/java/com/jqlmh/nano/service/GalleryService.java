package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 21:48
 */
public interface GalleryService {

	/**
	 * 查询所有图片 分页
	 *
	 * @param pageable pageable
	 * @return page
	 */
	Page<Gallery> findAllGalleries(Pageable pageable);

	/**
	 * 保存图片
	 *
	 * @param gallery gallery
	 * @return Gallery
	 */
	Gallery saveByGallery(Gallery gallery);

	/**
	 * 根据编号查询图片信息
	 *
	 * @param galleryId galleryId
	 * @return gallery
	 */
	Optional<Gallery> findByGalleryId(Long galleryId);

	/**
	 * 根据编号删除图片
	 *
	 * @param galleryId galleryId
	 */
	Gallery removeByGalleryId(Long galleryId);

	/**
	 * 查询所有图片 不分页
	 *
	 * @return list
	 */
	List<Gallery> findAllGalleries();

}
