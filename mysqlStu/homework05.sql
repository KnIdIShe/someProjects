CREATE TABLE department (
    id INT,
    `name` VARCHAR(32),
    PRIMARY KEY (id),
    UNIQUE (`name`)
    );

CREATE TABLE class (
    id INT,
    `subject` VARCHAR(32),
    deptname VARCHAR(32),
    enrolltime DATE,
    num INT,
    PRIMARY KEY (id),
    FOREIGN KEY (deptname) REFERENCES department(`name`)
    );

SELECT YEAR(NOW());

ALTER TABLE class
    MODIFY enrolltime YEAR;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id INT,
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    age INT,
    classId INT,
    PRIMARY KEY (id),
    FOREIGN KEY (classId) REFERENCES class(id)
    );

INSERT INTO department VALUES('001','数学');
INSERT INTO department VALUES('002','计算机');
INSERT INTO department VALUES('003','化学');
INSERT INTO department VALUES('004','中文');
INSERT INTO department VALUES('005','经济');

INSERT INTO class VALUES(101,'软件','计算机',1995,20);
INSERT INTO class VALUES(102,'微电子','计算机',1996,30);
INSERT INTO class VALUES(111,'无机化学','化学',1995,29);
INSERT INTO class VALUES(112,'高分子化学','化学',1996,25);
INSERT INTO class VALUES(121,'统计数学','数学',1995,20);
INSERT INTO class VALUES(131,'现代语言','中文',1996,20);
INSERT INTO class VALUES(141,'国际贸易','经济',1997,30);
INSERT INTO class VALUES(142,'国际金融','经济',1996,14);

INSERT INTO student VALUES(8101,'张三',18,101);
INSERT INTO student VALUES(8102,'钱四',16,121);
INSERT INTO student VALUES(8103,'王玲',17,131);
INSERT INTO student VALUES(8105,'李飞',19,102);
INSERT INTO student VALUES(8109,'赵四',18,141);
INSERT INTO student VALUES(8110,'李可',20,142);
INSERT INTO student VALUES(8201,'张飞',18,111);
INSERT INTO student VALUES(8302,'周瑜',16,112);
INSERT INTO student VALUES(8203,'王亮',17,111);
INSERT INTO student VALUES(8305,'董庆',19,102);
INSERT INTO student VALUES(8409,'赵龙',18,101);
INSERT INTO student VALUES(8510,'李丽',20,142);

-- 3 完成以下查询功能
-- （1）找出所有姓李的学生。
SELECT * FROM student WHERE `name` LIKE '李%';

SELECT * FROM student WHERE INSTR(`name`, '李')  = 1;-- srt, substr
SELECT * FROM student WHERE LOCATE('李', `name`)  = 1;-- substr, str
SELECT * FROM student WHERE POSITION('李' IN `name`)  = 1;-- -- substr in str

-- （2）列出所有开设超过1个专业的系的名字。
SELECT deptname, COUNT(*) AS num FROM class GROUP BY deptname HAVING num > 1;

-- （3）列出人数大于等于30的系的编号和名字。
SELECT department.*, t.s FROM department, (SELECT SUM(num) AS s, deptname FROM class GROUP BY deptname) t
WHERE department.`name` = t.deptname AND t.s >= 30;

SELECT department.*, t.s FROM department
INNER JOIN (SELECT SUM(num) AS s, deptname FROM class GROUP BY deptname) t
ON department.`name` = t.deptname
WHERE t.s >= 30;

SELECT department.*, t.s FROM department
INNER JOIN (SELECT SUM(num) AS s, deptname FROM class GROUP BY deptname HAVING s >= 30) t
ON department.`name` = t.deptname;

-- 
-- 4 学校又新增加了一个物理系，编号为006。
INSERT INTO department VALUES('006','物理');

-- 5 学生张三退学，请更新相关的表。

START TRANSACTION;
-- 所在班级人数-1
UPDATE class SET num = num - 1 WHERE class.`id` = (SELECT classId FROM student WHERE `name` = '张三');

DELETE FROM student WHERE `name` = '张三';

COMMIT;

SELECT * FROM student;















