with recursive hours as(
    select 0 as hour
    union all
    select hour + 1
    from hours
    where hour < 23
)
select h.hour, count(ao.animal_id) as count
from hours h left outer join animal_outs ao
on h.hour = hour(ao.datetime)
group by h.hour
order by h.hour asc