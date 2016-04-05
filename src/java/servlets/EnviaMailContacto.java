package servlets;

import ConexionBD.Constantes;
import beans.BMail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ClaseEnviarCorreo;

//Envia correo en  apartado de contacto  en  el home 
public class EnviaMailContacto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();    
        String nombre = new String(request.getParameter("txtNombre").getBytes("ISO-8859-1"), "UTF-8");
        String correo = new String(request.getParameter("txtEmail").getBytes("ISO-8859-1"), "UTF-8");
        String texto = new String(request.getParameter("txtDescripcion").getBytes("ISO-8859-1"), "UTF-8");
        BMail beanMail = new BMail();
        beanMail.setNombre(nombre);
        beanMail.setCorreo(correo);
        beanMail.setTexto(texto);
        ClaseEnviarCorreo m = new ClaseEnviarCorreo();

        boolean ret = m.sendMailContacto(beanMail, Constantes.MAIL_NOMBRE, false, Constantes.MAIL_ASUNTO_CONTACTO);
        if (ret) {
            out.write("s");
        } else {
            out.write("n");
        }
    }
}
