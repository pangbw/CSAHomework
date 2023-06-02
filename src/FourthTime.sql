select * from help_keyword where help_keyword_id<=3

create table student 
(studentid varchar(10),
 name varchar(20),
 sex varchar(6),
 age integer,
 Fee decimal(10,2),
 address varchar(50),
 memo varchar(300)
);

create table CourseAa(
Aa1 varchar(20),
Aa2 integer,
Aa3 decimal(10)
);

create table ChooseBb(
Bb1 varchar(30),
Bb2 integer,
Bb3 decimal(6)
);

drop table courseaa ; 

alter table choosebb add(Bb4 varchar(20) default'系统测试值' not null);
alter table choosebb add(Bb5 varchar(20) primary key);

create view View_chooseBb(view_bb1,view_bb2,view_bb3)as
    select bb1,bb4,bb5
    from choosebb;

drop view view_choosebb ;

create index Index_bb2 on choosebb(bb2 asc);

create index Index_bb4 on choosebb(bb4 desc);

drop index Index_bb2 on choosebb;

CREATE TABLE test
(Name VARCHAR(20),
 Age INTEGER,
 Score NUMERIC(10,2),
 Address VARCHAR(60));

INSERT INTO test (Name,Age,Score,Address) VALUES ('赵一',20,580.00,'兴业苑 2-3-5');
INSERT INTO test (Name,Age,Score,Address) VALUES ('钱二',19,540.00,'南福苑 5-2-9');
INSERT INTO test (Name,Age,Score,Address) VALUES ('孙三',21,555.50,'兴业苑 21-5-15');
INSERT INTO test (Name,Age,Score,Address) VALUES ('李四',22,505.00,'知行苑 8-6-22');
INSERT INTO test (Name,Age,Score,Address) VALUES ('周五',20,495.50,'宁静苑 23-4-8');
INSERT INTO test (Name,Age,Score,Address) VALUES ('吴六',19,435.00,'南福苑 2-5-12');

CREATE TABLE test_temp
(Name VARCHAR(20),
 Age INTEGER,
 Score NUMERIC(10,2),
 Address VARCHAR(60));

INSERT INTO test_temp (Name,Age,Score,Address) VALUES ('郑七',21,490.50,'兴业苑 11-2-1');
INSERT INTO test_temp (Name,Age,Score,Address) VALUES ('张八',20,560.00,'明理苑 3-3-3');
INSERT INTO test_temp (Name,Age,Score,Address) VALUES ('王九',19,515.00,'知行苑 19-7-1');

INSERT INTO test SELECT * FROM test_temp;

UPDATE test SET Score = Score + 5 WHERE Age <= 20;

UPDATE test SET Age = Age - 1 WHERE Address LIKE '兴业苑%';

DELETE FROM test WHERE Age >=21 AND Score >= 500;

DELETE FROM test WHERE Score <=500 AND Address LIKE '南福苑%';

CREATE table Student (
SNO Varchar(20),
Name Varchar(10),
Age Integer,
College Varchar(30)
);

CREATE table Course (
CourseID Varchar(15),
CourseName Varchar(30),
CourseBeforeId Varchar(15)
);

CREATE table Choose (
SNO Varchar(20),
CourseID Varchar(30),
Score DECIMAL(5,2)
);

INSERT INTO student (SNO,Name,Age,College) values ('S00001','张三',20,'计算机学院');
INSERT INTO student (SNO,Name,Age,College) values ('S00002','李四',19,'通信学院');
INSERT INTO student (SNO,Name,Age,College) values ('S00003','王五',21,'计算机学院');

INSERT INTO Course (CourseID,CourseName,CourseBeforeID) values ('C1','计算机引论',NULL);
INSERT INTO Course (CourseID,CourseName,CourseBeforeID) values ('C2','C语言','C1');
INSERT INTO Course (CourseID,CourseName,CourseBeforeID) values ('C3','数据结构','C2');

INSERT INTO Choose (SNO,CourseID,Score) values ('S00001','C1',95);
INSERT INTO Choose (SNO,CourseID,Score) values ('S00001','C2',80);
INSERT INTO Choose (SNO,CourseID,Score) values ('S00001','C3',84);
INSERT INTO Choose (SNO,CourseID,Score) values ('S00002','C1',80);
INSERT INTO Choose (SNO,CourseID,Score) values ('S00002','C3',85);
INSERT INTO Choose (SNO,CourseID,Score) values ('S00003','C1',78);
INSERT INTO Choose (SNO,CourseID,Score) values ('S00003','C3',70);

SELECT SNO,Name
FROM Student
WHERE College = '计算机学院';

SELECT *
FROM Student
WHERE Age BETWEEN 20 AND 23;

SELECT COUNT(SNO)
FROM student ;

SELECT MAX(Score),MIN(Score),SUM(Score),AVG(Score)
FROM Choose 
WHERE CourseID = 'C1';

SELECT CourseID,CourseName
FROM Course 
WHERE CourseBeforeID IS NULL;

SELECT Student.SNO,Name,CourseName,Score
FROM Student,Choose,Course
WHERE  Student.SNO = Choose.SNO AND Choose.CourseID = Course.CourseID ; 

SELECT *
FROM Student S1
WHERE EXISTS (
    SELECT *
    FROM Student S2
    WHERE S1.College = S2.College AND S2.Name = '张三'
);

SELECT SNO,Score 
FROM Choose C1
WHERE SNO IN(    SELECT C2.SNO 
                FROM Student,Choose C2
                WHERE Student.SNO = C2.SNO AND Student.Name = '张三' AND C2.Score > C1.Score);

SELECT SNO
FROM Student
WHERE SNO IN (SELECT SNO 
                FROM Choose  
                WHERE Student.SNO = Choose.SNO AND CourseID = 'C1')
UNION    
SELECT SNO
FROM Student
WHERE SNO IN (SELECT SNO 
                FROM Choose 
                WHERE Student.SNO = Choose.SNO AND CourseID = 'C3');

SELECT DISTINCT SNO 
FROM Student
WHERE SNO IN (SELECT SNO 
                FROM Choose  
                WHERE Student.SNO = Choose.SNO AND CourseID = 'C1')
UNION    
SELECT DISTINCT SNO
FROM Student
WHERE SNO IN (SELECT SNO 
                FROM Choose 
                WHERE Student.SNO = Choose.SNO AND CourseID = 'C3');