-- 코드를 입력하세요
SELECT f.FLAVOR
from first_half f
join icecream_info i on f.flavor = i.flavor
where i.ingredient_type ="fruit_based" and f.total_order > 3000
order by f.total_order desc