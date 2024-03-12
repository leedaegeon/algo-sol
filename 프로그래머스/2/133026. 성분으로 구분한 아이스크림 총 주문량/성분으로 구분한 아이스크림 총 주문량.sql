-- 코드를 입력하세요
SELECT i.ingredient_type, sum(f.total_order) as TOTAL_ORDER
from FIRST_HALF f
    join ICECREAM_INFO i 
    on f.flavor = i.flavor
group by i.ingredient_type
order by f.total_order ASC