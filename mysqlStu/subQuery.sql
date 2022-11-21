SELECT * FROM emp
    WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'SMITH');

SELECT * FROM emp
    WHERE job IN (SELECT DISTINCT job FROM emp WHERE deptno = 10)
    AND deptno <> 10;

SELECT e.ename, t.*
FROM emp e
INNER JOIN (
    SELECT deptno, MAX(sal) AS max_val FROM emp GROUP BY deptno) t
ON e.`sal` = t.max_val;

SELECT * FROM emp
WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);

SELECT * FROM emp
WHERE sal > ANY (SELECT sal FROM emp WHERE deptno = 30);

SELECT * FROM emp
WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno = 30);

SELECT e.* FROM emp e
INNER JOIN (SELECT deptno, job FROM emp WHERE ename = 'SMITH') t
ON e.deptno = t.deptno
AND e.job = t.job
WHERE e.ename <> 'SMITH';

SELECT * FROM emp
WHERE (deptno, job) = (SELECT deptno, job FROM emp WHERE ename = 'ALLEN')
AND ename <> 'ALLEN';

SELECT * FROM students
WHERE (chinese, math, english) = (SELECT chinese, math, english FROM students WHERE `name` = '宋江')
AND `name` <> '宋江';

SELECT * FROM emp e
INNER JOIN (SELECT deptno, AVG(sal) avg_sal FROM emp GROUP BY deptno) t
ON e.`deptno` = t.deptno
WHERE sal > avg_sal;

SELECT * FROM emp e
INNER JOIN (SELECT deptno, MAX(sal) max_sal FROM emp GROUP BY deptno) t
ON e.`deptno` = t.deptno
WHERE sal = max_sal;

SELECT * FROM dept d
INNER JOIN (SELECT deptno, COUNT(*) FROM emp GROUP BY deptno) t
ON d.`deptno` = t.deptno;




