package com.myapps.jdbccursorreader.reader;

import com.myapps.jdbccursorreader.domain.Client;
import org.springframework.batch.item.database.JdbcCursorItemReader;

import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ReaderConfig {

    @Bean
    public JdbcCursorItemReader<Client> jdbcCursorReader(
            @Qualifier("batchAppDataSource") DataSource dataSource
    ) {
//        JdbcCursorItemReader<Client> reader = new JdbcCursorItemReader<Client>();
//
//        return reader;

        return new JdbcCursorItemReaderBuilder<Client>()
                .name("jdbcCursorReader")
                .dataSource(dataSource)
                .sql("SELECT * FROM public.clients")
                /*
                This mapper must be used only if the domain class attributes are the same as the result set fields
                or columns from the database, or following standard naming conventions such as field_name = fieldName
                 */
                .rowMapper(new BeanPropertyRowMapper<Client>(Client.class))
                .build();
    }
}
