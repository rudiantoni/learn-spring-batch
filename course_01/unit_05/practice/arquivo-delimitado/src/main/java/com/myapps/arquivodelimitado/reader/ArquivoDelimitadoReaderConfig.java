package com.myapps.arquivodelimitado.reader;

import com.myapps.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ArquivoDelimitadoReaderConfig {

    @StepScope // Adicionado para ser possível acessar o parâmetro do arquivo
    @Bean
    public FlatFileItemReader<Cliente> arquivoDelimitadoReader(
        @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes
    ) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("arquivoDelimitadoReader")
                .resource(arquivoClientes)
                .delimited()
                .names(new String[]{"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();
    }



}
