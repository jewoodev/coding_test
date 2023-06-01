-- 코드를 입력하세요
SELECT DISTINCT FLAVOR
FROM (
    SELECT FT.T + JT.T as T, FT.FLAVOR 
    FROM (
        SELECT FLAVOR, SUM(TOTAL_ORDER) T
        FROM FIRST_HALF 
        GROUP BY FLAVOR) FT
    JOIN (
        SELECT FLAVOR, SUM(TOTAL_ORDER) T
        FROM JULY 
        GROUP BY FLAVOR) JT ON FT.FLAVOR = JT.FLAVOR
) TOTAL
ORDER BY T DESC
LIMIT 3;

# select flavor, t_o
# from (select fh.flavor as flavor, sum(fh.total_order) + sum(j.total_order) as t_o
#         from first_half as fh
#         inner join july as j
#         on fh.flavor = j.flavor
#         group by flavor
#         order by t_o desc
#      ) as temp
# limit 3;

# select *
# from first_half as fh
# inner join july as j
# on fh.flavor = j.flavor;