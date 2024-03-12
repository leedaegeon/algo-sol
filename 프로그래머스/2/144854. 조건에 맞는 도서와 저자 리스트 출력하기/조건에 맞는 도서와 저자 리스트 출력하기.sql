-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, date_format(b.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK b
join AUTHOR a
on b.author_id = a.author_id
where b.category = '경제'
order by b.PUBLISHED_DATE ASC