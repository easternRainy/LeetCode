# Write your MySQL query statement below

WITH scoreMinMax AS (
    SELECT DISTINCT
        exam_id,
        MIN(score) OVER (PARTITION BY exam_id) AS min_score,
        MAX(score) OVER (PARTITION BY exam_id) AS max_score
    FROM Exam
),

studentMinMax AS (
    SELECT DISTINCT
        exam_id,
        FIRST_VALUE(student_id) OVER (PARTITION BY exam_id ORDER BY score ASC) AS min_student,
        FIRST_VALUE(student_id) OVER (PARTITION BY exam_id ORDER BY score DESC) AS max_student
    FROM Exam
),

full_exam AS (
    SELECT Exam.exam_id, student_id, score, min_score, max_score
    FROM Exam
    LEFT JOIN scoreMinMax
    ON Exam.exam_id = scoreMinMax.exam_id
),

not_quiet AS (
    SELECT * 
    FROM full_exam
    WHERE 
        score = min_score OR
        score = max_score
)

# SELECT * FROM not_quiet

SELECT *
FROM Student
WHERE 
    student_id IN (
        SELECT student_id FROM Exam
    ) AND
    student_id NOT IN (
        SELECT student_id FROM not_quiet
    ) 
    
;