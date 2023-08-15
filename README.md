# Spring e Kafka

Projeto de estudos de integração do Spring Boot com Kafka.

## Requisitos

* Java 17
* Docker
* Kafka
* PosgreSQL


## Variáveis de ambiente

```
DATABASE_URL=jdbc:postgresql://localhost:15432/postgres
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=123456
KAFKA_SERVER=localhost:9093
```

## Preparando ambiente

Em uma máquina com Docker, executar o comando no diretório raiz:

```
docker compose up
```

## Exemplo de requisição

POST /pix

```
{
    "chaveOrigem": "123",
    "chaveDestino": "321",
    "valor": 100
}
```
