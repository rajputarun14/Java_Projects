import java.util.Properties;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;

public class Email implements NotificationChannel {
    @Override
    public void sendNotification(NotificationRequest request)
    {
        final String username = "rajputkumararun12@gmail.com";
        final String password = "osnyacscnqmgprwq";

        Properties props = new Properties();
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session  = null;
        try{
            session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(request.getEmail()) // NotificationRequest me user ka email hona chahiye
            );
            message.setSubject("Notification");
            message.setText(request.getMessage());

            Transport.send(message);

            System.out.println("Real Email Sent Successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Notification Sent via Email");
    }
}
