package com.myapps.arquivolargurafixa.reader;

import com.myapps.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(
            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes
    ) {
            return new FlatFileItemReaderBuilder<Cliente>()
                    .name("leituraArquivoLarguraFixaReader") // Nome do método do leitor
                    .resource(arquivoClientes) // Recurso a ser utilizado (arquivo local)
                    .fixedLength() // Tipo do recurso: largura fixa
                    .columns(new Range[]{ // Números de início e fim das colunas do arquivo
                            new Range(1,10), // Nome
                            new Range(11,20), // Sobrenome
                            new Range(21,23), // Idade
                            new Range(24,43), // E-mail
                    })
                    .names(new String[]{"nome", "sobrenome", "idade", "email"}) // Nomes das propriedades da Classe a seguir
                    .targetType(Cliente.class) // Classe para transformar os dados lidos
                    .build();
    }
}
