-- Homework 1
-- Question 0.1
-- I want to see the count of the number of products in each product line

-- question 0.2
-- I want to see a list of employees and all of the customers for that employee.   Employee name will be duplicated in the result set.   I want to see the employee first and last name
-- and the customer contact first and last name as well as the customer name

-- question 0.3
-- I want to see a list of employees in each office.   Show the office name and the employee name

-- question 0.4
-- I want to see the totaly number of each employee type based on job title.. result should the job title and the number of employess with that job title.

-- question 0.5
-- I want to see a list of all payments each customer has made.  Order the list by custoemr name ascending, then by the payment amount descending

-- question 0.6
-- I want to see a list of products that have never been sold.   use ... not in ( select product_id from order_details ) in your where clause
select * from products where id not in ( select product_id from orderdetails ); 

-- question 0.7
-- are there any customers that have never made an order

-- Question 1
-- How many customer are handled by each office.  I want to see the office name and the count of the number of customers in that office.

-- Question 2
-- I want to see the products with the most margin at the top of the table.  Include the product name, buy price, msrp, and margin in the results.  Margin is calculated (MSPR - buy_price) 

-- Question 2.5
-- I want to see the top 5 customers in each state based on margin 

-- Question 3
--  I want to see the top 5 salesmen in the company based on the total amount sold

-- Question 4
-- I want to see the top 5 salesmen based on overall profit (margin)

-- Question 5 
-- I want to see all of the orders that happened in 2004.   You can use a function called year(order_date) = 2004

-- Question 6
-- I want to see the total amount of all orders grouped by the year

-- Question 7
-- I want to see the top 5 products based on quantity sold across all orders

-- question 7.5
-- how many times has each product appeared in an order reguardless of how many were purchased.

-- question 7.6
-- how many products would be out of stock baed on the amount sold acrosss tiem.  -- not sure if the data will spoort this .. basically 
-- looking for any product where the sum of the quantity sold is greater than the quantity in stock

-- question 7.9
-- I want to see the distinct order status ordered alphabetically

-- Question 8
-- I want to see the office name and the distinct product lines that have been sold in that office.  This will require joining almost all of the tables.  
select distinct o.name as office_name, pl.productlines as product_line_name  ....





