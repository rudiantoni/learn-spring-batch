# learn-spring-batch - Course 1

Every developed project aims to use Gradle as the preferred JVM building tool and PostgreSQL as database.

Some projects were developed using different dependencies, such as Maven, MySQL and even H2, but some of them were not developed by me.

Versioning was only implemented in the Unit 5, so most of the code before is in Portuguese and with no major details.

> Unit 1 - Introduction, is not inserted since there's no code to show.

## Unit 2 - Spring Batch framework overview

### Practice
- [PrimeiroProjetoSpringBatch](course_01/unit_02/practice/primeiro-projeto-spring-batch)
    - First developed project, with a basic job, step and tasklet working structure.
    - Gradle, H2 (in memory database).

### Exercise
- [T1-PrimeiroProjetoSpringBatch-Exercicio](course_01/unit_02/exercise/T1-PrimeiroProjetoSpringBatch-Exercicio)
    - Exercise original project.
    - maven, h2.
    - Objective: The project is not working, so it needs to be fixed. This way we can practice the Spring Batch structure.
    - [T1-PrimeiroProjetoSpringBatch-Exercicio-Resposta](course_01/unit_02/exercise/T1-PrimeiroProjetoSpringBatch-Exercicio-Resposta)
        - Exercise answer.
        - maven, h2.
        - Project working properly.

## Unit 3 - Working with Jobs and Steps

### Content
- [ParImparJob](course_01/unit_03/content/ParImparJob)
    - Basic tasklets structure boilerplate with no implementations.
    - maven, mysql.
- [PrimeiroJobSpringBatch](course_01/unit_03/content/PrimeiroJobSpringBatch)
    - Basic working tasklets structure.
    - maven, mysql

### Practice
- [refactor-primeiro-projeto-spring-batch](course_01/unit_03/practice/refactor-primeiro-projeto-spring-batch)
    - First project refactoring. Applied single responsibility.
    - gradle, h2.
- [spring-batch-par-impar](course_01/unit_03/practice/spring-batch-par-impar)
    - Basic working structure without single responsibility.
    - Uses application argument execution and connects to a database for metadata persinstence.
    - gradle, mysql.
- Other:
    - [Clear Spring Batch metadata in MySQL database](course_01/unit_03/practice/limpar_metadados_springbatch.sql)

### Exercise
- [T2-ConfiguracaoJob-Exercicio](course_01/unit_03/exercise/T2-ConfiguracaoJob-Exercicio)
    - Exercise original project.
    - Objective: Find and fix the project settings errors until the project is running properly.
    - maven, mysql.
    - [T2-ConfiguracaoJob-Exercicio-Resposta](course_01/unit_03/exercise/T2-ConfiguracaoJob-Exercicio-Resposta)
        - Exercise answer.
        - maven, mysql.
- [T3-ParImparJob](course_01/unit_03/exercise/T3-ParImparJob)
    - Exercise original project.
    - Objective: Apply single responsibility in the code and make it work properly.
    - maven, mysql.
    - [T3-ParImparJob-Resposta](course_01/unit_03/exercise/T3-ParImparJob-Resposta)
        - Exercise answer.
        - maven, mysql.
    - [T3-GabaritoParImparJob](course_01/unit_03/exercise/T3-GabaritoParImparJob)
        - Exercise instructor answer.
        - maven, mysql.

## Unit 4 - Jobs in the production environment

### Content
- [PrimeiroJobSpringBatch](course_01/unit_04/content/PrimeiroJobSpringBatch)
    - Project connecting two databases and using custom log settings.
    - maven, mysql.

### Practice
- [primeiro-projeto-spring-batch-v2](course_01/unit_04/practice/primeiro-projeto-spring-batch-v2)
    - Project changing from the first developed version
    - Using internal properties.
    - Using MySQL database.
    - gradle, mysql.
- [primeiro-projeto-spring-batch-v3](course_01/unit_04/practice/primeiro-projeto-spring-batch-v3)
    - Using external properties.
    - gradle, mysql.
- [primeiro-projeto-spring-batch-v4](course_01/unit_04/practice/primeiro-projeto-spring-batch-v4)
    - Using PostgreSQL database.
    - gradle, postgresql.
- [primeiro-projeto-spring-batch-v5](course_01/unit_04/practice/primeiro-projeto-spring-batch-v5)
    - Using two databases.
    - gradle, postgresql.
- [primeiro-projeto-spring-batch-v6](course_01/unit_04/practice/primeiro-projeto-spring-batch-v6)
    - Using log tool log4j2 (logback removed)
    - gradle, postgresql.
- [primeiro-projeto-spring-batch-v7](course_01/unit_04/practice/primeiro-projeto-spring-batch-v7)
    - Using log tool logback (log4j2 removed)
    - gradle, postgresql.
- [primeiro-projeto-spring-batch-v8](course_01/unit_04/practice/primeiro-projeto-spring-batch-v8)
    - Using log definitions internally with the .xml file in resources.
    - Using properties definitions internally with the application.properties file in resources.
- Other
    - [Old versioning local control](course_01/unit_04/practice/Versões.txt)
    - [Log .xml settings file](course_01/unit_04/practice/log4j.xml)

### Exercise
- [T5-ProducaoParImparJob-Exercicio](course_01/unit_04/exercise/T5-ProducaoParImparJob-Exercicio)
    - Exercise original project.
    - Objective: Using a project emulating a real production environment
        - With externalized log settings, logging files and properties.
        - Connection with more than one database via Class configuration.
        - Usage of job, step, reader, processor and writer.
    - maven, mysql.
    - [T5-ProducaoParImparJob-Resposta](course_01/unit_04/exercise/T5-ProducaoParImparJob-Resposta)
        - Exercise answer.
        - maven, mysql.
    - [T5-ProducaoParImparJob-Gabarito](course_01/unit_04/exercise/T5-ProducaoParImparJob-Gabarito)
        - Exercise instructor answer.
        - maven, mysql.

## Unit 5 - Spring Batch Readers

### Content
- [ArquivoLarguraFixaJob](course_01/unit_05/content/ArquivoLarguraFixaJob)
    - Reading files with fixed width content (fixed number of columns).
    - maven, mysql.
- [ArquivoLarguraFixaJob-v2](course_01/unit_05/content/ArquivoLarguraFixaJob-v2)
    - Reading files with fixed width content (fixed number of columns).
    - maven, mysql.
- [ArquivoDelimitadoJob](course_01/unit_05/content/ArquivoDelimitadoJob)
    - Reading files with values delimited by chars.
    - maven, mysql.
- [ArquivoMultiplosFormatosJob](course_01/unit_05/content/ArquivoMultiplosFormatosJob)
    - Reading files whose values are delimited by chars and that can be associated with more than one domain class (entity).
    - maven, mysql.

### Practice
- [arquivo-largura-fixa](course_01/unit_05/practice/arquivo-largura-fixa)
    - Reading files with fixed width content (fixed number of columns).
    - gradle, postgresql.
- [arquivo-largura-fixa-v2](course_01/unit_05/practice/arquivo-largura-fixa-v2)
    - Reading files with fixed width content (fixed number of columns).
    - gradle, postgresql.
- [arquivo-delimitado](course_01/unit_05/practice/arquivo-delimitado)
    - Reading files with values delimited by chars.
    - gradle, postgresql.
- [arquivo-multiplos-formatos](course_01/unit_05/practice/arquivo-multiplos-formatos)
    - Reading files whose values are delimited by chars and that can be associated with more than one domain class (entity).
    - Stabilishing relations with domain classes register.
    - gradle, postgresql.

### Exercise


<!-- 
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