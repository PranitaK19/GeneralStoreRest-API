# 🏪 Marathi General Store - Udhari Billing System (REST API)

A simple and beginner-friendly RESTful backend application for managing customer credit (उधारी) records at a local general store. This project is built using **Spring Boot**, **PostgreSQL**, and follows the **MVC architecture**.

---
## 🤝 Group Members

Pranita Khendkar  
Sayali More

----
## 📸 Dairect Link To see Project: https://marathi-billing.surge.sh
----

## 🔧 Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Web (REST Controller)**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Postman** (for testing APIs)

---

## 📁 Project Structure (MVC)
```
src/main/java/
└── com.store.udhari
    ├── UdahriBillingApplication.java         # Main Spring Boot Application Class

    ├── controller/                           # REST Controllers for API Endpoints
    │   ├── CustomerController.java
    │   ├── RepaymentController.java
    │   ├── SummaryController.java
    │   └── UdhariController.java

    ├── dto/                                  # Data Transfer Objects (DTOs)
    │   └── CustomerSummary.java

    ├── model/                                # Entity Classes (JPA Models)
    │   ├── Customer.java
    │   ├── Repayment.java
    │   └── Udhari.java

    └── repository/                           # Repository Interfaces (Spring Data JPA)
        ├── CustomerRepository.java
        ├── RepaymentRepository.java
        └── UdhariRepository.java

```

---

## 📌 Features

- 👤 Add new customers (Name, Mobile)
- 📋 Record उधारी (Item, Quantity, Amount)
- 💰 Track repayments
- 🧾 View customer-wise transaction history
- 📌 View all customers with pending उधारी

---
## ▶️ How to Run the Project

### 🧩 Step 1: Backend (Spring Boot + PostgreSQL)

1. Clone the repository:
```bash
git clone https://github.com/PranitaK19/marathi-udhari-billing.git
cd marathi-udhari-billing
```

2. Set up your PostgreSQL database:
   - Create a database: `gsbilling`
   - Update `application.properties` with your credentials

3. Run the Spring Boot Application:
```bash
./mvnw spring-boot:run
```
   OR run it from **Eclipse STS** as `Spring Boot App`

---

### 🌐 Step 2: Frontend (HTML + CSS + JS)

1. Open a terminal inside the `frontend/` folder (where your `index.html` is located)

2. Run the Python HTTP server:
```bash
python -m http.server 3000
```

3. Open your browser and go to:
```
http://localhost:3000
```

> 🔗 Make sure the backend Spring Boot server is running on `http://localhost:8080` and frontend on `http://localhost:3000`

---

## 📸 Tested Using Postman

<img width="1013" height="865" alt="POST_OP1" src="https://github.com/user-attachments/assets/e4465c01-a636-4403-bebf-747575cdea50" />
<img width="980" height="831" alt="POST_OP2" src="https://github.com/user-attachments/assets/b0974de5-9ad7-4b49-8aa4-9b94942e8240" />
<img width="898" height="777" alt="GET_OP" src="https://github.com/user-attachments/assets/e732a043-8eb9-46ee-b102-d7c007923446" />
<img width="812" height="817" alt="GET_OP1" src="https://github.com/user-attachments/assets/60cb1b1f-7542-4281-a427-38f8d46711c2" />

----

## 📸 Final Web-Page

<img width="1886" height="892" alt="image" src="https://github.com/user-attachments/assets/b0f32a4e-b089-4e1f-852e-cc93168ba5c4" />
<img width="1881" height="840" alt="image" src="https://github.com/user-attachments/assets/b76267bc-2f5a-4349-aa3a-4c4a42a40e77" />

---

## 👩‍💻 Author

Name:-  
**Pranita Khendkar**  
**Sayali More**

Email:-    
khendkarpranita@gmail.com   
sayalimore0007@gmail.com

Github:-  
https://github.com/PranitaK19



