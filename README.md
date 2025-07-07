📦 Inventory Management System (Java + MySQL)
A console-based Java application that connects with a MySQL database to manage inventory, users, categories, suppliers, products, and stock entries. This is a simple, menu-driven system ideal for learning database operations using JDBC.

🛠️ Tech Stack
Java (JDK 8 or above)

MySQL

JDBC (MySQL Connector)

IDE: IntelliJ IDEA / NetBeans / Eclipse

📁 Repository Structure
├── .idea
├── libraries        # libraries used ex: mysql connector
├── src              # Java application source code
├── Inventory management database.sql     # SQL schema for creating and populating the database
└── README.md               # Project documentation
📂 Features
🔐 User authentication (login/signup)

🗃 View & add: Categories, Suppliers, Products, Stock Entries

✅ Relational database with proper foreign keys

🧠 Intuitive terminal UI

🔒 Protected with password authentication

🗃️ Database Setup
To get started, import the database schema:

📄 File: inventory_schema.sql

🔧 Steps:
Open phpMyAdmin or any MySQL CLI tool.

Run the script in inventory_schema.sql to:

Create the database

Create all required tables

Insert some sample data

🚀 How to Run the Application
✅ Make sure MySQL is running and accessible.

✅ Clone this repository:

bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
✅ Compile and run the Java file:

bash
javac Main.java
java Main
✅ Ensure the database credentials in Main.java match your local setup:

java
static final String databaseusername = "root";
static final String databasepassword = "root";
static final String databasepath = "jdbc:mysql://localhost:3306/inventory_system";
🧾 Main Menu Options

1. Login
2. Signup
3. Exit
➡️ After login:

1. View Categories
2. View Suppliers
3. View Products
4. View Stock Entries
5. Logout
⚠️ Requirements
✅ Java JDK 8 or higher

✅ MySQL Server (local or remote)

✅ mysql-connector-java-X.X.X.jar in your classpath

💡 Future Improvements
 Add product/supplier/category update/delete

 Use PreparedStatement instead of raw Statement

 Add input validations and error handling

 Create a Swing-based GUI

 Export stock data to CSV or PDF

👤 Author
Muhammad Hussain
🎓 Computer Science Student | Backend Enthusiast
📧 Feel free to connect or suggest improvements!
