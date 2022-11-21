SELECT CHARSET(ename) FROM emp;

SELECT CONCAT(ename, '\'s job is ', job) FROM emp;

# dual, 亚元表, 可作为测试用
SELECT INSTR('hello, tom.', 'tom') FROM DUAL;

SELECT UCASE('tom');

SELECT LCASE('TOM');

SELECT LEFT(ename, 2) FROM emp;
SELECT RIGHT(ename, 2) FROM emp;

# 字节长度
SELECT LENGTH('哈哈'); # 6

SELECT REPLACE(job, 'MANAGER', '经理') FROM emp;

# 比较字符串 s1 和 s2，如果 s1 与 s2 相等返回 0 ，如果 s1>s2 返回 1，如果 s1<s2 返回 -1
# 不区分大小写
SELECT STRCMP('hh', 'HH');

# SUBSTRING(str, from(从1开始), length(不写则到末尾))
SELECT CONCAT(SUBSTRING(ename, 1, 1), LCASE(SUBSTRING(ename, 2))) FROM emp;
SELECT REPLACE(ename, SUBSTRING(ename, 2), LCASE(SUBSTRING(ename, 2))) FROM emp;

SELECT LTRIM('    hh');
SELECT RTRIM('hh    ');
SELECT LTRIM('    hh    ');

SELECT REPLACE(ename, SUBSTRING(ename, 1, 1), LCASE(SUBSTRING(ename, 1, 1))) FROM emp;

SELECT REPLACE(ename, LEFT(ename, 1), LCASE(LEFT(ename, 1))) FROM emp;

SELECT REPLACE('THTH', LEFT('THTH', 1), LCASE(LEFT('THTH', 1)));

