-- Table for drugs
CREATE TABLE drugs (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (id)
);

-- Table for customers
CREATE TABLE customers (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255),
  phone VARCHAR(20),
  PRIMARY KEY (id)
);

-- Table for orders
CREATE TABLE orders (
  id INT NOT NULL AUTO_INCREMENT,
  customer_id INT NOT NULL,
  drug_id INT NOT NULL ,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (drug_id) REFERENCES drugs(id)
);
CREATE TABLE  Users 
(iduser INTEGER NOT NULL AUTO_INCREMENT,
login VARCHAR(100),
passwd VARCHAR(100), 
ConnectionNbr INTEGER DEFAULT 0, 
PRIMARY KEY ( iduser ));

