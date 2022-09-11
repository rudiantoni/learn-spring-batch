package com.myapps.arquivodelimitado.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ArquivoDelimitadoJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public ArquivoDelimitadoJobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job arquivoDelimitadoJob(
            Step arquivoDelimitadoStep
    ) {
        return jobBuilderFactory
                .get("arquivoDelimitadoJob")
                .start(arquivoDelimitadoStep)
                .incrementer(new RunIdIncrementer())
                .build();

    }

}
