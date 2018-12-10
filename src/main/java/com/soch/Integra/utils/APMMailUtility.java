package com.soch.Integra.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

import org.springframework.web.multipart.MultipartFile;

import com.soch.Integra.exception.APMException;

public class APMMailUtility {
	
	public static void main(String s[])
	{
		sendHTMLEmail("PleaseDoNotReply@soch-inc.com", "Test", "HEllo");
	}
	
	public static void sendHTMLEmail(String toEmail, String subject, String body) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("PleaseDoNotReply@soch-inc.com","enleetywyyizdtdm");
				}
			});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("PleaseDoNotReply@soch-inc.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmail));
			message.setSubject(subject);
			message.setContent(body, "text/html");
			

			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void generateString(String alias)
	{
		
		StringBuilder fromClause = new StringBuilder(" JOIN multivalue " + alias)
				.append(" ON " + alias + ".ParentTableID = " + 6)
				.append(" AND "+ alias + ".ParentID = o.ProjectID" )
				.append(" AND "+ alias + ".FieldID = 7214" );
		
				//.append(" AND " + alias + "." + MultiValue.getValueColumnForField(this.field))
				/*.append(" IN ('").append(Joiner.on("', '").join(this.getValues())).append("') ");
			searchObj.FROM += fromClause.toString();*/
		
		StringBuilder whereClause = new StringBuilder(" AND o.isAlive=1 GROUP BY o.ProjectID HAVING NumberOfMatches = " +2 + "ORDER BY o.ProjectID ASC LIMIT 100");
				
			
	}
	
	
	public static void  sendEmailAttachment(String fileName,String toAddresses)
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("PleaseDoNotReply@soch-inc.com","enleetywyyizdtdm");
				}
			});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("PleaseDoNotReply@soch-inc.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toAddresses));
			message.setSubject("Compare File");
			
			 BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("This is message body");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         DataSource source = new FileDataSource(fileName);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("policies.xls");
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart);
			

			Transport.send(message);


		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static boolean createFile(String location,MultipartFile file) throws APMException
	{
		File inputFile = new File(location);
		 if(!inputFile.exists())
		   {
			   inputFile.mkdir();
		   }
		 
		 location = location+"/"+file.getOriginalFilename();
		   inputFile =  new File(location);
			
				try {
					file.transferTo(inputFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					
					throw new APMException(e.getMessage());
				} finally {
					inputFile = null;
				}
		return true;		
	}
	
	public static boolean deleteFile(String filePath)
	{
		File deleteFile = new File(filePath);
		deleteFile.delete();
		return true;
	}

	public static boolean createFile(String location, String fileName, byte[] content) throws APMException {
		File inputFile = new File(location);
		 if(!inputFile.exists())
		   {
			   inputFile.mkdir();
		   }
		 
		 location = location+"/"+fileName;
		 
		   inputFile =  new File(location);
		   FileOutputStream fos = null;
				try {
					 fos = new FileOutputStream(new File(location));
					fos.write(content);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					
					throw new APMException(e.getMessage());
				} finally {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					inputFile = null;
				}
		return true;		
		
	}

}
