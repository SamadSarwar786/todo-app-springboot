# ToDoApp

ToDoApp is a simple Spring Boot application for managing tasks. It demonstrates best practices for developing a RESTful API with modern tools and frameworks, focusing on separation of concerns, security, and efficient data handling.

---

## Features

- **Task Management**: Create, retrieve, update, and delete tasks.
- **Spring Web**: Simplified development of RESTful web services.
- **Spring Data JPA**: Streamlined data access with MySQL database integration.
- **Spring Security**: JWT-based authentication and role-based authorization.
- **Lombok**: Reduced boilerplate code with annotations.
- **Validation**: Input validation for request DTOs.
- **Custom Exception Handling**: Centralized and user-friendly error responses.
- **DTO Usage**: Separation of concerns with request and response DTOs.

---

## Tech Stack

- **Backend**: Java 17, Spring Boot 3+
- **Database**: MySQL
- **Security**: Spring Security with JWT (JSON Web Tokens)
- **Dependencies**:
  - `Spring Web`
  - `Spring Data JPA`
  - `Spring Security`
  - `Lombok`
  - `Validation API`
  - `JSON Web Token`

---

## Prerequisites

- Java 17+
- Maven 3.6+
- MySQL 8+
- IDE of your choice (IntelliJ, Eclipse, etc.)
- Postman or similar API testing tool (optional)

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/SamadSarwar786/todo-app-springboot.git
   cd todo-app-springboot
2. Configuration
 - spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
 - spring.datasource.username=your-username
 - spring.datasource.password=your-password
 - spring.jpa.hibernate.ddl-auto=update

3. Build the project
   ```bash
   mvn clean install

4. Run the application
   ```bash
   mvn spring-boot:run
