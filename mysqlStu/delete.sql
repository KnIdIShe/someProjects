DELETE FROM students
    WHERE id = 6;

# 仅删除数据, 保留表结构
DELETE FROM students;

# 删除数据及表结构
DROP TABLE students;

RENAME TABLE students TO stu;

SELECT * FROM stu;