package com.myapps.arquivomultiplosformatos.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WriterArquivoConfig {

    @SuppressWarnings("rawtypes")
    @Bean
    public ItemWriter writerArquivo() {

        // Também funciona, retorna diretamente uma expressão lambda sem subrotina
        //return items -> items.forEach(System.out::println);

        return items -> {

            for (Object item: items) {
                System.out.println(items);
            }

        };

    }
}
