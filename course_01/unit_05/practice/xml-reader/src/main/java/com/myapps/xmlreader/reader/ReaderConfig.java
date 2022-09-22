package com.myapps.xmlreader.reader;

import com.myapps.xmlreader.domain.Trade;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ReaderConfig {

    private final String resourceFilePath;

    public ReaderConfig(
            @Value("${source.data.file.path}") String resourceFilePath
    ) {
        this.resourceFilePath = resourceFilePath;
    }

    @Bean
    public ItemReader<Trade> xmlReader() {

        return new StaxEventItemReaderBuilder<Trade>()
                .name("xmlReader")
                .resource(new FileSystemResource(resourceFilePath))
                .addFragmentRootElements("trade") // XML fragment that identifies a single "item in a list", which contains information about an unique register
                .unmarshaller(tradeUnmarshaller()) // Unmarshaller: Read XML documents to Java Objects
                .build();

    }

    private Jaxb2Marshaller tradeUnmarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Trade.class);

        return marshaller;
    }

}

