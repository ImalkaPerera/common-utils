# ---- Build Stage ----
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /build
# Add Nexus certificate to Java truststore
COPY nexus.crt /usr/local/share/ca-certificates/nexus.crt
RUN keytool -importcert -noprompt -trustcacerts -alias nexus -file /usr/local/share/ca-certificates/nexus.crt -keystore /etc/ssl/certs/java/cacerts -storepass changeit
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ---- Run Stage ----
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Add Nexus certificate to Java truststore in runtime image
COPY nexus.crt /usr/local/share/ca-certificates/nexus.crt
RUN keytool -importcert -noprompt -trustcacerts -alias nexus -file /usr/local/share/ca-certificates/nexus.crt -keystore /etc/ssl/certs/java/cacerts -storepass changeit
COPY --from=build /build/target/user-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
# Use non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser
ENTRYPOINT ["java", "-jar", "app.jar"]