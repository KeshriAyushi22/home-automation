package ayu.arduino.service;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.*;



import ayu.arduino.to.ApiRequest;
import ayu.arduino.to.LoginDetails;


public class Activation {

public static void doAccountActivation(LoginDetails request){
	 
	  
	     /* String to = "satyamnaik15@gmail.com";
	      String from = "ayushi1994keshri@gmail.com";
	      String host = "localhost";//or IP address  
	  
	     //Get the session object  
	      Properties properties = System.getProperties();  
	      properties.setProperty("mail.smtp.host", host);  
	      Session session = Session.getDefaultInstance(properties);  
	  
	     //compose the message  
	     
	      try
		    {
		      MimeMessage msg = new MimeMessage(session);
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");

		      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

		      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

		      msg.setSubject("subject", "UTF-8");

		      msg.setText("body", "UTF-8");

//		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
		      System.out.println("Message is ready");
	    	  Transport.send(msg);  

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
             
	     
	   }  */

		 
		  
		      String from = "subhamnaik15@gmail.com";   //mail id which dont have 2 way verification with phone.
		      String to = request.getEmail();
		      String password = "lucky1234567";
		      String token= request.getPasswordToken();

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
	           message.setSubject("new subject");    
	           message.setText("your activation link is: "+ "http://localhost:48080/arduino/web/iot/changePassword?key1="+to+"&key2="+token);  
	           
	           //send message  
	           Transport.send(message);    
	           System.out.println("message sent successfully");    
	          } catch (MessagingException e) {
	        	  throw new RuntimeException(e);}    
	             
		     
		   }  
		
		
		}
		


	
	
	

