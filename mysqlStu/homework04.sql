# 有员工的部门
SELECT * FROM dept
WHERE deptno IN (SELECT DISTINCT deptno FROM emp);

SELECT deptno FROM emp GROUP BY deptno;

SELECT DISTINCT deptno FROM emp;

SELECT deptno, COUNT(*) c FROM emp
GROUP BY deptno
HAVING c > 0;

# 薪资比Smith高的员工
SELECT * FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'SMITH');

# 入职日期晚于上级的员工
SELECT e1.*, e2.`hiredate` FROM emp e1
INNER JOIN emp e2
ON e1.`mgr` = e2.`empno`
WHERE e1.hiredate > e2.`hiredate`;

SELECT e1.*, e2.`hiredate` FROM emp e1, emp e2
WHERE e1.`mgr` = e2.`empno` AND e1.`hiredate` > e2.`hiredate`;

-- 列出所有部门的员工, 即使某部门没有员工
SELECT * FROM dept d
LEFT JOIN emp e
ON d.`deptno` = e.`deptno`;

# 所有clerk
SELECT * FROM emp e
INNER JOIN dept d
ON d.`deptno` = e.`deptno`
WHERE e.`job` = 'CLERK';

# 最低工资高于1500的工作
SELECT job, MIN(sal) `min` FROM emp
    GROUP BY job
    HAVING `min` > 1500;

# 在SALES部门工作的员工
SELECT ename FROM emp e
INNER JOIN dept d
ON e.`deptno` = d.`deptno`
WHERE d.`dname` = 'SALES';

# 工资高于平均工资
SELECT * FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp);

# 与Scott职位相同的员工
SELECT * FROM emp
    WHERE job = (
        SELECT job FROM emp WHERE ename = 'SMITH');

# 薪资高于30号部门最高薪资的员工
SELECT ename, sal FROM emp
    WHERE sal > (SELECT MAX(sal) FROM emp WHERE deptno = 30);

SELECT ename, sal FROM emp
    WHERE sal > ALL (SELECT sal FROM emp WHERE deptno = 30);

-- ROUND(X,D)： 返回参数X的四舍五入的有 D 位小数的一个数字。如果D为0，结果将没有小数点或小数部分。
-- ROUND 返回值被变换为一个BIGINT!
SELECT ROUND(1.2365, 2);

# 每个部门的员工数量, 平均工资, 平均司龄
SELECT deptno, COUNT(*), ROUND(AVG(sal), 2), ROUND(AVG(DATEDIFF(NOW(), hiredate) / 365.2422), 2) FROM emp GROUP BY deptno;;

# 所有员工的姓名、部门名称、工资。
SELECT ename, d.dname, sal FROM emp
    INNER JOIN dept d
    ON emp.`deptno` = d.`deptno`;

# 所有部门的详细信息和部门人数
SELECT * FROM dept
    LEFT JOIN (SELECT deptno, COUNT(*) FROM emp GROUP BY deptno) t
    ON dept.`deptno` = t.deptno;

# 每种工作的最低工资
SELECT deptno, MIN(sal) FROM emp GROUP BY deptno;

# manager 的最低工资
SELECT MIN(sal) FROM emp WHERE job = 'MANAGER';

# 所有员工年薪, 升序
SELECT sal * 12 AS "annual income" FROM emp ORDER BY "annual income"; -- 出错, 不排序
SELECT sal * 12 AS "annual income" FROM emp ORDER BY sal * 12; -- 正常
SELECT ename, (sal + IFNULL(comm, 0)) * 12 AS annual_income FROM emp ORDER BY annual_income; -- 变成一个单词, 正常









