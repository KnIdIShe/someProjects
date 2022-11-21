CREATE TABLE actor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(32) NOT NULL DEFAULT '',
    sex CHAR(1) NOT NULL DEFAULT 'F',
    borndate DATE,
    phone CHAR(11)
    );

ALTER TABLE actor
    MODIFY borndate DATE;

DESC actor;

-- INSERT INTO actor VALUES (null, 'tom');
INSERT INTO actor VALUES (NULL, 'jerry', 'M', '2012-02-03', '18000220033');
INSERT INTO actor VALUES (NULL, 'iris', 'F', '2015-05-03', '18000880099');

SELECT * FROM actor;

USE test;
CREATE TABLE news (id INT, content VARCHAR(32));
INSERT INTO news VALUES (1, 'tom');
INSERT INTO news VALUES (2, 'jerry');
INSERT INTO news VALUES (3, 'iris');
UPDATE news SET content = 'alice' WHERE id = 1;
DELETE FROM news WHERE id = 2;

SELECT * FROM news;

DROP TABLE news;


