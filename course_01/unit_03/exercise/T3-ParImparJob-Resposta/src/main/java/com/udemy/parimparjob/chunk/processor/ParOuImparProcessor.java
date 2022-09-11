package com.udemy.parimparjob.chunk.processor;

import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ParOuImparProcessor {
    @Bean
    public FunctionItemProcessor<Integer, String> verificaParImparProcessor() {
        return new FunctionItemProcessor<Integer, String>
                (item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Ímpar", item));
    }
}
