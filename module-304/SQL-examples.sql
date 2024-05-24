select * from employees where firstname = 'Diane';

select * from employees where job_title = 'Sales Rep' order by firstname desc;

select * from offices where country = 'USA';

select distinct country from offices;
select distinct firstname from employees order by firstname;

select count(*) as 'count' 
from offices o
where o.country = 'USA';

-- I want to see all employees that work in an office in the USA
select * from employees;
select * from offices;
select e.*, o.city
from employees e, offices o
where e.office_id = o.id
	and o.country = 'USA';
    
    
    
    