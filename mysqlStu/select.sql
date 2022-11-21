CREATE TABLE students (
    id INT NOT NULL DEFAULT 1,
    `name` VARCHAR(20) NOT NULL DEFAULT '',
    chinese FLOAT NOT NULL DEFAULT 0,
    english FLOAT NOT NULL DEFAULT 0,
    math FLOAT NOT NULL DEFAULT 0);

INSERT INTO students (id,`name`,chinese,english,math) VALUES (1,'韩顺平',89,78,90);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (2,'张飞',67,98,56);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (3,'宋江',87,78,77);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (4,'关羽',88,98,90);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (5,'赵云',82,84,67);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (6,'欧阳锋',55,85,45);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (7,'黄蓉',75,65,30);
INSERT INTO students (id,`name`,chinese,english,math) VALUES (8,'韩信',45,65,99);

SELECT * FROM students;

SELECT `name`, english FROM students;

SELECT DISTINCT `name`, english FROM students;

SELECT `name`, chinese + english + math AS total FROM students ORDER BY total DESC;

SELECT *, chinese + english + math AS total FROM students WHERE chinese + english + math > 200;
SELECT *, chinese + english + math AS total FROM students WHERE NOT chinese + english + math > 200;

SELECT * FROM students WHERE `name` = '赵云';

SELECT * FROM students WHERE english > 90;

SELECT * FROM students WHERE math > 60 AND id > 4;

SELECT * FROM students WHERE english > chinese;

SELECT *, chinese + english + math AS total FROM students 
    WHERE chinese + english + math > 200
        AND math < chinese
        AND `name` LIKE '赵%';

SELECT * FROM students WHERE english BETWEEN 80 AND 90;
# or
SELECT * FROM students WHERE english >= 80 AND english <= 90;

SELECT * FROM students WHERE math IN (89, 90, 91);
# or
SELECT * FROM students WHERE math BETWEEN 89 AND 91;
# or
SELECT * FROM students WHERE math = 89 || math = 90 || math = 91;

SELECT * FROM students WHERE math > 80 AND chinese > 80;

SELECT * FROM students WHERE chinese BETWEEN 70 AND 80;

SELECT * FROM students WHERE chinese + english + math IN (189, 190, 191);
# or
SELECT * FROM students WHERE chinese + english + math BETWEEN 189 AND 191;

SELECT * FROM students WHERE `name` LIKE '李%' OR `name` LIKE '宋%';

SELECT * FROM students WHERE math - chinese > 30;
