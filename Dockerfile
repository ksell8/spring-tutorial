# Use a base image with Maven and JDK
FROM maven:3-eclipse-temurin-22-alpine AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package

# Use a smaller image with just the JDK to run the application
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/library*.jar /app/library.jar

# Expose the port on which your application runs
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "/app/library.jar", "--spring.config.additional-location=/config/application-secrets.properties"]