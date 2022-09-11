package com.myapps.arquivodelimitado.step;

import com.myapps.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoDelimitadoStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public ArquivoDelimitadoStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step arquivoDelimitadoStep(
            ItemReader<Cliente> arquivoDelimitadoReader,
            ItemWriter<Cliente> arquivoDelimitadoWriter
    ) {
        return stepBuilderFactory
                .get("arquivoDelimitadoStep")
                .<Cliente, Cliente>chunk(1)
                .reader(arquivoDelimitadoReader)
                .writer(arquivoDelimitadoWriter)
                .build();
    }



}
