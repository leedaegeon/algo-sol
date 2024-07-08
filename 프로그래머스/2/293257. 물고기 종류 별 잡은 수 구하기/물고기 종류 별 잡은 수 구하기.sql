-- 코드를 작성해주세요
select count(i.id) as fish_count, n.fish_name as fish_name
from fish_info i join fish_name_info n
on i.fish_type = n.fish_type
group by i.fish_type, n.fish_name
order by 1 desc