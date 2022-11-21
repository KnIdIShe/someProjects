CREATE DATABASE shop_db;

CREATE TABLE goods (
    goods_id INT PRIMARY KEY,
    goods_name VARCHAR(32) NOT NULL DEFAULT '',
    unitprice DOUBLE NOT NULL DEFAULT 0 CHECK (unitprice BETWEEN 1.0 AND 999.99),
    category INT NOT NULL DEFAULT 0,
    provider VARCHAR(32) NOT NULL DEFAULT ''
    );

CREATE TABLE customer (
    customer_id INT PRIMARY KEY,
    `name` VARCHAR(32) NOT NULL DEFAULT 0,
    address VARCHAR(32) NOT NULL DEFAULT 0,
    email VARCHAR(32) UNIQUE NOT NULL,
    sex ENUM('F', 'M') NOT NULL,
--     sex char(1) check (sex in ('F', 'M')),
    card_id CHAR(18) UNIQUE NOT NULL
    );

CREATE TABLE purchase (
    order_id INT PRIMARY KEY,
    customer_id INT NOT NULL DEFAULT 0,
    goods_id INT NOT NULL DEFAULT 0,
    nums INT NOT NULL DEFAULT 0,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (goods_id) REFERENCES goods(goods_id)
    );












