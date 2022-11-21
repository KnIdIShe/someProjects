SELECT IF(TRUE, 1, 2);

SELECT ename, IF(comm IS NULL, 0.0, comm) FROM emp;

SELECT ename, IFNULL(comm, 0.0) FROM emp;

SELECT ename, CASE WHEN job = 'CLERK' THEN '文员'
                   WHEN job = 'MANAGER' THEN '经理'
                   WHEN job = 'SALESMAN' THEN '销售'
                   ELSE job
              END
FROM emp;

SELECT ename, CASE job
                   WHEN 'CLERK' THEN '文员'
                   WHEN 'MANAGER' THEN '经理'
                   WHEN 'SALESMAN' THEN '销售'
                   ELSE job
              END
FROM emp;










