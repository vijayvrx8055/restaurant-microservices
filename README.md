# Restaurant Microservices 🍽️

**Order Processing & Management System built with Spring Boot Microservices**

---

## 📋 Overview

A complete restaurant order management system built using microservices architecture. This project demonstrates real-world restaurant operations including order processing, inventory management, delivery tracking, and payment integration.

---

## ✨ Features

✅ **Order Management** - Create, track, and manage food orders  
✅ **Multi-Restaurant Support** - Handle multiple restaurants in one system  
✅ **Inventory Management** - Track food items and stock levels  
✅ **Delivery Tracking** - Real-time order delivery status updates  
✅ **Payment Integration** - Secure payment processing  
✅ **User Roles** - Customer, restaurant manager, delivery personnel  
✅ **Async Processing** - Message queues for order processing  
✅ **Database Flexibility** - MySQL and MongoDB for different services  
✅ **Rating & Reviews** - Customer feedback system  

---

## 🏗️ Microservices Architecture

### Service Breakdown

```
┌───────────────────────────────────┐
│      API Gateway / Load Balancer  │
└───────────────┬───────────────────┘
                │
    ┌───────────┼───────────┬─────────────┬──────────┐
    │           │           │             │          │
    ▼           ▼           ▼             ▼          ▼
  User      Restaurant   Order      Inventory    Payment
 Service    Service      Service    Service      Service
    │           │           │             │          │
    └───────────┼───────────┼─────────────┼──────────┘
                │
         ┌──────▼──────┐
         │  Databases  │
         │  (MySQL,    │
         │  MongoDB)   │
         └─────────────┘
                │
         ┌──────▼──────┐
         │ Message Queuee
         │  (RabbitMQ) │
         └─────────────┘
```

### Tech Stack

- **Backend:** Spring Boot 2.x, Spring Cloud
- **Databases:** MySQL, MongoDB
- **Message Queue:** RabbitMQ / Kafka
- **API Communication:** REST + OpenFeign
- **Security:** Spring Security, JWT
- **Build:** Maven

---

## 🚀 Getting Started

### Prerequisites

- Java 11+
- Maven 3.6+
- MySQL 8.0+
- MongoDB 4.4+
- RabbitMQ / Kafka

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/vijayvrx8055/restaurant-microservices.git
   cd restaurant-microservices
   ```

2. **Setup Databases**
   ```bash
   # MySQL setup
   mysql -u root -p
   CREATE DATABASE restaurant_db;
   
   # MongoDB setup (if separate)
   mongod --dbpath /data/db
   ```

3. **Setup Message Queue**
   ```bash
   # RabbitMQ
   docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
   ```

4. **Build & Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## 📡 API Endpoints

### User Service
```
POST   /api/users/register          - Register new user
POST   /api/users/login             - User login
GET    /api/users/{userId}          - Get user profile
PUT    /api/users/{userId}          - Update profile
```

### Restaurant Service
```
GET    /api/restaurants             - List all restaurants
GET    /api/restaurants/{id}        - Get restaurant details
POST   /api/restaurants             - Register restaurant (Admin)
GET    /api/restaurants/{id}/menu   - Get restaurant menu
```

### Order Service
```
POST   /api/orders                  - Place new order
GET    /api/orders/{orderId}        - Get order details
GET    /api/users/{userId}/orders   - Get user's orders
PUT    /api/orders/{orderId}/status - Update order status
DELETE /api/orders/{orderId}        - Cancel order
```

### Inventory Service
```
GET    /api/inventory/{restaurantId}         - Get food items
POST   /api/inventory/{restaurantId}/items   - Add new item
PUT    /api/inventory/items/{itemId}         - Update item
PUT    /api/inventory/items/{itemId}/stock   - Update stock
```

### Payment Service
```
POST   /api/payments                - Process payment
GET    /api/payments/{paymentId}    - Get payment status
PUT    /api/payments/{paymentId}    - Update payment
```

---

## 🔄 Order Processing Flow

```
1. Customer places order → Order Service
2. Order Service validates & creates order (MySQL)
3. Publishes event to message queue
4. Inventory Service consumes, deducts stock (MongoDB)
5. Restaurant Service receives order notification
6. Payment Service processes payment
7. Delivery Service assigned
8. Customer notified of status updates (real-time)
```

---

## 💾 Database Schema

### MySQL Tables (User, Order, Restaurant)
- `users` - User accounts
- `restaurants` - Restaurant information
- `orders` - Order records
- `payments` - Payment transactions

### MongoDB Collections (Inventory)
- `menu_items` - Food items with details
- `inventory_stock` - Stock tracking
- `ratings_reviews` - Customer feedback

---

## 📨 Message Queue Integration

**Topics/Queues:**
- `order.created` - New order events
- `order.status.updated` - Status change events
- `payment.processed` - Payment completion
- `inventory.updated` - Stock updates

---

## 🔐 Authentication & Authorization

- JWT token-based authentication
- Role-based access control:
  - **Customer:** Place orders, track delivery
  - **Restaurant Manager:** Manage menu, view orders
  - **Delivery:** Update delivery status
  - **Admin:** System-wide management

---

## 🧪 Testing

```bash
# Run all tests
mvn test

# Run service-specific tests
cd order-service && mvn test
```

**Tools:** JUnit 5, Mockito, Spring Test, Testcontainers

---

## 📊 Monitoring & Logging

- **Logging:** SLF4J with Logback
- **Metrics:** Micrometer, Prometheus
- **Distributed Tracing:** Spring Cloud Sleuth
- **Service Discovery:** Eureka (optional)

---

## 🚢 Deployment

```bash
# Docker build
docker build -t restaurant-microservices .

# Docker Compose
docker-compose up -d

# Kubernetes
kubectl apply -f k8s/
```

---

## 📈 Future Enhancements

- [ ] Add Redis caching layer
- [ ] Implement order recommendations ML model
- [ ] Add push notifications for order updates
- [ ] Integrate with payment gateways (Stripe, PayPal)
- [ ] Advanced analytics dashboard
- [ ] Mobile app integration

---

## 📝 License

This project is licensed under the GPL-3.0 License.

---

## 👨‍💻 Author

**Vijay Kumar**  
Backend Engineer | Microservices Specialist  
[LinkedIn](https://www.linkedin.com/in/vijay-kumar-51487a292/) | [GitHub](https://github.com/vijayvrx8055)

---

## 🤝 Contributing

Feel free to fork and contribute with improvements!

---

## ❓ Support

For issues, please open a GitHub issue.
