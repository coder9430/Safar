# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file (pom.xml) to the container
COPY pom.xml .

# Download dependencies specified in the pom.xml, but don't package them in the final JAR yet
RUN mvn dependency:go-offline

# Copy the entire project source code to the container
COPY src ./src

# Package the application into a JAR file
RUN mvn package -DskipTests

# Use a base image with Java installed
FROM openjdk:17-slim AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage to the container
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]
