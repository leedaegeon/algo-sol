select hour(datetime) as hour, count(*) as count
from animal_outs
group by hour(datetime)
having hour >= 9 and hour < 20
order by 1 ASC