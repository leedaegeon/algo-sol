-- 코드를 입력하세요
SELECT user_id, product_id
from online_sale
group by user_id, product_id
having count(online_sale_id) >= 2
order by 1 asc, 2 desc

# select *
# from online_sale
# where user_id = 15
# order by user_id, product_id
