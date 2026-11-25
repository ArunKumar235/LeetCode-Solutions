-- Write your PostgreSQL query statement below
WITH 
r1 AS (    
    SELECT DISTINCT requester_id AS id, COUNT(*) AS num 
    FROM requestaccepted r1
    GROUP BY requester_id
),
r2 AS (
    SELECT DISTINCT accepter_id AS id, COUNT(*) AS num 
    FROM requestaccepted r1
    GROUP BY accepter_id
)

SELECT COALESCE(r1.id, r2.id) AS id, (COALESCE(r1.num, 0) + COALESCE(r2.num, 0)) AS  num
FROM r1 
FULL JOIN r2
ON r1.id = r2.id
ORDER BY num DESC
LIMIT 1
