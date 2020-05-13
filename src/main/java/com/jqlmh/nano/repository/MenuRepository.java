package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:26
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
