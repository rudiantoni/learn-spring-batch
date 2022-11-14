package com.myapps.jdbcpagingreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class JdbcPagingReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcPagingReaderApplication.class, args);
	}

}
