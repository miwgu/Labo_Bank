CREATE TABLE customer (
id INT AUTO_INCREMENT PRIMARY KEY,
firstName VARCHAR(250),
lastName VARCHAR(250));

CREATE TABLE account (
id INT AUTO_INCREMENT PRIMARY KEY,
customerId INT,
balance INT,
foreign key (customerId) references customer(id));

