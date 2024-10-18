select user_id, product_id
# select user_id, count(*)
from online_sale
group by product_id, user_id
having count(*) >= 2
order by user_id ASC, product_id desc