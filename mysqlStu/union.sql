SELECT * FROM emp WHERE sal > 2500
UNION ALL -- 不去重
SELECT * FROM emp WHERE job = 'MANAGER';

SELECT * FROM emp WHERE sal > 2500
UNION -- 去重
SELECT * FROM emp WHERE job = 'MANAGER';

SELECT * FROM emp WHERE sal > 2500 OR job = 'MANAGER';









