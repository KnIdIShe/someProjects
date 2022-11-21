SELECT COUNT(*) FROM students;

SELECT COUNT(*) FROM students WHERE math > 90;

SELECT COUNT(*) FROM students WHERE chinese + english + math > 250;

CREATE TABLE t15 (
    `name` VARCHAR(20));

INSERT INTO t15 VALUES ('tom'), ("jerry"), (NULL), ('');

SELECT * FROM t15;
# all
SELECT COUNT(*) FROM t15;
# not count null, but includes ''
SELECT COUNT(`name`) FROM t15;


SELECT SUM(math) FROM students;

SELECT SUM(chinese), SUM(math), SUM(english) FROM students;

SELECT AVG(chinese) FROM students;

SELECT AVG(math) FROM students;

SELECT AVG(chinese + english + math) FROM students;

SELECT MAX(math) FROM students;

SELECT MIN(math) FROM students;

SELECT MAX(chinese + english + math), MIN(chinese + english + math) FROM students;


SELECT
  `name`,
  chinese + english + math AS total
FROM
  students
WHERE chinese + english + math IN
  (SELECT
    MAX(chinese + english + math)
  FROM
    students
);

