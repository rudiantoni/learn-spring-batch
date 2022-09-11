package com.myapps.arquivolargurafixa.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoLarguraFixaJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public ArquivoLarguraFixaJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job arquivoLarguraFixaJob(Step leituraArquivoLarguraFixaStep) {
        return jobBuilderFactory
                .get("arquivoLarguraFixaJob")
                .start(leituraArquivoLarguraFixaStep)
                //.incrementer(new RunIdIncrementer()) // Isso serve para permitir executar várias vezes o mesmo job com os mesmos parâmetros, mas é impossível reiniciar um job no caso de erro.
                .build();
    }

}
