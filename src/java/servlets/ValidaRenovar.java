/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.CreatePreficha2;
import ConexionBD.VerificaVigencia;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chris
 */
public class ValidaRenovar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String curp = request.getParameter("curpR");//.getBytes("ISO-8859-1"), "UTF-8");
        VerificaVigencia ver = new VerificaVigencia();

        
        String[] resValidoRenov;
        resValidoRenov = ver.getValidoRenovar(curp).split("&");
        int valido = -1;

        CreatePreficha2 preficha = new CreatePreficha2();

        try {
            valido = Integer.parseInt(resValidoRenov[0]);
            

        } catch (NumberFormatException es) {
            preficha.noRenovar(response, getServletContext(), "Estimado aspirante, no hemos podido generar su preficha, le pedimos intentarlo más tarde.");
            
        }
        switch (valido) {
            case 0:
                //Valido renovar
                preficha.create(response, getServletContext(), curp);
                break;
            case 1:
                //No valido renovar
                String error1 = resValidoRenov[1];
                preficha.noRenovar(response, getServletContext(), error1);
                break;
            case 3:
                String error3 = resValidoRenov[1];
                preficha.noRenovar(response, getServletContext(), error3);
                break;
            default:
                String errorDef = resValidoRenov[1];
                preficha.noRenovar(response, getServletContext(), errorDef);
                break;
        }
    }

 
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
