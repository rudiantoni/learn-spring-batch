package com.springbatch.arquivolargurafixa.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivolargurafixa.dominio.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaReaderConfig {
	
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader() {
		//TODO: Implementar leitor de arquivo de largura fixa.
		return null;
	}
}
