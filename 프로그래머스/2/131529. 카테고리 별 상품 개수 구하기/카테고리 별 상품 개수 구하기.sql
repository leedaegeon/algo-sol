select substring(product_code, 1, 2) as category, count(substring(product_code, 1, 2)) as products
from product
group by category
order by 1 ASC