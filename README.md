# User Service

## Overview

This project is a user service built with Java, Spring Boot, and Maven. It provides functionalities for user authentication and management, including login, signup, logout, and token validation. The service also integrates with Kafka for sending email notifications upon user signup.

## Technologies Used

- Java
- Spring Boot
- Maven
- SQL
- Kafka
- BCrypt for password hashing
- Jackson for JSON processing

## Project Structure

- `src/main/java/com/example/userservice/controllers`: Contains the REST controllers for handling HTTP requests.
- `src/main/java/com/example/userservice/services`: Contains the service classes that implement the business logic.
- `src/main/java/com/example/userservice/models`: Contains the entity classes.
- `src/main/java/com/example/userservice/repositories`: Contains the repository interfaces for database operations.
- `src/main/java/com/example/userservice/dtos`: Contains the Data Transfer Objects (DTOs) used for request and response payloads.

## Endpoints

### AuthController

- **POST /auth/login**
  - Request: `LoginRequestDto`
  - Response: `UserToken`
  - Description: Authenticates a user and returns a token.

- **POST /auth/signup**
  - Request: `SignUpRequestDto`
  - Response: `UserDto`
  - Description: Registers a new user and sends a welcome email.

- **POST /auth/logout**
  - Request: `LogoutRequestDto`
  - Response: `ResponseEntity<Void>`
  - Description: Logs out a user by invalidating their token.

- **GET /auth/validate-token**
  - Request: `token` (as query parameter)
  - Response: `UserDto`
  - Description: Validates a token and returns the associated user.

### UserController

- **GET /users**
  - Response: `List<User>`
  - Description: Retrieves all users.

- **GET /users/{id}**
  - Response: `User`
  - Description: Retrieves a user by ID.

- **POST /users**
  - Request: `User`
  - Response: `User`
  - Description: Adds a new user.

- **PUT /users/{id}**
  - Request: `User`
  - Response: `User`
  - Description: Replaces an existing user.

- **PATCH /users/{id}**
  - Request: `User`
  - Response: `User`
  - Description: Updates an existing user.

- **DELETE /users/{id}**
  - Response: `void`
  - Description: Deletes a user by ID.

## Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yash2303/UserService.git
   cd user-service
   ```

2. **Build the project:**
   ```sh
   mvn clean install
   ```

3. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

## Configuration

- **Database:** Configure your database settings in `application.properties`.
- **Kafka:** Configure your Kafka settings in `application.properties`.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
