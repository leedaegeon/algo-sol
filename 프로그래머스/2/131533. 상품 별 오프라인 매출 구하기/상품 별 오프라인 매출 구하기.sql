select p.product_code, sum(sales_amount)*p.price
from product p join offline_sale o on p.product_id = o.product_id
group by p.product_code
order by 2 DESC, 1 ASC