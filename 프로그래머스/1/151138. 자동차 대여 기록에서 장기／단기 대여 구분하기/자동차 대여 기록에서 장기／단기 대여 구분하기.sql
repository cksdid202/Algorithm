-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, START_DATE, END_DATE, 
if(DATEDIFF(END_DATE, START_DATE) + 1 >= 30, "장기 대여", "단기 대여") AS RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where YEAR(start_date) = 2022 and MONTH(start_date) = 09 
order by HISTORY_ID desc;