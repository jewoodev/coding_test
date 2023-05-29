-- 코드를 입력하세요
# WITH cte AS (
#     SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, RR.REVIEW_DATE, COUNT(RR.REVIEW_ID) arn
#     FROM MEMBER_PROFILE MP
#     JOIN REST_REVIEW RR ON MP.MEMBER_ID = RR.MEMBER_ID
#     GROUP BY MP.MEMBER_ID
#     ORDER BY arn desc
#     LIMIT 1
# )
# SELECT MEMBER_NAME, cte.REVIEW_TEXT, cte.REVIEW_DATE
# FROM cte
# ORDER BY REVIEW_DATE, REVIEW_TEXT;

# SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, RR.REVIEW_DATE, COUNT(RR.REVIEW_ID)
# FROM MEMBER_PROFILE MP
# JOIN REST_REVIEW RR
# GROUP BY MP.MEMBER_ID
# ORDER BY REVIEW_DATE, REVIEW_TEXT;

# SELECT *
# FROM MEMBER_PROFILE MP
# JOIN REST_REVIEW RR ON MP.MEMBER_ID = RR.MEMBER_ID
# ORDER BY MP.MEMBER_NAME;

# SELECT MP.MEMBER_NAME, RR.REVIEW_TEXT, RR.REVIEW_DATE, COUNT(RR.REVIEW_ID) arn
# FROM MEMBER_PROFILE MP
# JOIN REST_REVIEW RR ON MP.MEMBER_ID = RR.MEMBER_ID
# GROUP BY MP.MEMBER_ID
# ORDER BY arn desc;

-- ...
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d")
FROM MEMBER_PROFILE M
JOIN (
    SELECT REVIEW_TEXT, REVIEW_DATE, MEMBER_ID
    FROM REST_REVIEW
    WHERE MEMBER_ID = (
        SELECT MEMBER_ID
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
        ORDER BY COUNT(*) DESC
        LIMIT 1)
    ) R
ON R.MEMBER_ID = M.MEMBER_ID
ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT
;

# with sum_review as (
#     select 
#         member_id,
#         sum(review_score) as review_score
#     from rest_review
#     group by member_id, review_date
# ), reviewer_ids as (
#     select member_id
#     from sum_review
#     where review_score = (select max(review_score) from sum_review)
# )
# select
#     mem.member_name,
#     rv.review_text,
#     date_format(rv.review_date, '%Y-%m-%d')
# from member_profile mem
# inner join rest_review rv
# on mem.member_id = rv.member_id
# where mem.member_id in (select member_id from reviewer_ids)
# order by rv.review_date, rv.review_text;