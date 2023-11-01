# Use an official OpenJDK runtime as the parent image
FROM openjdk:22-ea-20-jdk-oraclelinux8

# Set the working directory in the container to /app
WORKDIR /app

# Copy the JAR file into the container at /app
COPY ./GuitarInventorySystem.jar /app

# Specify the command to run when the container starts
CMD ["java", "-jar", "GuitarInventorySystem.jar"]
