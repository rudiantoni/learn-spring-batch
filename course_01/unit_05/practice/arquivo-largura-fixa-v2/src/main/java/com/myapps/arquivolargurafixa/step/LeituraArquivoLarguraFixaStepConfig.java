package com.myapps.arquivolargurafixa.step;

import com.myapps.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public LeituraArquivoLarguraFixaStepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step leituraArquivoLarguraFixaStep(
            ItemReader<Cliente> leituraArquivoLarguraFixaReader,
            ItemWriter<Cliente> leituraArquivoLarguraFixaWriter
    ) {
        return stepBuilderFactory
                .get("leituraArquivoLarguraFixaStep") // Nome do método do step
                .<Cliente, Cliente>chunk(4) // Tipo do leitor, tipo do escritor e tamanho da quantidade de registros processados por vez
                .reader(leituraArquivoLarguraFixaReader) // Indica quem é o leitor
                .writer(leituraArquivoLarguraFixaWriter) // Indica quem é o escritor
                .build();
    }



}
