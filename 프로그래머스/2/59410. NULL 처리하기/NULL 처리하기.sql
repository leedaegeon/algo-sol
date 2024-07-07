-- 코드를 입력하세요
SELECT ai.animal_type, 
    case
        when ai.name is null then "No name"
        else ai.name
        end as Name
    , ai.SEX_UPON_INTAKE
from animal_ins ai
order by ai.animal_id ASC