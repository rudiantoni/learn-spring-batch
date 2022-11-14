package com.myapps.jdbcpagingreader.reader;

import com.myapps.jdbcpagingreader.domain.Client;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.PostgresPagingQueryProvider;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ReaderConfig {

    private final DataSource dataSource;

    public ReaderConfig(
        @Qualifier("batchAppDataSource") DataSource dataSource
    ) {
        this.dataSource = dataSource;
    }


    @Bean
    public JdbcPagingItemReader<Client> jdbcPagingReader(
        PagingQueryProvider queryProvider
        //PagingQueryProvider pgQueryProvider
    ) {
        return new JdbcPagingItemReaderBuilder<Client>()
            .name("jdbcPagingReader")
            .dataSource(dataSource)
            .queryProvider(queryProvider)
            //.queryProvider(pgQueryProvider)
            .pageSize(1)
            .rowMapper(new BeanPropertyRowMapper<Client>(Client.class))
            .build();
    }

    @Bean
    public PostgresPagingQueryProvider pgQueryProvider() throws Exception {
        Map<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("id", Order.ASCENDING);

        PostgresPagingQueryProvider queryProvider = new PostgresPagingQueryProvider();
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from clients");
        queryProvider.setSortKeys(sortKeys);
        queryProvider.init(dataSource);

        return queryProvider;
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider() {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("select *");
        queryProvider.setFromClause("from clients");
        queryProvider.setSortKey("id");

        return queryProvider;
    }
}
