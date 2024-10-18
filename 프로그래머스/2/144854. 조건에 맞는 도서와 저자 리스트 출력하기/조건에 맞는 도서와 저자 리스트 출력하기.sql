select b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d') PUBLISHED_DATE
from book b join author a on b.author_id = a.author_id
where category = '경제'
order by 3 ASC