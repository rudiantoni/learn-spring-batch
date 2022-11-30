package com.myapps.skipexception.step;

import com.myapps.skipexception.domain.Customer;
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
    public Step skipStep(
        ItemReader<Customer> skipReader,
        ItemWriter<Customer> skipWriter

    ) {
        return stepBuilderFactory
            .get("skipStep")
            .<Customer, Customer>chunk(1)
            .reader(skipReader)
            .writer(skipWriter)
            .faultTolerant()
            .skip(Exception.class)
            .skipLimit(2)
            .build();
    }

}
