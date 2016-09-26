# Invoice REST

API REST para gerenciar mercadorias e notas fiscais.

## Documentação

A documentação do desafio pode ser encontrada em [DevJavaSenior.pdf](docs/DevJavaSenior.pdf).

## Tecnologias e Requisitos

- Java 1.8
- Spring Boot 1.4
- Maven 3.3.9
- JPA
- HSQLDB
- ActiveMQ
- JUnit

## Instalação

    $ mvn spring-boot:run

## Suíte de testes

    $ mvn test

## API

### Listar mercadorias

**Exemplo de requisição:**

- **GET** [http://localhost:8080/products](http://localhost:8080/products)
- **Accept:** application/json
- **Content-Type:** application/json

**Exemplo de resposta:**

- **200** OK

```json
    {
      "content": [
        {
          "id": 1,
          "name": "iPhone 6S 16GB",
          "price": 2799
        },
        {
          "id": 2,
          "name": "iPad Mini 64GB",
          "price": 3700
        },
        {
          "id": 3,
          "name": "Moto X Style 32GB",
          "price": 2199
        },
        {
          "id": 4,
          "name": "Galaxy S6",
          "price": 1799
        }
      ],
      "last": true,
      "totalPages": 1,
      "totalElements": 4,
      "size": 20,
      "number": 0,
      "sort": null,
      "numberOfElements": 4,
      "first": true
    }
```

### Exibir detalhes da mercadoria

**Exemplo de requisição:**

- **GET** [http://localhost:8080/products/{id}](http://localhost:8080/products/{id})
- **Accept:** application/json
- **Content-Type:** application/json

**Exemplo de resposta:**

- **200** OK

```json
    {
      "id": 1,
      "name": "iPhone 6S 16GB",
      "price": 2799
    }
```

### Listar notas fiscais

**Exemplo de requisição:**

- **GET** [http://localhost:8080/invoices](http://localhost:8080/invoices)
- **Accept:** application/json
- **Content-Type:** application/json

**Exemplo de resposta:**

- **200** OK

```json
    {
      "content": [
        {
          "id": 1,
          "company": {
            "id": 1,
            "name": "Apple"
          },
          "customer": "John Doe",
          "description": "Invoice description",
          "items": [
            {
              "id": 1,
              "product": {
                "id": 1,
                "name": "iPhone 6S 16GB",
                "price": 2799
              },
              "quantity": 1,
              "totalPrice": 2799
            },
            {
              "id": 2,
              "product": {
                "id": 2,
                "name": "iPad Mini 64GB",
                "price": 3700
              },
              "quantity": 1,
              "totalPrice": 3700
            }
          ],
          "totalPrice": 6499
        },
        {
          "id": 2,
          "company": {
            "id": 1,
            "name": "Apple"
          },
          "customer": "John Doe",
          "description": "Invoice description",
          "items": [
            {
              "id": 3,
              "product": {
                "id": 3,
                "name": "Moto X Style 32GB",
                "price": 2199
              },
              "quantity": 2,
              "totalPrice": 4398
            }
          ],
          "totalPrice": 4398
        }
      ],
      "last": true,
      "totalPages": 1,
      "totalElements": 2,
      "size": 20,
      "number": 0,
      "sort": null,
      "numberOfElements": 2,
      "first": true
    }
```

### Exibir detalhes da notas fiscal

**Exemplo de requisição:**

- **GET** [http://localhost:8080/invoices/{id}](http://localhost:8080/invoices/{id})
- **Accept:** application/json
- **Content-Type:** application/json

**Exemplo de resposta:**

- **200** OK

```json
    {
      "id": 1,
      "company": {
        "id": 1,
        "name": "Apple"
      },
      "customer": "John Doe",
      "description": "Invoice description",
      "items": [
        {
          "id": 1,
          "product": {
            "id": 1,
            "name": "iPhone 6S 16GB",
            "price": 2799
          },
          "quantity": 1,
          "totalPrice": 2799
        },
        {
          "id": 2,
          "product": {
            "id": 2,
            "name": "iPad Mini 64GB",
            "price": 3700
          },
          "quantity": 1,
          "totalPrice": 3700
        }
      ],
      "totalPrice": 6499
    }
```
