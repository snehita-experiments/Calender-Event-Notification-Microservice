# Calender-Event-Notification-Microservice

This project is a microservice-based Java Spring Boot system for creating an event and sending reminder/notification via Email/SMS to the recipient.

## 📦 Services

### 1. **Eureka Server (`eureka-server`)**
- Acts as the **Service Registry**
- Other microservices register here and discover each other
- Runs on port `8010`

### 2. **Calendar Service (`calender-service`)**
- Manages creation, retrieval, updating, deletion, and search of calendar events
- Communicates with the Notification service using **Feign Client**
- Registers with Eureka
- REST-based for now (can be migrated to event-driven later)
- Runs on port `8080`

### 3. **Notification Service (`notification-service`)**
- Receives notification payloads from the Calendar service
- Currently simulates sending notifications via email/SMS
- Registered with Eureka
- Runs on port `8020` (or any available port)

---

## 🔗 Microservice Communication

- `Calendar Service` uses **OpenFeign** to call `Notification Service`
- Both services are registered with **Eureka** for discovery

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- Spring Cloud (Eureka, OpenFeign)
- MySQL
- Swagger (springdoc-openapi)
- Maven

---

## 🚀 How to Run

1. Start **Eureka Server** on port `8010`
2. Start **notification-service**
3. Start **calender-service**
4. Use Postman to trigger `POST /calender/create` to test notification flow

---

## 💡 Future Enhancements

- Switch to Event-Driven architecture using RabbitMQ or Kafka
- Store notification history in a database
- Add authentication via Spring Security + JWT
- Add email/SMS integration (SendGrid, Twilio)
