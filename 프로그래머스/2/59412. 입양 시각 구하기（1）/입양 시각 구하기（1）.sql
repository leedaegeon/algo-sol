-- 코드를 입력하세요
SELECT DATE_FORMAT(datetime, "%H") hour, count(DATE_FORMAT(datetime, "%H")) count
from ANIMAL_OUTS
where date_format(datetime, "%H:%i") between "09:00" and "19:59"
group by DATE_FORMAT(datetime, "%H")
order by DATE_FORMAT(datetime, "%H") ASC