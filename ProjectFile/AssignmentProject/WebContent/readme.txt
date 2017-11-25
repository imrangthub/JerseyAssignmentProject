# JerseyAssignmentProject
This is a project where i implement four rest  API for create, read, update and delete with showing list. here all request and response as JSON data type.\

Technology stack:
Jersey
and
JDBC.


Modal will be:  Student (name, mobile, email, present address, permanent address).

Database name: simple.
Table name: student

Createing Sql as: 

Create table student(
  id int not null AUTO_INCREMENT Primary Key,
  name varchar(99) not null,
  mobile varchar(99) not null,
  email varchar(99) default null,
  present_address varchar(99) default null,
  Permanent_address varchar(99) not null
);


URI List:
          GET
       1| http://localhost:8080/AssignmentProject/student/list 
          for showing student list.
          
          GET
       2| http://localhost:8080/AssignmentProject/student/read/1
          for read single data.
          
          POST
       3| http://localhost:8080/AssignmentProject/student/create
          for create data.
          
          PUT
       4| http://localhost:8080/AssignmentProject/student/update
          for update data.
          
          DELETE
       5| http://localhost:8080/AssignmentProject/student/delete/1
          for delete data.
		  
		  
		  
		  All Request and Response willbe JSON formate.
		  