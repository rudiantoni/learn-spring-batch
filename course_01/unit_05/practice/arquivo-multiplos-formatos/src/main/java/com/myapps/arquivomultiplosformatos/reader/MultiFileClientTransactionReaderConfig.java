package com.myapps.arquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.annotation.Resources;

@Configuration
public class MultiFileClientTransactionReaderConfig {

    @SuppressWarnings({"unchecked", "rawtypes"})
    @StepScope
    @Bean
    public MultiResourceItemReader multiFileClientTransactionReader(
            @Value("#{jobParameters['arquivosClientes']}") Resource[] arquivosClientes,
            FlatFileItemReader multiFileReader
    ) {

        return new MultiResourceItemReaderBuilder<>()
                .name("multiFileClientTransactionReader")
                .resources(arquivosClientes)
                .delegate(new ClientTransactionReader(multiFileReader))
                .build();
    }

}
