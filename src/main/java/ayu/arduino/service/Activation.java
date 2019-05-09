/*package ayu.arduino.service;

import java.util.Properties;


import javax.mail.Session;


import javax.mail.*;
import javax.mail.internet.*;


import ayu.arduino.to.LoginDetails;


public class Activation {

public static void doAccountActivation(LoginDetails request){
	 
	  
	      String from = "subhamnaik15@gmail.com";
	      String to = request.getEmail();
	      String password = "lucky1234567";
	      String userId= request.getUserId();

	      String host = "127.0.0.1";//or IP address  
	  
	    //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
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
           message.setSubject("Trying");    
           message.setText("your activation link is: "+ "http://localhost:48080/arduino/web/iot/activateAccount?key1="+to+"&key2=");  
           
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
	     
	   }  
	
	
	}
	

*/