package com.myapps.jdbccursorreader.writer;

import com.myapps.jdbccursorreader.domain.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Client> jdbcCursorWriter() {
        
        return items -> {

            for (Client item: items) {
                System.out.println(item.toString());
            }

        };
    }
}
