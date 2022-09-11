package com.myapps.arquivomultiplosformatos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ReaderArquivoConfig {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @StepScope // Permite que o reader entre no escopo de step, e assim pode acessar os parâmetros enviados para a aplicação
    @Bean
    public FlatFileItemReader readerArquivo(
            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes,
            LineMapper arquivoLineMapper
    ) {
        return new FlatFileItemReaderBuilder()
                .name("readerArquivo")
                .resource(arquivoClientes)
                .lineMapper(arquivoLineMapper)
                .build();
    }

}
