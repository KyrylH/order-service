# Order service

This service is implementation of imitation 
of real order service which use JSP 
and validation with exception handling
for validating data to sending data to next service
for processing this data

## Dependencies

| Dependencies                   | Version      |
|--------------------------------|--------------|
| spring-boot-starter-data-jpa   |              |
| spring-boot-starter-web        |              |
| tomcat-embed-jasper            |              |
| spring-cloud-square-okhttp     | 0.4.1        |
| spring-boot-starter-test       |              |
| lombok                         |              |
| jakarta.servlet.jsp.jstl-api   | 3.0.0        |
| jakarta.servlet.jsp.jstl       | 3.0.1        |
| liquibase-core                 |              |
| liquibase-hibernate6           | 4.18.0       |
| mockito-core                   | 5.12.0       |
| spring-boot-starter-validation |              |
| sqlite-jdbc                    | 3.41.2.2     |
| hibernate-community-dialects   |              |


## How to run
### Docker
```docker-compose build```

```docker-compose up -d```

### Maven
```mvn clean install```

```mvn spring-boot:run ```