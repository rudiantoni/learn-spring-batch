package com.myapps.budgetstatementexercise.step;

import com.myapps.budgetstatementexercise.reader.BudgetItemJdbcDelegatedReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
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
        // Leitor usado para ler de vários arquivos
        // MultiResourceItemReader<BudgetItem> budgetStatementReader,
        JdbcPagingItemReader bugdetStatementJdbcPagingReader,
        ItemWriter budgetStatementWriter
    ) {
        return stepBuilderFactory
            .get("budgetStatementStep")
            .chunk(1)
            //.reader(budgetStatementReader)
            .reader(new BudgetItemJdbcDelegatedReader(bugdetStatementJdbcPagingReader))
            .writer(budgetStatementWriter)
            .build();
    }

}
