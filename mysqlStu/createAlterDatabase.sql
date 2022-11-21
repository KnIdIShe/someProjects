CREATE DATABASE test;

ALTER DATABASE test COLLATE utf8_bin;

CREATE TABLE `goods` (
    id INT,
    `name` VARCHAR(10),
    price DOUBLE);

INSERT INTO goods
    VALUES (1, 'apple', 3),
    (2, 'pear', 4);

INSERT INTO goods (id, `name`)
    VALUES (4, 'orange');

ALTER TABLE goods
    MODIFY price DOUBLE NOT NULL DEFAULT 2.8;

UPDATE goods SET price = 100 WHERE price IS NULL;

