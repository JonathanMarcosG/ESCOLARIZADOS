/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import PDF.CreatePreficha2;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import modelos.Encripta;

/**
 * Genera la preficha al terminar de guardar los datos del aspirante
 * desencriptandola primero
 *
 * @author ElyyzZ BaRruEtA
 */
public class PrefichaGenerar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Encripta e = new Encripta();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("application/pdf");
//        String curp = request.getParameter("curp");
//        curp = e.decrypt(curp);
//        CreatePreficha2 preficha = new CreatePreficha2();
//        ByteArrayOutputStream obj=preficha.create(getServletContext(), curp);
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
        String curp = request.getParameter("curp");
        curp = e.decrypt(curp);
        CreatePreficha2 preficha = new CreatePreficha2();
        ByteArrayOutputStream obj=preficha.create(getServletContext(), curp);
//        processRequest(request, response);
        sendDocument(response, obj);
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
