package com.springbatch.jdbccursorreader.reader;

import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.jdbccursorreader.dominio.Cliente;

@Configuration
public class JdbcCursorReaderConfig {
	@Bean
	public JdbcCursorItemReader<Cliente> jdbcCursorReader() {
		//TODO Implementar o leitor aqui...
	}
}
