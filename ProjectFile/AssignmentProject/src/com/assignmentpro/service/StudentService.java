package com.assignmentpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.assignmentpro.configure.DBconnection;
import com.assignmentpro.model.Student;



// Student Service for Business Login implementation. 
public class StudentService { 
	
	private DBconnection dbconnectionObj = DBconnection.getInstance();
	private  Statement stmt;
	
	
	public List<Student> studentList(){
		List<Student> studentList = new ArrayList<Student>();
		String getAllDataQuery = "SELECT * FROM student ORDER BY ID"; 
		
		try {
			stmt = dbconnectionObj.getConnection().createStatement();
			ResultSet tempResult = stmt.executeQuery(getAllDataQuery);
		
			while(tempResult.next()){
				Student studentObj = new Student();
			    
				studentObj.setId(tempResult.getLong("id"));
				studentObj.setName(tempResult.getString("name"));
				studentObj.setMobile(tempResult.getString("mobile"));
				studentObj.setEmail(tempResult.getString("email"));
				studentObj.setPresentAddress(tempResult.getString("present_address"));
				studentObj.setPermanentAddress(tempResult.getString("permanent_address"));
			
				studentList.add(studentObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;		
	}
	
	public Map<String, Object> addStudent(Student student){
		Map<String, Object> results = new HashMap<String, Object>();
		int status=0;
		
		if(student.getName() == null || student.getMobile() == null){
			results.put("message", "Operation failure, Please provide required data and try again.");
			return results;
		}
		String storeQuery = "insert into student(name, mobile, email, present_address, Permanent_address) values('"+student.getName()+"', '"+student.getMobile()+"','"+student.getEmail()+"', '"+student.getPresentAddress()+"', '"+student.getPermanentAddress()+"');";
		
			try {
			stmt = dbconnectionObj.getConnection().createStatement();
			status = stmt.executeUpdate(storeQuery);	
			
			if(status>0){
				results.put("message", "Successfully completed adding student.");
			}else{
				results.put("message", "Operation failure.");
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	
	public List<Student>  getStudent(long id){
		List<Student> singleStudent = new ArrayList<Student>();
		String getStudentQuery ="select * from student WHERE id='"+id+"'";
	        System.out.println(getStudentQuery);
		try {
			stmt = dbconnectionObj.getConnection().createStatement();
			ResultSet tempResult = stmt.executeQuery(getStudentQuery);
		
			while(tempResult.next()){
				Student studentObj = new Student();
			    
				studentObj.setId(tempResult.getLong("id"));
				studentObj.setName(tempResult.getString("name"));
				studentObj.setMobile(tempResult.getString("mobile"));
				studentObj.setEmail(tempResult.getString("email"));
				studentObj.setPresentAddress(tempResult.getString("present_address"));
				studentObj.setPermanentAddress(tempResult.getString("permanent_address"));
			
				singleStudent.add(studentObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return singleStudent;	
	}
	
	
	public Map<String, Object> updateStudent(Student student){
		Map<String, Object> results = new HashMap<String, Object>();
		int status=0;
		
		if(student.getId() <= 0){
			results.put("message", "Update Operation failure,Student not found.");
			return results;
		}
		if(student.getName() == null || student.getMobile() == null){
			results.put("message", "Update Operation failure, Please provide required data and try again.");
			return results;
		}
		String storeQuery = "update student set name ='"+student.getName()+"', mobile = '"+student.getMobile()+"', email='"+student.getEmail()+"', present_address = '"+student.getPresentAddress()+"', Permanent_address='"+student.getPermanentAddress()+"' where id = '"+student.getId()+"';";
		System.out.println(storeQuery);
			try {
			stmt = dbconnectionObj.getConnection().createStatement();
			status = stmt.executeUpdate(storeQuery);	
			
			if(status>0){
				results.put("message", "Successfully Update completed.");
			}else{
				results.put("message", "Update Operation failure.");
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public Map<String, Object> deleteStudent(long id){
		Map<String, Object> results = new HashMap<String, Object>();
		int status=0;
		String deleteQuery ="DELETE FROM student WHERE `id`='"+id+"'";
		
			try {
			stmt = dbconnectionObj.getConnection().createStatement();
			status = stmt.executeUpdate(deleteQuery);
			if(status>0){
				results.put("message", "Successfully delete student.");
			}else{
				results.put("message", "Operation failure, Data not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}	

}
