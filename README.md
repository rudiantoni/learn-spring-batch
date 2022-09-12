# learn-spring-batch - Course 1

## About

This repository contains projects referring to my personal learning about the Spring Batch framework.

This course is divided in units, for now, each of them have 3 categories:
- **Content**: the original content provided in the course by the instructor.
- **Practice**: my own code developed in the course progression with various changes.
- **Exercise**: some tasks provided by the instructor in order to practice the code shown.

There will be no mentions or links to any type of content on purpose, but the names can normally appear in the code.

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

> Unit 1 - Introduction, is not inserted since there's no code to show.

---

## [Unit 2 - Spring Batch framework overview](course_01/unit_02/)

<details><summary>Details</summary>

### Practice
- [PrimeiroProjetoSpringBatch](course_01/unit_02/practice/primeiro-projeto-spring-batch)
    - First developed project, with a basic job, step and tasklet working structure.
    - H2.

### Exercise
- [T1-PrimeiroProjetoSpringBatch-Exercicio](course_01/unit_02/exercise/T1-PrimeiroProjetoSpringBatch-Exercicio)
    - Exercise original project.
    - H2.
    - Objective: The project is not working, so it needs to be fixed. This way we can practice the Spring Batch structure.
    - [T1-PrimeiroProjetoSpringBatch-Exercicio-Resposta](course_01/unit_02/exercise/T1-PrimeiroProjetoSpringBatch-Exercicio-Resposta)
        - Exercise answer.
        - H2.
        - Project working properly.

</details>

---

## Unit 3 - Working with Jobs and Steps

<details><summary>Details</summary>

### Content
- [ParImparJob](course_01/unit_03/content/ParImparJob)
    - Basic tasklets structure boilerplate with no implementations.
- [PrimeiroJobSpringBatch](course_01/unit_03/content/PrimeiroJobSpringBatch)
    - Basic working tasklets structure.

### Practice
- [refactor-primeiro-projeto-spring-batch](course_01/unit_03/practice/refactor-primeiro-projeto-spring-batch)
    - First project refactoring. Applied single responsibility.
    - H2.
- [spring-batch-par-impar](course_01/unit_03/practice/spring-batch-par-impar)
    - Basic working structure without single responsibility.
    - Uses application argument execution and connects to a database for metadata persinstence.
    - MySQL.
- Other:
    - [Clear Spring Batch metadata in MySQL database](course_01/unit_03/practice/limpar_metadados_springbatch.sql)

### Exercise
- [T2-ConfiguracaoJob-Exercicio](course_01/unit_03/exercise/T2-ConfiguracaoJob-Exercicio)
    - Exercise original project.
    - Objective: Find and fix the project settings errors until the project is running properly.
    - [T2-ConfiguracaoJob-Exercicio-Resposta](course_01/unit_03/exercise/T2-ConfiguracaoJob-Exercicio-Resposta)
        - Exercise answer.
- [T3-ParImparJob](course_01/unit_03/exercise/T3-ParImparJob)
    - Exercise original project.
    - Objective: Apply single responsibility in the code and make it work properly.
    - [T3-ParImparJob-Resposta](course_01/unit_03/exercise/T3-ParImparJob-Resposta)
        - Exercise answer.
    - [T3-GabaritoParImparJob](course_01/unit_03/exercise/T3-GabaritoParImparJob)
        - Exercise instructor answer.

</details>

---

## Unit 4 - Jobs in the production environment

<details><summary>Details</summary>

### Content
- [PrimeiroJobSpringBatch](course_01/unit_04/content/PrimeiroJobSpringBatch)
    - Project connecting two databases and using custom log settings.

### Practice
- [primeiro-projeto-spring-batch-v2](course_01/unit_04/practice/primeiro-projeto-spring-batch-v2)
    - Project changing from the first developed version
    - Using internal properties.
    - Using MySQL database.
- [primeiro-projeto-spring-batch-v3](course_01/unit_04/practice/primeiro-projeto-spring-batch-v3)
    - Using external properties.
- [primeiro-projeto-spring-batch-v4](course_01/unit_04/practice/primeiro-projeto-spring-batch-v4)
    - Using PostgreSQL database.
    - PostgreSQL.
- [primeiro-projeto-spring-batch-v5](course_01/unit_04/practice/primeiro-projeto-spring-batch-v5)
    - Using two databases.
- [primeiro-projeto-spring-batch-v6](course_01/unit_04/practice/primeiro-projeto-spring-batch-v6)
    - Using log tool log4j2 (logback removed).
- [primeiro-projeto-spring-batch-v7](course_01/unit_04/practice/primeiro-projeto-spring-batch-v7)
    - Using log tool logback (log4j2 removed).
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
    - [T5-ProducaoParImparJob-Resposta](course_01/unit_04/exercise/T5-ProducaoParImparJob-Resposta)
        - Exercise answer.
    - [T5-ProducaoParImparJob-Gabarito](course_01/unit_04/exercise/T5-ProducaoParImparJob-Gabarito)
        - Exercise instructor answer.

</details>

---

## Unit 5 - Spring Batch Readers

<details><summary>Details</summary>

working...


</details>

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