-- 코드를 작성해주세요
select year(DIFFERENTIATION_DATE) as YEAR,
        (select max(E2.SIZE_OF_COLONY)
        from ECOLI_DATA as E2
        where year(E2.DIFFERENTIATION_DATE) = year(E1.DIFFERENTIATION_DATE)
        group by year(E2.DIFFERENTIATION_DATE)) - E1.SIZE_OF_COLONY as YEAR_DEV,
        ID
from ECOLI_DATA as E1
order by year(E1.DIFFERENTIATION_DATE) ASC, E1.SIZE_OF_COLONY DESC