package com.assignmentpro.controller;

import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.assignmentpro.model.Student;
import com.assignmentpro.service.StudentService;


// Controller for handling Request and Response.
@Path("/student")
public class StudentController {
	
	StudentService studentService = new StudentService();
	
	// Assignment project Rest API for create operation
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> createStudent(Student student){
    	System.out.println(student.getName());
     	return studentService.addStudent(student);
	}
    
    // Assignment project  Rest API for read operation
    @GET
    @Path("/read/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Student> studentReadById(@PathParam("id") long id){
		return studentService.getStudent(id);
	}
    
    // Assignment project  Rest API for list show operation
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Student> list(){
		return studentService.studentList();
	}
    
    // Assignment project  Rest API for update operation
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> updateStudent(Student student){
    	System.out.println(student.getId());
     	return studentService.updateStudent(student);
	}
    
    // Assignment project  Rest API for delete operation
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public  Map<String, Object> deleteStudentById(@PathParam("id") long id){
		return studentService.deleteStudent(id);
	}



}
