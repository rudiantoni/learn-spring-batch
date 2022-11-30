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

# TODO: update these projects to Spring 3.0: Spring Batch 5.0

> Unit 1 - Introduction, is not inserted since there's no code to show.

---

## [Unit 2 - Spring Batch framework overview](course_01/unit_02)

- [PrimeiroProjetoSpringBatch](course_01/unit_02/practice/primeiro-projeto-spring-batch)
    - First developed project, with a basic job, step and tasklet working structure.

---

## [Unit 3 - Working with Jobs and Steps](course_01/unit_03)

- [refactor-primeiro-projeto-spring-batch](course_01/unit_03/practice/refactor-primeiro-projeto-spring-batch)
    - First project refactoring. Applied single responsibility.
- [spring-batch-par-impar](course_01/unit_03/practice/spring-batch-par-impar)
    - Basic working structure without single responsibility. Uses application argument execution and connects to a MySQL database for metadata persistence.

---

## [Unit 4 - Jobs in the production environment](course_01/unit_04)

<details><summary>Details</summary>

working...

</details>

---

## [Unit 5 - Spring Batch Readers](course_01/unit_05)

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
