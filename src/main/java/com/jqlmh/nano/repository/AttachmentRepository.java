package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 15:00
 */
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
