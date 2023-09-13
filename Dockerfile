# Use a base image with the required tools to build your Kotlin application
FROM gradle:7.2-jdk11 AS builder

# Set the working directory
WORKDIR /app

# Copy only the Gradle build files and download dependencies
COPY build.gradle.kts .
COPY settings.gradle.kts .
RUN gradle clean build --no-daemon

# Use a lightweight base image for the final container
FROM openjdk:11-jre-slim

# Set the working directory in the final image
WORKDIR /app

# Copy the compiled JAR file from the builder image
COPY --from=builder /app/build/libs/smitbackend.jar .

# Define the command to run your Ktor application
CMD ["java", "-jar", "smitbackend.jar"]
