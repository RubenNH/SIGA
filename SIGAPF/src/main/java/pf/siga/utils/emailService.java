package pf.siga.utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.ResourceBundle;

public class emailService {
    ResourceBundle authenticationProperties;
    String email;
    String password;
    String host;
    String port;
    String enable;
    String auth;

    public boolean sendEmail(String username) {
        if (authenticationProperties == null) {
            authenticationProperties =
                    ResourceBundle.getBundle("mail_props");
            email = authenticationProperties.getString("email");
            password = authenticationProperties.getString("password");
            host = authenticationProperties.getString("host");
            port = authenticationProperties.getString("port");
            enable = authenticationProperties.getString("enable");
            auth = authenticationProperties.getString("auth");
        }
        System.out.println(email);
        System.out.println(password);
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", enable);

        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email, password);
                    }
                });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email,
                    "SP | Recuperación de contraseña"));
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(username));
            message.setSubject("Recuperar contraseña");
            message.setContent("<strong>" +
                    "Correo enviado desde Servlets" +
                    "</strong>","text/html");
            Transport.send(message);
            return true;
        }catch (AddressException e){
            System.out.println("Error AddressException");
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("Error MessagingException");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error UnsupportedEncodingException");
            e.printStackTrace();
        }
        return false;
    }
}