-- 코드를 작성해주세요
# 부모 ID랑 and 했을 때 
select e1.id
    , e1.genotype
    , (select e2.genotype
       from ECOLI_DATA e2
        where e1.parent_id = e2.id) as parent_genotype
from ECOLI_DATA e1
where PARENT_ID is not null 
        and e1.GENOTYPE & (select e2.genotype
                           from ECOLI_DATA e2
                            where e1.parent_id = e2.id) = (select e2.genotype
                                                           from ECOLI_DATA e2
                                                            where e1.parent_id = e2.id)
order by e1.id ASC