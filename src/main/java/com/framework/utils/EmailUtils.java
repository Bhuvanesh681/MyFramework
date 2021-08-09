package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.framework.constants.FrameworkConstants;
import com.framework.utils.TestGlobal;

public class EmailUtils {

	public static Logger logger ;
	
	
	
	public static void sendEmailReportWithAttachment(final String userID, final String userPass, final String emailTo) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.cfinsdev.com");
		props.put("mail.smtp.port", "25");
		//props.put("mail.smtp.host", "mail.cfins.com"); 
		//props.put("mail.smtp.port","25");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userID, userPass);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
	    	String pattern = "EEE, d MMM yyyy HH:mm:ss Z";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			message.setSubject("Automation Execution Report.." +date);
			Multipart multipart = new MimeMultipart();
			//String filePath=FrameworkConstants.getExtentReportFilePath();
			String filePath="C:/Users/bsikarwar/eclipse-workspace/CyberToDCTAutomation/extent-test-output";
			String fileName = "index.html";
			System.out.println(filePath+"  "+fileName);
			addAttachment(multipart, filePath, fileName);
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("This is an auto-generated email, no need to reply.");
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
			Exception ex = null;
		      if ((ex = e.getNextException()) != null) {
		    ex.printStackTrace();
		      }
		}
	}

	public static void sendEmailLogsWithAttachment(final String userID, final String userPass, final String emailTo) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.cfinsdev.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userID, userPass);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			
			String pattern = "EEE, d MMM yyyy HH:mm:ss Z";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			message.setSubject("Automation Execution Logs.." +date);

			Multipart multipart = new MimeMultipart();
			//String filePath = "C:\\CnF_CL_Workspace\\projectname\\";
			String filePath=FrameworkConstants.getExtentReportFilePath();
			String fileName = "CyberToDCT.html";
			
			addAttachment(multipart, filePath, fileName);

			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("This is an auto-generated email, no need to reply.");
			multipart.addBodyPart(messageBodyPart1);

			message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	//AttachMultiPleFiles
	//@Author: Abhishek Banerjee
	public static void sendEmailWithMultipleAttachments(final String userID, final String userPass, final String emailTo) {	
	
		TestGlobal.sleepDuringExecution(9000);
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.cfinsdev.com");
		props.put("mail.smtp.port", "25");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userID, userPass);
			}
		});
        
		try {
			Message msg = new MimeMessage(session);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			
			String pattern = "EEE, d MMM yyyy HH:mm:ss Z";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			msg.setSubject(" Automation Execution Logs.." +date);
			
			String reportAttachment=FrameworkConstants.getExtentReportFilePath();
			//String logAttachment=TestUtil.LOGPATH;
			//String resultAttachment=TestUtil.RESULT_PATH;
			
			String [] attachMents= {reportAttachment};
			
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setContent("Please find attached Report,Log and Result", "text/html");
	 
	        // creates multi-part
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        TestGlobal.sleepDuringExecution(60000);
	        // adds attachments
	        if (attachMents != null && attachMents.length > 0) {
	            for (String filePath : attachMents) {
	                MimeBodyPart attachPart = new MimeBodyPart();
	 
	                try {
	                    attachPart.attachFile(filePath);
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	 
	                multipart.addBodyPart(attachPart);
	            }
	        }
	        
	        // sets the multi-part as e-mail's content
	        msg.setContent(multipart);
	 
	        // sends the e-mail
	        Transport.send(msg);
	
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static void addAttachment(Multipart multipart, String filePath, String fileName){
		DataSource source = null;
		File f = new File(filePath +"/"+ fileName);
		if(f.exists() && !f.isDirectory()) {
			source = new FileDataSource(filePath +"/"+ fileName);
			BodyPart messageBodyPart = new MimeBodyPart();
			try {
				messageBodyPart.setHeader("Content-Type", "text/html");
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(fileName);
				multipart.addBodyPart(messageBodyPart);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
}
