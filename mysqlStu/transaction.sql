CREATE TABLE t27 (
    id INT,
    `name` VARCHAR(32));

-- 开启事务
START TRANSACTION;
-- or
SET autocommit = off;
SET autocommit = FALSE;

-- 设置保存点
SAVEPOINT a;

-- 执行 dml 操作
INSERT INTO t27 VALUES (100, 'tom');

SELECT * FROM t27;

SAVEPOINT b;

INSERT INTO t27 VALUES (200, 'jerry');
INSERT INTO t27 VALUES (300, 'iris');

-- 回退到保存点 b
ROLLBACK TO b;

-- 继续回退到保存点 a, 但回退到a后就不能再回退到b, 回退到a后, a之后的保存点全部被删除
ROLLBACK TO a;

-- 回退到事务开始的状态
ROLLBACK;

COMMIT;




    