select truncate(price/10000,0)*10000 as price_group, count(*) products
from product
group by truncate(price/10000,0)
order by 1 ASC