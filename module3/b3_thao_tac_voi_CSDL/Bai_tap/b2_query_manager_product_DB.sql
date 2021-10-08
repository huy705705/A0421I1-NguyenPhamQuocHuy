create database b02_bt_quan_ly_ban_hang;
use b02_bt_quan_ly_ban_hang;
CREATE TABLE Customer (
    cID INT PRIMARY KEY,
    cName VARCHAR(50),
    cAge INT
);

CREATE TABLE `Order` (
    oID INT PRIMARY KEY,
    cID INT,
    oDate DATETIME,
    oTotalPrice INT,
    FOREIGN KEY (cID)
        REFERENCES Customer (cID)
);

CREATE TABLE Product (
    pID INT PRIMARY KEY,
    pName VARCHAR(50),
    pPrice INT
);

CREATE TABLE OrderDetail (
    oID INT,
    pID INT,
    odQTY INT,
    PRIMARY KEY (oID , pID),
    FOREIGN KEY (oID)
        REFERENCES `Order` (oID),
    FOREIGN KEY (pID)
        REFERENCES Product (pID)
);
 insert into customer values(1,'Minh Quan', 10),
 (2,'Ngoc Oanh', 20),
 (3,'Hoang Ha', 50);
 select * from customer;
 insert into `order` values (1,1,'2006-3-21',null),
 (2,2,'2006-3-23',null),
 (3,1,'2006-3-16',null);
 select * from `order`;
  insert into product values (1,'May giat' ,3),
  (2,'Tu lanh' ,5),
  (3,'Dieu hoa' ,7),
  (4,'Quat' ,1),
  (5,'Bep dien' ,2);
   select * from product;
   
   insert into orderDetail values(1,1,3),
   (1,3,7),
   (1,4,2),
   (2,1,1),
   (3,1,8),
   (2,5,4),
   (2,3,3);
select * from orderdetail;
select * from `order`;
select `order`.oId,`order`.odate,`order`.ototalPrice from `order`;

select customer.cid,customer.cname,product.pname from customer
join `order` on customer.cid=`order`.cid
join orderdetail on `order`.oid=orderdetail.oid
join product on product.pid=orderdetail.pid
order by customer.cid,product.pname;

select customer.cname from customer
where not exists (select customer.cname
from `order` where customer.cid=`order`.cid);


select `order`.oid,`order`.odate,sum(product.pprice*orderDetail.odQTY) as amount 
from `order`
inner join orderdetail on `order`.oid=orderDetail.oid
inner join product on product .pid=orderdetail.pid
group by `order`.oid;
