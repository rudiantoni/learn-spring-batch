package com.myapps.jsonreader.writer;

import com.myapps.jsonreader.domain.Trade;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Trade> jsonWriter() {
        return items -> {
            for (Trade item: items) {
                System.out.println(items.toString());
            }
        };
    }
}
