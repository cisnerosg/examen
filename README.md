# examen
-SpringBoot (MVC + JPA)

Requirements
For building and running the application you need:

JDK 1.8

* Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the 
com.cash.examen.ExamenApplication.java class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so: mvn spring-boot:run


Endpoint healthCheck: localhost:8080/healthCheck

* Running DB (mySQL)
 download: https://dev.mysql.com/downloads/

1- Init Connection (resources/application.properties)

  datasource url: jdbc:mysql://localhost:3306/cash
  datasource username: root
  datasource password: root

2- Running Script CreationTables
  
  path: resources/static/scripts/creationTables

3- Running Script insertData
  
  path: resources/static/scripts/insertData



*Examples

localhost:8080/users/2 (get user with id 2)

localhost:8080/users/6(remove user with id 6)

localhost:8080/loans/?size=5&page=0 (get all loans with paging params)

localhost:8080/loans/?userId=5&page=0&size=5 (get loans with paging and user params)



