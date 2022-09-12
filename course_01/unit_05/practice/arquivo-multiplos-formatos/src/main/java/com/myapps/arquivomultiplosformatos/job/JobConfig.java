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
public class JobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    public JobConfig(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    /**
     * The .incrementer(new RunIdIncrementer()) option allows the job to run everytime the application
     * is started.
     * A job using this building option, can't be restarted if some error occurs.
     * <p>
     * If there's saved metadata in the job repository before the first time it runs with this option,
     * the job will not be executed, so the metadata must be cleared. Empty all the metadata tables.
     * <p>
     * If this option is not used, the application needs to be run at least one argument
     * whose value has not yet been used in a successful run, otherwise the application will not
     * run the job. But it's recovery (i.e. restart job from where it stopped on error) keeps working.
     */
    @Bean
    public Job job(
            Step step // Parameter is another bean annotated method: step -> StepConfig
    ) {
        return jobBuilderFactory
                .get("job") // Normally this bean method name
                .start(step)
                .incrementer(new RunIdIncrementer()) // See comment above
                .build();
    }

}
