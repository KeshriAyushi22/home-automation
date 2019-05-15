package ayu.arduino.service;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.*;



import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.LoginDetails;


public class Activation extends Authenticator {

	public static void doAccountActivation(LoginDetails request){

		String from = "22keshri.ayushi@gmail.com";   //mail id which dont have 2 way verification with phone.
		String to = request.getEmail();
		String password = "@Ayushi.keshri22";
		String token= request.getPasswordToken();

		String host = "127.0.0.1";//or IP address  

		//Get properties object    
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "587");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "587");    
		//get Session   

		if ((from != null) && (from.length() > 0) && (password != null) 
				&& (password.length   () > 0)) {
			Session session = Session.getDefaultInstance(props,    
					new javax.mail.Authenticator() {    
				protected PasswordAuthentication getPasswordAuthentication() {    
					return new PasswordAuthentication(from,password);  

				}    
			}); 

			//compose message    
			try {    
				MimeMessage message = new MimeMessage(session);  
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
				message.setSubject("new subject");    
				/*message.setText("your activation link is: "+ "http://localhost:48080/arduino/web/iot/changePassword?key1="+to+"&key2="+token);*/  
				message.setText("your activation link is: "+ "https://home-automation-iot.herokuapp.com/web/iot/changePassword?key1="+to+"&key2="+token);

				//send message  
				Transport.send(message);    
				System.out.println("message sent successfully");    
			} catch (MessagingException e) {
				throw new RuntimeException(e);}    


		} 



	}
}







