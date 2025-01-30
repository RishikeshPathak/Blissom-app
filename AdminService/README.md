# Admin Service

The AdminService is a Spring Boot-based microservice designed for the administration functionality of the Blissom platform. This service provides administrative APIs and connects to a PostgreSQL database for data management. It integrates with Spring Cloud Config for centralized configuration management and Spring Eureka for service discovery.

## Features

*   RESTful APIs for admin-related functionalities.
*   Integration with PostgreSQL for data storage.
*   Service discovery via Spring Cloud Eureka.
*   Centralized configuration using Spring Cloud Config.

## Tech Stack

*   Backend: Java 21, Spring Boot 3.4.2
*   Database: PostgreSQL
*   Cloud: Spring Cloud (Config, Eureka)
*   Development: Lombok for reducing boilerplate code
*   Testing: Spring Boot Starter Test

## Configuration

The service uses the following configuration file:

### application.yml

yaml
server:
  port: 8084

spring:
  datasource:
    url: "jdbc:postgresql://localhost:5432/users"
    username: "postgres"
    password: "password"
  jpa:
    hibernate:
      ddl-auto: create
      show-sql: true
  application:
    name: ADMIN-SERVICE
  config:
    import: optional:configserver:http://localhost:8082

This configuration connects to the PostgreSQL database and imports configurations from a centralized Spring Cloud Config server running at localhost:8082.

## Installation

### Prerequisites

- **Java 21**: Download and install from [Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) or [OpenJDK](https://openjdk.org/projects/jdk/21/).
- **Maven**: Download and install from [Apache Maven](https://maven.apache.org/download.cgi).
- **PostgreSQL**: Download and install from [PostgreSQL](https://www.postgresql.org/download/).
- **Postman**: Download and install from [Postman](https://www.postman.com/downloads/) for testing RESTful APIs.

### Steps to Run Locally

1.  Clone the repository:

    bash
    git clone https://github.com/RishikeshPathak/Blissom-app.git

2.  Navigate to the AdminService directory.

3.  Set up the database by creating a users database in PostgreSQL.

4.  Configure application.yml for correct database credentials and service configuration.

5.  Build and run the service:

    bash
    mvn spring-boot:run

The service will be available at http://localhost:8084.

## Dependencies

*   Spring Boot Starter Data JPA: For database operations.
*   Spring Boot Starter Web: To expose REST APIs.
*   Spring Cloud Config: For centralized configuration management.
*   Spring Cloud Netflix Eureka Client: For service discovery.
*   PostgreSQL: Relational database.
*   Lombok: For reducing boilerplate code.

## Contributing

Feel free to fork the repository and submit pull requests. For bugs or feature requests, please open an issue.
