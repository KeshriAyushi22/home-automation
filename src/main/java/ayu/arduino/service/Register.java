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
import ayu.arduino.to.Mail;
import ayu.arduino.to.Rooms;



public class Register {

	public static void doRegisteration() throws FileNotFoundException, IOException {
		ApiResponse regResponse=new ApiResponse();

		/*//inserting data into login db.
		LoginDetails l= new LoginDetails();
		l.setEmail("ayushi1994keshri@gmail.com");
		l.setLoginName("ayushikeshri");
		l.setAndroidId("ayushiAndroid2");
		l.setPassword("PassWordayushi2");
		l.setToken("TokenAyushi2");

		//inserting 2 objects inside house db.
		House h= new House();
		h.setHouseName("House122");
		h.setAddress("Address122");
		h.setLoginDetails(l);   //since there is one mapping so add that object here.

		House h1= new House();
		h1.setHouseName("House NAME221");
		h1.setAddress("Address221");
		h1.setLoginDetails(l);   //since there is one mapping so add that object here.

		//for setting list of house to login details.
		List<House> list= new ArrayList<House>();
		list.add(h);
		list.add(h1);

		//since loginDetail object contains house as a list lets add that here and save it
		l.setHouse(list);
		

		//inserting data into rooms db.

		
		
		
		Appliance ap=new Appliance();
		ap.setFan("FanROOM112");
		ap.setLights("LightROOM112");
		ap.setPlug("PlugROOM112");
		

		Appliance ap2=new Appliance();
		ap2.setFan("Fan221ROOM");
		ap2.setLights("Light221ROOM");
		ap2.setPlug("Plug221ROOM");
		

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

		
		Mail m= new Mail();
		m.setLoginDetail(l);
		m.setActive("pending");
		m.setHash("UserId123");
		
		
		DaoImpl.saveData(ap);
		DaoImpl.saveData(ap2);
		DaoImpl.saveData(l);
		DaoImpl.saveData(r);
		DaoImpl.saveData(r2);
		DaoImpl.saveData(m);
		DaoImpl.saveData(h);  //saving parent class first and then its foreign key holding class(called as child class.)
		DaoImpl.saveData(h1);
	
*/
		
		/*2nd data*/
		LoginDetails login= new LoginDetails();
		login.setEmail("satyamnaik15@gmail.com");
		login.setLoginName("satyam");
		login.setAndroidId("null");
		login.setPassword("pass");
		login.setNotificationToken("token");

		//inserting 2 objects inside house db.
		House samHouse= new House();
		samHouse.setHouseName("satyamHouse");
		samHouse.setAddress("Marathalli");
		samHouse.setLoginDetails(login);   //since there is one mapping so add that object here.

		House visHouse= new House();
		visHouse.setHouseName("vishalHouse");
		visHouse.setAddress("Marathalli Brigde");
		visHouse.setLoginDetails(login  );   //since there is one mapping so add that object here.

		//for setting list of house to login details.
		List<House> listHouse= new ArrayList<House>();
		listHouse.add(samHouse);
		listHouse.add(visHouse);

		//since loginDetail object contains house as a list lets add that here and save it
		login.setHouse(listHouse);
		

		//inserting data into rooms db.

		
		
		
		Appliance samR1ap1=new Appliance();
		samR1ap1.setFan("fanRoom1");
		samR1ap1.setLights("lightRoom1");
		samR1ap1.setPlug("plugRoom1");
		

		Appliance samHallap=new Appliance();
		samHallap.setFan("fanHall");
		samHallap.setLights("LightHall");
		samHallap.setPlug("PlugHall");
		

		List<Appliance> listApp= new ArrayList<Appliance>();
		listApp.add(samR1ap1);
		listApp.add(samHallap);
		
		Rooms samR1= new Rooms();   
		samR1.setAppliance(listApp);
		samR1.setHouse(samHouse);
		
		
		samR1ap1.setRooms(samR1);
		
		
		Rooms samHall= new Rooms();
		samHall.setAppliance(null);
		samHall.setHouse(samHouse);
		
		samHallap.setRooms(samHall);
		
		//for setting list of rooms to house details.
		List<Rooms> listRooms= new ArrayList<Rooms>();
		listRooms.add(samR1);//making list of rooms to store it in house db.
		listRooms.add(samHall);
		samHouse.setRooms(listRooms);

		
		Mail mail= new Mail();
		mail.setLoginDetail(login);
		mail.setActive("pending");
		mail.setHash("Sam123");
		
		
		DaoImpl.saveData(samR1ap1);
		DaoImpl.saveData(samHallap);
		DaoImpl.saveData(login);
		DaoImpl.saveData(samR1);
		DaoImpl.saveData(samHall);
		DaoImpl.saveData(mail);
		DaoImpl.saveData(samHouse);  //saving parent class first and then its foreign key holding class(called as child class.)
		DaoImpl.saveData(visHouse);
	







		











			}

		






	}


