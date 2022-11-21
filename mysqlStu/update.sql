UPDATE students
    SET score = 88
    WHERE id = 5;

UPDATE students
    SET score = score + 5
    WHERE id = 5;

UPDATE students
    SET score = score + 5, grade = 1
    WHERE id = 6;

SELECT * FROM students WHERE id = 5;


