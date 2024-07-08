-- 코드를 입력하세요
SELECT hour(ao.datetime) as hour, count(*) as count
from animal_outs ao
where hour(ao.datetime) >= 9 and hour(ao.datetime) <= 19
group by hour(ao.datetime)
order by hour(ao.datetime)