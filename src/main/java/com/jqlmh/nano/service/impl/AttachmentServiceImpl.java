package com.jqlmh.nano.service.impl;

import com.jqlmh.nano.model.domain.Attachment;
import com.jqlmh.nano.repository.AttachmentRepository;
import com.jqlmh.nano.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 14:41
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	/**
	 * 查询所有的文件信息:不分页
	 *
	 * @return List
	 */
	@Override
	public List<Attachment> findAllAttachments() {
		return attachmentRepository.findAll();
	}


	/**
	 * 查询所有的文件信息:分页
	 *
	 * @return List
	 */
	@Override
	public Page<Attachment> findAllAttachments(Pageable pageable) {
		return attachmentRepository.findAll(pageable);
	}


	/**
	 * 保存附件信息
	 *
	 * @param attachment attachment
	 * @return Attachment
	 */
	@Override
	public Attachment saveByAttachment(Attachment attachment) {
		return attachmentRepository.save(attachment);
	}


	/**
	 * 根据编号查询一个附件信息
	 *
	 * @param attachId attachId
	 * @return Attachment
	 */
	@Override
	public Optional<Attachment> findByAttachId(Long attachId) {
		return attachmentRepository.findById(attachId);
	}


	/**
	 * 根据编号移除一个附件
	 *
	 * @param attachId attachId
	 * @return Attachment
	 */
	@Override
	public Attachment removeByAttachId(Long attachId) {
		Optional<Attachment> optional = this.findByAttachId(attachId);
		if (!optional.isPresent()) {
			return null;
		}
		attachmentRepository.delete(optional.get());
		return optional.get();
	}
}
