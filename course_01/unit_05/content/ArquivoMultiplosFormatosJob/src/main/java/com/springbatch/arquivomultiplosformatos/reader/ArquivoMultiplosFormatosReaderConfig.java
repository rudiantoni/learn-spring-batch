package com.springbatch.arquivomultiplosformatos.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoMultiplosFormatosReaderConfig {

	@Bean
	public FlatFileItemReader arquivoMultiplosFormatosItemReader() {
		// TODO: Implementar leitor de múltiplos formatos.
		return null;
	}

}
