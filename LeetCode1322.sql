# Write your MySQL query statement below
SELECT
    ad_id,
    CASE
        WHEN n_click=0 AND n_view=0 THEN 0.00
        ELSE ROUND(100*n_click / (n_click + n_view), 2)
    END AS ctr
FROM (
    SELECT DISTINCT
        ad_id,
        SUM( IF (action='Clicked', 1, 0) ) AS n_click,
        SUM( IF (action='Viewed', 1, 0) ) AS n_view,
        SUM( IF (action='Igored', 1, 0) ) AS n_ignore   
    FROM Ads
    GROUP BY ad_id
) AS t1
ORDER BY ctr DESC, ad_id 