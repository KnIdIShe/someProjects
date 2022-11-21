CREATE VIEW emp_view01
    AS SELECT empno, ename, job, deptno FROM emp;
    
DESC emp_view01;
    
SELECT * FROM emp_view01;
    
-- 更新视图
ALTER VIEW emp_view01 AS SELECT ...;

-- 查看创建视图的指令
SHOW CREATE VIEW emp_view01;

-- 删除指令
DROP VIEW emp_view01;    

-- 修改视图对应的数据(来自基表, 映射关系), 会影响到基表, 反之也成立
UPDATE emp_view01
    SET job = 'MANAGER'
    WHERE empno = 7369;

SELECT * FROM emp;

UPDATE emp
    SET job = 'SALESMAN'
    WHERE empno = 7369;

-- 视图中可以使用视图, 数据依然来自基表
CREATE VIEW empp_view02
    AS SELECT empno, ename FROM emp_view01;

SELECT * FROM empp_view02;

CREATE VIEW emp_view03
    AS
    SELECT empno, ename, d.dname, s.grade
    FROM emp e
    INNER JOIN dept d
    ON e.deptno = d.deptno
    INNER JOIN salgrade s
    ON sal BETWEEN s.losal AND s.hisal;

SELECT * FROM emp_view03;    
    