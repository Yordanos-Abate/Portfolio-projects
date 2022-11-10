/**
Question 1: list all the books by type and publisher_code whose type is SFI, HOR, and POE.
**/
select title, publisher_code, type
from book
where type IN ('SFI', 'HOR', 'POE');

/**
Question 2: list all book type once in alphabetical order
**/
select type
from book
group by type
order by 1;

/**
Question 3: list the average price for each group type
**/
select type , AVG(price) as 'AvgPrice' 
from book
group by type;

/**
Question 4: list the price of book in decending order where 
price is greater than or equal to $20 and less than or equal to $30
**/
select title, price
from book
where price >=20 and price <=30
order by price DESC;

/**
Question 5: list all the books whose price is more than $10 
and published by Basic Books
**/
select title, price
from book
where publisher_code = 'BA' and price >=10;

/**
Question 6: updating the cost of a book
**/
update book
set price = 7.95
where title = 'Of Mice and Men';

/**
Question 7: book written by Toni Morrison
**/
select distinct b.title
from wrote w inner join book b on w.book_code=b.book_code
inner join author a on w.AUTHOR_NUM=a.AUTHOR_NUM
where a.AUTHOR_FIRST= 'Toni' and a.AUTHOR_LAST= 'Morrison';

/**
Question 8: list book title with type FIC and published by Penguin USA
**/
SELECT distinct b.title
from publisher p inner join book b on p.PUBLISHER_CODE=b.PUBLISHER_CODE
where type= 'FIC' and PUBLISHER_NAME= 'Penguin USA';

/**
Question 9: show the inventory in all braches based on title, 
price, book code, and how many books are on hand in each branch
**/
SELECT b.book_code, b.title, b.price, i.on_hand, i.branch_num
from book b inner join inventory i on b.BOOK_CODE=i.BOOK_CODE;

/**
Question 10: show all the authors who have written books 
**/
SELECT a.author_last, a.author_first, b.book_code
from wrote w inner join author a on w. AUTHOR_NUM= a.AUTHOR_NUM
inner join book b on w.BOOK_CODE= b.BOOK_CODE
group by a.AUTHOR_LAST
order by 1;

/**
Question EC1: show the least expensive book
**/
select title, 
min(price)
from book;



