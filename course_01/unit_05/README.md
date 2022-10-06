# Unit 5 - Spring Batch Readers
[Home (online)](https://github.com/rudiantoni/learn-spring-batch)

## Practice
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
- [xml-reader](practice/xml-reader)
    - Reading files using ItemReader reader and JAXB-2 Marshaller as a marshaller (write)/unmarshaller (read) for Java Objects and XML.
        - Marshal: means transform a Java Object into a XML document.
        - Unmarshal: means transform a XML document into a Java Object.
- [json-reader](practice/json-reader)
    - Reading files using JsonItemReader reader and using Jackson as a serializer between Java Objects and JSON.
- [jdbc-cursor-reader](practice/jdbc-cursor-reader)
    - Reading files from a secondary database connection using JdbcCursorReader, without remapping all class attributes to match the result set (database query result).
    - In this project some database routines such as building migration and rollback scripts generation were automated via bash script.

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
    - No domain class remapping to the result set.

</details>

## Exercise

<details><summary>Details</summary>

working...

</details>

