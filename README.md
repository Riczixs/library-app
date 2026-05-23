# library-app

A microservice web application built with **Java 21** and **Spring Boot 3.5.2**. 

## Features
* **CRUD Operations:** Full management of authors and books.
* **Database Migration:** Backed by MySQL and initialized using Liquibase.
* **Service Discovery:** Service registration and discovery via Netflix Eureka.
* **Event-Driven Communication:** Decoupled internal communication using Spring Events.
* **Containerization:** Fully containerized environment powered by Docker Compose.

## Deployment

### Prerequisites
The project requires Docker installed on your operating system. You can download it from the official page:
[Docker Installation Guide](https://docs.docker.com/engine/install/)

### Linux / macOS
Once the Docker daemon is up and running, launch the setup script from the root directory of the project:
```bash
./library.sh
```
### Windows
To run this project on Windows, you will need Git Bash, which you can download here:
[Git for Windows installation guide](https://git-scm.com/install/windows)

After installation, open Git Bash, navigate to the root directory of the cloned repository, and execute:

```bash
./library.sh
```

To stop the project, simply run:
```bash
 docker compose down
 ```



### Notes & Testing the API

- As the basic setup both author and book services are deployed in 3 replicas which can be check under the Eureka Server address after running:
[Eureka Server](http://localhost:8761)

- The project will generate a significant amount of logs in the terminal while starting up. Once the log stream stabilizes, you can test the application. Using Postman is highly recommended.

[Postman Collection](https://oluremi-7198468.postman.co/workspace/Oluremi's-Workspace~14b8325c-1747-40cb-89d1-f3c972034006/collection/46737074-d42d5f0b-2c0c-44e7-9d49-bf5ec903873f?action=share&creator=46737074)