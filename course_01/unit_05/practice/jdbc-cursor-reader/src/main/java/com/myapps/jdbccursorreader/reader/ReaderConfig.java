package com.myapps.jdbccursorreader.reader;

import com.myapps.jdbccursorreader.domain.Client;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderConfig {

    public JdbcCursorItemReader<Client> jdbcCursorReader() {
        JdbcCursorItemReader<Client> reader = new JdbcCursorItemReader<Client>();



        return reader;
    }
}
