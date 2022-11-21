# 名字不带R
SELECT ename FROM emp WHERE ename NOT LIKE '%R%';
-- or
-- 未找到, 返回0
SELECT ename FROM emp WHERE LOCATE('R', ename) = 0;
SELECT ename FROM emp WHERE POSITION('R' IN ename) = 0;
SELECT ename FROM emp WHERE INSTR(ename, 'R') = 0;

SELECT LOCATE('R', 'FLOO'); -- 0

# 名字前三位
SELECT LEFT(ename, 3) FROM emp;

# a 替换 A
-- REPLACE(s,s1,s2)	将字符串 s2 替代字符串 s 中的字符串 s1
SELECT REPLACE(ename, 'A', 'a') FROM emp;

# 入职10年以上员工
SELECT ename, hiredate FROM emp WHERE DATE_SUB(NOW(), INTERVAL 10 YEAR) >= hiredate;
-- or
SELECT ename, hiredate FROM emp WHERE DATE_ADD(hiredate, INTERVAL 10 YEAR) <= NOW();

# 姓名排序
SELECT * FROM emp ORDER BY ename;

# 工作年限倒序
SELECT * FROM emp ORDER BY DATEDIFF(NOW(), hiredate) DESC;
-- or, 偷懒做法, 按入职时间, 入职早则年限久, 因为日期 2000 > 2001
SELECT * FROM emp ORDER BY hiredate;

# 工作倒叙, 相同则工资正序
SELECT ename, job, sal FROM emp ORDER BY job DESC, sal;

# 月排序, 相同则年优先
SELECT ename, YEAR(hiredate) `year`, MONTH(hiredate) `month` FROM emp ORDER BY `month`, `year`;

# 日薪, 忽略小数
SELECT FLOOR(sal / 30) FROM emp;
-- FORMAT(x,n)	函数可以将数字 x 进行格式化 "#,###.##", 将 x 保留到小数点后 n 位，最后一位四舍五入。
SELECT FORMAT(sal / 30, 0) FROM emp;

# 2月入职的员工
SELECT * FROM emp WHERE MONTH(hiredate) = 2;

# 入职天数
SELECT DATEDIFF(NOW(), hiredate) FROM emp;

# 名字包含A
SELECT ename FROM emp WHERE ename LIKE '%A%';
-- or
SELECT ename FROM emp WHERE LOCATE('A', ename) <> 0;
SELECT ename FROM emp WHERE POSITION('A' IN ename) <> 0;
SELECT ename FROM emp WHERE INSTR(ename, 'A') <> 0;

SELECT 5 % 2; -- 1
-- %*/ 同级
# 司龄(大概), 年月日
SELECT ename, CONCAT(FLOOR(DATEDIFF(NOW(), hiredate) / 365.2422), '年',
            FLOOR((DATEDIFF(NOW(), hiredate) % 365.2422) / 30.43685), '月',
            FLOOR((DATEDIFF(NOW(), hiredate) % 365.2422) % 30.43685), '天'
            ) FROM emp;




