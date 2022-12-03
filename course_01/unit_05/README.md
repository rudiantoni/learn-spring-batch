# Unit 5 - Spring Batch Readers
[Home (online)](https://github.com/rudiantoni/learn-spring-batch)

## Practice

<details open><summary>Details</summary>

- [arquivo-largura-fixa](practice/arquivo-largura-fixa)
    - Reading files with fixed width content (fixed number of columns).
- [arquivo-largura-fixa-v2](practice/arquivo-largura-fixa-v2)
    - Reading files with fixed width content (fixed number of columns).
- [arquivo-delimitado](practice/arquivo-delimitado)
    - Reading files with values delimited by chars.
- [arquivo-multiplos-formatos](practice/arquivo-multiplos-formatos)
    - Reading files whose values are delimited by chars and that can be associated with more than one domain class (entity).
    - Stabilishing relations with domain classes register.
    - Reading multi data source files with path provided via job parameters.
    - Now using multi data source file reading with path provided by profile property.
    - Using delegate for mapping purposes and a better flow control.
- [xml-reader](practice/xml-reader)
    - Reading files using ItemReader reader and JAXB-2 Marshaller as a marshaller (write)/unmarshaller (read) for Java Objects and XML.
        - Marshal: means transform a Java Object into a XML document.
        - Unmarshal: means transform a XML document into a Java Object.
- [json-reader](practice/json-reader)
    - Reading files using JsonItemReader reader and using Jackson as a serializer between Java Objects and JSON.
- [jdbc-cursor-reader](practice/jdbc-cursor-reader)
    - Reading data with Cursor with reader JdbcCursorReader.
    - Using a secondary database connection, domain class auto mapped by attributes and result set equality.
    - In this project some database routines such as building migration and rollback scripts generation were automated via bash script.
    - Updated reader row mapping to a custom making it possible to use any database column name and any domain class attribute name.
    - Some code is commented, but it's showed the different ways to use the row mapper, and the bean row mapper.
- [jdbc-paging-reader](practice/jdbc-paging-reader)
    - Reading data with Pagination with reader JdbcPagingItemReader.
    - Using a secondary database connection, domain class auto mapped by attributes and result set equality.
    - Using generic query provider builder with SqlPagingQueryProviderFactoryBean to general usage.
    - Using PostgreSQL specific query provider builder with PostgresPagingQueryProvider to usage only with PostgreSQL databases for demonstration purposes. Some of the code was left commented to not affect the ordinary flow.
    - Using @Qualifier injected in constructor to define DataSource at the reader configuration.
    - Added property in order to be able to see logging about the paging and current data processing pagination in .properties file.
    - Updated contents and already present migration and rollback filenames.
    - Updated migration and rollback script to use standard flyway (not included in project) location.
    - Updated reader row mapping to a custom making it possible to use any database column name and any domain class attribute name.
    - Some code is commented, but it's showed the different ways to use the row mapper, and the bean row mapper.
- [skip-exception](practice/skip-exception)
    - Same as [jdbc-paging-reader](practice/jdbc-paging-reader).
    - There are a forced error (exception thrown) to emulate the skip failure policy.

</details>

## Content

<details><summary>Details</summary>

- [ArquivoLarguraFixaJob](content/ArquivoLarguraFixaJob)
    - Reading files with fixed width content (fixed number of columns).
- [ArquivoLarguraFixaJob-v2](content/ArquivoLarguraFixaJob-v2)
    - Reading files with fixed width content (fixed number of columns).
- [ArquivoDelimitadoJob](content/ArquivoDelimitadoJob)
    - Reading files with values delimited by chars.
- [ArquivoMultiplosFormatosJob](content/ArquivoMultiplosFormatosJob)
    - Reading files whose values are delimited by chars and that can be associated with more than one domain class (entity).
- [ArquivoMultiplosFormatosJob-v2](content/ArquivoMultiplosFormatosJob-v2)
    - Reading multi data source files with path provided via job parameters.
- [JdbcCursorReaderJob](content/JdbcCursorReaderJob)
    - Reading data from a database with a cursor based JDBC reader.
    - No result set remapping to the domain class.
- [JdbcPagingReaderJob](content/JdbcPagingReaderJob)
    - Reading data from a database with a paging based JDBC reader.
    - No result set remapping to the domain class.
- [SkipExceptionJob](content/SkipExceptionJob)
    - Reading data from a database with a paging based JDBC reader.
    - Result set remapped to the domain class.
    - Usage of skip failure tolerance

</details>

## Exercise

<details><summary>Details</summary>

- [budget-statement-exercise](exercise/T6-budget-statement-Resposta/budget-statement-exercise)
    - Project reading data from multiple files and returning custom objects to the writer with the usage of delegate.

</details>

