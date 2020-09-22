DROP TABLE IF EXISTS EMPLOYEE;
  
CREATE TABLE EMPLOYEE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  manager VARCHAR(250) NOT NULL,
  salary VARCHAR(250) DEFAULT NULL,
  employeetype VARCHAR(250) DEFAULT NULL,
  mobilenumber VARCHAR(250) DEFAULT NULL,
  department VARCHAR(250) NOT NULL
);


INSERT INTO EMPLOYEE (name,manager,salary,employeetype,mobilenumber,department) 
values ('Ana','Manager001','120000','Permanent','022','Department001');
INSERT INTO EMPLOYEE (name,manager,salary,employeetype,mobilenumber,department)
values ('Topson','Manager001','110000','Permanent','022','Department001');
INSERT INTO EMPLOYEE (name,manager,salary,employeetype,mobilenumber,department)
values ('Jerax','Manager001','105000','Permanent','022','Department001');
INSERT INTO EMPLOYEE (name,manager,salary,employeetype,mobilenumber,department)
values ('Ceb','Manager001','105000','Permanent','022','Department001');
INSERT INTO EMPLOYEE (name,manager,salary,employeetype,mobilenumber,department)
values ('NoTail','Manager001','130000','Permanent','022','Department001');


