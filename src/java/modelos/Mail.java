package modelos;

import ConexionBD.Constantes;
import beans.BMail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    MimeMultipart multipart = new MimeMultipart("related"); //Para agrgar imagenes de header/footer 

    public boolean sendMail(BMail beanMail, String to, boolean link, String asunto) {
        boolean retorno = false;
        Properties props = System.getProperties();
        props.setProperty("mail.mime.charset", "ISO-8859-1");
        
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", Constantes.MAIL_HOST);
        props.put("mail.smtp.user", Constantes.MAIL_NOMBRE);
        props.put("mail.smtp.password", Constantes.MAIL_PASS);
        props.put("mail.smtp.port", Constantes.MAIL_PORT);
        props.put("mail.smtp.localhost", "sia.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", Constantes.MAIL_HOST);
        props.put("mail.smtp.ehlo", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(Constantes.MAIL_NOMBRE));
            InternetAddress toAddress = new InternetAddress(Constantes.MAIL_NOMBRE);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(asunto);
            message.setText("Cuerpo");

            if (link == true) {
                message.setText(beanMail.getCuerpo(), "ISO-8859-1", "html");
            } else {

                String nom = beanMail.getNombre();
                String corr = beanMail.getCorreo();
                String mens = beanMail.getTexto();

                String mensaje = "Enviando un correo\n\n"
                        + "Nombre: " + nom + "\n"
                        + "Correo: " + corr + "\n\n"
                        + "Mensaje:\n" + mens + "\n";

                message.setText(mensaje);

            }
            Transport transport = session.getTransport("smtp");
            transport.connect(Constantes.MAIL_HOST, Constantes.MAIL_NOMBRE, Constantes.MAIL_PASS);

            try {
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                retorno = true;
            } catch (MessagingException ex) {
                
                retorno = false;
            }
        } catch (MessagingException me) {
            me.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
}
