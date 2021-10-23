create database b2_furuma_khu_nghi_duong_tieng_viet;
use b2_furuma_khu_nghi_duong_tieng_viet;
create table vi_tri(
id_vi_tri int not null auto_increment primary key,
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int not null auto_increment primary key,
trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int not null auto_increment primary key,
ten_bo_phan varchar(45)
);
create table nhan_vien(
id_nhan_vien int not null auto_increment primary key,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int, 
ngay_sinh date,
so_cmnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);
create table loai_khach(
id_loai_khach int not null auto_increment primary key,
ten_loai_khach varchar(45)
);
create table khach_hang(
id_khach_hang  int not null auto_increment primary key,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);
create table kieu_thue(
id_kieu_thue int not null auto_increment primary key,
ten_kieu_thue varchar(45),
gia int
);
create table loai_dich_vu(
id_loai_dich_vu  int not null auto_increment primary key,
ten_loai_dich_vu varchar(45)
);
create table dich_vu(
id_dich_vu int not null auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);
create table hop_dong(
id_hop_dong int not null auto_increment primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);
create table dich_vu_di_kem(
id_dich_vu_di_kem  int not null auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet  int not null auto_increment primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_hop_dong) references hop_dong(id_hop_dong),
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);
select * from table_1;
insert into vi_tri values (1,'Le tan'),(2,'Phuc vu'),(3,'Chuyen vien'),(4,'Giam sat'),(5,'Quan li'),(6,'Giam doc');
insert into trinh_do values (1,'Trung cap'),(3,'Dai hoc'),(2,'Cao dang'),(4,'Sau dai hoc');
insert into bo_phan values (1,'Sale-Marketing'), (2,'Hanh chinh'),(3,'Phuc vu'),(4,'Quan ly');
insert into loai_khach values (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
insert into kieu_thue values(1,'năm',90000000),(2,'tháng',1200000),(3,'ngày',2000000),(4,'giờ',200000);
insert into loai_dich_vu values(1,'Villa'),(2,'House'),(3,'Room');
insert into dich_vu_di_kem
values
(1,'massage',500000,1,'Kha dung'),
(2,'karaoke',400000,1,'Kha dung'),
(3,'thức ăn',100000,1,'Kha dung'),
(4,'nước uống',20000,1,'Kha dung'),
(5,'thuê xe di chuyển tham quan resort',1000000,1,'Kha dung');
insert into khach_hang
values
(1,2,'Nguyễn Đoàn','1989-02-09','234345345','090543454','nguyendoan@gmail.com','Hai Phong'),
(2,3,'Nguyễn Anh','1991-12-17','223445398','095643457','nguyenanh@gmail.com','Quảng Bình'),
(3,1,'Lê Hùng','1990-02-12','342345456','0906456756','hung@gmail.com','Hai Dương'),
(4,4,'Đoàn Lĩnh','1978-02-12','234345665','0935678767','doanlinhgmail.com','Đà Nẵng'),
(5,5,'Tô Lâm','1995-02-12','323454345','090542546','tolam@gmail.com','Hà Nội');
insert into dich_vu
values(1,'thuê view biển villa',200,2,'12',5000000,3,1,'tốt nhất'),
(2,'thuê view biển house',100,2,'9',4000000,3,2,'tốt nhất'),
(3,'thuê view biển room',30,2,'3',3000000,3,3,'tốt nhất'),
(4,'thuê view trung tâm villa',200,2,'12',4000000,3,1,'tốt nhất'),
(5,'thuê view trung tâm house',100,2,'9',3000000,3,2,'tốt nhất'),
(6,'thuê view trung tâm room',30,2,'3',2000000,3,3,'tốt nhất');

insert into nhan_vien
values
(1,'Hồ Đình Khuê',6,4,2,'1978-02-12',206184291,50000000,0905345432,'khue@gmail.com','Đà Nẵng'),
(2,'Nguyễn Văn Sơn',1,1,1,'1999-12-12',206764234,5000000,090534345,'nguyenson@gmail.com','Đà Nẵng'),
(3,'Nguyễn Văn An',1,1,3,'1988-04-13',206184291,5000000,0905768796,'vanan@gmail.com','Quảng Nam'),
(4,'Lê Thị Thu',2,3,4,'1995-02-12',206184291,10000000,0905453657,'lethu@gmail.com','Đà Nẵng'),
(5,'Trương Văn Tuấn',2,3,1,'1989-02-09',206915647,10000000,0909452456,'vantuan@gmail.com','Hồ Chí Minh'),
(6,'Trần Khánh Chi',3,3,2,'1991-12-17',202914563,20000000,0905567345,'tranchi@gmail.com','Hà Nội'),
(7,'Nguyễn Ngọc',3,3,1,'1988-02-12',206566914,20000000,09055467846,'nguyenngoc@gmail.com','Hai Phòng'),
(8,'La Thành',4,4,4,'1978-02-12',206184291,50000000,0905345432,'khue@gmail.com','Đà Nẵng'),
(9,'Hồ Văn Chiến',6,4,2,'1978-02-18',20657478,30000000,0935678567,'vanchien@gmail.com','Đà Nẵng'),
(10,'Võ Anh Dũng',5,4,1,'1990-02-12',20656465,40000000,0905345768,'voanh@gmail.com','Quảng Nam');

insert into hop_dong_chi_tiet
values
(1,1,2,3),
(2,2,1,2),
(3,3,4,2);

insert into hop_dong
values
(1,2,1,1,'2020-12-12','2021-01-02',3000000,5000000),
(2,3,4,2,'2021-01-12','2021-01-20',400000,7000000),
(3,6,3,4,'2020-03-12','2021-03-22',5000000,10000000);
select * from vi_tri;
select * from trinh_do;
select * from bo_phan;
select * from nhan_vien;
select * from loai_khach;
select * from kieu_thue;
select * from loai_dich_vu;
select * from dich_vu_di_kem;
select * from khach_hang;
select * from dich_vu;
select * from hop_dong;
select * from hop_dong_chi_tiet;
-- select *,length(ho_ten) 'so ki tu' from nhan_vien  where (ho_ten like 'h%'or ho_ten like 't%' or ho_ten like 'K%') and ('so ki tu'<10);
-- select *,length(ho_ten) 'so ki tu' from nhan_vien  where length(ho_ten)<=15 and (ho_ten like 'h%'or ho_ten like 't%' or ho_ten like 'K%');
-- select *,char_length(ho_ten) 'so ki tu' from nhan_vien  where 'so ki tu'<10;
-- select *,char_length(ho_ten) as sokitu from nhan_vien  where ho_ten like 'h%'or ho_ten like 't%' or ho_ten like 'K%'
-- group by ho_ten
--  having 'so ki tu'<10;

-- task2
 select *,char_length(ho_ten)as 'sokitu',now() from nhan_vien  where ho_ten like 'h%'or ho_ten like 't%' or ho_ten like 'K%' and char_length(ho_ten)<=15;
 -- task3  so sánh năm
 select *,round(datediff(curdate(),ngay_sinh)/365,0) as tuoi from khach_hang  where (dia_chi='da nang' or dia_chi='quang tri' )
 and (round(datediff(curdate(),ngay_sinh)/365,0) between 18 and 50);
 -- task 4
 select *,count(hop_dong.id_khach_hang) as 'số lần đặt phòng'  from khach_hang  
 join hop_dong on khach_hang.id_khach_hang=hop_dong.id_khach_hang 
 where khach_hang.id_loai_khach=1
 group by (hop_dong.id_khach_hang) ;
 -- task 5 
 select  khach_hang.id_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,hop_dong.id_hop_dong,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,
 dich_vu_di_kem.ten_dich_vu_di_kem,hop_dong_chi_tiet.so_luong,dich_vu_di_kem.gia,dich_vu.chi_phi_thue,dich_vu.chi_phi_thue+hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia 'tong tien'
 from khach_hang
 join loai_khach on khach_hang.id_loai_khach=loai_khach.id_loai_khach
 join hop_dong on hop_dong.id_khach_hang=khach_hang.id_khach_hang
 join dich_vu on dich_vu.id_dich_vu=hop_dong.id_dich_vu
 join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong=hop_dong.id_hop_dong
 join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem=hop_dong_chi_tiet.id_dich_vu_di_kem;
 
 -- task 6 so sánh ngày 
 select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.chi_phi_thue,dich_vu.ten_dich_vu from dich_vu
where not exists (select dich_vu.id_dich_vu from hop_dong
 where dich_vu.id_dich_vu=hop_dong.id_dich_vu and hop_dong.ngay_lam_hop_dong>'2019-01-01');
 -- task 7 
 select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,loai_dich_vu.ten_loai_dich_vu from dich_vu
 join loai_dich_vu on loai_dich_vu.id_loai_dich_vu=dich_vu.id_loai_dich_vu
 where exists (select hop_dong.id_dich_vu from hop_dong
 where hop_dong.id_dich_vu=dich_vu.id_dich_vu and( hop_dong.ngay_lam_hop_dong>'2021-01-01' and hop_dong.ngay_lam_hop_dong<'2021-12-31'));
 -- task8
 select distinct khach_hang.ho_ten from khach_hang;
  select  khach_hang.ho_ten from khach_hang
  group by khach_hang.ho_ten;
select  khach_hang.ho_ten from khach_hang
order by khach_hang.ho_ten;
-- task 9
select month(hop_dong.ngay_lam_hop_dong),year(hop_dong.ngay_lam_hop_dong), sum(tong_tien)'doanh thu theo thang' from hop_dong 
group by month(hop_dong.ngay_lam_hop_dong),
year(hop_dong.ngay_lam_hop_dong);
-- task 10
select hop_dong.id_hop_dong,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,hop_dong.tien_dat_coc,hop_dong_chi_tiet.so_luong 'so luong dich vu di kem' from hop_dong
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong=hop_dong.id_hop_dong;
-- task 11
select khach_hang.id_khach_hang,loai_khach.ten_loai_khach from khach_hang
join loai_khach on khach_hang.id_loai_khach=loai_khach.id_loai_khach
where loai_khach.id_loai_khach=1 and( khach_hang.dia_chi='Quang Ngai' or khach_hang.dia_chi='vinh');
-- task 12
select hop_dong.id_hop_dong,nhan_vien.ho_ten 'ho ten nhan vien', khach_hang.ho_ten 'ho ten khach hang',khach_hang.sdt 'so dth khach hang',dich_vu.ten_dich_vu,
dich_vu_di_kem.ten_dich_vu_di_kem,hop_dong_chi_tiet.so_luong,hop_dong.tien_dat_coc,hop_dong.ngay_lam_hop_dong
 from hop_dong
join nhan_vien on hop_dong.id_nhan_vien=nhan_vien.id_nhan_vien
join khach_hang on khach_hang.id_khach_hang=hop_dong.id_khach_hang
join dich_vu on hop_dong.id_dich_vu=dich_vu.id_dich_vu
join hop_dong_chi_tiet on hop_dong.id_hop_dong=hop_dong_chi_tiet.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem=hop_dong_chi_tiet.id_dich_vu_di_kem
where hop_dong.ngay_lam_hop_dong<'2021-12-31' and hop_dong.ngay_lam_hop_dong>'2021-09-01';
-- task 13
select dich_vu_di_kem.id_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem,hop_dong_chi_tiet.so_luong,sum(hop_dong_chi_tiet.so_luong)'so luong dv di kem da dung' from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem=dich_vu_di_kem.id_dich_vu_di_kem
group by dich_vu_di_kem.id_dich_vu_di_kem;
-- task 14
select hop_dong.id_hop_dong,hop_dong.id_dich_vu,loai_dich_vu.ten_loai_dich_vu,hop_dong_chi_tiet.id_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem,hop_dong_chi_tiet.so_luong from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem=dich_vu_di_kem.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong=hop_dong_chi_tiet.id_hop_dong
join dich_vu on dich_vu.id_dich_vu=hop_dong.id_dich_vu
join loai_dich_vu on dich_vu.id_loai_dich_vu=loai_dich_vu.id_loai_dich_vu;
-- task 15
select nhan_vien.id_nhan_vien,nhan_vien.ho_ten,trinh_do.trinh_do,bo_phan.ten_bo_phan,nhan_vien.sdt,nhan_vien.dia_chi,count(hop_dong.id_hop_dong), hop_dong.ngay_lam_hop_dong from nhan_vien
join trinh_do on nhan_vien.id_trinh_do=trinh_do.id_trinh_do
join bo_phan on bo_phan.id_bo_phan=nhan_vien.id_bo_phan
join hop_dong on hop_dong.id_nhan_vien=nhan_vien.id_nhan_vien
group by nhan_vien.id_nhan_vien
having count(hop_dong.id_hop_dong)>0 and hop_dong.ngay_lam_hop_dong >'2021-02-20' and hop_dong.ngay_lam_hop_dong <'2022-02-20' ;
-- task 16
select * from nhan_vien
where not exists (select *,count(hop_dong.id_hop_dong) from hop_dong
where nhan_vien.id_nhan_vien=hop_dong.id_nhan_vien
group by nhan_vien.id_nhan_vien
having count(hop_dong.id_hop_dong)>0 and (hop_dong.ngay_lam_hop_dong<'2021-12-29' and hop_dong.ngay_lam_hop_dong>'2021-01-01'));
-- task 17 



  select * from khach_hang;
    select * from loai_khach;
select * from nhan_vien;
 select * from loai_dich_vu;
select * from dich_vu_di_kem;
select * from khach_hang;
select * from dich_vu;
select * from hop_dong;
select * from hop_dong_chi_tiet;
select '2019-01-01'>'2018-01-01'