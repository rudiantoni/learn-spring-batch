package com.springbatch.arquivodelimitado.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.arquivodelimitado.dominio.Cliente;

@Configuration
public class LeituraArquivoDelimitadoReaderConfig {
	
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoDelimitadoReader() {
		// TODO Implementar leitor de arquivo delimitado.
		return null;
    }
}
