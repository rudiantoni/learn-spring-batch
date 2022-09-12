package com.myapps.arquivomultiplosformatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public StepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean // Must be a bean (and public) so the job can find it
    public Step step(
            FlatFileItemReader reader, // Parameter is another bean annotated method: reader -> ReaderConfig
            ItemWriter writer // Parameter is another bean annotated method: writer -> WriterConfig
    ) {
        return stepBuilderFactory
                .get("step") // Normally this bean method name
                //.<Client, Client>chunk(1) // Reader and writer classes aren't used when the datasource can be any of them
                .chunk(1) // Amount of data to be processed each time this step is executed
                .reader(reader) // Reader bean to this step
                .writer(writer) // Writer bean to this step
                .build();
    }

}
