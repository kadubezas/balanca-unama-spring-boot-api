# API Rest Do Sistema De Pesagem Unama

>Serviço de consumo e registro de dados do Projeto de Balança Rodoviária Automatizada

## Objetos da API

### Funcionário

#### 1. Objeto padrão
~~~json
{
    "id": 1,
    "nome": "Carlos Eduardo da Silva Mesquita",
    "login": "kadubezas",
    "email": "kadubezas@gmail.com",
    "password": "12345678",
    "ativo": true,
    "setor": {
        "id": 1,
        "descricao": "Administração"
    },
    "veiculo": {
        "id": 1,
        "placa": "RTX3080",
        "tara": null,
        "marca": "Fiat",
        "cor": "Rosa"
    }
}
~~~
#### 2. Inserção do Objeto <br>

Chave | Valor
------- | ------
URL | /usuarios
METHOD | POST

Headers

key | value
------- | ------
Content-Type | application/json

Body de Envio<br>

~~~json
{
    "nome": "André Luiz",
    "login": "andreLuiz",
    "email": "andre@gmail.com",
    "password": "78444",
    "ativo": true,
    "setor": {
        "id": 1
    },
    "veiculo": {
        "id": 1
    }
}
~~~

#### 3. Update Objeto

Chave | Valor
------- | ------
URL | /usuarios/{id}
METHOD | PUT

Headers

key | value
------- | ------
Content-Type | application/json

Body de Envio<br>
~~~json
{
    "nome": "André Antonio",
    "login": "andreLuiz",
    "email": "andre@gmail.com",
    "password": "78444",
    "ativo": true,
    "setor": {
        "id": 1
    },
    "veiculo": {
        "id": 1
    }
}
~~~

#### 4. Findy By Id

Chave | Valor
------- | ------
URL | /usuarios/{id}
METHOD | GET

Objeto retornado
~~~json
{
    "id": 1,
    "nome": "Carlos Eduardo da Silva Mesquita",
    "login": "kadubezas",
    "email": "kadubezas@gmail.com",
    "password": "12345678",
    "ativo": true,
    "setor": {
        "id": 1,
        "descricao": "Administração"
    },
    "veiculo": {
        "id": 1,
        "placa": "RTX3080",
        "tara": null,
        "marca": "Fiat",
        "cor": "Rosa"
    }
}
~~~

#### 5. Find All

Chave | Valor
------- | ------
URL | /usuarios
METHOD | GET

Objeto Retornado

~~~json
[
    {
        "id": 1,
        "nome": "André Luiz",
        "login": "andreLuiz",
        "email": "andre@gmail.com",
        "password": "78444",
        "ativo": true,
        "setor": {
            "id": 1,
            "descricao": "Administração"
        },
        "veiculo": {
            "id": 1,
            "placa": "RTX3080",
            "tara": null,
            "marca": "Fiat",
            "cor": "Rosa"
        }
    },
    {
        "id": 2,
        "nome": "Richard Aquino",
        "login": "ri_chard",
        "email": "richard@gmail.com",
        "password": "123456sd78",
        "ativo": true,
        "setor": {
            "id": 2,
            "descricao": "Balança"
        },
        "veiculo": null
    }
]
~~~
