package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

	@Primary
	@Bean(name = "ccuDataSource")
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "healthDataSource")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "ccuJdbcTemplate")
	public JdbcTemplate jdbcTemplateCcu(@Qualifier("ccuDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "healthJdbcTemplate")
	public JdbcTemplate jdbcTemplateHealth(@Qualifier("ccuDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
