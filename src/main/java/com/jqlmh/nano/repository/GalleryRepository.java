package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 22:12
 */
@Repository
public interface GalleryRepository  extends JpaRepository<Gallery, Long> {
}
