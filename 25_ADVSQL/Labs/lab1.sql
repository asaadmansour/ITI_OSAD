use sakila;
#1
delimiter //

create procedure return_customer_details(
    in c_id int,
    out resultset varchar(300)
)
begin
select concat(c.first_name, ' ', c.last_name, ' | ', c.email, ' | ', a.address, ' | ', cc.city)
into resultset
from customer c
join address a  on c.address_id = a.address_id
join city cc    on a.city_id    = cc.city_id
where c.customer_id = c_id;
end //
set @resultset = '';
call return_customer_details(1, @resultset);
select @resultset;
#2
delimiter //
create procedure get_total_revenue(in start_date date,in end_date date)
begin
select ss.store_id ,sum(p.amount)
from payment p
join staff s on s.staff_id = p.staff_id 
join store ss on ss.store_id = s.store_id
where p.payment_date between start_date and end_date
group by ss.store_id;
end //

call get_total_revenue("2005-05-25","2005-06-15")

#3
delimiter //
create procedure get_film_title_rating(in word varchar(100))
begin
select title,rating
from film
where title like concat('%',word,'%');
end //

call get_film_title_rating("aa")
delimiter ;

#4
delimiter //
create procedure customer_rental(in c_id int)
begin
select cc.customer_id, c.name as category_name, count(*) as rent_count
from category c, film_category fc, rental r, customer cc, inventory i
where fc.category_id = c.category_id and i.film_id = fc.film_id
and i.inventory_id = r.inventory_id and r.customer_id = cc.customer_id 
and cc.customer_id = c_id
group by cc.customer_id,c.name
order by cc.customer_id,rent_count desc
limit 1;
end //

call customer_rental(1);

#triggers
#1
delimiter //
create trigger update_last
before update 
on address
for each row
begin 
set NEW.last_update = now();
end //
#2
delimiter //

create trigger prevent_update
before update
on staff
for each row
begin
if NEW.username = 'admin' then
signal sqlstate '45000'
set message_text = 'cannot update admin username';
end if;
end //


#3
delimiter //
create trigger check_email
before update
on customer
for each row
begin
if NEW.email not like '%@%.%'
then signal sqlstate '45000'
set message_text = 'cannot update email';
end if;
end //

#4
create table film_price_history(
    old_price decimal(4,2),
    new_price decimal(4,2),
    change_date datetime
);

delimiter //
create trigger film_price_update
after update on film
for each row
begin
    if old.rental_rate <> new.rental_rate then
        insert into film_price_history(old_price, new_price, change_date)
        values (old.rental_rate, new.rental_rate, now());
    end if;
end;
//
delimiter ;
