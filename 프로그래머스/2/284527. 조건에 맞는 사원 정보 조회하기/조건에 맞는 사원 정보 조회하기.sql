-- 코드를 작성해주세요

# select sum(g.score) as score, e.emp_no, e.emp_name, e.position, e.email
# from HR_EMPLOYEES e
# join HR_GRADE g
# on e.emp_no = g.emp_no
# where sum(g.score) = (select sum(score) 
#                     from HR_GRADE 
#                     group by EMP_no 
#                     order by sum(score) DESC
#                     limit 1)
# group by g.emp_no

select sum(g.score) as score, e.emp_no, e.emp_name, e.position, e.email
from HR_EMPLOYEES e
right join HR_GRADE g
on e.emp_no = g.emp_no
group by g.emp_no
order by score DESC
limit 1