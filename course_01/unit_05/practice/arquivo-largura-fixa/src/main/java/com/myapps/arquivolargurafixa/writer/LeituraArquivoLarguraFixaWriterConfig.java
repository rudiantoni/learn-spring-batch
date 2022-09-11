package com.myapps.arquivolargurafixa.writer;

import com.myapps.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
        return items -> items.forEach(
                System.out::println // Ação a ser executada em cada item que será lido da fonte de dados
        );
    }
}
