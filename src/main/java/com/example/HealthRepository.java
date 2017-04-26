package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HealthRepository {

	@Autowired
	@Qualifier("healthJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public void updateTimestamp() {
		final long current = System.currentTimeMillis();
		final String currentDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		jdbcTemplate.update("update health.health_now set tstamp=?,tstamp_ccu=?,tstamp_rcvd=?", currentDate, current,
				current);
		jdbcTemplate.update("update health.consist_now set tstamp_ccu=?,tstamp_rcvd=?", current, current);
	}

}
