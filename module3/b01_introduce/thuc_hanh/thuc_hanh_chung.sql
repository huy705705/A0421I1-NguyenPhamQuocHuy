create database demo;
use demo;
create table student(
id int,
`name` varchar(250),
address varchar(250)
);
select * from student;
insert into student values(1,"huy","dn");
insert into student(id, address, `name`  ) values(2,"dn","huy2");
update student set id=3 where id=2;
delete from student where id=3;
drop table student ;
drop database demo;