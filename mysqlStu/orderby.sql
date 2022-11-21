SELECT * FROM students ORDER BY math;

SELECT *, chinese + english + math AS total FROM students ORDER BY total DESC;

SELECT *, chinese + english + math AS total FROM students WHERE `name` LIKE '韩%' ORDER BY total DESC;

SELECT * FROM students WHERE `name` LIKE '韩%' ORDER BY chinese + english + math DESC;




