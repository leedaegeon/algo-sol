-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME

from DEVELOPERS
where skill_code & (select code from skillcodes where Name ='python') = (select code from skillcodes where Name ='python')
    or skill_code & (select code from skillcodes where Name ='c#') = (select code from skillcodes where Name ='c#')

order by id ASC