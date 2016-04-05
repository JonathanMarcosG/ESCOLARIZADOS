/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Procedimientos;
import beans.BaseDatos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Encripta;
import modelos.llenarBD;

/**
 * Carga al dar clic en el enlace que se envia al correo del aspirante
 *
 * @author ElyyzZ BaRruEtA
 */
public class DatosAspiranteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    llenarBD bd = new llenarBD();
    List<BaseDatos> dia = bd.llenadia();
    List<BaseDatos> mes = bd.llenames();
    List<BaseDatos> anio = bd.llenaaño();
    List<BaseDatos> EdoCivil;
    List<BaseDatos> Discapacidad;
    List<BaseDatos> Escuela;
    List<BaseDatos> sangre;
    List<BaseDatos> pais;
    List<BaseDatos> estado;
    List<BaseDatos> promedio = bd.llenaPromedio();

    List<BaseDatos> opciones;
    BaseDatos catalogo = new BaseDatos();
    List<BaseDatos> opciones1;
    List<BaseDatos> opciones2;
    List<BaseDatos> opciones3;
    Encripta en = new Encripta();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        String Email = request.getParameter("correo");
        Email = en.decrypt(Email);
        Procedimientos p = new Procedimientos();
        try {
            pais = p.getCatalogos(1, 0);
            pais = catalogo.AgregaS(pais);
            estado = p.getCatalogos(2, 0);
            estado = catalogo.AgregaS(estado);
            Escuela = p.getCatalogos(8, 0);
            Escuela = catalogo.AgregaS(Escuela);
            opciones = p.getCatalogos(10, 0);
            opciones = catalogo.AgregaS(opciones);
            sangre = p.getCatalogos(11, 0);
            sangre = catalogo.AgregaS(sangre);
            EdoCivil = p.getCatalogos(12, 0);
            EdoCivil = catalogo.AgregaS(EdoCivil);
            Discapacidad = p.getCatalogos(13, 0);
            Discapacidad = catalogo.AgregaS(Discapacidad);

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatosAspiranteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        opciones1 = opciones;
        opciones2 = opciones;
        opciones3 = opciones;
        HttpSession session = request.getSession(true);
        session.setAttribute("mes", mes);
        session.setAttribute("dia", dia);
        session.setAttribute("anio", anio);
        session.setAttribute("sangre", sangre);
        session.setAttribute("pais", pais);
        session.setAttribute("EdoCivil", EdoCivil);
        session.setAttribute("Discapacidad", Discapacidad);
        session.setAttribute("opciones1", opciones1);
        session.setAttribute("opciones2", opciones2);
        session.setAttribute("opciones3", opciones3);
        session.setAttribute("promedio", promedio);
        session.setAttribute("Escuela", Escuela);
        session.setAttribute("estado", estado);
        session.setAttribute("Email", Email);
        request.getSession().removeAttribute("aspirante");
        request.getSession().removeAttribute("AspDomicilio");
        request.getSession().removeAttribute("AspEscuela");
        request.getSession().removeAttribute("AspSocioecono");
        request.getSession().removeAttribute("contacto");

        request.getRequestDispatcher("/vistas/Aspirante/Datos_Aspirante.jsp").forward(request, response);
    }


}
