# Dockerfile for Spring Boot application
FROM openjdk:17-jdk-alpine
WORKDIR /
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT java -jar /app.jar
