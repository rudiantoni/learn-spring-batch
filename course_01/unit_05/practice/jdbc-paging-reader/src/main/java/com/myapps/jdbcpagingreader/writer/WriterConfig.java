package com.myapps.jdbcpagingreader.writer;

import com.myapps.jdbcpagingreader.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Client> jdbcPagingWriter() {
        return items -> {
            System.out.println("Writing clients: ");
            for (Client item: items) {
                System.out.println(item.toString());
            }
        };
    }
}
