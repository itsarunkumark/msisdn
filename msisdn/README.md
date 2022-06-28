# Spring Boot "Microservice" Example Project

This is a sample Java / Maven / Spring Boot (version 2.7.1) application that can be used as a starter for creating a microservice application.

## How to Run 

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar target/msisdn-1.0.0-SNAPSHOT.jar
or
        mvn spring-boot:run
```
Once the application runs you should see something like this

```
2022-06-28 21:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2022-06-28 21:31:23.097  INFO 19387 --- [           main] Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is just a simple REST service. 
Here are some endpoints you can call:

### Get information about mobile numbers in MSISDN format.

```
Content-Type : application/json 
http://localhost:8080/api/msisdn/mobile-numbers

```



