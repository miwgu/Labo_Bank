CREATE TABLE customer (
id INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(250),
lastName VARCHAR(250));

CREATE TABLE account (
id INT AUTO_INCREMENT PRIMARY KEY,
customer_Id INT,
balance INT,
foreign key (customer_Id) references customer(id));

