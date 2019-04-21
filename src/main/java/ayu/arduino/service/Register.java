package ayu.arduino.service;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.sun.research.ws.wadl.Request;

import ayu.arduino.dao.DaoImpl;
import ayu.arduino.to.ApiResponse;
import ayu.arduino.to.House;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.util.IsNullorEmpty;



public class Register {

	public static void doRegisteration() throws FileNotFoundException, IOException {
		ApiResponse regResponse=new ApiResponse();
		LoginDetails l= new LoginDetails();
		l.setEmail("ayush@gmail.com");
		l.setLoginName("ayush");
		l.setAndroidId("android");
		l.setPassword("pass");
		l.setToken("token1");

		House h= new House();
		h.setHouseId("101");
		h.setAddress("kolkata");
		h.setLoginDetails(l);
		
		House h1= new House();
		h1.setHouseId("201");
		h1.setAddress("varanasi");
		h1.setLoginDetails(l);
		

//		List<House> list= new ArrayList<House>();
//		list.add(h);
//		list.add(h1);

//		l.setHouse(list);
		DaoImpl.saveData(l);
		DaoImpl.saveData(h);
		DaoImpl.saveData(h1);
		












	}

}
