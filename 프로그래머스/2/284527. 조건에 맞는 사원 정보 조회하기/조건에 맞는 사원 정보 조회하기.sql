select (select sum(g.score)
                from hr_grade g 
                where g.year = 2022 
                group by g.emp_no
                order by sum(g.score) DESC
                limit 1) as score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e
where e.emp_no = (select g.emp_no
                from hr_grade g 
                where g.year = 2022 
                group by g.emp_no
                order by sum(g.score) DESC
                limit 1)
        
