SELECT * FROM emp WHERE deptno = 30;

SELECT ename, empno, deptno FROM emp WHERE job = 'CLERK';

SELECT * FROM emp WHERE IFNULL(comm, 0) > sal;

SELECT * FROM emp WHERE IFNULL(comm, 0) > sal * 0.6;

SELECT * FROM emp WHERE (deptno = 10 AND job = 'MANAGER') OR (deptno = 20 AND job = 'CLERK');
-- or
SELECT * FROM emp WHERE deptno = 10 AND job = 'MANAGER'
UNION
SELECT * FROM emp WHERE deptno = 20 AND job = 'CLERK';

SELECT 1 <> 1 AND 1 <> 2; -- 0(false)

SELECT * FROM emp WHERE (deptno = 10 AND job = 'MANAGER') OR (deptno = 20 AND job = 'CLERK')
    OR (job NOT IN ('MANAGER', 'CLERK') AND sal >= 2000);

-- 先过滤再分组, 否则Unknown column 'comm' in 'having clause'
-- HAVING子句中不能使用除了分组字段和聚合函数之外的其他字段。
SELECT job FROM emp WHERE comm IS NOT NULL GROUP BY job;
-- or
SELECT DISTINCT job FROM emp WHERE comm IS NOT NULL;

SELECT NULL < 100; -- null
SELECT 1 OR NULL; -- 1

SELECT * FROM emp WHERE comm IS NULL OR IFNULL(comm, 0) < 100;

SELECT MONTH('2020-02-02') + 1; -- 3

SELECT DATE_SUB('2020-2-01', INTERVAL 0 DAY); -- 2020-02-01

SELECT CONCAT_WS('-', YEAR('2020-2-10'), MONTH('2020-2-10')+1, '01'); -- 2020-3-01

-- DATE_SUB() 会把 '2020-2-1' 转换成规范格式 '2020-02-01'
SELECT * FROM emp WHERE hiredate = DATE_SUB(CONCAT_WS('-', YEAR(hiredate), MONTH(hiredate)+1, '01'), INTERVAL 3 DAY);
-- LAST_DAY(d), 返回给定日期的那一月份的最后一天
SELECT * FROM emp WHERE hiredate = DATE_SUB(LAST_DAY(hiredate), INTERVAL 2 DAY);

SELECT DATE(LAST_DAY(NOW()) - 2) = DATE('2021-11-28'); -- 1
SELECT DATE(LAST_DAY(NOW()) - 2) = '2021-11-28'; -- 1
SELECT LAST_DAY(NOW()) - 2 = '2021-11-28'; -- 0, 20211128 <> '2021-11-28'

SELECT DATE_SUB(NOW(), INTERVAL 30 YEAR); -- 1991-11-12 14:06:49

SELECT * FROM emp WHERE DATE_SUB(NOW(), INTERVAL 12 YEAR) > hiredate;

SELECT CONCAT(LCASE(LEFT(ename, 1)), RIGHT(ename, LENGTH(ename) - 1)) FROM emp;
SELECT CONCAT(LCASE(LEFT(ename, 1)), MID(ename, 2, LENGTH(ename))) FROM emp;
SELECT CONCAT(LCASE(LEFT(ename, 1)), SUBSTRING(ename, 2)) FROM emp;

SELECT ename FROM emp WHERE LENGTH(ename) = 5;
-- or
SELECT ename FROM emp WHERE ename LIKE '_____';