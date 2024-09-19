Para listar todos os carros:

GET http://localhost:8080/api/carros

---------------------------------------------------------------------------------------

Buscar carro por ID:

GET http://localhost:8080/api/carros/{id} - substituir o "{id}" pelo id do carro que deseja buscar.

------------------------------------------------------------------------------------------

Para fazer o POST - (Criar um novo carro):


POST http://localhost:8080/api/carros

Modelo do body para criação:

{
    "nome": "Fiat Uno", 
    "marca": "Fiat", 
    "cor": "preto", 
    "ano": 2020, 
    "estacionamento": {
            "id": 3,
            "categoria": "Hatch"
        }
}

-----------------------------------------------------------------------------------------

Para DELETAR um carro:

DELETE http://localhost:8080/api/carros{id} - substituir o "{id}" pelo id do carro que deseja deletar. 

Exemplo:
DELETE /api/carros/7

------------------------------------------------------------------------------------------

Atualizar um carro existente:

PUT http://localhost:8080/api/carros/{id} - substituir o "{id}" pelo id do carro que deseja atualizar.

{
  "nome": "Corolla Atualizado", 
    "marca": "Toyota", 
    "cor": "preto", 
    "ano": 2020, 
    "estacionamento": {
            "id": 1,
            "categoria": "Sedan"
        }
}






