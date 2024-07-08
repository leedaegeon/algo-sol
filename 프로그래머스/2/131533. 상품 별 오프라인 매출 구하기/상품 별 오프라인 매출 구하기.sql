-- 코드를 입력하세요
SELECT p.product_code, sum(o.sales_amount)*p.price
from offline_sale o join product p
on o.product_id = p.product_id
group by p.product_code
order by 2 DESC, 1 ASC
# select sum(o.sales_amount)*price
# from offline_sale o join product p
# where o.product_id = p.product_id and p.product_code = "B1000000"
