# Notepad Backend 📝

This repository contains a **Spring Boot** back-end application designed to manage notes. It is part of a microservices architecture with a front-end service communicating via REST requests.

## Project Structure ☕
- **Framework:** Spring Boot 3.4.0
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Database migrations:** Flyway

## .env exemple:
```.env
DB_URL=jdbc:postgresql://localhost:5432/notepad
DB_USERNAME=postgres
DB_PASSWORD=admin
```

## API Endpoints and Examples

### 1. **GET /notas** - List all notes.

```curl
curl --location --request GET 'http://localhost:8080/notas' \
--header 'Content-Type: application/json'
```

```json
[
    {
        "id": 1,
        "titulo": "Minha Primeira Nota",
        "nota": "insert via postgres",
        "dataCriacao": "2024-12-25T17:25:32.61507",
        "ultimaAtualizacao": "2024-12-25T17:25:32.61507"
    },
    {
        "id": 2,
        "titulo": "nota 2",
        "nota": "insert via postgres",
        "dataCriacao": "2024-12-25T17:43:07.264351",
        "ultimaAtualizacao": "2024-12-25T17:43:07.264351"
    }
]
```

### 2. **POST /notas** - Create a new note.

```curl
curl --location 'http://localhost:8080/notas' \
--header 'Content-Type: application/json' \
--data '{
    "titulo": "Nota Via tela frontend",
    "nota": "Conteúdo criado via Postman"
}'
```

```json
{
    "id": 3,
    "titulo": "Nota Via tela frontend",
    "nota": "Conteúdo criado via Postman",
    "dataCriacao": "2024-12-31T18:53:57.2601885",
    "ultimaAtualizacao": "2024-12-31T18:53:57.2601885"
}
```

### 2. **DELETE /notas/{id}** - Delete a note.

```curl
curl --location --request DELETE 'http://localhost:8080/notas/3' \
--header 'Content-Type: application/json'
```
Response:
HTTP Status: 200 OK (No body).


## Next steps:
- [x] - Create a front-end interface for user-friendly management.
- [x] -  Enable CORS to allow requests from other origins (e.g., @CrossOrigin(origins = "http://localhost:3000")).
- [ ] - Deploy the application to an AWS server or other hosting service.
