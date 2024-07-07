-- 코드를 입력하세요
SELECT floor(p.price/10000)*10000 as price_group, count(p.product_id) as products
from product p
group by floor(p.price/10000)
order by 1 asc

# select * 
# from product p