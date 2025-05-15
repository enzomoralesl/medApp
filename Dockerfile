FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /ap

# Copie o arquivo JAR gerado para o container
COPY target/*.jar app.jar

# Expõe a porta usada pela aplicação
EXPOSE 8081

# Define o comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]