drop database loginApp;

create database loginApp;

use loginApp;


create table admin(
user_name varchar(15) primary key,
password varchar(20),
name varchar(15),
contact_number long ,
email_id varchar(20) ,
DOB date);



insert into admin values("abc",'abc@1234',"Harry",1234567890,"harry@gmail.com","2001-02-12");
insert into admin values("def","def@1234","Ron",9876543210,"ron@gmail.com","2001-02-12");
insert into admin values("xyz","xyz@1234","Hermoine",5555555555,"her@gmail.com","2001-02-21");

create table Users(
emp_id int primary key AUTO_INCREMENT,
name varchar(15),
email_id varchar(15),
contact_number long,
admin varchar(15),
foreign key (admin) references admin(user_name)
);

insert into Users values(1001,'aaa','aaa@gmail.com',111111111,'abc');
insert into Users values(1002,'bbb','bbb@gmail.com',2222222222,'abc');
insert into Users values(1003,'ccc','ccc@gmail.com',3333333333,'def');
insert into Users values(1004,'ddd','ddd@gmail.com',4444444444,'xyz');

commit;

select * from admin;
select * from users;
