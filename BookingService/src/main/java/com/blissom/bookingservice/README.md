# Blissom-app
## BookingService : Still In Progress has compilation error.

### Description
BookingService is a Spring Boot-based microservice that handles booking operations for the Blissom platform. It utilizes Spring Cloud and PostgreSQL to provide efficient and scalable services for booking management.

### Features
- RESTful APIs to handle booking requests.
- Integration with Spring Cloud Config and Eureka for configuration and service discovery.
- PostgreSQL database for persistent data storage.
- Easy-to-use API for creating, updating, and managing bookings.

### Tech Stack
- Backend: Java 21, Spring Boot 3.4.2
- Database: PostgreSQL
- Cloud: Spring Cloud (Config, Eureka)
- Development: Lombok (for reducing boilerplate code)
- Testing: Spring Boot Starter Test

### Installation

#### Prerequisites
- **Java 21**: Download and install from [Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) or [OpenJDK](https://openjdk.org/projects/jdk/21/).
- **Maven**: Download and install from [Apache Maven](https://maven.apache.org/download.cgi).
- **PostgreSQL**: Download and install from [PostgreSQL](https://www.postgresql.org/download/).
- **Postman**: Download and install from [Postman](https://www.postman.com/downloads/) for testing RESTful APIs.

#### Steps to Run Locally
Steps to Run Locally
======================

### Clone the repository

    git clone https://github.com/RishikeshPathak/Blissom-app.git
### Navigate to the BookingService directory

    cd BookingService
### Set up the database connection in the application.properties file

    # Set up the database connection in the application.properties file
    ### Set up the environment variables
    *   `SPRING_DATASOURCE_URL`: The JDBC URL for the PostgreSQL instance.
    *   `SPRING_DATASOURCE_USERNAME`: The username to use for the connection.
    *   `SPRING_DATASOURCE_PASSWORD`: The password to use for the connection.
### Build and run the service
    mvn spring-boot:run
### The service will be available at http://localhost:8086

Dependencies
============

*   Spring Boot Starter Data JPA: For data persistence.
*   Spring Boot Starter Web: To expose REST APIs.
*   Spring Cloud Starter Config: To manage configurations.
*   Spring Cloud Netflix Eureka Client: For service discovery.
*   PostgreSQL: Relational database.
*   Lombok: For reducing boilerplate code.

Contributing
============

Feel free to fork the repository and submit pull requests. Open an issue if you find any bugs or have feature requests.


