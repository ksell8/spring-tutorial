# Start with a base image containing Java runtime
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/library*.jar /app/library.jar

# Expose the port on which your application runs
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "/app/library.jar"]