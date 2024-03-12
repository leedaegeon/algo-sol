-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, Date_format(DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH
# , date_format(DATE_OF_BIRTH, "%m") 
from MEMBER_PROFILE
where TLNO is not null and month(DATE_OF_BIRTH) = "3" and gender = "W"
order by MEMBER_ID ASC