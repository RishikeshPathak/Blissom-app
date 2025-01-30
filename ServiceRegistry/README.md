
# Blissom Service Registry

## Description
`Service Registry` is a Spring Boot-based microservice using **Netflix Eureka** for service discovery. It allows other microservices to register and discover each other in the **Blissom** platform. The Eureka server will not register itself with Eureka, as it is solely used for service discovery.

### Features
- **Service Discovery**: Microservices register with Eureka to discover and communicate with each other.
- **Eureka Server**: Handles service registration and discovery.
- **Debug Logging**: Logs detailed information for better monitoring and debugging of service interactions.

### Tech Stack
- **Backend**: Java 21, Spring Boot 3.4.1
- **Cloud**: Spring Cloud (Eureka)
- **Logging**: Debug logging for Eureka and Spring Cloud services
- **Testing**: Spring Boot Starter Test

### Installation

#### Prerequisites
- **Java 21**: [Download and install](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) or [OpenJDK](https://openjdk.org/projects/jdk/21/).
- **Maven**: [Download and install](https://maven.apache.org/download.cgi).
- **Postman**: [Download and install](https://www.postman.com/downloads/) for testing.

#### Steps to Run Locally
1. **Clone the repository**:
    ```bash
    git clone https://github.com/RishikeshPathak/Blissom-app.git
    ```

2. **Navigate to the Service Registry directory**:
    ```bash
    cd ServiceRegistry
    ```

3. **Build and run the service**:
    ```bash
    mvn spring-boot:run
    ```

4. The **Service Registry** will be available at `http://localhost:8761`.

### Configuration
In `application.yml`, the Eureka server is configured as follows:
```yaml
server:
  port: 8761

eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
  logging:
    level:
      com.netflix.discovery: DEBUG
      org.springframework.cloud.netflix.eureka: DEBUG
```

### Dependencies
- **Spring Cloud Starter Netflix Eureka Server**: For the Eureka server setup.
- **Spring Boot Starter**: Core dependencies for Spring Boot applications.
- **Spring Boot Starter Test**: For unit and integration testing.

### Contributing
Feel free to fork the repository and submit pull requests. Open an issue if you find any bugs or have feature requests.
