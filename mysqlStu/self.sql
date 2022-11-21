-- 多表查询 自连接

SELECT e1.ename, e2.ename
FROM emp e1
INNER JOIN emp e2
ON e1.`mgr` = e2.`empno`;







