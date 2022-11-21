SELECT * FROM emp WHERE hiredate > '1992-01-01';

SELECT * FROM emp WHERE ename LIKE 'S%';

SELECT * FROM emp WHERE ename LIKE '__O%';

SELECT * FROM emp WHERE mgr IS NULL;

# 表结构
DESC emp;

SELECT * FROM emp ORDER BY sal;

SELECT * FROM emp ORDER BY deptno, sal DESC;

SELECT * FROM emp ORDER BY empno LIMIT 3;

SELECT * FROM emp ORDER BY empno LIMIT 3, 3;

SELECT * FROM emp ORDER BY empno LIMIT 6, 3;

SELECT * FROM emp ORDER BY empno DESC LIMIT 10, 5;

SELECT * FROM emp ORDER BY empno DESC LIMIT 20, 5;

SELECT job, COUNT(*), AVG(sal) FROM emp GROUP BY job;

SELECT COUNT(*), COUNT(comm) FROM emp;

SELECT COUNT(*), SUM(IF(comm IS NULL, 1, 0)) FROM emp;
SELECT COUNT(*), COUNT(IF(comm IS NULL, 1, NULL)) FROM emp;

SELECT COUNT(DISTINCT mgr) FROM emp;

SELECT MAX(sal) - MIN(sal) FROM emp;

SELECT deptno, AVG(sal) AS avg_sal FROM emp GROUP BY deptno HAVING avg_sal > 1000 ORDER BY avg_sal DESC LIMIT 2;





