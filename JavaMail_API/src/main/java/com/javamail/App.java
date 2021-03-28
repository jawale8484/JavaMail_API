package com.javamail;
import java.util.*;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
	//This is responsible to send message
	private static void sendMail(String message, String subject, String to, String from) {
		
		//variable for gmail
		String host ="smtp.gmail.com";
		
		//get the system properties
		Properties properties=System.getProperties();
		
		//properties Object
		//set host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
			
		
		//step 1: to get session object...
	Session session=Session.getInstance(properties,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("*********@gmail.com", "****Password***");
			}
				
		}); 
	
	 //	session.setDebug(true);
	 	//step 2 : Compose the messsage
	 	MimeMessage msg =new MimeMessage(session);
	 	
	 	try {
	 		//from Email Id
			msg.setFrom(from);
			
			//Add Recipient
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Adding Subject
			msg.setSubject(subject);
			
			//Adding text to message
			msg.setText(message);
			
			//Send message using Transport class
			Transport.send(msg);
			
			System.out.println("Send Successfully.......");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
	 	
	}
	
	
	
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
        System.out.println("To:-");
        String to=sc.nextLine();
  //      String to = "**********e@gmail.com";
        
        System.out.println("Enter Subject-");
        String subject=sc.nextLine();
    //    String subject = "CodeByMe : JavaMailApi";
        
        System.out.println("Enter Message-");
        String message=sc.nextLine();
     //   String message = "Hello Dear, \n This  mail Sent through Java Code";
        
        System.out.println( "Preparing to Send Mail....." );
        String from ="*********@gmail.com";
        
        sendMail(message,subject,to,from);
    }

}
