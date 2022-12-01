package com.myapps.budgetstatementexercise.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public JobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job budgetStatementJob(
        Step budgetStatementStep
    ) {
        return jobBuilderFactory
            .get("budgetStatementJob")
            .start(budgetStatementStep)
            .incrementer(new RunIdIncrementer())
            .build();
    }
}
