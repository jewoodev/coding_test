-- 코드를 입력하세요
WITH RECURSIVE time AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 
    FROM time 
    WHERE hour < 23
), animal AS (
    SELECT HOUR(datetime) AS hour
         , COUNT(*) AS count
    FROM animal_outs AS a 
    GROUP BY hour
    ORDER BY hour
)

SELECT time.hour
     , CASE WHEN animal.count IS NULL THEN 0 ELSE animal.count END AS count
FROM time
    LEFT JOIN animal ON time.hour = animal.hour
GROUP BY time.hour
ORDER BY time.hour