select car_id, round(avg(datediff(END_DATE, START_DATE) + 1), 1)
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as c
group by car_id
having avg(datediff(END_DATE, START_DATE) + 1) >= 7
order by 2 DESC, 1 DESC