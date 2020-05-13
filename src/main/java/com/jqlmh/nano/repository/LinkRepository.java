package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-13 21:54
 */
public interface LinkRepository extends JpaRepository<Link, Long> {
}
