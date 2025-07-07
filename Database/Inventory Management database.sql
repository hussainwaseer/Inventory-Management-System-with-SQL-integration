CREATE DATABASE IF NOT EXISTS inventory_system;
USE inventory_system;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS stock_entries;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    user_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(20) NOT NULL
);

insert into users (user_id,name,password) values
(001,"Hussain","123"),
(002,"Ali","555");

CREATE TABLE IF NOT EXISTS categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL
);

insert into categories (name) values
("ELectronics"),
("Medicines"),
("Groceries");

CREATE TABLE IF NOT EXISTS suppliers (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address VARCHAR(100) NOT NULL
);

insert into suppliers (name,phone,address)
values
("Amir","123132132","sukkur"),
("Muneeb","3425235","larkana");

CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    category_id INT NOT NULL,
    supplier_id INT NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into products (product_id,name,category_id,supplier_id,price,quantity)
values
(2,"TV",1,2,3000,30),
(4,"Panadol",2,1,60,2000);

CREATE TABLE IF NOT EXISTS stock_entries (
    entry_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    user_id INT NOT NULL,
    quantity INT NOT NULL,
    entry_type ENUM('IN', 'OUT') NOT NULL,
    entry_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into stock_entries(entry_id,product_id,user_id,quantity,entry_type)
values
(101,2,1,10,"IN"),
(102,4,2,5,"OUT");


SELECT * FROM users;
SELECT * FROM categories;
SELECT * FROM suppliers;
SELECT * FROM products;
SELECT * FROM stock_entries;
