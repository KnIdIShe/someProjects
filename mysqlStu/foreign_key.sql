CREATE TABLE my_class (
    id INT PRIMARY KEY,
    `name` VARCHAR(32) NOT NULL DEFAULT '');

CREATE TABLE my_stu (
    id INT PRIMARY KEY,
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    class_id INT,
    FOREIGN KEY (class_id) REFERENCES my_class(id)
    );

INSERT INTO my_class VALUES (100, 'java'), (200, 'web');

INSERT INTO my_stu VALUES (1, 'tom', 100), (2, 'jerry', 200);

INSERT INTO my_stu VALUES (3, 'iris', NULL);

SELECT * FROM my_class;

SELECT * FROM my_stu;

DELETE FROM my_class WHERE id = 100;






    