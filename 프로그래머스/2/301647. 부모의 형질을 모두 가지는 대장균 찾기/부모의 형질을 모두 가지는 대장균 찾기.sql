-- 코드를 작성해주세요
select e.id, e.genotype, (select e2.genotype from ecoli_data e2 where e2.id = e.parent_id) as parent_genotype
from ecoli_data e
where e.parent_id is not null and (e.genotype & (select e2.genotype from ecoli_data e2 where e2.id = e.parent_id)) = (select e2.genotype from ecoli_data e2 where e2.id = e.parent_id)
order by 1 asc