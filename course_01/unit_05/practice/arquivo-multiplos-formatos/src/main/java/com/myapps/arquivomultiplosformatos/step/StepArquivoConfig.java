package com.myapps.arquivomultiplosformatos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepArquivoConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public StepArquivoConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step stepArquivo(
            FlatFileItemReader readerArquivo,
            ItemWriter writerArquivo
    ) {
        return stepBuilderFactory
                .get("stepArquivo")
                .chunk(1)
                .reader(readerArquivo)
                .writer(writerArquivo)
                .build();
    }

}
