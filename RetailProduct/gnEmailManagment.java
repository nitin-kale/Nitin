package RetailProduct;

import javax.mail.Transport;

import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class gnEmailManagment {

	public void sendMailWithAttachement(String vreceiver, String filename) {

		String vdate = new gnDate().getBegindate();
		String vcomp = new gnConfig().getCompanycode();

		String recipient = vreceiver;
		String myAccountemail = "mymeretoo@gmail.com";
		String myPassword = "datgru99999";
		String sender = myAccountemail;

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountemail, myPassword);
			}
		});

		try {
			// MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From Field: adding senders email to from field.
			message.setFrom(new InternetAddress(sender));
			// Set To Field: adding recipient's email to from field.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			// Set Subject: subject of the email
			message.setSubject("Meretoo Data File");
			// creating first MimeBodyPart object
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("Hi , Please Check Attached File For Testing of Data Transfer == > Company code : "
					+ vcomp + " & Date Is :" + vdate);

			// creating second MimeBodyPart object
			BodyPart messageBodyPart2 = new MimeBodyPart();
			// String filename =
			// "D://AKN//BackupMySqlDB//FarmTrolly_MeretooBackup26062020115129.zip"
			// ;
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			// creating MultiPart object
			Multipart multipartObject = new MimeMultipart();
			multipartObject.addBodyPart(messageBodyPart1);
			multipartObject.addBodyPart(messageBodyPart2);
			// set body of the email.
			message.setContent(multipartObject);
			// Send email.
			Transport.send(message);
			new General().msg("Mail successfully sent");

		} catch (MessagingException r) {
			r.printStackTrace();
			new General().msg("Email Exception " + " " + r.getMessage());
			new gnLogger().loggerInfoEntry("SEND MAIL", r.getMessage());
		}
	}

}
