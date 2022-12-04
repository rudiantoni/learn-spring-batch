# learn-spring-batch

This repository contains projects referring to my personal learning about the Spring Batch framework.

## Course 1

This course is divided in units, for now, each of them have 3 categories:
- **Content**: the original content provided in the course by the instructor.
- **Practice**: my own code developed in the course progression with various changes.
- **Exercise**: some tasks provided by the instructor in order to practice the code shown.

There will be no mentions or links to any type of content on purpose, but there are some names that can normally appear in the code.

## Technical

Every project was developed with Java and aims to use Gradle as the preferred JVM building tool, PostgreSQL as database and Logback (Spring standard) as logging tool.

In some cases different tools have been implemented, but this is not the focus at the moment so there is no single standard in which content is made available.

Some projects were developed in Maven, and using different dependencies, such as MySQL, H2 (in memory database) anc Log4j2.

- Projects in the **practice** category are using Gradle and PostgreSQL (Unit 4 and afterwards), except where specified.
    - In some cases it uses H2 and MySQL as the course progresses.
- Projects in the **content** and **exercise** category are using Maven and MySQL, except where specified.
    - In some cases it uses H2 as the course progresses.

The logging tools were not a focus yet, but there's some changing involving them.

Versioning via Git was only implemented in the Unit 5, so most of the code before is in Portuguese and with no major details and with a unusual project structure.

In this Readme, only the **practice** projects will be shown, if you want to see **exercise** or **content**, you must follow the links to the desired unit and expand its sections.

> TODO: update these projects to Spring 3.0: Spring Batch 5.0

> Unit 1 - Introduction, is not inserted since there's no code to show.

---

## [Unit 2 - Spring Batch framework overview](course_01/unit_02)

- [PrimeiroProjetoSpringBatch](course_01/unit_02/practice/primeiro-projeto-spring-batch)
    - First developed project, with a basic job, step and tasklet working structure.

---

## [Unit 3 - Working with Jobs and Steps](course_01/unit_03)

- [refactor-primeiro-projeto-spring-batch](course_01/unit_03/practice/refactor-primeiro-projeto-spring-batch)
    - First project refactoring. Applied single responsibility.
- [segundo-projeto-spring-batch](course_01/unit_03/practice/segundo-projeto-spring-batch)
    - Basic working structure without single responsibility. Uses application argument execution and connects to a MySQL database for metadata persistence.

---

## [Unit 4 - Jobs in the production environment](course_01/unit_04)

- [primeiro-projeto-spring-batch-v8](course_01/unit_04/practice/primeiro-projeto-spring-batch-v8)
    - After various changes in logs (between log4j2 and logback, with external and internal xml definitions), properties (both external and internal definitions) and the database (changed to PostgreSQL) with an additional database defined for future batch application data read. That was  the first defined standard projects to follow.
---

## [Unit 5 - Spring Batch Readers](course_01/unit_05)

- [arquivo-largura-fixa-v2](course_01/unit_05/practice/arquivo-largura-fixa-v2)
    - Reading files with fixed width content (fixed number of columns).
- [arquivo-delimitado](course_01/unit_05/practice/arquivo-delimitado)
    - Reading files with values delimited by chars.
- [arquivo-multiplos-formatos](course_01/unit_05/practice/arquivo-multiplos-formatos)
    - Reading files whose values are delimited by chars and that can be associated with more than one domain class (entity).
    - Stabilishing relations with domain classes register.
    - Reading multi data source files with path provided via job parameters.
    - Now using multi data source file reading with path provided by profile property.
    - Using delegate for mapping purposes and a better flow control.
- [xml-reader](course_01/unit_05/practice/xml-reader)
    - Reading files using ItemReader reader and JAXB-2 Marshaller as a marshaller (write)/unmarshaller (read) for Java Objects and XML.
        - Marshal: means transform a Java Object into a XML document.
        - Unmarshal: means transform a XML document into a Java Object.
- [json-reader](course_01/unit_05/practice/json-reader)
    - Reading files using JsonItemReader reader and using Jackson as a serializer between Java Objects and JSON.
- [jdbc-cursor-reader](course_01/unit_05/practice/jdbc-cursor-reader)
    - Reading data with Cursor with reader JdbcCursorReader.
    - Using a secondary database connection, domain class auto mapped by attributes and result set equality.
    - In this project some database routines such as building migration and rollback scripts generation were automated via bash script.
    - Updated reader row mapping to a custom making it possible to use any database column name and any domain class attribute name.
    - Some code is commented, but it's showed the different ways to use the row mapper, and the bean row mapper.
- [jdbc-paging-reader](course_01/unit_05/practice/jdbc-paging-reader)
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
- [budget-statement-exercise](course_01/unit_05/exercise/T6-budget-statement-Resposta/budget-statement-exercise)
    - An exercise made in a different way.
    - Project reading data from multiple files and returning custom objects to the writer with the usage of delegate.
    - Updated project, now it's reading data from database with JdbcPagingItemReader, using delegate directly at the Step config.
    - This can be a good reference for delegate, multi file source and database reading usage.
    - Objective: 1. Print data in a certain format using multiple files as data source.
        - Read data from multiple files.
        - Delegating a reader from another reader to properly read and deliver the data to the writer in the correct form.
        - Write the data to the screen in the specified way.
        - Structure usage in answer:
            - Domain: BudgetItem and BudgetCategory
            - Job: No parameter.
            - Step: MultiResourceItemReader and ItemWriter.
            - Reader: MultiResourceItemReader (delegating to BudgetItemDelegatedReader that implements ItemStreamReader and ResourceAwareItemReaderItemStream, and needs a FlatFileItemReader as delegated reader), FlatFileItemReader, GenericApplicationContext,  LineMapper, LineTokenizer and FieldSetMapper.
            - Writer: ItemWriter.
    - Objective: 2. Same as before, but the data must be read from a database.
        - Read data from database.
        - Delegating a reader from the step to properly read and deliver the data to the writer in the correct form.
        - Structure usage in answer:
            - Config: DataSource
            - Domain: BudgetItem and BudgetCategory
            - Job: No parameter.
            - Step: JdbcPagingItemReader (delegating to BudgetItemJdbcDelegatedReader that implements ItemStreamReader, and needs a JdbcPagingItemReader) and ItemWriter.
            - Reader: JdbcPagingItemReader, DataSource, PostgresPagingQueryProvider and RowMapper.
            - Writer: ItemWriter.

---




<!-- 

<details><summary>Details</summary>

</details>
- [x](x)
    - x
    - x
- [x](x)
    - x
    - x
- [x](x)
    - x
    - x
- [x](x)
    - x
    - x
- [x](x)
    - x
    - x
- [x](x)
    - x
    - x
-->
