-- 코드를 입력하세요
SELECT p.PRODUCT_CODE as PRODUCT_CODE, sum(p.price*o.sales_amount) as sales
from product p 
join OFFLINE_SALE o
on p.product_id = o.product_id
group by p.PRODUCT_CODE
order by sales DESC, p.PRODUCT_CODE ASC