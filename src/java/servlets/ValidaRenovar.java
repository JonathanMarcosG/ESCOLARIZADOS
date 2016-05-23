/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import modelos.Constantes;
import PDF.CreatePreficha2;
import DAO.VerificarDAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

        
        String[] resValidoRenov;
        resValidoRenov = VerificarDAO.getValidoRenovar(Constantes.BD_NAME,Constantes.BD_PASS,curp).split("&");
        int valido = -1;

        CreatePreficha2 preficha = new CreatePreficha2();

        try {
            valido = Integer.parseInt(resValidoRenov[0]);
            

        } catch (NumberFormatException es) {
            sendDocument(response, preficha.noRenovar(getServletContext(), "Estimado aspirante, no hemos podido generar su preficha, le pedimos intentarlo más tarde."));
        }
        switch (valido) {
            case 0:
                //Valido renovar
                sendDocument(response,preficha.create(getServletContext(), curp));
                break;
            case 1:
                //No valido renovar
                String error1 = resValidoRenov[1];
                sendDocument(response,preficha.noRenovar(getServletContext(), error1));
                break;
            case 3:
                String error3 = resValidoRenov[1];
                sendDocument(response,preficha.noRenovar(getServletContext(), error3));
                break;
            default:
                String errorDef = resValidoRenov[1];
                sendDocument(response,preficha.noRenovar(getServletContext(), errorDef));
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
    
    public void sendDocument(HttpServletResponse response, ByteArrayOutputStream obj) throws IOException{
         
        response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentType("application/pdf");
            response.setContentLength(obj.size());
        try (OutputStream os = response.getOutputStream()) {
            obj.writeTo(os);
            os.flush();
            os.close();
        }
    }
}
