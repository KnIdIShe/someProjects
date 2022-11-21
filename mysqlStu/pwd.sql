SELECT USER();

SELECT DATABASE();

# 32位
SELECT MD5('root');

SELECT LENGTH(MD5('root'));

# p37 users表
CREATE TABLE users (
    id INT,
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    pwd CHAR(32) NOT NULL DEFAULT '');

INSERT INTO users VALUES (1, 'root', MD5('root'));

SELECT * FROM users;

SELECT PASSWORD('root');

# /G 的作用是将查到的结构旋转90度变成纵向, dos下有效果.
SELECT * FROM mysql.`user` \G;






