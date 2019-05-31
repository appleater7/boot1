package com.practice.boot1.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.practice.boot1.mapper")
public class DBConfig {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}
}
