select MCDP_CD as "진료과코드", count(*) as "5월예약건수"
from appointment
where APNT_YMD like "%2022-05%"
group by MCDP_CD
order by 2 ASC, 1 ASC