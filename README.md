# Employee Management System

A secure, RESTful Employee Management System built with **Spring Boot**, featuring **JWT-based authentication**, **role-secured endpoints**, and full **CRUD operations** with **pagination and sorting**. Built as part of a Spring Boot + Database Integration + JWT Authentication assignment.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Testing](#testing)
- [Postman Collection](#postman-collection)
- [Author](#author)

---

## 🧭 Overview

This project is a backend REST API that allows an organization to manage employee records securely. Users must register and log in to receive a **JSON Web Token (JWT)**, which is then required to access any employee-related endpoint. Passwords are never stored in plain text — they are hashed using **BCrypt** before being saved to the database.

The system is intentionally kept simple and beginner-friendly, following clean, industry-standard Spring Boot conventions (controller → service → repository → entity), making it easy to read, extend, and explain.

---

## ✨ Features

- 🔐 **User Registration & Login** — secure signup and authentication
- 🔑 **JWT Authentication** — stateless, token-based security on all protected routes
- 🔒 **BCrypt Password Hashing** — passwords are never stored as plain text
- 👤 **Employee CRUD** — Create, Read, Update, Delete employee records
- 📄 **Pagination** — fetch employee lists in manageable pages
- ↕️ **Sorting** — sort employees by any field (name, salary, etc.) in ascending or descending order
- ⚠️ **Global Exception Handling** — consistent, clean JSON error responses
- ✅ **Unit Tests** — service layer (Mockito) and repository layer (`@DataJpaTest` + H2)

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Framework | Spring Boot |
| Security | Spring Security + JWT (jjwt) |
| Persistence | Spring Data JPA (Hibernate) |
| Database | PostgreSQL |
| Build Tool | Maven |
| Testing | JUnit 5, Mockito, H2 (in-memory) |
| API Testing | Postman |

---

## 📁 Project Structure

```
employee-management/
├── src/main/java/com/example/employeemanagement/
│   ├── entity/          # Employee, User — JPA entities mapped to DB tables
│   ├── repository/      # EmployeeRepository, UserRepository — Spring Data JPA interfaces
│   ├── dto/              # RegisterRequest, LoginRequest, AuthResponse — request/response objects
│   ├── security/         # JwtUtil, JwtAuthFilter, SecurityConfig, CustomUserDetailsService
│   ├── service/          # AuthService, EmployeeService — business logic
│   ├── controller/       # AuthController, EmployeeController — REST endpoints
│   ├── exception/        # GlobalExceptionHandler, ResourceNotFoundException
│   └── EmployeeManagementApplication.java
├── src/main/resources/
│   └── application.properties
├── src/test/java/com/example/employeemanagement/
│   ├── service/EmployeeServiceTest.java
│   └── repository/EmployeeRepositoryTest.java
├── database.sql
├── pom.xml
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8+
- Postman (for API testing)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/employee-management-system.git
   cd employee-management-system
   ```

2. **Configure the database**
   Update `src/main/resources/application.properties` with your MySQL credentials (see [Configuration](#configuration) below). The database is auto-created on first run.

3. **Build the project**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   The application starts on `http://localhost:8080`.

---

## ⚙️ Configuration

Key properties in `application.properties`:

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update

jwt.secret=your-secret-key
jwt.expiration=86400000
```

> ⚠️ Update `spring.datasource.username` and `spring.datasource.password` to match your local MySQL setup before running.

---

## 📡 API Documentation

### Authentication

| Method | Endpoint | Auth Required | Description |
|---|---|---|---|
| `POST` | `/auth/register` | ❌ No | Register a new user |
| `POST` | `/auth/login` | ❌ No | Login and receive a JWT token |

**Register — Request Body**
```json
{
  "username": "avinash",
  "password": "test1234"
}
```

**Login — Request Body**
```json
{
  "username": "avinash",
  "password": "test1234"
}
```

**Login — Response**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9........."
}
```

> All employee endpoints below require this token, sent as:
> `Authorization: Bearer <token>`

### Employee Management

| Method | Endpoint | Auth Required | Description |
|---|---|---|---|
| `POST` | `/employees` | ✅ Yes | Create a new employee |
| `GET` | `/employees` | ✅ Yes | Get paginated & sorted employee list |
| `GET` | `/employees/{id}` | ✅ Yes | Get employee by ID |
| `PUT` | `/employees/{id}` | ✅ Yes | Update employee by ID |
| `DELETE` | `/employees/{id}` | ✅ Yes | Delete employee by ID |

**Create/Update — Request Body**
```json
{
  "name": "Rahul Sharma",
  "email": "rahul@example.com",
  "department": "IT",
  "position": "Java Developer",
  "salary": 55000,
  "dateOfJoining": "2025-06-01"
}
```

**Get All Employees — with pagination and sorting**
```
GET /employees?page=0&size=5&sortBy=name&direction=asc
```

| Param | Description | Default |
|---|---|---|
| `page` | Page number (0-indexed) | `0` |
| `size` | Records per page | `5` |
| `sortBy` | Field to sort by | `id` |
| `direction` | `asc` or `desc` | `asc` |

---

## 🧪 Testing

Run all unit tests:
```bash
mvn test
```

- **`EmployeeServiceTest`** — tests business logic using Mockito (no real database required)
- **`EmployeeRepositoryTest`** — tests JPA queries using an in-memory H2 database (`@DataJpaTest`)

---

## 📬 Postman Collection

A ready-to-import Postman collection covering every endpoint (Register, Login, Create, Get All, Get by ID, Update, Delete) is available at:

```
postman/Employee-Management.postman_collection.json
```

Import it into Postman, run **Register → Login → copy the token → set it as the Bearer token** for the remaining requests, and test each endpoint in sequence.

---

## 👤 Author

**Avinash**
B.E. Information Technology | Java Full Stack Developer
📍 Navi Mumbai, India
