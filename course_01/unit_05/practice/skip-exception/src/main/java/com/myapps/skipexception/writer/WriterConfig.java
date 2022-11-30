package com.myapps.skipexception.writer;

import com.myapps.skipexception.domain.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Customer> skipWriter() {
        return items -> {

            for (Customer item: items) {
                System.out.println(item.toString());
            }

        };
    }
}
