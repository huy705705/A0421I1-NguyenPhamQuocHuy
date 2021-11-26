update user set  username='huuyquoc1111@gmail.com',password='123123' where username='huuyquoc1@gmail.com';
update user_role set role_id=2,user_name='huuyquoc1@gmail.com' where user_name='huuyquoc1@gmail.com';
update employee set employee_name='Nguyen Pham Quoc Huy 1',user_name='huuyquoc1111@gmail.com' where employee_id=13;

ALTER TABLE `employee` DROP CONSTRAINT `employee_ibfk_4`;
ALTER TABLE `employee`
ADD CONSTRAINT `employee_ibfk_4` 
FOREIGN KEY (`user_name`) 
REFERENCES `user` (`username`)
ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE `user_role` DROP CONSTRAINT `user_role_ibfk_1`;
ALTER TABLE `user_role`
ADD CONSTRAINT `user_role_ibfk_1` 
FOREIGN KEY (`user_name`) 
REFERENCES `user` (`username`)
ON UPDATE CASCADE ON DELETE CASCADE;
-- update employee set employee_name=?,employee_birthday=?,employee_birthday=?,employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?,division_id=?,user_name=? where id=13;
