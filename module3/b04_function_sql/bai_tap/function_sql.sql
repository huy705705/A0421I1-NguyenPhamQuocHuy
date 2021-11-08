CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);
CREATE TABLE Student
(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);
CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);

CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);
insert into class values (1,'A1', '2008-12-20',1);
insert into class values (2,'A2', '2008-12-22',1);
insert into class values (3,'B3', current_date,1);
select * from class;

insert into student values (1,'Hung', 'Ha Noi', '0902534350', 1,1),
(2,'Huy', 'Ha Noi', '0902534350', 1,1),
(3,'Hoa', 'Ha Noi', '0902534350', 1,1);
insert into student values (4,'Hue', 'Da Nang', '0902534350', 1,1);
select * from student;

insert into subject values (1,"CF",5,1),
		(2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       select * from subject;
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 22, 1);
select * from student;
select * from mark;
select * from subject;
select * from class;
select s.subid,s.subname,max(s.Credit)'max credit',s.status from subject s;


select s.subid,s.subname,s.credit,s.status,max(m.mark) 'max mark' from subject s
join mark m on m.subid=s.subid;

select st.studentid,st.studentname,st.address,st.phone,st.status,st.classid,avg(mark.mark)  'avg mark' from student st
inner join mark on st.studentid=mark.studentid
group by st.studentid
order by avg(mark.mark)desc;