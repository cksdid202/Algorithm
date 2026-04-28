-- 코드를 입력하세요
SELECT dr_name, dr_id, MCDP_CD, hire_ymd from doctor where MCDP_CD in('CS', 'GS') order by hire_ymd desc, dr_name