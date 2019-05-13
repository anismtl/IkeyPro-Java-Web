package ca.ikeypro.Utilitaire;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Anis
 */
public class MailManager {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    private static void SendEmail(String to, String sujet, String mess) throws AddressException, MessagingException {
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        generateMailMessage.setSubject(sujet);
        generateMailMessage.setContent(mess, "text/html");
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "ikeyprofessionnel@gmail.com", "iKeyProfessionnel123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    public static void SendConfirmation(String to, String tx, int idCommande, String Montant) {

        String suje = (" Confirmation paiement commande N : " + idCommande);
        String Message = ("<b>Bonjour,</b>");
        Message += ("\n <br/>Vous avez envoyé un paiement d’un montant de $" + Montant + " CAD à ikeypro.ca<br/>");
        Message += ("\n <br/>numero de transaction :" + tx + "<br/>");
        Message += ("<br/>Cordialement, ");
        Message += ("<br/>IkeyPro.ca ");

        try {
            SendEmail(to, suje, Message);
        } catch (MessagingException ex) {
            Logger.getLogger(MailManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void SendContactMail(String email, String from, String telephone, String mess) {
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd à HH:mm:ss").format(new Date());
        String sujet = (" Message envoyé par : " + from);
        String Message = ("<b>Message Envoyé par : </b>" + from);
        Message += ("\n <br/><b>Le : </b>" + timeStamp);
        Message += ("\n <br/><b>Email : </b>" + email);
        Message += ("\n <br/><b>Téléphone : </b>" + telephone);
        Message += ("\n <br/>------------------------------------------------");
        Message += ("\n <br/><b>Message:</b><br/>" + mess);

        String Message2 = ("Bonjour " + from + ",");
        Message2 += ("<br/>Nous avons bien reçu votre requête et allons vous répondre dans les plus brefs délais.");
        Message2 += ("<br/>Cordialement, ");
        Message2 += ("<br/>IkeyPro.ca ");

        try {
            SendEmail("aboutekadjiret@yahoo.fr", sujet, Message);
            SendEmail(email, "Confirmation", Message2);
        } catch (MessagingException ex) {
            Logger.getLogger(MailManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void SendNewsletterInscrisption(String Courriel) {

        String sujet = (" Confirmation Inscription Newsletter Ikeypro.ca. ");
        String Message = ("<b>Bonjour,</b>");
        Message += ("\n <br/>Vous avez envoyé une demande dinscrption a la news lettre .<br/>");
        Message += ("\n <br/>Inscription effectuée<br/>");
        Message += ("<br/>Cordialement, ");
        Message += ("<br/>IkeyPro.ca ");

        try {
            SendEmail(Courriel, sujet, Message);
        } catch (MessagingException ex) {
            Logger.getLogger(MailManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void SendNewsletterSupression(String Courriel) {

        String sujet = (" Confirmation Supression Newsletter Ikeypro.ca. ");
        String Message = ("<b>Bonjour,</b>");
        Message += ("\n <br/>Vous avez envoyé une demande de supréssion de la news lettre .<br/>");
        Message += ("\n <br/>Supression effectuée<br/>");
        Message += ("<br/>Cordialement, ");
        Message += ("<br/>IkeyPro.ca ");

        try {
            SendEmail(Courriel, sujet, Message);
        } catch (MessagingException ex) {
            Logger.getLogger(MailManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
