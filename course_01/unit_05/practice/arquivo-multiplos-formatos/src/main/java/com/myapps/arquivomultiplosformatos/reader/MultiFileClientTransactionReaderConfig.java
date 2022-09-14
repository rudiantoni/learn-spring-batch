package com.myapps.arquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.*;

import javax.annotation.Resources;
import java.io.IOException;

@Configuration
public class MultiFileClientTransactionReaderConfig {

    @Value("${source.data.files.path}") private String sourceDataFilesPath;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @StepScope
    @Bean
    public MultiResourceItemReader multiFileClientTransactionReader(
            FlatFileItemReader multiFileReader
    ) {
        try {
            GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
            Resource[] resources = genericApplicationContext.getResources("file:" + sourceDataFilesPath);
            return new MultiResourceItemReaderBuilder<>()
                    .name("multiFileClientTransactionReader")
                    .resources(resources)
                    .delegate(new ClientTransactionReader(multiFileReader))
                    .build();

        } catch (IOException e) {
            throw new RuntimeException("Unable to find or parse specified resources: " + sourceDataFilesPath + ".\n" + e.getMessage());
        }
    }

}
