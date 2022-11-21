SELECT * FROM mysql.`user`;

-- 创建用户, mysql 自动对密码进行加密(password()), 修改密码时使用password()
-- 用户名, 登录地址(ip), 密码
CREATE USER 'zh'@'localhost' IDENTIFIED BY 'zh';

SELECT PASSWORD('zh');

DROP USER 'zh'@'localhost';

-- root用户修改他人密码
SET PASSWORD FOR 'zh'@'localhost' = PASSWORD('zh');

ALTER USER 'zh'@'localhost' IDENTIFIED BY '123';

-- 可修改自己密码
SET PASSWORD  = PASSWORD('123456');

-- 修改他人密码需要权限
SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123456');

-- 未指定host, 则默认为%, 即在所有ip都有连接权限
CREATE USER jack;

CREATE USER 'tom'@'192.168.1.*';
CREATE USER 'tom'@'192.168.1.%';

SELECT * FROM mysql.`user`;

-- 删除用户时, 如用户host不是%, 则需明确指定host
DROP USER jack;

DROP USER zh; -- NG, 默认为'zh'@'%', 不存在

DROP USER 'tom'@'192.168.1.*';
DROP USER 'tom'@'192.168.1.%';


DROP USER 'zh'@'localhost';




