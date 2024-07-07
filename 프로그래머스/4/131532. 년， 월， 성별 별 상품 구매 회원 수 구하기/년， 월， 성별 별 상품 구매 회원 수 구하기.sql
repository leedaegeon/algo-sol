-- 코드를 입력하세요
SELECT year(sales_date) as YEAR, month(sales_date) as MONTH, gender as GENDER, count(distinct o.user_id) as USERS
from online_sale o join user_info u
on o.user_id = u.user_id
where u.gender is not null
group by year(sales_date), month(sales_date), gender
order by year(sales_date) asc, month(sales_date) asc, gender asc

# select *
# from online_sale o join user_info u
# on o.user_id = u.user_id
# order by o.sales_date asc