select * from employees where firstname = 'Diane';

select * from employees where job_title = 'Sales Rep' order by firstname desc;

select * from offices order by city asc, country desc;

select * from employees order by firstname asc, lastname desc;

select * from customers;

select distinct country from customers order by country asc;
select country, count(*) from customers group by country order by country asc;

-- these 2 statemenst are the same
select * from customers where country IN ( 'USA', 'Australia', 'France' );
select * from customers where country = 'USA' or country = 'Austrailia' or country = 'France';

-- null does not work with =
select * from customers where address_line2 = null;
select * from customers where address_line2 is not null;

select country, count(*) as country_cnt, max(credit_limit) as max_credit_limit, min(credit_limit) as min_credit_limit, avg(credit_limit) as avg_credit_limit 
from customers 
group by country
having max(credit_limit) > 50000
order by max_credit_limit desc
limit 5;

select lower(customer_name), upper(customer_name) from customers;

select current_date();
select month(current_date());
select year(current_date()) = 2024;

				-- 'YYYY-MM-DD'	
SELECT DATE_FORMAT('2014-02-01', '%Y-%m-%e');

SELECT IF(200<200, 'yes', 'no') as ifstatement;




select *, (select max(credit_limit) from customers where country = 'USA' ) as max_usa
from customers
where phone like '%21%';

select * from customers
where credit_limit between 50000 and 60000;
where crecit_limit >= 50000 and credit_limit <= 600000;













select contact_firstname, count(*) from customers group by contact_firstname order by 2 desc, 1 asc;
select * from customers where contact_firstname = 'First Name';

select * from offices where country = 'USA';

select * from customers where id = 145;

SELECT UUID() AS UUID_Value;


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
    
    
-- lets just start looking at what is in the various tables
select * from orders;    
select * from orderdetails;

-- caclualte the total price for each line item in the order 10103
select od.*, (quantity_ordered * price_each) as total_price
from orderdetails od 
where order_id = 10103 
order by order_line_number;    

-- now add the product name to this query result
select od.*, (quantity_ordered * price_each) as total_price, p.product_name
from orderdetails od, products p
where order_id = 10103 
	and p.id = od.product_id
order by order_line_number;    

-- now lets add the date of the order
select * from orderdetails;
select * from orders where id = 10103;  -- this only retuns a single record
-- however when we join against the order table the order date is duplicated because each line tiem in the order details was
-- essentially orderd on the same day
select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date
from orderdetails od, products p, orders o
where order_id = 10103 
	and p.id = od.product_id
    and o.id = od.order_id
order by order_line_number;    

-- now lets add the customer name to this report
select od.*, (quantity_ordered * price_each) as total_price, p.product_name, o.order_date, c.customer_name
from orderdetails od, products p, orders o, customers c
where order_id = 10103 
	and p.id = od.product_id
    and o.id = od.order_id
    and o.customer_id = c.id
order by order_line_number;    

-- so this is a new question --
-- I want to see the sum of the total cost for all line items for order 10103
-- the sum() function is called an aggregate function
select sum(quantity_ordered * price_each) as total_order_cost,
	max(quantity_ordered) as max_quantity_ordered,
    min(quantity_ordered) as min_quantity_ordered,
    avg(quantity_ordered * price_each) as avergage_line_item_cost,
    avg(quantity_ordered) as avg_quantity_ordered
from orderdetails od
where order_id = 10103;

select od.*, (quantity_ordered * price_each) as total_price
from orderdetails od
where order_id = 10103;

-- I want to see the total cost of each order of each order for all orders
select * from orderdetails;

select order_id, sum(quantity_ordered * price_each) as total_order_cost,
		min(quantity_ordered) as min_qty_ordered,
		count(*) as number_of_products
	from orderdetails
	group by order_id;
    
-- ############ I want to see the total amount each customer has spent ############
-- step 1 was to join the customer table and the order table
-- we also limited our colums in the result set so the data was a bit more consumable by a human brain
-- put an order by on this so we could see all of the customer order together
select c.customer_name, o.id as order_id
from customers c, orders o
where c.id = o.customer_id
order by customer_name;

-- step 2 we need to continue joining over to the order details table
-- we added a second column to the order by so we could see the products in each order by the order ide
select c.customer_name, o.id as order_id, od.product_id
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
order by customer_name, order_id;

-- step 3 to join to the orderdetails table and we added the line item cost calculation
-- its at this step now that we can visualize the data in the database and begin to think about how we can do a group by
select c.id, c.customer_name, o.id as order_id, od.product_id, quantity_ordered, price_each, (quantity_ordered * price_each) as line_item_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
order by customer_name, order_id;

-- step 4 is add the group by 
-- we removed the extra columns that were not in group by from the select
-- we also removed the extra columns from the order by
-- because we are grouping but the custoemr id we can also get the customer name because the customer record is singular and grouped by
select c.id, c.customer_name, sum(quantity_ordered * price_each) as total_customer_spend
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id
order by total_customer_spend desc;

-- to expand the original question to see the sum of each order for each customer
-- we have now added an order by for the order id so we can see the total cost for each order for all customers
-- we can now include the order id in the select columns because it is in the group by
select c.id, c.customer_name, o.id as order_id, sum(quantity_ordered * price_each) as total_order_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id, o.id
order by c.customer_name;

-- now lets make this one more step complex.   I only want to see the orders that over 50k
-- by adding having it allows us to filter the aggregate results and we can not do this in the where clause because the
-- aggregate result has not yet been calculated at the time the database is conidering the where clause
select c.id, c.customer_name, o.id as order_id, sum(quantity_ordered * price_each) as total_order_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
	and o.id = od.order_id
group by c.id, o.id
having total_order_cost > 50000
order by c.customer_name;

