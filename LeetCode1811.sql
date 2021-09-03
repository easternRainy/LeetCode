# Write your MySQL query statement below
# Reference: 
# https://leetcode.com/problems/find-interview-candidates/discuss/1434048/MySQL-solution-with-window-function-easy-to-understand
WITH any_medal AS (
    SELECT contest_id, gold_medal AS medal
    FROM Contests
    UNION (
        SELECT contest_id, silver_medal AS medal
        FROM Contests
    )
    Union (
        SELECT contest_id, bronze_medal AS medal
        FROM Contests
    )
    ORDER BY contest_id, medal
),

consecutive AS (
    SELECT
        medal
    FROM (
        SELECT 
            contest_id, 
            medal,
            ROW_NUMBER() OVER(PARTITION BY medal ORDER BY contest_id) AS row_n,
            contest_id - ROW_NUMBER() OVER(PARTITION BY medal ORDER BY contest_id) AS divider
        FROM any_medal
    ) AS tmp
   GROUP BY medal, divider
   HAVING COUNT(*) >= 3
),


gold AS (
    SELECT gold_medal, COUNT(contest_id) AS count_gold
    FROM Contests
    GROUP BY gold_medal
    HAVING count_gold >= 3
)

SELECT name, mail
FROM Users
WHERE user_id IN (
    SELECT medal FROM consecutive
) OR user_id IN (
    SELECT gold_medal FROM gold
)





