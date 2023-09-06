-- 코드를 입력하세요
-- 코드를 입력하세요
SELECT
    CAR_ID,
    CAR_TYPE,
    FEE
 FROM(
    SELECT
        CAR_ID,
        CAR_TYPE,
        TRUNCATE(((daily_fee * 30) * (1 - (DISCOUNT_RATE / 100))),0)  FEE
    FROM (
    SELECT
        a.*,
        (SELECT DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
         WHERE c.CAR_TYPE = a.CAR_TYPE
         and DURATION_TYPE like '30일%'
        ) DISCOUNT_RATE
      FROM CAR_RENTAL_COMPANY_CAR a
      LEFT JOIN (
           SELECT
               CAR_ID
             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
             WHERE DATE_FORMAT(end_date,'%Y-%m-%d') >='2022-11-01'
      )b on a.car_id = b.car_id
      WHERE CAR_TYPE IN ('SUV','세단')
      and b.CAR_ID is null
    )T
)TT
WHERE FEE >= 500000 and FEE < 2000000