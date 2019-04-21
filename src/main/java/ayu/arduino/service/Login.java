package ayu.arduino.service;

import java.util.List;

import ayu.arduino.dao.DaoImpl;
import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.ApiResponse;
import ayu.arduino.to.LoginDetails;


public class Login {

	public static List<LoginDetails> dologin(LoginDetails req) {
	
		ApiResponse response =new ApiResponse();
	List<LoginDetails> list=DaoImpl.getDetails(req);
			
	
	
		return list;
	}
}

