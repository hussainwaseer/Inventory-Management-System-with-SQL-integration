# 📦 Inventory Management System (Java + MySQL)

A console-based Java application that connects with a MySQL database to manage inventory, users, categories, suppliers, products, and stock entries. It's a menu-driven system designed for practicing JDBC and SQL integration.

## 🛠️ Tech Stack
Java (JDK 8 or above)  
MySQL  
JDBC (MySQL Connector)  
IDE: IntelliJ IDEA / NetBeans / Eclipse  

## 📁 Repository Structure
├── .idea/ – IDE project files  
├── libraries/ – Contains MySQL JDBC driver (.jar)  
├── src/ – Java application source code  
│   └── Main.java  
├── Inventory management database.sql – SQL schema for database setup  
└── README.md – Project documentation  

## 📂 Features
🔐 User authentication (Login & Signup)  
🗃 View and Add: Categories, Suppliers, Products, Stock Entries  
✅ Proper relational structure using foreign keys  
🔒 Password-protected access  
🧠 Simple text-based interface (terminal)

## 🗄️ Database Setup
📄 SQL File: `Inventory management database.sql`  
1. Open phpMyAdmin or any MySQL GUI/CLI  
2. Import the `.sql` file to automatically create the database and populate it with sample data  
3. Make sure your MySQL server is running and accessible  

## 🚀 How to Run
1. Clone this repository:  
   `git clone https://github.com/hussainwaseer/Inventory-Management-System-with-SQL-integration`  
2. Open in IntelliJ or your preferred IDE  
3. Ensure the JDBC jar (MySQL Connector) is added to your project's libraries  
4. Compile and run `Main.java`  
5. Make sure your DB credentials in `Main.java` match your MySQL setup:  
```java
static final String databaseusername = "root";
static final String databasepassword = "root";
static final String databasepath = "jdbc:mysql://localhost:3306/inventory_system";

🧾 Application Flow
🔸 Main Menu:

Login

Signup

Exit

🔸 After login:

View Categories

View Suppliers

View Products

View Stock Entries

Logout

⚠️ Requirements
✔ Java 8+
✔ MySQL Server
✔ MySQL Connector/J (JDBC driver)

💡 Future Ideas
Add update/delete options

Use PreparedStatement for better security

Input validation and error handling

Export to CSV/PDF

Swing/JavaFX GUI interface

👤 Author
Muhammad Hussain
🎓 Computer Science Student | Backend Developer
📧 Feel free to connect or suggest improvements!
