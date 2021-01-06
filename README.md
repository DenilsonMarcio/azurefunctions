1 - Function que recebe um número via path parameter.
  - receber um valor numérico através de path parameter e retornar conforme as seguintes condições:
    - caso o valor seja menor que 5, deve retornar status HTTP 200 com o número
    - caso o valor seja maior que 5, deve retornar status HTTP 404


2 - Function que recebe um número via query parameter.
  - receber um valor numérico através de query parameter e retornar conforme as seguintes condições:
    - caso o valor seja menor que 5, deve retornar status HTTP 200 com o número
    - caso o valor seja maior que 5, deve retornar status HTTP 404


3 - Function que recebe um JSON.
  - aceitar apenas HTTP POST
  - receber um json no corpo da requisição e retornar conforme as seguintes condições:
    - caso o valor seja "João", "José" ou "Joaquim", retornar http 200
    - demais nomes retornar http 400
    - não deve ser case sensitive
    - JSON de modelo a ser utilizado: {"nome": "João"}
    - utilizar biblioteca org.json


4 - Function que recebe um JSON e efetua validação de header/valor "userIdentifier" e seu valor
  - deve esperar um header chamado "userIdentifier"
  - deve receber um json no corpo da requisição e retornar conforme as seguintes condições:
    - caso não venha o header, deve retornar http status 401
    - caso venha o header mas o valor seja diferente de "azurefunctions", retornar http status 401
    - a validação do header deve ser case sensitive
    - caso o valor seja "João", "José" ou "Joaquim", retornar http 200
    - demais nomes retornar http 400
    - a validação do valor do campo "nome" não deve ser case sensitive
    - JSON de modelo a ser utilizado: {"nome": "João"}
    - utilizar biblioteca org.json
