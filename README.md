# 💰 Finance Tracker

A personal finance tracker built with Spring Boot, designed to help users manage their income and expenses efficiently.

## 📋 Features

- User registration and management
- Record income and expense transactions
- Categorize transactions (e.g., Salary, Food, Utilities)
- View all transactions per user
- RESTful API endpoints for CRUD operations
- In-memory H2 database integration
- Lombok annotations for cleaner code

## 🛠️ Technologies Used

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [H2 Database](https://h2database.com/html/main.html)
- [Lombok](https://projectlombok.org)
- [Maven](https://maven.apache.org)

## 🚀 Getting Started
### Prerequisites
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) installed
- [Maven](https://maven.apache.org/install.html) installed
- [IntelliJ IDEA](https://www.jetbrains.com/idea) or any preferred IDE

### Installation

**1. Clone the repository:**
```text
git clone https://github.com/alexander-ellison/finance-tracker.git
```
**2. Navigate to the project directory:**
```text
cd finance-tracker
```
**3. Build the project using Maven:**
```text
mvn clean install
```
**4. Run the application**
```text
mvn spring-boot:run
```
**5. Access the application:**

Open your browser and navigate to `https://localhost:8080`.

## 📂Project Structure

```text
finance-tracker/
├── .mvn/wrapper/
|   └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── alexander/
│   │   │           └── financetracker/
│   │   │               ├── controller/
│   │   │               |   ├── TransactionController.java
│   │   │               |   └── Usercontroller.java
│   │   │               ├── model/
│   │   │               |   ├── Transaction.java
│   │   │               |   ├── TransactionType.java
│   │   │               |   └── User.java
│   │   │               ├── repository/
│   │   │               |   ├── TransactionRepository.java
│   │   │               |   └── UserRepository.java
│   │   │               ├── service/
│   │   │               |   ├── TransactionService.java
│   │   │               |   └── UserRepository.java
│   │   │               └── FinanceTrackerApplication.java
│   │   └── resources/
│   │       ├── static
│   │       |   ├── finance-tracker.postman_collection.json
│   │       |   └── openapi-finance-tracker.yaml
│   │       ├── templates
│   │       └── application.properties
├── pom.xml
└── README.md
```

## 🔧 Configuration

The application uses an in-memory H2 database. To access the H2 console:

**1. Ensure the following is present in `application.properties`:**

```text
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
**2. Navigate to http://localhost:8080/h2-console in your browser.**

**3. Use the default JDBC URL: `jdbc:h2:mem:testdb` and connect.**

## 📬 API Endpoints

### Users
- **GET** `/api/users`

  Retrieve all users.


- **POST** `/api/users`

   Create a new user.

### Transactions
- **GET** `/api/transactions`

  Retrieve all transactions.


- **POST** `/api/transactions/user/{userId}`

  Create a transaction for a specific user.

## 🧪 Testing with Postman

Use [Postman](https://www.postman.com/) to test the API endpoints.

### Create a User
- **Endpoint: `POST https://localhost:8080/api/users`**
- **Body:**

```json
  {
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
```

### Create a Transaction
- **Endpoint: `POST http://localhost:8080/api/transactions/user/{userId}`**
- **Body:**

```json
  {
  "amount": 100.00,
  "type": "INCOME",
  "category": "Salary",
  "date": "2025-06-24"
}
```
## 📈 Future Enhancements
* **Implement user authentication and authorization**
* **Integrate with a persistent database like PostgreSQL**
* **Develop a frontend interface using React or Angular**
* **Add features for budgeting and financial reporting**
