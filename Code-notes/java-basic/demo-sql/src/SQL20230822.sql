-- 22 Aug
use sys;
show tables;
CREATE TABLE TEACHER (
  ID INTEGER NOT NULL, -- AUTO_INCREMENT
  NAME VARCHAR(20) NOT NULL, 
  AGE NUMERIC(3) NOT NULL, -- NUMERIC(3) means INTEGER
  NATIONALITY VARCHAR(2) NOT NULL, -- HK, CN, US, UK
  MEMBERSHIP VARCHAR(1) NOT NULL -- S, G
);
-- Select Data from Table, * means all columns
select * from TEACHER;
select id, name, age from TEACHER;
-- Insert records
-- All column alias
insert into teacher (id, name, age, nationality, membership) 
	values (1, 'John Lau', 23, 'HK', 'G');
insert into teacher values (2, 'Mary Lau', 27, 'CN', 'G');
-- 
CREATE TABLE STAFF (
  ID INTEGER NOT NULL, -- NUMERIC(4) equals NUMERIC(4,0)
  NAME VARCHAR(20) NOT NULL, 
  SALARY NUMERIC(10,2) -- Nullable, 8 digits goes to Integer, 2 belongs to decimal
);
-- All column alias
Delete from staff;
insert into staff (id, name, salary)
	values (1, 'John Lau', 10010000.23);
insert into staff (name, id, salary)
	values ('Eric Cheung', 4, 10010000.23);
insert into staff values (2, 'Mary Lau', null);
insert into staff (id, name) values (3, 'Peter Chu');
insert into staff (id, name, salary) values (5, 'John Lau', 20000.00);
-- Update 
update staff set salary = salary + 1000;
-- select data by criteria
select * from staff where id = 1;
select * from staff where name = 'John Lau' and salary < 50000;
select id from staff where name = 'John Lau' and salary < 50000;
select * from staff where name = 'John Lau' or name = 'Mary Lau';
select * from staff where name in ('John Lau', 'Mary Lau'); -- OR
select id, name as fullname, salary from staff;
-- Update by criteria
update staff set salary = salary + 1000 where id = 4;
update staff set salary = salary + 10, name = 'Mary Chan' where name = 'Mary Lau';
-- Delete by criteria
delete from staff where id = 5;
delete from staff where id in (1, 2);
-- Order by (sorting)
insert into staff values (10, 'ABC', 100000);
insert into staff values (11, 'DEF', 34567);
insert into staff values (12, 'IJK', 2000);
select * from staff order by salary; -- default ascending order
select * from staff order by salary asc; -- same as the above
select * from staff order by salary desc; -- descending order
insert into staff values (13, 'BCD', 100000);
select * from staff order by salary asc, name desc; -- sort salary asc first, then name desc

-- Sub-query
select max(salary) from staff;
select id from staff where salary = (select max(salary) from staff);
select id from staff where salary = (select min(salary) from staff);

-- Function
select avg(salary) as AVERAGE_SALARY from staff;
select upper(name) as UPPER_CASE_NAME from staff;
select lower(name) as LOWER_CASE_NAME from staff;
insert into staff values (13, 'PETER CHU', 22000);
insert into staff values (14, 'peter chu', 21000);
select * from staff where upper(name) = 'PETER CHU';

-- Like (case-insensitive in MySQL, case-sensitive in Oracle)
select * from staff where upper(name) like '% CHU'; -- % means any character
select * from staff where upper(name) like '%TER%'; -- % means any character
select * from staff where upper(name) like '%TER%' OR name = 'BCD';

-- count()
select * from staff;
select 1 from staff;
select count(*) from staff; -- 8
select count(1) from staff; -- 8

-- group by
select upper(name) as NAME, 
sum(salary) as TOTAL_SALARY,  -- "salary" column is not allowed
avg(salary) as AVG_SALARY,
max(salary) as max_salary,
min(salary) as min_salary
from staff
group by upper(name);

-- String Operations
select *  from staff where instr(name, 'chu') > 0; -- case-insensitive
select *  from staff where length(name) > 10;
select substring(name, 1, 3)  from staff;
select length(trim(' testing something ')) from dual;
select ltrim(' testing something ') from dual;
select concat(rtrim(' testing something '), ' ABC') from dual; -- dual = 1 x 1 table
select replace('I love Java', 'Java', 'Python') from dual;
