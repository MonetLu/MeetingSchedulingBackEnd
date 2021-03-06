package main.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * For security consideration, I closed this function in the mail server.
 */
public class EmailSendingUtils {

    /**
     * @param email
     * @param verificationCode
     * @return if successful 1, or 0
     */
    public static int sendVerificationCode(String email, String verificationCode) {


        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //sensitive information was eliminated.
                return new PasswordAuthentication("", "");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("meeting_scheduling@qq.com"));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));
            message.setSubject("Verification code");
            message.setText("Your verification code is " + verificationCode + ". \n\n     --from Meeting Scheduling team");
            Transport.send(message);
            return 1;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return 0;
        }
    }

    public static void main(String[] args) {
        int i = sendVerificationCode("", "8986");
        System.out.println(i);
    }

}
