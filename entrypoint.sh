#!/bin/bash
set -e

# Espera o banco de dados ficar disponível
until pg_isready -h db -p 5432 -U "$SPRING_DATASOURCE_USERNAME"; do
  echo "Aguardando o banco de dados..."
  sleep 2
done

echo "Banco de dados disponível! Aplicando schema.sql..."

# Aplica o schema.sql manualmente
PGPASSWORD=$SPRING_DATASOURCE_PASSWORD psql -h db -U "$SPRING_DATASOURCE_USERNAME" -d postgres -f /app/schema.sql || true

# Lista as tabelas para garantir que tb_patient foi criada
PGPASSWORD=$SPRING_DATASOURCE_PASSWORD psql -h db -U "$SPRING_DATASOURCE_USERNAME" -d postgres -c "\dt"

# Mostra a estrutura da tabela tb_patient
PGPASSWORD=$SPRING_DATASOURCE_PASSWORD psql -h db -U "$SPRING_DATASOURCE_USERNAME" -d postgres -c "\d+ tb_patient"

echo "Iniciando aplicação Java..."
exec java -jar /app/app.jar --spring.profiles.active=docker
