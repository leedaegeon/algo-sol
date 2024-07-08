-- 코드를 작성해주세요
select dev.id, dev.email, dev.first_name, dev.last_name
from developers dev 
# join skillcodes skill
# on dev.skill_code = skill.code
where dev.skill_code & (select sum(sk.code)
                        from skillcodes sk
                        where sk.name = "Python" or sk.name = "C#"
                        group by sk.category) != 0
order by 1 asc

# select sum(sk.code) & 400, sum(sk.code) & 2048, sum(sk.code) & 1024, sum(sk.code) & 16384, sum(sk.code) & 8452
# from skillcodes sk
# where sk.name = "Python" or sk.name = "C#"
# group by sk.category