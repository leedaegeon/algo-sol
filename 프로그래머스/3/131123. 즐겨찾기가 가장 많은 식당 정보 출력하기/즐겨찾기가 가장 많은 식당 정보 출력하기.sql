with ranked_rest as(
    select 
        i.rest_id,
        i.food_type,
        i.rest_name,
        i.favorites,
        rank() over(partition by i.food_type order by i.favorites DESC) as ranking
    from rest_info i
)

# -- 코드를 입력하세요
SELECT ri1.food_type, ri1.rest_id, ri1.rest_name, ri1.favorites
from ranked_rest ri1
where ri1.ranking = 1
order by ri1.food_type DESC