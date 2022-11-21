CREATE USER 'zhang'@'localhost' IDENTIFIED BY '123';

SELECT * FROM mysql.user;

CREATE DATABASE testdb;

CREATE TABLE testdb.news (
    id INT,
    content VARCHAR(32)
    );

INSERT INTO news VALUE (100, 'tom news.');

SELECT * FROM news;

-- 授权
GRANT SELECT, INSERT ON testdb.`news` TO 'zhang'@'localhost';

-- 增加权限
GRANT UPDATE ON testdb.`news` TO 'zhang'@'localhost';

-- 修改其他用户密码
ALTER USER 'zhang'@'localhost' IDENTIFIED BY 'zh';

SET PASSWORD FOR 'zhang'@'localhost' = PASSWORD('123');
-- or
SET PASSWORD FOR 'zhang'@'localhost' = '123';

-- 收回权限
REVOKE ALL ON testdb.`news` FROM 'zhang'@'localhost';
-- or
REVOKE SELECT, INSERT, UPDATE ON testdb.`news` FROM 'zhang'@'localhost';

-- 删除用户
DROP USER 'zhang'@'localhost';

