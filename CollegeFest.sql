create schema studentDB;

use studentDB;



-- Geeral -1
insert into users(username, password) values('general', '$2a$12$XPG8FHNUWFNgp6IniwHUkuKeeXMdX4oWrxobOeVUkYEeyOoOxk2iu');

-- password = admin -- 2
insert into users(username, password) values('admin', '$2a$12$sulOD45A7cPRbR2izIXfquBz5F7AoZQDD33PnbK0VCMQ5.Rb8q4yu');

-- admin -1
insert into roles(name) values('ADMIN');
-- user -2
insert into roles(name) values('USER');

insert into users_roles(user_id, role_id) values(2,1); -- admin userid=2 roleid=1
insert into users_roles(user_id, role_id) values(1, 2); -- general userid=1, roleid=2

select * from users ;
select * from roles;
select * from users_roles;
select * from student;

select * from book;

delete from roles where role_id =2;

update users set password = "$2a$12$dRLNYSdUn9KhcA8h8P35KO/PrnINPclGMzB8n9tMd.at8Z0Hux5wq" where username = "admin";