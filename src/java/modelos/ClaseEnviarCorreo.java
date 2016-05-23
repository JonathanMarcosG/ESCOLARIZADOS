
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import beans.BMail;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;

/**
 *
 * @author Rocio
 */
public class ClaseEnviarCorreo {

    private MimeMultipart multipart = new MimeMultipart("related");
    private String origen = Constantes.MAIL_NOMBRE;
    private String contrasenia = Constantes.MAIL_PASS;
//    private String correo;
    //private final String asuntoIni = "Aspirante  Tecnológico de Toluca: Liga Para Registro.";
    //private final String asuntoPre = "Aspirante  Tecnológico de Toluca: Generar Preficha";
//    private String cuerpo;
    private String error = "correcto";

    /**
     *
     * @param context: Contexto del servlet para integrar las imagenes
     * @param sendTo: Destinatario del correo (aspirante)
     * @param cuerpo: Cuerpo del mensaje
     * @param asunto: Asunto del correo 1 -> El primer correo que envia la liga
     * de registro. 2 -> Liga para generar preficha
     * @return: Codigo de error/informacion del envio de correo
     * @throws Exception: Cualquier causa por la que no se enviara el correo.
     */
    public int sendMail(ServletContext context, String sendTo, String cuerpo, String asunto) throws Exception {
        int retorno = 0;
        addContent(formato(cuerpo));
        addImagen(context);
        addPDF(context);

        Session session = Session.getDefaultInstance(propiedades());
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(origen));
            InternetAddress toAddress = new InternetAddress(sendTo);

            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(asunto);
            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(Constantes.MAIL_HOST, origen, contrasenia);
            try {

                transport.sendMessage(message, message.getAllRecipients());

                transport.close();
                retorno = 0;
            } catch (MessagingException ex) {
                error = ex.getMessage();
                //System.out.println(ex.getCause());
                retorno = -1;
            }

        } catch (MessagingException me) {
            me.printStackTrace();
            error = me.getMessage();
            //System.out.println(me.getMessage());
            retorno = -2;
        }
        return retorno;
    }

    public boolean sendMailFin(ServletContext context, String sendTo, String cuerpo, String asunto) throws Exception {
        boolean retorno = false;

        addContent(formato(cuerpo));
        addImagen(context);

        Session session = Session.getDefaultInstance(propiedades());
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(origen));
            InternetAddress toAddress = new InternetAddress(sendTo);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(asunto);

            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect(Constantes.MAIL_HOST, origen, contrasenia);
            try {

                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                retorno = true;
            } catch (MessagingException ex) {
                error = ex.getMessage();
                //System.out.println(ex.getCause());
                retorno = false;
            }

        } catch (MessagingException me) {
            me.printStackTrace();
            error = me.getMessage();
            //System.out.println(me.getMessage());
            retorno = false;
        }
        return retorno;
    }

    public boolean sendMailContacto(ServletContext context, BMail beanMail, String to, boolean link, String asunto) throws Exception {
        boolean retorno = false;
        addContent(formato(beanMail.getCuerpo()));
        addImagen(context);
        Session session = Session.getDefaultInstance(propiedades());
        MimeMessage message = new MimeMessage(session);
        try {
//            message.setFrom(new InternetAddress(Constantes.MAIL_NOMBRE));
//            InternetAddress toAddress = new InternetAddress(Constantes.MAIL_NOMBRE);

            message.setFrom(new InternetAddress(origen));
            InternetAddress toAddress = new InternetAddress(to);

            message.addRecipient(Message.RecipientType.TO, toAddress);

            message.setSubject(asunto);
            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(Constantes.MAIL_HOST, origen, contrasenia);

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

    public Properties propiedades() {
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
        return props;
    }

    public String formato(String cuerpo) throws Exception {

        String content;

        String cabecera = new StringBuffer()
                .append("<html>")
                .append("<br>")
                .append("    <head>")
                .append("<br><br>")
                .append( "        <meta charset=\"UTF-8\">")
                .append("<br>")
                .append("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                .append("<br>")
                .append("    </head>")
                .append("<br>")
                .append("    <header style=\"position: relative;left:80px;\">")
                .append("<br>")
                .append("        <img src=\"cid:cidcabecera\">")
                .append("<br>")
                .append("        <pre style=\"font-family:'calibri'; font-size: 16px;\">")
                .append("<br>")
                .append("            Instituto Tecnológico de Toluca")
                .append("<br><br>")
                .append("            Centro de Cómputo")
                .append("<br><br>")
                .append("            Coordinación de Desarrollo de Sistemas")
                .append("<br>")
                .append("        </pre>")
                .append("<br>")
                .append("    </header>")
                .append("<br>")
                .append("    <body >").toString();

        String pie = new StringBuffer()
                .append(" </body>")
                .append("<br>")                
                .append("    <footer  style=\"position: relative;\" >")
                .append("<br>")
                .append("         <img src=\"cid:cidpie\">")
                .append("<br>")
                .append("    </footer>")
                .append("<br>")
                .append("</html>").toString();
        content = String.format("%s%s%s%s%s", cabecera, "<br/>", cuerpo, "<br/>", pie);

        return content;
    }

    public void addPDF(ServletContext context) throws Exception {
        String url_cab = "/PDF/Manual-CENEVAL.pdf";
        String cab_img = context.getRealPath(url_cab);
        BodyPart messageBodyPart = new MimeBodyPart();
        DataSource fds = new FileDataSource(cab_img);
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setFileName("Manual-CENEVAL.pdf");
        this.multipart.addBodyPart(messageBodyPart);
        
    }
    public void addImagen(ServletContext context) throws Exception {

        String url_cab = "/Imagenes/header_ittoluca.png";
        String cab_img = context.getRealPath(url_cab);
        String url_pie = "/Imagenes/footer_ittoluca.png";
        String pie_img = context.getRealPath(url_pie);
        addCID("cidcabecera", cab_img);
        addCID("cidpie", pie_img);
    }

    public void addContent(String htmlText) throws Exception {
        // first part (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(htmlText, "text/html");
        // add it
        this.multipart.addBodyPart(messageBodyPart);
    }

    public void addCID(String cidname, String pathname) throws Exception {
        DataSource fds = new FileDataSource(pathname);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(fds));
        messageBodyPart.setHeader("Content-ID", "<" + cidname + ">");
        this.multipart.addBodyPart(messageBodyPart);
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
}
