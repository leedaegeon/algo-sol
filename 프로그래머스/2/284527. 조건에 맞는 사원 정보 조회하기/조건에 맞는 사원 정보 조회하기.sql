select sum(g.score) as score, em.emp_no, em.emp_name,  em.position, em.email
from HR_EMPLOYEES em join HR_GRADE g
on em.emp_no = g.emp_no
group by em.emp_no
having sum(g.score) = (select sum(g2.score) 
                       from HR_GRADE g2
                      group by g2.emp_no
                      order by 1 desc
                      limit 1)
