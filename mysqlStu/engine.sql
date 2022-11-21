SHOW ENGINES;

-- innodb, 支持事务、外键、行级锁

-- myisam 添加速度快, 不支持事务和外键, 支持表级锁
CREATE TABLE t28 (
    id INT,
    `name` VARCHAR(32)) ENGINE MYISAM;

START TRANSACTION;
SAVEPOINT a;
INSERT INTO t28 VALUES (1, 'tom');
SELECT * FROM t28;
ROLLBACK TO a;

-- memory 数据存储在内存中(MySQL服务关闭, 数据丢失, 但表结构还在), 速度快(没有IO读写), 默认支持索引(hash表)
CREATE TABLE t29 (
    id INT,
    `name` VARCHAR(32)) ENGINE MEMORY;
INSERT INTO t29 VALUES (1, 'tom'), (2, 'jerry');
SELECT * FROM t29;
DESC t29;

-- 修改存储引擎
ALTER TABLE t29 ENGINE = INNODB;

















