# Etapa 1: Construir o projeto
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Etapa 2: Rodar o projeto
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/slow-deploy-test-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]