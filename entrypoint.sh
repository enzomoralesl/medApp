#!/bin/bash

# Define a senha do PostgreSQL para o comando psql
export PGPASSWORD=12345

# Aguarda o banco de dados estar disponível
until pg_isready -h db -p 5432 -U postgres; do
  echo "Aguardando o banco de dados..."
  sleep 2
done

# Verifica se o arquivo schema.sql existe antes de tentar executá-lo
if [ -f /app/schema.sql ]; then
  echo "Executando o schema.sql..."
  psql -h db -U postgres -d postgres -f /app/schema.sql
else
  echo "Arquivo schema.sql não encontrado!"
fi

# Verifica se o arquivo app.jar existe antes de tentar executá-lo
if [ -f /app/app.jar ]; then
  echo "Iniciando a aplicação Java..."
  java -jar /app/app.jar
else
  echo "Arquivo app.jar não encontrado!"
fi
