package com.assignmentpro.controller;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class HomeController {
	
	    @GET
	    @Produces(MediaType.TEXT_PLAIN)
		public String getCountryById(){	 
			return "Welcome to Assignmement Project \n This is a project where i implement four rest  API for create, read, update and delete with showing list. here all request and response as JSON data type.";
		}

}
