select
	last_name,
	first_name,
	points,
    points/10 as 'discount factor'
from customers;


select state
from customers;


select distinct state
from customers;


select
	name,
    unit_price,
    unit_price*1.1 as new_price
from products;


select * from customers
where points >= 3000;


select * from customers
where state != 'VA';


select * from customers
where birth_date > '1990-01-01';


select * from orders
where order_date >= '2019-01-01';


select * from customers
where birth_date > '1990-01-01' or
(points > 1000 and state = 'VA');


select * from customers
where not (birth_date > '1990-01-01' or
(points > 1000 and state = 'VA'));
        -- OR --
select * from customers
where (birth_date <= '1990-01-01' and
(points <= 1000 or state != 'VA'));


select * from order_items
where order_id = 6 and (unit_price * quantity) > 30;


select * from customers
where state = 'VA' or state = 'FL' or state = 'GA';
                -- OR --
select * from customers
where state in ('VA', 'FL', 'GA');


select * from customers
where points >= 1000 and points <= 3000;
            -- OR --
select * from customers
where points between 1000 and 3000;


select * from customers
where birth_date between '1990-01-01' and '2000-01-01';


select * from customers
where last_name like 'b%';


select * from customers
where last_name like '%b%';


select * from customers
where last_name like '_____y';


select * from customers
where last_name like 'b____y';


select * from customers
where address like '%trail%'
   or address like '%avenue%';


select * from customers
where phone like '%9';


select * from customers
where last_name like '%field%';
        -- OR --
select * from customers
where last_name regexp 'field';


select * from customers
where last_name regexp 'field$|mac|rose';


select * from customers
where last_name regexp '[gim]e';


select * from customers
where last_name regexp 'e[a-m]';


select * from customers
where first_name in ('elka', 'ambur');
        -- OR --
select * from customers
where first_name regexp 'elka|ambur';


select * from customers
where last_name regexp 'ey$|on$';


select * from customers
where last_name regexp '^my|se';


select * from customers
where last_name regexp 'b[ru]';


select * from customers
where phone is not null;


select * from orders
where shipped_date is null;


select * from customers
order by first_name desc;


select * from customers
order by state, first_name;


select * from customers
order by state desc, first_name;


select first_name, last_name, 10 as points
from customers
order by points, first_name;


select * from order_items
where order_id = 2
order by (quantity * unit_price) desc;


select *, (quantity * unit_price) as total_price
from order_items
where order_id = 2
order by total_price desc;


select * from customers
limit 5;


select * from customers
limit 6, 3;


select * from customers
order by points desc
limit 3;



-- INNER JOIN / JOIN --
select order_id, first_name, last_name
from orders
join customers
	on orders.customer_id = customers.customer_id;



select order_id, orders.customer_id, first_name, last_name
from orders
join customers
	on orders.customer_id = customers.customer_id;


select order_id, o.customer_id, first_name, last_name
from orders o
join customers c
	on o.customer_id = c.customer_id;


select order_id, oi.product_id, name, quantity, oi.unit_price
from order_items oi
join products p
	on oi.product_id = p.product_id;


use sql_store;
select *
from order_items oi
join sql_inventory.products p
	on oi.product_id = p.product_id;


use sql_inventory;
select *
from sql_store.order_items oi
join products p
	on oi.product_id = p.product_id;



-- SELF JOIN --
use sql_hr;
select *
from employees e
join employees m
	on e.reports_to = m.employee_id;


use sql_hr;
select
	e.employee_id,
    e.first_name,
    m.first_name as manager
from employees e
join employees m
	on e.reports_to = m.employee_id;



-- MULTIPLE JOINS --
use sql_store;
select
    o.order_id,
    o.order_date,
    c.first_name,
    c.last_name,
    os.name as STATUS
from orders o
join customers c
	on o.customer_id = c.customer_id
join order_statuses os
	on o.status = os.order_status_id;


use sql_invoicing;
select
    p.date,
    p.invoice_id,
    p.amount,
    c.name,
    pm.name as 'Pay Via'
from payments p
join clients c
	on p.client_id = c.client_id
join payment_methods pm
	on p.payment_method = pm.payment_method_id;



-- COMPOUND JOIN --
use sql_store;
select *
from order_items oi
join order_item_notes oin
	on oi.order_id = oin.order_id
    and oi.product_id = oin.product_id;



-- IMPLICIT JOIN --
use sql_store;
-- select *
-- from orders o
-- join customers c
-- 	on o.customer_id = c.customer_id;
select *
from orders o, customers c
where o.customer_id = c.customer_id;


        -- OUTER JOIN --
use sql_store;
select
	c.customer_id,
	c.first_name,
	o.order_id
from customers c
left join orders o
	on c.customer_id = o.customer_id
group by c.customer_id;
		-- OR --
select
	c.customer_id,
	c.first_name,
	o.order_id
from orders o
right join customers c
	on c.customer_id = o.customer_id
group by c.customer_id;


use sql_store;
select
	p.product_id,
	p.name,
	oi.quantity
from products p
left join order_items oi
	on oi.product_id = p.product_id


use sql_store;
select
	c.customer_id,
	c.first_name,
	o.order_id
from customers c
left join orders o
	on c.customer_id = o.customer_id
join shippers sh
	on o.shipper_id = sh.shipper_id
order by c.customer_id;


use sql_store;
select
	c.customer_id,
	c.first_name,
	o.order_id,
        sh.name as shipper
from customers c
left join orders o
	on c.customer_id = o.customer_id
left join shippers sh
	on o.shipper_id = sh.shipper_id
order by c.customer_id


use sql_store;
select
	o.order_id,
	o.order_date,
	c.first_name,
    sh.name as shipper,
    os.name as status
from orders o
join customers c
	on o.customer_id = c.customer_id
left join shippers sh
	on o.shipper_id = sh.shipper_id
join order_statuses os
	on o.status = os.order_status_id
order by o.order_id;


use sql_hr;
select
	e.employee_id,
    e.first_name,
    m.first_name as manager
from employees e
left join employees m
	on e.reports_to = m.employee_id


use sql_store;
select
	o.order_id,
    c.first_name,
    sh.name as shipper
from orders o
join customers c
	using (customer_id)
left join shippers sh
	using (shipper_id);


-- USING --
use sql_invoicing;
select
	p.date,
    c.name as client,
    p.amount,
    pm.name as method
from payments p
join clients c
	using (client_id)
join payment_methods pm
	on p.payment_method = pm.payment_method_id;


-- NATURAL JOINS --
use sql_store;
select
	o.order_id,
    c.first_name
from orders o
natural join customers c;


use sql_store;
select
    c.first_name as customer,
    p.name as product
from customers c
cross join products p
order by c.first_name;


-- CROSS JOIN --
use sql_store;
select
	sh.name as shipper,
	p.name as product
from shippers sh
cross join products p
order by sh.name;
	-- OR --
select
	sh.name as shipper,
    p.name as product
from shippers sh, products p
order by sh.name;


