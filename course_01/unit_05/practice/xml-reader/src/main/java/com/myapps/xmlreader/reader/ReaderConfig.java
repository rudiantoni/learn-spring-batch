package com.myapps.xmlreader.reader;

import com.myapps.xmlreader.domain.Trade;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ReaderConfig {

    @Value("${source.data.file.path}") private String resourceFilePath;

    @Bean
    public StaxEventItemReader xmlReader() {

        return new StaxEventItemReaderBuilder<Trade>()
                .name("xmlReader")
                .resource(new FileSystemResource(resourceFilePath))
                .addFragmentRootElements("trade")
                .unmarshaller(tradeMarshaller())
                .build();
    }

    @Bean
    public XStreamMarshaller tradeMarshaller() {
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("trade", Trade.class);
        aliases.put("isin", String.class);
        aliases.put("quantity", Integer.class);
        aliases.put("price", Float.class);
        aliases.put("customer", String.class);

        XStreamMarshaller marshaller = new XStreamMarshaller();

        marshaller.setAliases(aliases);

        return marshaller;
    }



}
