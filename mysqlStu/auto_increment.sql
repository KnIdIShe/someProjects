CREATE TABLE t24 (
    id INT PRIMARY KEY AUTO_INCREMENT, -- 自增默认从1开始
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    email VARCHAR(32) NOT NULL DEFAULT ''
    );

CREATE TABLE t25 (
    id INT PRIMARY KEY AUTO_INCREMENT, -- 自增默认从1开始, 可alter table auto_increment = 100 设置起始值
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    email VARCHAR(32) NOT NULL DEFAULT ''
    );

ALTER TABLE t25 AUTO_INCREMENT = 100;

INSERT INTO t25 VALUES (NULL, 'tom', 'tom@gmail.com');

-- 如果指定了自增长的值(不建议), 则以指定的值为准, 后续从666开始增长
INSERT INTO t25 VALUES (666, 'tom', 'tom@gmail.com');

-- id = 667
INSERT INTO t25 VALUES (NULL, 'tom', 'tom@gmail.com');

DESC t24;

INSERT INTO t24 VALUES (NULL, 'tom', 'tom@gmail.com');

SELECT * FROM t25;

INSERT INTO t25 (`name`, email) VALUES ('jerry', 'jerry@gmail.com');


    