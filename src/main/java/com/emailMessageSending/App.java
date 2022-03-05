package com.emailMessageSending;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App{
	public static void main(String[] args) {
		System.out.println("Preparing to send message....");
		String message="Hello, This is message for security check";
		String subject="CodersArea: Confirmation";
		String to="ankurbhar2000@gmail.com";
		String from="testing18072000@gmail.com";
		
		//sendEmail(message, subject, to, from);
		sendAttach(message,subject,to,from);
	}
	
	//this method is reponsible for send attachment
	private static void sendAttach(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		
		//Variable for gmail host
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("Properties "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Step 1: to get the session object...
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("testing18072000","*********");
			}
			
		});
		
		session.setDebug(true);
		//Step 2: compose the message[text, multi media]
		
		MimeMessage msg = new MimeMessage(session);
		
		
		try {
			
			//from email
			msg.setFrom(from);
			
			//adding recipients
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			msg.setSubject(subject);
			
			//attachment...
			
			//file path
			String path = "C:\\Users\\ankur\\Desktop\\praveenphoto.jpg";
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			
			//text
			//file
			
			MimeBodyPart textMime = new MimeBodyPart();
			
			MimeBodyPart fileMime = new MimeBodyPart();
			
			try {
				textMime.setText(message);
				
				File file = new File(path);
				fileMime.attachFile(file);
				
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			msg.setContent(mimeMultipart);
			
			
			//send
			
			
			// Step 3: send the message using Transport class
			Transport.send(msg);
			
			System.out.print("Send success........");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// this is responsible to send email
	private static void sendEmail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub
		
		//Variable for gmail host
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("Properties "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Step 1: to get the session object...
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("testing18072000","Ank@88123");
			}
			
		});
		
		session.setDebug(true);
		//Step 2: compose the message[text, multi media]
		
		MimeMessage msg = new MimeMessage(session);
		
		
		try {
			
			//from email
			msg.setFrom(from);
			
			//adding recipients
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			msg.setSubject(subject);
			
			//adding text to message
			msg.setText(message);
			
			//send
			
			
			// Step 3: send the message using Transport class
			Transport.send(msg);
			
			System.out.print("Send success........");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}