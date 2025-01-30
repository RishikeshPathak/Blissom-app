
# Blissom Config Server

## Description
Blissom Config Server is a Spring Boot-based service that provides centralized configuration management for the Blissom platform's microservices. It utilizes Spring Cloud Config and connects to a Git repository for configuration storage.

## Features
- Centralized management of configurations for microservices.
- Integration with Git for configuration storage and retrieval.
- Integration with Eureka for service registration.
- Auto-refresh support for configurations when changes occur in the repository.

## Tech Stack
- Backend: Java 21, Spring Boot 3.4.1
- Cloud: Spring Cloud Config, Spring Cloud Netflix Eureka
- Development: Lombok (for reducing boilerplate code)
- Testing: Spring Boot Starter Test

## Installation

### Prerequisites
- **Java 21**: Download and install from [Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) or [OpenJDK](https://openjdk.org/projects/jdk/21/).
- **Maven**: Download and install from [Apache Maven](https://maven.apache.org/download.cgi).
- **Git**: Download and install from [Git](https://git-scm.com/).
- **Postman**: Download and install from [Postman](https://www.postman.com/downloads/) for testing RESTful APIs.

### Steps to Run Locally
1. Clone the repository
   ```bash
   git clone https://github.com/RishikeshPathak/blissom-configserver.git
   ```
2. Navigate to the ConfigServer directory
   ```bash
   cd ConfigServer
   ```
3. Set up the configuration repository in the application.yml file
   - The `uri` parameter should point to the Git repository for configuration files.

4. Build and run the service
   ```bash
   mvn spring-boot:run
   ```
5. The service will be available at `http://localhost:8082`.

## Dependencies
- Spring Cloud Config Server: For managing configurations.
- Spring Cloud Netflix Eureka Client: For service registration with Eureka.
- Spring Boot Starter Test: For testing.

## Contributing
Feel free to fork the repository and submit pull requests. Open an issue if you find any bugs or have feature requests.

## License
This project is licensed under the MIT License.
