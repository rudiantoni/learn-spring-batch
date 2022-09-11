package com.myapps.arquivomultiplosformatos.reader;

import com.myapps.arquivomultiplosformatos.dominio.Cliente;
import com.myapps.arquivomultiplosformatos.dominio.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.Line;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapperConfig {

    @Bean
    public PatternMatchingCompositeLineMapper arquivoLineMapper() {
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper();
        // Separador de dados (em palavras, etc,) da linha
        lineMapper.setTokenizers(tokenizers());
        // Mapeia os dados de uma linha para uma classe de dominio
        lineMapper.setFieldSetMappers(fieldSetMappers());
        return lineMapper;
    }

    /**
     * Tokenizadores
     */
    private Map<String, LineTokenizer> tokenizers() {
        // Mapeia todos as possíveis configurações de tokenizadores
        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        // Linhas começadas com 0 são dados de Cliente
        tokenizers.put("0*", clienteLineTokenizer());
        // Linhas começadas com 1 são dados de Transacao
        tokenizers.put("1*", transacaoLineTokenizer());
        return tokenizers;
    }

    private LineTokenizer clienteLineTokenizer() {
        // Arquivo do tipo delimitado (por algum caractere)
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        // Atributos da classe que receberão os valores das linhas
        lineTokenizer.setNames("nome", "sobrenome", "idade", "email");
        // Índices dos campos a serem inseridos, baseados em 0
        // Nesse caso não foi adicionado o 0, pois ele representa apenas o tipo de dado da linha
        lineTokenizer.setIncludedFields(1, 2, 3, 4);
        return lineTokenizer;
    }

    private LineTokenizer transacaoLineTokenizer() {
        // Arquivo do tipo delimitado (por algum caractere)
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        // Atributos da classe que receberão os valores das linhas
        lineTokenizer.setNames("id", "descrição", "valor");
        // Índices dos campos a serem inseridos, baseados em 0
        // Nesse caso não foi adicionado o 0, pois ele representa apenas o tipo de dado da linha
        lineTokenizer.setIncludedFields(1, 2, 3);
        return lineTokenizer;
    }

    /**
     * Mepadores de conjunto de campos
     */
    @SuppressWarnings("rawtypes")
    private Map<String, FieldSetMapper> fieldSetMappers() {
        // Mapeia todos os possíveis mapeadores
        Map<String, FieldSetMapper> fieldSetMappers = new HashMap<>();
        // Linhas começadas com 0 são dados de Cliente
        fieldSetMappers.put("0*", fieldSetMapper(Cliente.class));
        // Linhas começadas com 0 são dados de Transacao
        fieldSetMappers.put("1*", fieldSetMapper(Transacao.class));
        return fieldSetMappers;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private FieldSetMapper fieldSetMapper(Class domainClass) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        // Define a classe que receberá os dados segundo os tokenizadores
        fieldSetMapper.setTargetType(domainClass);
        return fieldSetMapper;
    }

}
