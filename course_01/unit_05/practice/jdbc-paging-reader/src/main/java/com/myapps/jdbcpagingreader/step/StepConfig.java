package com.myapps.jdbcpagingreader.step;

import com.myapps.jdbcpagingreader.domain.Client;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public StepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step jdbcPagingStep(
        ItemReader<Client> jdbcPagingReader,
        ItemWriter<Client> jdbcPagingWriter
    ) {
        return stepBuilderFactory
            .get("jdbcPagingStep")
            .<Client, Client>chunk(1)
            .reader(jdbcPagingReader)
            .writer(jdbcPagingWriter)
            .build();
    }
}
