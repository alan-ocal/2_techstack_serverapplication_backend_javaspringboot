# esirgeyen ve bağışlayan❤️ Allah'ın (c.c) adıyla - 2a0_bpb_rajput
- `Spring Initializr` is used by creating a new project with `IntelliJ IDEA`

## Table of Contents
- [1_ Project Structure](#1-project-structure)
- [2_ Configuring Data and CRUD Operations](#2-configuring-data-and-crud-operations)
  - [A-JDBC](#a-jdbc)
  - [B-ORM Hibernate](#b-orm-hibernate)
  - [C-Spring Data JPA](#c-spring-data-jpa)


## 1 Project Structure

- `pom.xml` build tool file has the bare minimum requirement for the `Spring Boot 4.1.0 application`
with the Spring MVC web module.
- `ProdosApplication.java` bootstraps the SpringBoot project as the main application file 
- `ProdosApplicationTests.java` Junit  test class file used to ensure the Spring application context is loaded successfully.
- `ProductControllerTest` Junit  test class file used to ensure the ProductController class is loaded successfully.
![image](/imgs/h2_configuration.png)
- `src\main\resoruces\application.properties` is the externalized autoconfiguration file for H2 via JDBC
  
## 2 Configuring Data and CRUD Operations
The Spring framework provides full support to use backend technologies 
- A - `JDBC access using JDBCTemplate` 
- B - `Object relational mapping (ORM)` solution technologies such as `Hibernate`. 
- C - `Spring Data Java Persistence API (JPA) ` is a framework that simplifies the process of working with databases in Spring applications. 
It creates Repository implementations from interfaces and generates queires from the method names

### A-JDBC
- 1 - Adding a `domain class`
- 2 - Adding Spring Boot's `JDBC starter and H2 embedded database  dependencies`to the pom.xml file

![image](/imgs/h2_configuration.png)
- 3 - Writing a `repository interface` to fetch and save data from the `H2 in memory database`
- 4 - Implementing the repository interface with the help of `JdbcTemplate` and inject it into `ProductController class`
- 5 - H2 Script Initialization. Because JDBC does not automatically generate database tables from Java objects like Hibernate/JPA does,
      we need script files(`data.sql & schema.sql`) to prepare
  ![image](/imgs/schema_data_sql.png)
- 6 - Implementing ProductControllerTest class to test the ProductController class by using
  - adding `spring-boot-webmvc-test dependency`
  - adding  
  - `@Sql` for schema/data initialization
  - `@TestPropertySource` to disable Boot’s automatic SQL init during the test context
  The main app config in application.properties remains application-level, but the test overrides the datasource and
  sets spring.sql.init.mode=never so the table is not created twice.
- ![image](/imgs/demo.png)
### B-ORM Hibernate

### C-Spring Data JPA