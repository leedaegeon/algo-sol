select animal_type as ANIMAL_TYPE, count(animal_type) as count
from animal_ins
group by animal_type
order by animal_type ASC