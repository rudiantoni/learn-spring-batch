package com.myapps.arquivolargurafixa.writer;

import com.myapps.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
        // Funcionando corretamente
        return items -> items.forEach(
            System.out::println // Ação a ser executada em cada item que será lido da fonte de dados
        );
        // Erro proposital para testar a reinicialização do job
        /*return items -> {
            for(Cliente cliente: items) {
                if (cliente.getNome().equals("Maria")) {
                    throw new Exception();
                }
                else {
                    System.out.println(cliente.toString());
                }
            }
        };*/

    }
}
