/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import modelos.Constantes;
import DAO.ValidacionesDAO;
import beans.BMail;
import beans.FechaRenovar;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.ClaseEnviarCorreo;
import modelos.CuerpoCorreos;
import modelos.Encripta;
import modelos.GeneraAuditoria;

/**
 * Envía el primer correo de Verificación para continuar con el registro desde
 * un link
 *
 * @author ElyyzZ BaRruEtA
 */
public class EnviaEmailInicio extends HttpServlet {

    Encripta e = new Encripta();
    ArrayList<FechaRenovar> fechaList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            response.setContentType("text/html;charset=ISO-8859-1");
            request.setCharacterEncoding("UTF8");
            String correo = request.getParameter("correo");

            PrintWriter out = response.getWriter();
//            Procedimientos p = new Procedimientos();
            
            String CorreoEnc = e.encryptURL(correo);
            String Url=Constantes.URL;
            String UrlEnc = e.encryptURL(Url);
            String liga = Url + "?correo=" + CorreoEnc;

            //Obtenemos la cadena compuesta de la verificacion del correo 
            //  y la transformamos a vector
            String[] cadExiste = ValidacionesDAO.GetValidaCorreo(Constantes.BD_NAME,Constantes.BD_PASS,correo, UrlEnc).split("&");
            int existe = Integer.parseInt(cadExiste[0]);
            String msg = cadExiste[1].trim();
            
//            existe =0;
            switch (existe) {

                case 0:
                    BMail beanMail = new CuerpoCorreos().inicioRegistro(Constantes.APP_HOME, liga);

                    ClaseEnviarCorreo cec = new ClaseEnviarCorreo();
                    int ret = cec.sendMail(getServletContext(), correo, beanMail.getCuerpo(), Constantes.MAIL_ASUNTO_REGISTRO);
                    switch (ret) {

                        case 0:
                            out.print("Se ha enviado un enlace a su correo para continuar con su registro. Si no  logra  visualizar el correo en su bandeja  de  entrada no  olvide consultar  la  bandeja de correo no deseado.");
                            break;
                        case -1:
                            out.print("Su dirección de correo  electrónico es inválida. Vuelva a Intentarlo. Revise que este  bien escrita antes de dar clic en enviar");
                            break;
                        case -2:
                            msg = "No se  pudo enviar el correo. Por favor vuelva a intentarlo. Revise  que este escrito correctamente";
                            out.print(msg);
                            GeneraAuditoria ob = new GeneraAuditoria();
                            ob.crea_archivo("1961", "com.sun.mail.util.MailConnectException: Couldn't connect to host, port: mail.ittoluca.edu.mx, 25; timeout -1;", msg);
                            break;
                        default:
                            msg = "No se  pudo enviar el correo. Por favor vuelva a intentarlo. Revise  que este escrito correctamente";
                            out.print(msg);
                            GeneraAuditoria o = new GeneraAuditoria();
                            o.crea_archivo("654", "com.sun.mail.util.MailConnectException: Couldn't connect to host, port: mail.ittoluca.edu.mx, 25; timeout -1;", msg);
                            break;
                    }
                    
                    break;

                case 1:
                    // retorna  que ya existe correo
                    
                    out.print(msg);
                    GeneraAuditoria ob = new GeneraAuditoria();
                    ob.crea_archivo("1", "AUDITORIA, El aspirante con correo: " + correo + " ya se registro en esta convocatoria", msg);
                    
                    break;

                case 2:
                    out.print(msg);
                    GeneraAuditoria err2 = new GeneraAuditoria();
                    err2.crea_archivo("2", "AUDITORIA, Surgio un error al generar la liga para el aspirante con correo: " + correo, msg);
                    break;
                case 3:
                    BMail beanNoFichas = new CuerpoCorreos().inicioRegistro(Constantes.APP_HOME, liga);

                    //Mail m2 = new Mail();
                    ClaseEnviarCorreo cec2 = new ClaseEnviarCorreo();
                    
                    int ret2 = cec2.sendMail(getServletContext(),correo, beanNoFichas.getCuerpo(),Constantes.MAIL_ASUNTO_REGISTRO);
                    switch (ret2) {

                        case 0:
                            out.print("Se ha enviado un enlace a su correo para continuar con su registro. Si no  logra  visualizar el correo en su bandeja  de  entrada no  olvide consultar  la  bandeja de correo no deseado.");
                            break;
                        case -1:
                            out.print("Su dirección de correo no electrónico es inválida. Vuelva a Intentarlo. Revise que este  bien escrita antes de dar clic en enviar");
                            break;
                        case -2:
                            msg = "No se  pudo enviar el correo. Por favor vuelva a intentarlo. Revise  que este escrito correctamente";
                            out.print(msg);
                            GeneraAuditoria ob2 = new GeneraAuditoria();
                            ob2.crea_archivo("1961", "com.sun.mail.util.MailConnectException: Couldn't connect to host, port: mail.ittoluca.edu.mx, 25; timeout -1;", msg);
                            break;
                        default:
                            msg = "No se  pudo enviar el correo. Por favor vuelva a intentarlo. Revise  que este escrito correctamente";
                            out.print(msg);
                            GeneraAuditoria o = new GeneraAuditoria();
                            o.crea_archivo("654", "com.sun.mail.util.MailConnectException: Couldn't connect to host, port: mail.ittoluca.edu.mx, 25; timeout -1;", msg);
                            break;
                    }
                    break;
                case 6:
                    out.print(msg);
                    GeneraAuditoria err6 = new GeneraAuditoria();
                    err6.crea_archivo("6", "Surgio un error al revisar las fichas", msg);
                    break;
                default:
                    // error  inesperado al crear  la liga
                    //msg = "Ha ocurrido un error. Por favor  vuelve intentarlo.";
                    out.print(msg);
                    
                    GeneraAuditoria o = new GeneraAuditoria();
                    o.crea_archivo("---", "AUDITORIA   Error al crear la liga", msg);
                    break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(EnviaEmailInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EnviaEmailInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
