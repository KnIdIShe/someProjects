CREATE TABLE  myTab01 (
    id INT,
    `name` VARCHAR(32),
    sal DOUBLE,
    job VARCHAR(32),
    deptno INT);

INSERT INTO myTab01
        SELECT empno, ename, sal, job, deptno FROM emp;

INSERT INTO myTab01
    SELECT * FROM myTab01;

SELECT * FROM myTab01;

SELECT COUNT(*) FROM myTab01;

CREATE TABLE myTab02 LIKE emp;

DESC myTab02;

INSERT INTO myTab02 
    SELECT * FROM emp;

SELECT * FROM myTab02;

-- 表去重 start
CREATE TABLE my_tmp LIKE myTab02; -- 新建临时表

INSERT INTO my_tmp -- 临时表内插入去重后数据
    SELECT DISTINCT * FROM myTab02;

-- select * from my_tmp;

DELETE FROM myTab02; -- 清空原表

-- select * from myTab02;

INSERT INTO myTab02 -- 原表内插入去重后数据
    SELECT * FROM my_tmp;

DROP TABLE my_tmp; -- 删除临时表
-- 表去重 end


