# Order Management API (Spring Boot)

A robust, production-ready RESTful API for order and product management, built with Spring Boot, Spring Security (JWT), and JPA/Hibernate. This project demonstrates best practices in API design, security, rate limiting, and modular architecture.

---

## 🚀 Features

* **User & Admin Authentication** (JWT-based)
* **Order Management (User)**:

    * Place orders
    * View orders
    * Cancel orders
* **Admin Order Control**:

    * Confirm orders
    * Ship orders
    * Deliver orders
    * Cancel any order
* **Product Management**:

    * Add new products (Admin)
* **Rate Limiting** (optional integration)
* **Structured Logging** (SLF4J + Logback)
* **Swagger/OpenAPI Documentation**
* **Layered Architecture** (Controller → Service → Repository)
* **Global Exception Handling**
* **DTO-based Request/Response Handling**

---

## 🛠 Tech Stack

* **Java 21**
* **Spring Boot 3.x**
* **Spring Security (JWT)**
* **Spring Data JPA (Hibernate)**
* **PostgreSQL / MySQL**
* **Maven**
* **Lombok**
* **Swagger (Springdoc OpenAPI)**

---

## 📁 Project Structure

```
order-management-api-springboot/
├── src/main/java/com/order/management/
│   ├── controller/        # REST Controllers (API endpoints)
│   ├── service/           # Business logic
│   ├── repository/        # JPA repositories (DB access)
│   ├── entity/            # JPA entities (DB models)
│   ├── dto/               # Request & Response DTOs
│   ├── security/          # JWT, filters, security config
│   ├── exception/         # Global exception handling
│   ├── config/            # App configurations
│   └── util/              # Utility classes
│
├── src/main/resources/
│   ├── application.yml    # Configuration file
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## ⚙️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/order-management-api-springboot.git
cd order-management-api-springboot
```

---

### 2. Configure Database

Update `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/order_db
    username: postgres
    password: yourpassword

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

jwt:
  secret: your-secret-key
  expiration: 600000
```

---

### 3. Build the application

```bash
mvn clean install
```

---

### 4. Run the application

```bash
java -jar target/order-management-api.jar
```

---

### 🌐 Application URLs

* API Base URL: `http://localhost:8080`
* Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 📌 API Overview

### 🔐 Authentication

* **POST /auth/login** → Generate JWT token

---

### 👤 User APIs

* **POST /api/orders** → Place order
* **GET /api/orders** → Get all user orders
* **GET /api/orders/{id}** → Get order details
* **DELETE /api/orders/{id}** → Cancel order

---

### 🛠 Admin APIs

* **GET /admin/orders** → View all orders
* **GET /admin/orders/{id}** → View specific order
* **PUT /admin/orders/{id}/confirm** → Confirm order
* **PUT /admin/orders/{id}/ship** → Ship order
* **PUT /admin/orders/{id}/deliver** → Deliver order
* **DELETE /admin/orders/{id}** → Cancel order

---

### 📦 Product APIs (Admin)

* **POST /admin/products** → Add new product

---

## 🔐 Authentication & Authorization

* JWT-based authentication is used
* Pass token in header:

```http
Authorization: Bearer <token>
```

* Role-based access:

    * USER → Limited access
    * ADMIN → Full control

---

## ⏱ Rate Limiting

* Can be implemented using:

    * Bucket4j (recommended for Spring Boot)
* Applied per user/per endpoint

---

## 🧾 Logging

* Implemented using **SLF4J + Logback**
* Logs include:

    * API requests
    * Errors
    * Security events

---

## ⚠️ Exception Handling

* Global exception handling using `@RestControllerAdvice`
* Security exceptions handled separately:

    * `AuthenticationEntryPoint` → 401
    * `AccessDeniedHandler` → 403

---

## 🔧 Customization

* Update JWT secret in `application.yml`
* Configure DB as needed
* Add roles/permissions for advanced security

---

## 🤝 Contributing

Pull requests are welcome!
For major changes, please open an issue first to discuss your ideas.

---

## 👨‍💻 Author

**Mohit Sai Kumar Madireddy**
Backend Developer

📧 [your.madireddymohit@gmail.com](mailto:your.madireddymohit@gmail.com)

---

*Project built for interview/demo purposes showcasing Spring Boot + JWT + Clean Architecture.*
