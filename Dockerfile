FROM openjdk:17-jdk-slim

# Instala utilitários necessários
RUN apt-get update && apt-get install -y postgresql-client && rm -rf /var/lib/apt/lists/*

# Define o diretório de trabalho no container
WORKDIR /app

# Copie o arquivo JAR gerado para o container
COPY target/*.jar app.jar

# Copie o schema.sql e o entrypoint.sh para o container
COPY src/main/resources/schema.sql /app/schema.sql
COPY entrypoint.sh /app/entrypoint.sh

# Permite execução do entrypoint
RUN chmod +x /app/entrypoint.sh

# Expõe a porta usada pela aplicação
EXPOSE 8081

# Define o entrypoint customizado
ENTRYPOINT ["/app/entrypoint.sh"]