package com.myapps.xmlreader.writer;

import com.myapps.xmlreader.domain.Trade;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @Bean
    public ItemWriter<Trade> xmlWriter() {

        return items -> {

            for (Trade item: items) {
                System.out.println(items.toString());
            }

        };

    }



}
