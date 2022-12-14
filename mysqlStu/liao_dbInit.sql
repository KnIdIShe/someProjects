-- -- 创建数据库learjdbc:
-- DROP DATABASE IF EXISTS learnjdbc;
-- CREATE DATABASE learnjdbc;

-- -- 创建登录用户learn/口令learnpassword
-- CREATE USER IF NOT EXISTS learn@'%' IDENTIFIED BY 'learnpassword';
-- GRANT ALL PRIVILEGES ON learnjdbc.* TO learn@'%' WITH GRANT OPTION;
-- FLUSH PRIVILEGES;

-- 创建表stu:
USE test;
-- CREATE TABLE stu (
--   id BIGINT AUTO_INCREMENT NOT NULL,
--   name VARCHAR(50) NOT NULL,
--   gender TINYINT(1) NOT NULL,
--   grade INT NOT NULL,
--   score INT NOT NULL,
--   PRIMARY KEY(id)
-- ) Engine=INNODB DEFAULT CHARSET=UTF8 collate utf8_bin;

-- 插入初始数据:
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小明', 1, 1, 88);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小红', 1, 1, 95);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小军', 0, 1, 93);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小白', 0, 1, 100);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小牛', 1, 2, 96);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小兵', 1, 2, 99);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小强', 0, 2, 86);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小乔', 0, 2, 79);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小青', 1, 3, 85);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小王', 1, 3, 90);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小林', 0, 3, 91);
INSERT INTO stu (NAME, gender, grade, score) VALUES ('小贝', 0, 3, 77);