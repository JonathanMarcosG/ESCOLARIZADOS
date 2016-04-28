/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Constantes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.VerificarDAO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Valida el periodo al cargar el home
 *
 * @author Chavitta
 */
public class ServletValPeriodo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a sefrvlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        
        String cadenaVig = VerificarDAO.period2(Constantes.BD_NAME,Constantes.BD_PASS);
        String[] validaVig = cadenaVig.split("&") ;
        
        
        if ("0".equals(validaVig[0].trim())) {
            out.write("si");
        } else {
            out.write(cadenaVig);
        }
        request.getSession().setAttribute("msgError", validaVig[1].trim());
    }

 /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletValPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
