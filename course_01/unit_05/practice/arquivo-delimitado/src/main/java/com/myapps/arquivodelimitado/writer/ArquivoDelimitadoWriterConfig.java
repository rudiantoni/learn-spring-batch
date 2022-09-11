package com.myapps.arquivodelimitado.writer;

import com.myapps.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoDelimitadoWriterConfig {

    @Bean
    public ItemWriter<Cliente> arquivoDelimitadoWriter() {
        return items -> {
            for(Cliente cliente: items) {
                System.out.println(cliente.toString());
            }
        };

    }

}
