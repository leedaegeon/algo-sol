-- 코드를 입력하세요
SELECT SUBSTRING( product_code, 1, 2) as CATEGORY, count(SUBSTRING( product_code, 1, 2)) as product
from PRODUCT
group by CATEGORY
order by CATEGORY ASC