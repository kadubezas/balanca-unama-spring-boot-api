# API Rest Do Sistema De Pesagem Unama

>Serviço de consumo e registro de dados do Projeto de Balança Rodoviária Automatizada

## Objetos da API

### Funcionário

#### 1. Objeto padrão
~~~json
{
    "id": Long,
    "nome": String,
    "login": String,
    "email": String,
    "password": String,
    "ativo": Boolean,
    "setor": {
        "id": Long,
        "descricao": String
    },
    "veiculo": {
        "id": Long,
        "placa": String,
        "tara": Float,
        "marca": String,
        "cor": String
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

### Setor

#### 1. Objeto padrão.

~~~json
    {
        "id": Long,
        "descricao": String
    }
~~~

#### 2. Insert

Chave | Valor
------- | ------
URL | /setores
METHOD | POST

Headers

key | value
------- | ------
Content-Type | application/json

Body de Envio

~~~json
    {
        "descricao": "Financeiro"
    }
~~~

#### 3. Update

Chave | Valor
------- | ------
URL | /setores/{id}
METHOD | PUT

Headers

key | value
------- | ------
Content-Type | application/json

Body de Envio

~~~json
    {
        "descricao": "Contabilidade"
    }
~~~

#### 4. Find By Id

Chave | Valor
------- | ------
URL | /setores/{id}
METHOD | GET

Objeto Retornado

~~~json
    {
        "id": "1"
        "descricao": "Administração"
    }
~~~

#### 5. Find All

Chave | Valor
------- | ------
URL | /setores
METHOD | GET

Objeto Retornado

~~~json
    {
        "id": 1,
        "descricao": "Administração"
    },
    {
        "id": 2,
        "descricao": "Balança"
    }
~~~

### Veiculo

#### 1. Objeto Padrão

~~~json
    {
        "id": Long,
        "placa": String,
        "tara": Float,
        "marca": String,
        "cor": String
    }
~~~

#### 2. Insert

Chave | Valor
------- | ------
URL | /veiculos
METHOD | POST

Headers

key | value
------- | ------
Content-Type | application/json

Body de Envio

~~~json
    {
        "placa": "NTB1234",
        "tara": 5000.0,
        "marca": "Volkswagen",
        "cor": "Preto"
    }
~~~

#### 3. Update

Chave | Valor
------- | ------
URL | /veiculos/{id}
METHOD | PUT

Headers

key | value
------- | ------
Content-Type | application/json

Body de Envio

~~~json
    {
        "placa": "NTB1234",
        "tara": 5000.0,
        "marca": "Volkswagen",
        "cor": "Azul"
    }
~~~

#### 4. Find By Id

Chave | Valor
------- | ------
URL | /veiculos/{id}
METHOD | GET

Objeto Retornado

~~~json
    {
        "placa": "NTB1234",
        "tara": 5000.0,
        "marca": "Volkswagen",
        "cor": "Azul"
    }
~~~

#### 5. Find All

Chave | Valor
------- | ------
URL | /veiculos
METHOD | GET

Objetos Retornado

~~~json
    {
        "id": 1,
        "placa": "NTB1234",
        "tara": 5000.0,
        "marca": "Volkswagen",
        "cor": "Azul"
    },
    {
        "id": 2,
        "placa": "NTS1544",
        "tara": 4500.0,
        "marca": "Fiat",
        "cor": "Vermelho"
    }
~~~
