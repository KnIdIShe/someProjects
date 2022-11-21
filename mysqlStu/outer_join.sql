SELECT d.`dname`, e.`ename`, e.`job` FROM emp e
RIGHT JOIN dept d
ON e.`deptno` = d.`deptno`;

CREATE TABLE exam (
    id INT,
    grade INT);

INSERT INTO exam VALUES (1, 56), (2, 76), (11, 8);

SELECT * FROM exam;

CREATE TABLE stu2 AS SELECT id, `name` FROM stu;

SELECT * FROM stu2;

SELECT * FROM stu2
LEFT JOIN exam
ON stu2.`id` = exam.`id`;

SELECT * FROM stu2
RIGHT JOIN exam
ON stu2.`id` = exam.`id`;

UPDATE stu2 SET id = id - 12;

SELECT dname, ename, job FROM dept
LEFT JOIN emp
ON dept.`deptno` = emp.`deptno`;

SELECT dname, ename, job FROM emp
RIGHT JOIN dept
ON dept.`deptno` = emp.`deptno`;


