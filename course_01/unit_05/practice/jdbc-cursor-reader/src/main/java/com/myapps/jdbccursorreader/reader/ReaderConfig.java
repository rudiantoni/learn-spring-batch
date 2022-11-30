package com.myapps.jdbccursorreader.reader;

import com.myapps.jdbccursorreader.domain.Client;
import com.myapps.jdbccursorreader.domain.ClientRowMapper;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class ReaderConfig {

    // Usage to inject the ClientRowMapper implementation, and use it in the reader configuration
    /*
    private final ClientRowMapper clientRowMapper;
    public ReaderConfig(ClientRowMapper clientRowMapper) {
        this.clientRowMapper = clientRowMapper;
    }
    */
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
                    The mapper below must be used only if the domain class attributes are the same as the result set fields
                    or columns from the database, or following standard naming conventions such as field_name = fieldName
                    beanRowMapper(domain_class) or
                    rowMapper(new BeanPropertyRowMapper<domain_class>(domain_class))
                */
                //.beanRowMapper(Client.class)
                /*
                    The mapper below can be used everytime, that's the recommended method, since it can map any result set
                    field or column names from the database to any domain class attribute.
                    Just need to implement the RowMapper interface.
                */
                //.rowMapper(clientRowMapper)
                .rowMapper(rowMapper())
                .build();
    }

    private RowMapper<Client> rowMapper() {
        return new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                Client client = new Client();
                client.setFirstName(rs.getString("first_name"));
                client.setLastName(rs.getString("last_name"));
                client.setAge(rs.getString("age"));
                client.setEmail(rs.getString("email"));
                return client;
            }
        };
    }
}
