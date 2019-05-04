package ayu.arduino.service;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ayu.arduino.dao.DaoImpl;
import ayu.arduino.to.ApiResponse;
import ayu.arduino.to.Appliance;
import ayu.arduino.to.House;
import ayu.arduino.to.LoginDetails;
import ayu.arduino.to.Rooms;



public class Register {

	public static void doRegisteration() throws FileNotFoundException, IOException {
		ApiResponse regResponse=new ApiResponse();

		//inserting data into login db.
		LoginDetails l= new LoginDetails();
		l.setEmail("satyamNew@gmail.com");
		l.setLoginName("satyamnew");
		l.setAndroidId("Androidsatyamnew");
		l.setPassword("PassWordsatyamnew");
		l.setToken("TokenNew1");

		//inserting 2 objects inside house db.
		House h= new House();
		h.setHouseName("House3");
		h.setAddress("Address3");
		h.setLoginDetails(l);   //since there is one mapping so add that object here.

		House h1= new House();
		h1.setHouseName("House NAME4");
		h1.setAddress("Address 4");
		h1.setLoginDetails(l);   //since there is one mapping so add that object here.

		//for setting list of house to login details.
		List<House> list= new ArrayList<House>();
		list.add(h);
		list.add(h1);

		//since loginDetail object contains house as a list lets add that here and save it
		l.setHouse(list);
		

		//inserting data into rooms db.

		
		
		
		Appliance ap=new Appliance();
		ap.setFan("FanROOM1");
		ap.setLights("LightROOM1");
		ap.setPlug("PlugROOM1");
		

		Appliance ap2=new Appliance();
		ap2.setFan("Fan2ROOM");
		ap2.setLights("Light2ROOM");
		ap2.setPlug("Plug2ROOM");
		

		List<Appliance> listAp= new ArrayList<Appliance>();
		listAp.add(ap);
		listAp.add(ap2);
		
		Rooms r= new Rooms();
		r.setAppliance(listAp);
		r.setHouse(h);
		
		
		ap.setRooms(r);
		ap2.setRooms(r);
		
		Rooms r2= new Rooms();
		r.setAppliance(null);
		r.setHouse(h1);
		
		
		//for setting list of rooms to house details.
		List<Rooms> listRoom= new ArrayList<Rooms>();
		listRoom.add(r);//making list of rooms to store it in house db.
		listRoom.add(r2);
		h.setRooms(listRoom);

		
		DaoImpl.saveData(ap);
		DaoImpl.saveData(ap2);
		DaoImpl.saveData(l);
		DaoImpl.saveData(r);
		DaoImpl.saveData(r2);
		DaoImpl.saveData(h);  //saving parent class first and then its foreign key holding class(called as child class.)
		DaoImpl.saveData(h1);
		








		
/*		LoginDetails l= new LoginDetails();
		l.setLoginId(98);
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
		DaoImpl.saveData(h1);*/	












			}

		






	}


