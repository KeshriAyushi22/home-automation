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

		List<Rooms> rooms=null;




		ApiResponse response= new ApiResponse();
		if(!IsNullorEmpty.isNullOrEmpty(req.getEmail())) {
			LoginDetails detail=DaoImpl.getDetails(req);
			
			
			if(!IsNullorEmpty.isNullOrEmpty(detail)&& detail.isActive()==true) {
				List<House> houseList= detail.getHouse();
				for(House house:houseList) {
					rooms=  house.getRooms();

				}
				response.setRooms(rooms);
				response.setHouse(houseList);	
				response.setResCode("0000");
				response.setResStatus("Success");



			}else {
				response.setErrorCode("1111");;
				response.setErrorStatus("Email is inactive");
				
			}
		}else {
			response.setErrorCode("1111");;
			response.setErrorStatus("no Data Found"); 

		}

		return response;

	}


}

