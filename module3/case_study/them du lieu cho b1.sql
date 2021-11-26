insert into position_employee values (1,'Le tan'),(2,'Phuc vu'),(3,'Chuyen vien'),(4,'Giam sat'),(5,'Quan li'),(6,'Giam doc');
insert into eduaction_degree values (1,'Trung cap'),(3,'Dai hoc'),(2,'Cao dang'),(4,'Sau dai hoc');
insert into division values (1,'Sale-Marketing'), (2,'Hanh chinh'),(3,'Phuc vu'),(4,'Quan ly');
insert into customer_type values (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
insert into rent_type values(1,'năm',90000000),(2,'tháng',1200000),(3,'ngày',2000000),(4,'giờ',200000);
insert into service_type values(1,'Villa'),(2,'House'),(3,'Room');

insert into attach_service
values
(1,'massage',500000,1,'Kha dung'),
(2,'karaoke',400000,1,'Kha dung'),
(3,'thức ăn',100000,1,'Kha dung'),
(4,'nước uống',20000,1,'Kha dung'),
(5,'thuê xe di chuyển tham quan resort',1000000,1,'Kha dung');
insert into customer
values
(1,2,'Nguyễn Đoàn','1989-02-09',1,'234345345','090543454','nguyendoan@gmail.com','Hai Phong'),
(2,3,'Nguyễn Anh','1991-12-17',0,'223445398','095643457','nguyenanh@gmail.com','Quảng Bình'),
(3,1,'Lê Hùng','1990-02-12',1,'342345456','0906456756','hung@gmail.com','Hai Dương'),
(4,4,'Đoàn Lĩnh','1978-02-12',1,'234345665','0935678767','doanlinhgmail.com','Đà Nẵng'),
(5,5,'Tô Lâm','1995-02-12',0,'323454345','090542546','tolam@gmail.com','Hà Nội');
-- insert into service
-- values(1,'thuê view biển villa',200,2,'12',5000000,3,1,'tốt nhất'),
-- (2,'thuê view biển house',100,2,'9',4000000,3,2,'tốt nhất'),
-- (3,'thuê view biển room',30,2,'3',3000000,3,3,'tốt nhất'),
-- (4,'thuê view trung tâm villa',200,2,'12',4000000,3,1,'tốt nhất'),
-- (5,'thuê view trung tâm house',100,2,'9',3000000,3,2,'tốt nhất'),
-- (6,'thuê view trung tâm room',30,2,'3',2000000,3,3,'tốt nhất');

insert into service
values (1,'thuê view biển villa',200,5000000,12,3,1,'tốt nhất','none',30,2),
(2,'thuê view biển room',100,4000000,9,3,2,'tốt nhất','none',60,4),
(3,'thuê view trung tâm villa',300,6000000,15,3,3,'tốt nhất','none',90,1),
(4,'thuê view biển room',200,4000000,9,3,1,'tốt nhất','none',30,5),
(5,'thuê view trung tâm house',100,3000000,9,3,2,'tốt nhất','none',40,10),
(6,'thuê view trung tâm room',300,9000000,15,3,3,'tốt nhất','none',40,11);

-- insert into nhan_vien
-- values
-- (1,'Hồ Đình Khuê',6,4,2,'1978-02-12',206184291,50000000,0905345432,'khue@gmail.com','Đà Nẵng'),
-- (2,'Nguyễn Văn Sơn',1,1,1,'1999-12-12',206764234,5000000,090534345,'nguyenson@gmail.com','Đà Nẵng'),
-- (3,'Nguyễn Văn An',1,1,3,'1988-04-13',206184291,5000000,0905768796,'vanan@gmail.com','Quảng Nam'),
-- (4,'Lê Thị Thu',2,3,4,'1995-02-12',206184291,10000000,0905453657,'lethu@gmail.com','Đà Nẵng'),
-- (5,'Trương Văn Tuấn',2,3,1,'1989-02-09',206915647,10000000,0909452456,'vantuan@gmail.com','Hồ Chí Minh'),
-- (6,'Trần Khánh Chi',3,3,2,'1991-12-17',202914563,20000000,0905567345,'tranchi@gmail.com','Hà Nội'),
-- (7,'Nguyễn Ngọc',3,3,1,'1988-02-12',206566914,20000000,09055467846,'nguyenngoc@gmail.com','Hai Phòng'),
-- (8,'La Thành',4,4,4,'1978-02-12',206184291,50000000,0905345432,'khue@gmail.com','Đà Nẵng'),
-- (9,'Hồ Văn Chiến',6,4,2,'1978-02-18',20657478,30000000,0935678567,'vanchien@gmail.com','Đà Nẵng'),
-- (10,'Võ Anh Dũng',5,4,1,'1990-02-12',20656465,40000000,0905345768,'voanh@gmail.com','Quảng Nam');	

insert into employee
values
(1,'Hồ Đình Khuê','1978-02-12',206184291,50000000,0905345432,'khue@gmail.com','Đà Nẵng',6,4,2,'khue@gmail.com'),
(2,'Nguyễn Văn Sơn','1999-12-12',206764234,5000000,090534345,'nguyenson@gmail.com','Đà Nẵng',1,1,1,'nguyenson@gmail.com'),
(3,'Nguyễn Văn An','1988-04-13',206184291,5000000,0905768796,'vanan@gmail.com','Quảng Nam',1,1,3,'vanan@gmail.com'),
(4,'Lê Thị Thu','1995-02-12',206184291,10000000,0905453657,'lethu@gmail.com','Đà Nẵng',2,3,4,'lethu@gmail.com'),
(5,'Trương Văn Tuấn','1989-02-09',206915647,10000000,0909452456,'vantuan@gmail.com','Hồ Chí Minh',2,3,1,'vantuan@gmail.com'),
(6,'Trần Khánh Chi','1991-12-17',202914563,20000000,0905567345,'tranchi@gmail.com','Hà Nội',3,3,2,'tranchi@gmail.com'),
(7,'Nguyễn Ngọc','1988-02-12',206566914,20000000,09055467846,'nguyenngoc@gmail.com','Hai Phòng',3,3,1,'nguyenngoc@gmail.com'),
(8,'La Thành','1978-02-12',206184291,50000000,0905345432,'khue@gmail.com','Đà Nẵng',4,4,4,'khue@gmail.com'),
(9,'Hồ Văn Chiến','1978-02-18',20657478,30000000,0935678567,'vanchien@gmail.com','Đà Nẵng',6,4,2,'vanchien@gmail.com'),
(10,'Võ Anh Dũng','1990-02-12',20656465,40000000,0905345768,'voanh@gmail.com','Quảng Nam',5,4,1,'voanh@gmail.com');

insert into contract_detail
values
(1,1,2,3),
(2,2,1,2),
(3,3,4,2);

insert into contract
values
(1,'2020-12-12','2021-01-02',3000000,5000000,2,1,1),
(2,'2021-01-12','2021-01-20',400000,7000000,3,4,2),
(3,'2020-03-12','2021-03-22',5000000,10000000,6,3,4);