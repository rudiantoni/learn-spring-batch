package com.myapps.jdbccursorreader.step;

import com.myapps.jdbccursorreader.domain.Client;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
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
    public Step jdbcCursorStep(
            ItemReader<Client> jdbcCursorReader,
            ItemWriter<Client> jdbcCursorWriter
    ) {
        return stepBuilderFactory
                .get("jdbcCursorStep")
                .<Client, Client>chunk(1)
                .reader(jdbcCursorReader)
                .writer(jdbcCursorWriter)
                .build();
    }
}
