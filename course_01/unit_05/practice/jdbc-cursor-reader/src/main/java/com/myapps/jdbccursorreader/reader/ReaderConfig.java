package com.myapps.jdbccursorreader.reader;

import com.myapps.jdbccursorreader.domain.Client;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderConfig {

    @Bean
    public JdbcCursorItemReader<Client> jdbcCursorReader() {
        JdbcCursorItemReader<Client> reader = new JdbcCursorItemReader<Client>();



        return reader;
    }
}
