# Use lightweight Java image
FROM eclipse-temurin:17-jdk-alpine

# Set working dir
WORKDIR /app

# Copy jar
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8081

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]