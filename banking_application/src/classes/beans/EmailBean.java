package beans;


import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailBean {
	public void approve(Long acc_no,int cid,String pwd ,String email)
	{
		String msg=  ( "Dear Customer,\n All the verifications are completed and you are ready to use your account.\n Your account credentials are provided below.\n\n Account Number:"+acc_no+"\n\n Customer ID:"+cid+"\n\nPassword:"+pwd) ;
		String subject="Wells Fargo Bank - Your account is activated successfully";
		send_mail(msg,email,subject);
	}
	public void send_mail(String msg,String email,String subject)
	{
	 
        //Get properties object    
        Properties props = new Properties();    
		  props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.port", "587");
        //get Session   
        Session s = Session.getInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("wellsfargo.bank03@gmail.com","wellsfargo1");  
         }    
        });    
        //compose message    
        try {    
      	   
      	  Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress("wellsfargo.bank03@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
 				InternetAddress.parse(email));
			message.setSubject(subject);
			//String msg=  ( "Dear Mail Crawler,"+ "\n\nAccount Number:"+acc_no+"\n\n Transaction Password:"+transaction_id) ;
	  				
			//msg= msg.concat(acc_no);
			message.setText(msg);

			Transport.send(message);  
	
System.out.println("sent");
		} catch (MessagingException e) {
			e.printStackTrace();
		} 

		
	}
}