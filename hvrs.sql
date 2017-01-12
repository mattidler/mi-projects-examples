drop table if exists customer_info cascade;
drop table if exists employee_info cascade;
drop table if exists call_info cascade;
drop table if exists terp_info cascade;
drop table if exists outside_user cascade;
drop table if exists fcc_info;
drop table if exists rid_info;

create table customer_info
(cust_id int primary key,
custSSN char(10) unique not null,
cust_lastname varchar(45) not null,
cust_firstname varchar(45) not null,
cust_email varchar(45),
cust_phone char(10) not null unique,
cust_address varchar(45) not null,
cust_city varchar(45) not null,
cust_state char(2) not null,
cust_zip char(5) not null,
cust_accountcreatedate date not null,
cust_mostrecentcall date,
cust_numberofcalls numeric,
cust_numberofminutes time(6));

create index num_of_mins on customer_info(cust_numberofminutes desc);

create table employee_info
(emp_id char(5) primary key,
emp_lastname varchar(45) not null unique,
emp_firstname varchar(45) not null unique,
emp_title varchar(20) not null,
emp_homeoffice varchar(45) not null unique);

create table call_info 
(session_id numeric primary key,
session_start timestamp(6),
session_end timestamp(6),
session_duration time(6), 
session_queue varchar(20),
session_phonenumber char(10) not null unique,
constraint fk_callinfo foreign key(session_phonenumber)
references customer_info(cust_phone));

create index duration_ind on call_info(session_duration desc);

create table terp_info
(vi_num char(3) primary key,
terp_lastname varchar(45) not null references employee_info(emp_lastname) on update cascade,
terp_firstname varchar(45) not null references employee_info(emp_firstname) on update cascade,
terp_homeoffice varchar(45) not null references employee_info(emp_homeoffice) on update cascade,
terp_cert varchar(25) not null,
terp_language varchar(25) not null,
terp_numofcalls numeric not null,
terp_gender char(1) not null);

create table outside_user 
(session_id numeric primary key,
outside_phonenumber char(10) not null,
vi_number char(3) not null,
constraint fk_vi_num foreign key(vi_number)
references terp_info(vi_num));

alter table outside_user
add constraint fk_sessionid foreign key(session_id)
references call_info(session_id);

create table fcc_info
(fcc_rep_lastname varchar(45) primary key,
fcc_rep_firstname varchar(45) not null);

create table rid_info
(rid_rep_lastname varchar(45) primary key,
rid_repfirstname varchar(45) not null);

create view customer_vew as
select cust_id, cust_lastname, cust_firstname, cust_email, cust_numberofminutes
from customer_info;

create view callinfo_vew as
select * from call_info;
