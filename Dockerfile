# Use OpenJDK as base image
FROM openjdk:11-jdk-slim

# Set working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/calculator-0.0.1-SNAPSHOT.jar"]