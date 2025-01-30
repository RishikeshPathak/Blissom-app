# API Gateway

## Description
API Gateway is a Spring Boot-based microservice that acts as the entry point for all client requests in the Blissom platform. It leverages Spring Cloud Gateway for routing and service discovery via Eureka. The API Gateway routes requests to backend services, such as the USER-SERVICE, and adds necessary headers and other functionalities.

## Features
- **API Gateway**: Routes requests to various microservices.
- **Eureka Client**: Service discovery for dynamic routing.
- **Spring Cloud Gateway**: Handles routing, filtering, and load balancing.
- **Reactive Web Application**: Uses Spring WebFlux for a non-blocking, event-driven model.
- **Request ID Header**: Adds a unique X-Request-Id header to all incoming requests.

## Tech Stack
- **Backend**: Java 21, Spring Boot 3.4.1
- **Cloud**: Spring Cloud (Gateway, Eureka)
- **Development**: Lombok (for reducing boilerplate code)
- **Testing**: Spring Boot Starter Test, Reactor Test

## Installation

### Prerequisites
- **Java 21**: Download and install from [Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) or [OpenJDK](https://openjdk.org/projects/jdk/21/).
- **Maven**: Download and install from [Apache Maven](https://maven.apache.org/download.cgi).
- **Postman**: Download and install from [Postman](https://www.postman.com/downloads/) for testing RESTful APIs.

### Steps to Run Locally
1. Clone the repository:
    ```bash
    git clone https://github.com/RishikeshPathak/Blissom-app.git
    ```

2. Navigate to the API Gateway directory:
    ```bash
    cd API-Gateway
    ```

3. Build and run the service:
    ```bash
    mvn spring-boot:run
    ```

The API Gateway will be available at http://localhost:8081.

## Configuration

In `application.yml`, the API Gateway routes requests to the USER-SERVICE as shown below:

```yaml
spring:
  cloud:
    gateway:
      default-filters:
        - AddRequestHeader=X-Request-Id, ${random.uuid}
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/api/v1/users/**
```

## Dependencies
- **Spring Cloud Starter Gateway**: To enable routing functionality.
- **Spring Cloud Netflix Eureka Client**: For service discovery.
- **Spring Boot Starter Test**: For unit and integration testing.
- **Lombok**: For reducing boilerplate code.

## Contributing
Feel free to fork the repository and submit pull requests. Open an issue if you find any bugs or have feature requests.

