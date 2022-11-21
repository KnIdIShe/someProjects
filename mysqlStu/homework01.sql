SELECT * FROM emp WHERE comm IS NOT NULL;

SELECT * FROM emp WHERE NOT comm IS NULL;

SELECT ename na FROM emp ORDER BY ename;
SELECT ename na FROM emp ORDER BY na;

DESC emp;
DESC dept;

SELECT dname FROM dept;

SELECT NULL + 1; -- null

SELECT ename, (sal + IFNULL(comm, 0)) * 13 AS 'annual income' FROM emp;
-- COALESCE(expr1, expr2, ...., expr_n), 返回参数中的第一个非空表达式（从左向右）
SELECT ename, (sal + COALESCE(comm, 0)) * 13 AS 'annual income' FROM emp;

SELECT ename, sal FROM emp WHERE sal > 2850;

SELECT ename, sal FROM emp WHERE sal NOT BETWEEN 1500 AND 2850;
SELECT ename, sal FROM emp WHERE sal < 1500 OR sal > 2850;
SELECT ename, sal FROM emp WHERE NOT (sal >= 1500 AND sal <= 2850);

SELECT ename, deptno FROM emp WHERE empno = 7566;

SELECT ename, sal FROM emp WHERE sal > 1500 AND deptno IN (10, 30);

SELECT ename, job FROM emp WHERE mgr IS NULL;

SELECT ename, job, hiredate FROM emp WHERE hiredate BETWEEN '1991-02-01' AND '1991-05-01' ORDER BY hiredate;

SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL ORDER BY sal DESC;





