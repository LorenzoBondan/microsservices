# Microservices Architecture with Kafka and Spring Cloud

This project demonstrates a microservices architecture using **Spring Boot**, **Spring Cloud (Eureka, Config Server, API Gateway)**, and **Apache Kafka** for asynchronous communication between services.

---

## 🧭 Overview

The architecture consists of:

- **Eureka Server** – Service registry
- **Config Server** – Centralized configuration management
- **API Gateway** – Routing
- **Hr-Oauth** – Authentication using OAuth2 and JWT
- **Notification** – Event-driven communication service
- **Hr-Exception-Handler** – Shared library to handle custom exceptions
- **Auth-lib** – Shared library to retrieve logged-in user and perform validations
- **Multiple microservices** – e.g., `payroll-service`, `worker-service`, etc.

---

## 🚀 How to Run

1. **Start Kafka using Docker Compose**:

   ```bash
   docker-compose up

2. ** Run the services in this order: Eureka Service, Config Service, Api Gateway, other services...

---

## 📦 Technologies Used
- Java 17
- Spring Boot
- Spring Cloud (Eureka, Config Server)
- Spring Cloud Gateway
- Spring Security (Oauth2)
- Spring Data (JPA)
- Spring Kafka
- Docker

---

## 🗺️ Project Structure Map

![microsservices map](https://github.com/user-attachments/assets/e3d0fff8-279b-4fb5-a836-26a43bfdb2fa)
