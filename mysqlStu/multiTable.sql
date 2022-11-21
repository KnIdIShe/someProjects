SELECT ename, sal, dept.`dname`, emp.`deptno`
FROM emp
INNER JOIN dept
ON emp.`deptno` = dept.`deptno`
ORDER BY emp.`deptno` DESC;

SELECT ename, sal, CASE WHEN sal BETWEEN 700 AND 1200 THEN 1
                        WHEN sal BETWEEN 1201 AND 1400 THEN 2
                        WHEN sal BETWEEN 1401 AND 2000 THEN 3
                        WHEN sal BETWEEN 2001 AND 3000 THEN 4
                        WHEN sal BETWEEN 3001 AND 9999 THEN 5
                        ELSE 0
                    END AS grade
FROM emp;

SELECT emp.ename, emp.sal, salgrade.`grade`
FROM emp, salgrade
WHERE emp.sal BETWEEN salgrade.losal AND salgrade.hisal;





