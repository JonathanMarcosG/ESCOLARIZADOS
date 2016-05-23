package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import PDF.CreatePreficha2;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
//Recupera  la  preficha  desde el apartado de Recuperar  preficha en el inicio
public class PrefichaPDF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String curp = new String(request.getParameter("curp").getBytes("ISO-8859-1"), "UTF-8");
       
        CreatePreficha2 pre2 = new CreatePreficha2();
        ByteArrayOutputStream baos=pre2.create(getServletContext(), curp);
        sendDocument(response, baos);
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
