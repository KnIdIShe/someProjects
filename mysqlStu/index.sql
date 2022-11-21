USE tmp;

SELECT COUNT(*) FROM emp;

-- 第一条数据, 当没有索引时, 查询第一条数据和最后一条数据时间接近, 都是遍历所有数据, 
-- 找到第一条数据后也会进行后面的扫描以查找有后续符合条件的
SELECT * FROM emp
    WHERE empno = '100002'; -- 4.936s

SELECT * FROM emp -- 最后一条数据
    WHERE empno = '8100001'; -- 4.935s

CREATE INDEX empno_index ON emp (empno);

DROP INDEX empno_index ON emp;
ALTER TABLE emp DROP INDEX empno_index;

SELECT * FROM emp LIMIT 10;
SELECT * FROM emp ORDER BY empno DESC LIMIT 10;

CREATE TABLE t25 (
    id INT,
    `name` VARCHAR(32));

SHOW INDEX FROM t25;

# 添加普通索引 way 1
-- 唯一索引, id 不可重复
CREATE UNIQUE INDEX id_index ON t25 (id);

-- 普通索引, id 可重复
CREATE INDEX id_index ON t25 (id);

# 添加索引 way 2
ALTER TABLE t25 ADD INDEX id_index (id);

# 添加主键索引
CREATE TABLE t26 (
    id INT /* primary key */, -- way 1
    `name` VARCHAR(32));

ALTER TABLE t26 ADD PRIMARY KEY (id); -- way 2

# 删除索引
DROP INDEX id_index ON t25;

SHOW INDEX FROM t26;

# 删除主键索引
ALTER TABLE t26 DROP PRIMARY KEY;

# 修改索引 --> 先删除, 再添加

# 查询索引
-- way 1
SHOW INDEX FROM t25;
-- way 2
SHOW INDEXES FROM t25;
-- way 3
SHOW KEYS FROM t25;
-- way 4
DESC t25;

# homework
-- 创建主键索引
CREATE TABLE `order` (
    id INT PRIMARY KEY, -- way 2
    goods_name VARCHAR(32),
    buyer VARCHAR(32),
    num INT
    );

CREATE TABLE `order` (
    id INT,
    goods_name VARCHAR(32),
    buyer VARCHAR(32),
    num INT,
    PRIMARY KEY (id) -- way 3
    );

DROP TABLE `order`;

ALTER TABLE `order` ADD PRIMARY KEY (id); -- way 1
ALTER TABLE `order` DROP PRIMARY KEY;
SHOW INDEX FROM `order`;

-- 创建唯一索引
CREATE TABLE menu (
    id INT,
    `name` VARCHAR(32),
    chef VARCHAR(32),
    IDcard CHAR(18),
    price DOUBLE
    );

ALTER TABLE menu ADD UNIQUE INDEX uni_IDcard (IDcard);
ALTER TABLE menu DROP INDEX uni_IDcard;

CREATE UNIQUE INDEX uni_IDcard ON menu (IDcard);

SHOW INDEX FROM menu;

-- 创建普通索引
CREATE TABLE sportman (
    id INT,
    `name` VARCHAR(32),
    specialty VARCHAR(32)
    );

ALTER TABLE sportman ADD INDEX id_index (id);
CREATE INDEX id_index ON sportman (id);

SHOW INDEX FROM sportman;




