FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

# Instala utilitários necessários
RUN apt-get update && apt-get install -y postgresql-client && rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho no container
WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar
COPY src/main/resources/schema.sql /app/schema.sql
COPY entrypoint.sh /app/entrypoint.sh


RUN chmod +x /app/entrypoint.sh
EXPOSE 8081
ENTRYPOINT ["/app/entrypoint.sh"]