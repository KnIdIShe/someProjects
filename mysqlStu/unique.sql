CREATE TABLE t21 (
    id INT UNIQUE, -- 不重复(唯一), 但可为多个 null
    `name` VARCHAR(32),
    email VARCHAR(32));

INSERT INTO t21 VALUES (1, 'tom', 'tom@gmail.com');
INSERT INTO t21 VALUES (NULL, 'jerry', 'jerry@gmail.com');
INSERT INTO t21 VALUES (NULL, 'iris', 'iris@gmail.com');

SELECT * FROM t21;

-- unique not null 效果类似 primary key

-- 一个表可有多个 unique 字段
CREATE TABLE t21 (
    id INT UNIQUE, -- 不重复(唯一), 但可为多个 null
    `name` VARCHAR(32) UNIQUE,
    email VARCHAR(32));
        
        
        
        
        