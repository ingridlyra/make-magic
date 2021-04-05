# make-magic
Desafio do Bootcamp Agora São Elas no Java, da Dextra.
A aplicação é uma API REST de CRUD de um personagem.

## Requisitos:
- MySQL
- JDK 11
- Spring boot

### Criar personagem:
- Rota: /api/v1/personagem
- Método: Post

### Atualizar personagem:
- Rota: /api/v1/personagem/{id}
- Método: Put

### Buscar 1 personagem:
- Rota: /api/v1/personagem/{id}
- Método: Get

### Buscar todos os personagens (filtro por casa disponível):
- Rota: /api/v1/personagem ou /api/v1/personagem?house={id}
- Método: Get

### Deletar um personagem:
- /api/v1/personagem/{id}
- Método: Delete
