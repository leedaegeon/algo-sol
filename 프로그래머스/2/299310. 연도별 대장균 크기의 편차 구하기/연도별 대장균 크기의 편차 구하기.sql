-- 코드를 작성해주세요
select year(e.DIFFERENTIATION_DATE) year,
        (select max(SIZE_OF_COLONY)
        from ECOLI_DATA e2
         where year(e2.DIFFERENTIATION_DATE) = year(e.DIFFERENTIATION_DATE)
        group by year(e2.DIFFERENTIATION_DATE))- e.size_of_colony as year_dev,
        e.id
from ECOLI_DATA e
order by 1 ASC, 2 asc