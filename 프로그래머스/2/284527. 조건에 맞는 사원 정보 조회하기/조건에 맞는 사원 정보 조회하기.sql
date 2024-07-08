-- 코드를 작성해주세요
select (select sum(g2.score)
        from hr_grade g2
        group by g2.emp_no
        order by sum(g2.score) desc
        limit 1
        ) as SCORE,
        em.emp_no, em.emp_name, em.position, em.email
from hr_employees em
where em.emp_no = (select g2.emp_no
                    from hr_grade g2
                    group by g2.emp_no
                     having sum(g2.score)
                    order by sum(g2.score) desc
                    limit 1)

