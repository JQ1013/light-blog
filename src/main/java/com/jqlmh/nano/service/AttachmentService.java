package com.jqlmh.nano.service;

import com.jqlmh.nano.model.domain.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:41
 */
public interface AttachmentService {

	/**
	 * 查询所有的文件信息:不分页
	 *
	 * @return List
	 */
	List<Attachment> findAllAttachments();

	/**
	 * 查询所有的文件信息:分页
	 *
	 * @return List
	 */
	Page<Attachment> findAllAttachments(Pageable pageable);

	/**
	 * 保存一个附件信息
	 *
	 * @param attachment attachment
	 * @return Attachment
	 */
	Attachment saveByAttachment(Attachment attachment);

	/**
	 * 根据编号查询一个附件信息
	 *
	 * @param attachId attachId
	 * @return Attachment
	 */
	Optional<Attachment> findByAttachId(Long attachId);

	/**
	 * 根据编号移除一个附件
	 *
	 * @param attachId attachId
	 * @return Attachment
	 */
	Attachment removeByAttachId(Long attachId);
}
