-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM PATIENT P 
JOIN APPOINTMENT A ON P.PT_NO = A.PT_NO
JOIN DOCTOR D ON D.DR_ID = A.MDDR_ID
WHERE DATE_FORMAT(APNT_YMD, "%Y-%m-%d") = "2022-04-13"
    AND APNT_CNCL_YMD IS NULL
    AND D.MCDP_CD = "CS"
ORDER BY 6;