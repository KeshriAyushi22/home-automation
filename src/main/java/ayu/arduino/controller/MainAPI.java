package ayu.arduino.controller;

import java.io.IOException;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import ayu.arduino.dao.DaoImpl;
import ayu.arduino.helper.RandomGenerator;
import ayu.arduino.service.Activation;
import ayu.arduino.service.Login;
import ayu.arduino.service.Register;

import ayu.arduino.to.ApiResponse;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.to.Mail;
import ayu.arduino.util.HibernateUtil;
import ayu.arduino.util.IsNullorEmpty;



@Path("/iot")
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
		ApiResponse response=new ApiResponse();
		try {
			ObjectMapper mapper = new ObjectMapper();
			LoginDetails req= mapper.readValue(request, LoginDetails.class);

			//validation

			if(IsNullorEmpty.isNullOrEmpty(error)) {
				response = Login.dologin(req);
				System.out.println("response success"+response);

			}

		}catch(Exception e) {
			System.out.println(e);
		}finally {
			HibernateUtil.shutdown();
		}

		return response;

	}



	@POST
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ApiResponse homeApi(String request) throws JsonParseException, JsonMappingException, IOException {

		String error=null;
		ApiResponse response=null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			LoginDetails req= mapper.readValue(request, LoginDetails.class);

			//validation

			if(IsNullorEmpty.isNullOrEmpty(error)) {
				response = Login.HomeApi(req);
				System.out.println("Home response success"+response);

			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			HibernateUtil.shutdown();
		}

		return response;

	}



	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse register(String request) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("coming to main api");
		String error=null; //validate method to be implemented.
		ApiResponse response=new ApiResponse();
		//validation
		if(IsNullorEmpty.isNullOrEmpty(error)) {
			Register.doRegisteration();
			response.setResCode("1111");
			response.setResStatus("registration success");
		}else {

			response.setErrorCode("0000");
			response.setErrorStatus("error in registering the info.");
		}
		return response;


	}

	@POST
	@Path("/forgetPassword")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse forgetPassword(String request) throws JsonParseException, JsonMappingException, IOException {
		ApiResponse response=new ApiResponse();
		ObjectMapper mapper = new ObjectMapper();
		LoginDetails req= mapper.readValue(request, LoginDetails.class);
		String emailId=	req.getEmail();
		String newPass=req.getNewPassword();
		String passToken=RandomGenerator.randomAlphaNumeric(6);

		LoginDetails loginDetails=DaoImpl.getEmailDetails(emailId);
		if(!IsNullorEmpty.isNullOrEmpty(loginDetails)) {
			if(loginDetails.isActive()==true) {
				loginDetails.setNewPassword(newPass);
				loginDetails.setPasswordToken(passToken);
				DaoImpl.saveData(loginDetails);
				Activation.doAccountActivation(loginDetails);
				response.setResCode("0000");
				response.setResStatus("activation link sent successfully!");
			}

		}else {
			response.setErrorCode("1111");
			response.setErrorStatus("Email doesn't exist");
		}




		return response;

	}





	@GET
	@Path("/changePassword")
	@Produces(MediaType.APPLICATION_JSON)
	public ApiResponse changePassword(@QueryParam("key1") String email,@QueryParam("key2") String token) {

		//System.out.println("coming to get api to check whether the email is active or not before updating the password");

		ApiResponse response=new ApiResponse();
		LoginDetails loginDetails=DaoImpl.getActivationDetails(email,token);
		if(!IsNullorEmpty.isNullOrEmpty(loginDetails)&&loginDetails.isActive()==true) {

			loginDetails.setPassword(loginDetails.getNewPassword());
			loginDetails.setPasswordToken("");
			DaoImpl.saveData(loginDetails);
			response.setResCode("0000");
			response.setResStatus("password Change");

		}else {
			response.setErrorCode("1111");
			response.setErrorStatus("email not in active state");
		}


		return response;


	}







}
