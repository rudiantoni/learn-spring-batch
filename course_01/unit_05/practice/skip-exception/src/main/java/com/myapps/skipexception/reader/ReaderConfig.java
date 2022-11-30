package com.myapps.skipexception.reader;

import com.myapps.skipexception.domain.Customer;
import com.myapps.skipexception.domain.CustomerRowMapper;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ReaderConfig {

    private final DataSource batchDataSource;
    private final CustomerRowMapper customerRowMapper;
    public ReaderConfig(
        @Qualifier("batchAppDataSource") DataSource batchDataSource,
        CustomerRowMapper customerRowMapper
    ) {
        this.batchDataSource = batchDataSource;
        this.customerRowMapper = customerRowMapper;
    }

    @Bean
    public JdbcCursorItemReader<Customer> skipReader() {
        return new JdbcCursorItemReaderBuilder<Customer>()
            .name("skipReader")
            .dataSource(batchDataSource)
            .sql("SELECT * FROM public.clients")
            .rowMapper(customerRowMapper)
            .build();
    }

}
