# My Application

This is a Spring Boot application with a MySQL database and a simple frontend, all containerized with Docker. Follow the instructions below to run the application locally with minimal configuration.

## Prerequisites

Before you start, make sure you have the following installed:

- **Docker**: [Docker Installation Guide](https://docs.docker.com/get-docker/)
- **Docker Compose**: [Docker Compose Installation Guide](https://docs.docker.com/compose/install/)
- **Git**: [Git Installation Guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/yourrepository.git
cd yourrepository

.\gradlew clean build
docker-compose up --build
