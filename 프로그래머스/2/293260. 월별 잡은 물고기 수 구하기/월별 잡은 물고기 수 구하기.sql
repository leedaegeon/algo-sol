-- 코드를 작성해주세요
select count(id) as fish_count, month(time) month
from FISH_INFO
group by month(time)
order by month(time) asc