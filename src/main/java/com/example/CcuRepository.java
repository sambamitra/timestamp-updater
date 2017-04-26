package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CcuRepository {

	@Autowired
	@Qualifier("ccuJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void updateTimestamp() {
		final long current = System.currentTimeMillis();
		jdbcTemplate.update("update t_ccu_now set tstamp=?", current);
	}

}
