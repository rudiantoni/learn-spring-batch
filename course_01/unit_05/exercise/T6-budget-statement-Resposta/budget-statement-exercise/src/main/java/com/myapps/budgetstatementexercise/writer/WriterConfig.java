package com.myapps.budgetstatementexercise.writer;

import com.myapps.budgetstatementexercise.domain.BudgetItem;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterConfig {

    @SuppressWarnings("rawtypes")
    @Bean
    public ItemWriter budgetStatementWriter() {
        return items -> {
            for(Object item: items) {
                System.out.println(item.toString());
            }
        };
    }

}
