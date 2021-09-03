# Write your MySQL query statement below
WITH STORE1 AS (
    SELECT
        product_id,
        'store1' AS store,
        store1 AS price
    FROM Products
    WHERE store1 IS NOT NULL
),

STORE2 AS (
    SELECT
        product_id,
        'store2' AS store,
        store2 AS price
    FROM Products
    WHERE store2 IS NOT NULL
),

STORE3 AS (
    SELECT
        product_id,
        'store3' AS store,
        store3 AS price
    FROM Products
    WHERE store3 IS NOT NULL    
)

SELECT *
FROM STORE1
UNION (SELECT * FROM STORE2)
UNION (SELECT * FROM STORE3)