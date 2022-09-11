package com.myapps.arquivomultiplosformatos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JobArquivoConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public JobArquivoConfig (JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job jobArquivo(Step stepArquivo) {
        return jobBuilderFactory
                .get("jobArquivo")
                .start(stepArquivo)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
