select d.id, d.email, d.first_name, d.last_name
from developers d
where d.skill_code & (select sum(s.code) from skillcodes s where name in('python', 'c#')) != 0
order by 1 ASC
