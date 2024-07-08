-- 코드를 작성해주세요
select case
        when month(DIFFERENTIATION_DATE) <= 3 then "1Q"
        when month(DIFFERENTIATION_DATE) <= 6 then "2Q"
        when month(DIFFERENTIATION_DATE) <= 9 then "3Q"
        when month(DIFFERENTIATION_DATE) <= 12 then "4Q"
        end as quarter,
        count(id) as ECOLI_COUNT
from ecoli_data
group by 1
order by 1