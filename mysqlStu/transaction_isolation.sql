
-- 查看当前会话隔离级别
SELECT @@tx_isolation;

SELECT @@transaction_isolation;

-- 系统当前隔离级别
SELECT @@global.tx_isolation;

SELECT @@global.transaction_isolation;

START TRANSACTION;

-- 设置前会话隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;

SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;

SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

-- 系统当前隔离级别
SET GLOBAL TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;

CREATE TABLE `account` (
    id INT,
    `name` VARCHAR(32),
    money INT
    );

SELECT * FROM `account`;

INSERT INTO `account` VALUES (800, 'jane', 2300);

COMMIT;






