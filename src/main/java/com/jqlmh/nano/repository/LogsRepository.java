package com.jqlmh.nano.repository;

import com.jqlmh.nano.model.domain.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LMH
 * @version 1.0
 * @create 2020-05-12 16:25
 */
@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {

	/**
	 * 查询最新的五条日志
	 *
	 * @return list
	 */
	@Query(value = "SELECT * FROM nano_logs ORDER BY log_created DESC LIMIT 5", nativeQuery = true)
	List<Logs> getTopFive();
}
