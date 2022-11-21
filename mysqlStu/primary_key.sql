-- primary key 非空且唯一

INSERT INTO TABLE VALUES (NULL, ...); -- NG

CREATE TABLE t18 (
    id INT PRIMARY KEY,
    `name` VARCHAR(32) PRIMARY KEY, -- NG, 一张表只能有一个主键
    email VARCHAR(32));

# 复合主键
CREATE TABLE t18 (
    id INT,
    `name` VARCHAR(32),
    email VARCHAR(32),
    PRIMARY KEY (id, `name`));

INSERT INTO t18 VALUES (1, 'tom', 'tom@gmail.com');

INSERT INTO t18 VALUES (1, 'jerry', 'jerry@gmail.com');

INSERT INTO t18 VALUES (1, 'tom', 'zz@gmail.com'); -- NG 

SELECT * FROM t18;

-- 两种定义主键的方式
-- 1. 列级约束
CREATE TABLE t18 (
    id INT PRIMARY KEY, -- type 1
    `name` VARCHAR(32),
    email VARCHAR(32));

-- 2. 表级约束
CREATE TABLE t18 (
    id INT,
    `name` VARCHAR(32),
    email VARCHAR(32),
    PRIMARY KEY (id)); -- type 2

-- 查看索引, 也可查看主键
SHOW INDEX FROM t18;
SHOW INDEXES FROM t18;
-- 查看主键
DESC t18;
-- or
SHOW KEYS FROM t18 WHERE key_name = 'primary';

