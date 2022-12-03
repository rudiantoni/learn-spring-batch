package com.myapps.budgetstatementexercise.step;

import com.myapps.budgetstatementexercise.domain.BudgetCategory;
import com.myapps.budgetstatementexercise.domain.BudgetItem;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    public StepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    public Step budgetStatementStep(
        MultiResourceItemReader<BudgetItem> budgetStatementReader,
        ItemWriter<BudgetCategory> budgetStatementWriter
    ) {
        return stepBuilderFactory
            .get("budgetStatementStep")
            .<BudgetItem, BudgetCategory>chunk(1)
            .reader(budgetStatementReader)
            .writer(budgetStatementWriter)
            .build();
    }

}
