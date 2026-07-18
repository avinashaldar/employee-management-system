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

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL
- Postman (for API testing)

## ⚙️ Configuration

Key properties in `application.properties`:

```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_db?createDatabaseIfNotExist=true
spring.datasource.username=postgres
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update

jwt.secret=your-secret-key
jwt.expiration=86400000
```

> ⚠️ Update `spring.datasource.username` and `spring.datasource.password` to match your local PostgreSQL setup before running.

---

## 📡 API Documentation

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

---


## 👤 Author

**Avinash**
B.E. Information Technology | Java Full Stack Developer
📍 Navi Mumbai, India
