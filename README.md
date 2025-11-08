# Supnum - Student Management API

A RESTful web service built with Spring Boot for managing student information. This project provides a complete CRUD (Create, Read, Update, Delete) API for student management.

## Features

- **Student Management**: Full CRUD operations for student records
- **RESTful API**: Clean and intuitive REST endpoints
- **API Documentation**: Integrated Swagger/OpenAPI documentation
- **In-Memory Storage**: Simple HashMap-based storage for demonstration
- **Error Handling**: Custom exception handling for resource not found scenarios

## Prerequisites

Before running this project, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+** (or use the included Maven Wrapper)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

## Technologies Used

- **Spring Boot 3.5.7**: Framework (java) for building the application
- **Spring Web**: For REST API development
- **SpringDoc OpenAPI 2.3.0**: For API documentation (Swagger UI)
- **Java 17**: Programming language
- **Maven**: Build and dependency management

## Project Structure

```
GestionEtudients_SpringBoot/
├── src/
│   ├── main/
│   │   ├── java/supnum_api/supnum/
│   │   │   ├── Controllers/
│   │   │   │   ├── EtudiantController.java
│   │   │   │   └── EtudiantNotFoundException.java
│   │   │   ├── Models/
│   │   │   │   └── Etudiant.java
│   │   │   ├── Services/
│   │   │   │   └── EtudiantService.java
│   │   │   └── SupnumApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Aichetou05/GestionEtudients_SpringBoot.git
cd GestionEtudients_SpringBoot
```

### 2. Build the Project

Using Maven Wrapper (recommended):
```bash
# Windows
.\mvnw.cmd clean install

# Linux/Mac
./mvnw clean install
```

Or using Maven directly:
```bash
mvn clean install
```

### 3. Run the Application

Using Maven Wrapper:
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

Or using Maven directly:
```bash
mvn spring-boot:run
```

Or run the `SupnumApplication.java` class directly from your IDE.

The application will start on `http://localhost:8080`

## API Endpoints

### Base URL
```
http://localhost:8080/api/etudiants
```

### Available Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/etudiants` | Get all students |
| GET | `/api/etudiants/{id}` | Get a student by ID |
| POST | `/api/etudiants` | Create a new student |
| PUT | `/api/etudiants/{id}` | Update a student |
| DELETE | `/api/etudiants/{id}` | Delete a student |

### Request/Response Examples

#### Get All Students
```http
GET /api/etudiants
```

**Response:**
```json
[
  {
    "id": 1,
    "nom": "Aichetou",
    "prenom": "Mohameden Beida",
    "email": "23021@supnum.mr",
    "filiere": "Reseau,System et Securite",
    "niveau": 3
  },
  {
    "id": 2,
    "nom": "Ahmed",
    "prenom": "Mohamed",
    "email": "ahmed@supnum.mr",
    "filiere": "Mathématiques",
    "niveau": 2
  }
]
```

#### Get Student by ID
```http
GET /api/etudiants/1
```

**Response:**
```json

{
  "id": 1,
  "nom": "Aichetou",
  "prenom": "Mohameden Beida",
  "email": "23021@supnum.mr",
  "filiere": "Reseau,System et Securite",
  "niveau": 3
}

```

#### Create a New Student
```http
POST /api/etudiants
Content-Type: application/json

{
  "nom": "Elhassen",
  "prenom": "Sidi mahmoud",
  "email": "elhassen@supnum.mr",
  "filiere": "Informatique",
  "niveau": 3
}
```

**Response:**
```json
{
  "id": 3,
  "nom": "Elhassen",
  "prenom": "Sidi mahmoud",
  "email": "elhassen@supnum.mr",
  "filiere": "Informatique",
  "niveau": 3
}
```

#### Update a Student
```http
PUT /api/etudiants/3
Content-Type: application/json

{
  "nom": "Elhassen",
  "prenom": "Sidi mahmoud",
  "email": "elhassen.updated@supnum.mr",
  "filiere": "Informatique",
  "niveau": 4
}
```

#### Delete a Student
```http
DELETE /api/etudiants/1
```

**Response:** `204 No Content`

## API Documentation

Once the application is running, you can access the interactive API documentation at:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Testing the API

### Using cURL

#### Get all students
```bash
curl http://localhost:8080/api/etudiants
```

#### Get student by ID
```bash
curl http://localhost:8080/api/etudiants/1
```

#### Create a student
```bash
curl -X POST http://localhost:8080/api/etudiants \
  -H "Content-Type: application/json" \
  -d '{
    "nom": "Smith",
    "prenom": "Jane",
    "email": "jane.smith@supnum.mr",
    "filiere": "Chimie",
    "niveau": 2
  }'
```

#### Update a student
```bash
curl -X PUT http://localhost:8080/api/etudiants/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nom": "Elhassen",
    "prenom": "Sidi mahmoud",
    "email": "elhassen@supnum.mr",
    "filiere": "Informatique",
    "niveau": 4
  }'
```

#### Delete a student
```bash
curl -X DELETE http://localhost:8080/api/etudiants/1
```

### Using Postman or Thunder

Import the API endpoints into your preferred API client tool and test the endpoints interactively.

## Student Model

The `Etudiant` (Student) model contains the following fields:

| Field | Type | Description |
|-------|------|-------------|
| id | Long | Unique identifier (auto-generated) |
| nom | String | Last name |
| prenom | String | First name |
| email | String | Email address |
| filiere | String | Field of study |
| niveau | int | Academic level/year |

## Error Handling

The API returns appropriate HTTP status codes:

- `200 OK`: Successful GET or PUT request
- `201 Created`: Successful POST request
- `204 No Content`: Successful DELETE request
- `404 Not Found`: Student not found
- `400 Bad Request`: Invalid request data

## Configuration

The application configuration is located in `src/main/resources/application.properties`:

```properties
spring.application.name=supnum
```

## Limitations

- **In-Memory Storage**: Data is stored in memory and will be lost when the application restarts
- **No Persistence**: No database integration (can be added for production use)
- **No Validation**: Basic validation can be added for data integrity

## Future Enhancements

- Database integration (JPA/Hibernate with MySQL/PostgreSQL)
- Input validation and error handling improvements
- Authentication and authorization
- Pagination and filtering
- Unit and integration tests
- Docker containerization

## License

This project is part of a learning exercise and is provided as-is.

## Author

Created as part of SOA (Service-Oriented Architecture) course exercises.

## Contributing

This is an educational project. Feel free to fork and modify for your own learning purposes.

---

**Note**: This is a demo project for Spring Boot learning purposes. For production use, consider adding database persistence, validation, security, and comprehensive testing.
