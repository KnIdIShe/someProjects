-- MySQL 5.7只做语法校验, 不生效, MySQL 8支持

CREATE TABLE t23 (
    id INT,
    `name` VARCHAR(32),
    sex VARCHAR(32) CHECK (sex IN ('man', 'women')),
    sal DOUBLE CHECK (sal > 1800)
    );

INSERT INTO t23 VALUES (1, 'tom', 'mid', 1);

SELECT * FROM t23;






    