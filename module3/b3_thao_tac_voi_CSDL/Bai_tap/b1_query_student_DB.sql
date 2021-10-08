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
select * from student;

insert into subject values (1,"CF",5,1),
		(2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       select * from subject;
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
select * from student 
where studentname like 'h%';

select * from subject
where credit between 3 and 5;

select * from class
where startdate between '2008-10-1' and '2008-12-20';

 update student 
 set classid=2 where studentname='hung';
select * from student ;
select * from subject ;


select student.studentname,Subject.SubName,mark.mark from student
join mark on student.studentid=mark.markid 
join subject on mark.studentid=subject.subid;