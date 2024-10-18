# -- 코드를 입력하세요
SELECT ri1.food_type, ri1.rest_id, ri1.rest_name, ri1.favorites
from rest_info ri1 natural join 
    (select ri2.rest_id, rank() over(partition by ri2.food_type order by favorites Desc) ranking from rest_info ri2) as joined   
where ranking = 1
order by food_type DESC