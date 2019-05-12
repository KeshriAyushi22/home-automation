package ayu.arduino.service;

import java.util.List;

import ayu.arduino.dao.DaoImpl;
import ayu.arduino.to.ApiResponse;
import ayu.arduino.to.House;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.to.Rooms;
import ayu.arduino.util.IsNullorEmpty;


public class Login {

	public static ApiResponse dologin(LoginDetails req) {

	
		ApiResponse response= new ApiResponse();
		if(!IsNullorEmpty.isNullOrEmpty(req.getEmail())) {
			LoginDetails detail=DaoImpl.getDetails(req);
			if(!IsNullorEmpty.isNullOrEmpty(detail)) {
				if(detail.isActive()==true) {
				response.setResCode("0000");
				response.setResStatus("Success");
				}else {
					response.setErrorCode("1111");;
					response.setErrorStatus("Email not active.");
				}

			}else {
				response.setErrorCode("1111");;
				response.setErrorStatus("Email doesnot exist.");
				
			}
		}else {
			response.setErrorCode("1111");;
			response.setErrorStatus("request packet empty"); 

		}

		return response;

	}
	
	public static ApiResponse HomeApi(LoginDetails req) {
		ApiResponse response= new ApiResponse();
		if(!IsNullorEmpty.isNullOrEmpty(req.getEmail())) {
			LoginDetails detail=DaoImpl.getDetails(req);
			if(!IsNullorEmpty.isNullOrEmpty(detail)) {
				if(detail.isActive()==true) {
					response.setHouse(detail.getHouse());
					response.setLoginName(detail.getLoginName());
				response.setResCode("0000");
				response.setResStatus("Success");
				}else {
					response.setErrorCode("1111");;
					response.setErrorStatus("Email not active.");
				}

			}else {
				response.setErrorCode("1111");;
				response.setErrorStatus("Email doesnot exist.");
				
			}
		}else {
			response.setErrorCode("1111");;
			response.setErrorStatus("request packet empty"); 

		}

		return response;
	}


}

