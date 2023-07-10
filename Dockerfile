# Use an image base JDK 11 y Maven
FROM maven:3.8.4-openjdk-11 AS build

# Set a working directory
WORKDIR /app

# Copy files from your project to the working directory
COPY . /app

# Run Maven to build the project
RUN mvn clean package

# Create a new image based on OpenJDK 11
FROM openjdk:11-jre-slim-buster

# Expose the port that the application will use
EXPOSE 8080

# Copy the JAR file built from the previous step
COPY --from=build /app/target/PlayersStatistics-0.0.1-SNAPSHOT.jar /app/PlayersStatistics-0.0.1-SNAPSHOT.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "/app/PlayersStatistics.jar"]