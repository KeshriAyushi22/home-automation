package ayu.arduino.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ayu.arduino.service.Login;
import ayu.arduino.service.Register;
import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.ApiResponse;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.util.IsNullorEmpty;



@Path("/t")
public class MainAPI {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object test() {
		System.out.println("checking the connection");
	return "connection done";

	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApiResponse login(String request) throws JsonParseException, JsonMappingException, IOException {
		
		String error=null;
		
		ObjectMapper mapper = new ObjectMapper();
		LoginDetails req= mapper.readValue(request, LoginDetails.class);
		ApiResponse response=null;
		//validation
		
		if(IsNullorEmpty.isNullOrEmpty(error)) {
		response = Login.dologin(req);
		return response;
		}
		System.out.println("response"+response);
		
		return response;

	}
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)

	public void register(String request) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("coming to main api");
		String error=null; //validate method to be implemented.
		ObjectMapper mapper = new ObjectMapper();
		/*ApiRequest req= mapper.readValue(request, ApiRequest.class);
		ApiResponse response=new ApiResponse();*/
		//validation
		if(IsNullorEmpty.isNullOrEmpty(error)) 
			Register.doRegisteration();
			
		
		

	}
	
	
	
}
