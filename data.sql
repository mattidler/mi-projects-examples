create or replace function call_time(time(6)) returns void as
$$
	insert into call_info(session_duration) values
	($1)
$$ language sql;

create trigger insert_calls
after insert on call_info
for each statement
execute procedure call_time();

insert into customer_info values
(0122,
123456789,
'Smith',
'John',
'jsmith@gmail.com',
'9165554321',
'123 main st.',
'Rocklin',
'CA',
'95677',
'2016-01-20',
'2016-01-25',
2,
'00:40:00'),
(6789, 
098765432,
'Doe',
'Jane',
'jdoe@yahoo.com',
'9165550987',
'205 maple st.',
'Roseville',
'CA',
'95678',
'2015-5-5',
'2016-6-13',
55,
'12:23:01');

insert into employee_info values
('11223',
'Jones',
'Valerie',
'Manager',
'Rocklin'),
('09764',
'Belanger',
'Wesley',
'Translator',
'Roseville' );

insert into terp_info values
('098',
'Jones',
'Valerie',
'Rocklin',
'Yes',
'Spanish',
'100',
'F'),
('135',
'Belanger',
'Wesley',
'Roseville',
'Yes',
'French',
'25',
'M');

insert into call_info values
(13579, 
'2016-08-01 08:20:00', 
'2016-08-01 08:35:00', 
'00:15:00', 
11223, 
'9165554321'),
(97531,
'2016-07-04 11:30:00',
'2016-07-04 12:35:00',
'01:05:00',
6789,
'9165550987');

insert into outside_user values
('13579',
'9165554321',
'098'),
('97531',
'9165550987',
'135');

insert into fcc_info values
('Taylor', 
'Susan');

insert into rid_info values
('Nelson', 
'James');

select terp_info.vi_num, customer_info.cust_lastname
from terp_info join customer_info on terp_info.vi_num = '098'
AND customer_info.cust_lastname = 'Smith';

select cust_lastname, cust_id
from customer_info
where cust_id in
(select session_id
from call_info
where session_id = 97531);
