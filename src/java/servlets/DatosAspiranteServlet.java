/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import modelos.Constantes;
import DAO.CatalogosDAO;
import beans.Combos;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Encripta;
import modelos.llenarCombos;

/**
 * Carga al dar clic en el enlace que se envia al correo del aspirante
 *
 * @author ElyyzZ BaRruEtA
 */
public class DatosAspiranteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    llenarCombos bd = new llenarCombos();
    Encripta en = new Encripta();
    Combos catalogo = new Combos();
    
    List<Combos> dia = bd.llenadia();
    List<Combos> mes = bd.llenames();
    List<Combos> anio = bd.llenaaño();
    List<Combos> promedio = bd.llenaPromedio();
    List<Combos> EdoCivil;
    List<Combos> Discapacidad;
    List<Combos> Escuela;
    List<Combos> sangre;
    List<Combos> pais;
    List<Combos> estado;

    List<Combos> opciones;
    List<Combos> opciones1;
    List<Combos> opciones2;
    List<Combos> opciones3;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        String Email = request.getParameter("correo");
        Email = en.decrypt(Email);
        pais = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,1, 0);
        pais = catalogo.AgregaS(pais);
        estado = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,2, 0);
        estado = catalogo.AgregaS(estado);
        Escuela = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,8, 0);
        Escuela = catalogo.AgregaS(Escuela);
        opciones = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,10, 0);
        opciones = catalogo.AgregaS(opciones);
        sangre = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,11, 0);
        sangre = catalogo.AgregaS(sangre);
        EdoCivil = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,12, 0);
        EdoCivil = catalogo.AgregaS(EdoCivil);
        Discapacidad = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,13, 0);
        Discapacidad = catalogo.AgregaS(Discapacidad);
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
