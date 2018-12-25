# examen
-SpringBoot (MVC + JPA)

Requirements
For building and running the application you need:

JDK 1.8

* Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the 
com.cash.examen.ExamenApplication.java class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so: mvn spring-boot:run

* Running DB (mySQL)

1- Init Conection (resources/application.properties)

  datasource url= jdbc:mysql://localhost:3306/cash
  datasource username= root
  datasource password= root

2- Running Script CreationTables
  
  path: resources/static/scripts/creationTables

3- Running Script insertData
  
  path: resources/static/scripts/insertData


