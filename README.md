# Invoice - API e Frontend

Sistema para gerenciar mercadorias e notas fiscais.
Backend desenvolvido em Java e Frontend desenvolvido em AngularJS.

## Documentação

A documentação do desafio pode ser encontrada em [DevJavaSenior.pdf](docs/DevJavaSenior.pdf).

As telas (frontend) podem ser visualizadas em:

- [ScreenShot-1.png](docs/ScreenShot-1.png)
- [ScreenShot-2.png](docs/ScreenShot-2.png)
- [ScreenShot-3.png](docs/ScreenShot-3.png)
- [ScreenShot-4.png](docs/ScreenShot-4.png)
- [ScreenShot-5.png](docs/ScreenShot-5.png)

## Tecnologias e Requisitos

- Java 1.8
- AngularJS
- Spring Boot 1.4
- Maven 3.3.9
- JPA
- HSQLDB
- JMS
- ActiveMQ
- JUnit

## Suíte de testes

    $ mvn test

## Instalação

    $ mvn spring-boot:run

## Demo (Frontend)

- [http://localhost:8080/index.html](http://localhost:8080/index.html)

## API

### Listar mercadorias

**Exemplo de requisição:**

- **GET** [http://localhost:8080/api/products](http://localhost:8080/api/products)
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

- **GET** [http://localhost:8080/api/products/{id}](http://localhost:8080/api/products/{id})
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

- **GET** [http://localhost:8080/api/invoices](http://localhost:8080/api/invoices)
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

- **GET** [http://localhost:8080/api/invoices/{id}](http://localhost:8080/api/invoices/{id})
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
