/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Procedimientos;
import beans.BaseDatos;
import com.google.gson.Gson;
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
import modelos.llenarBD;

/**
 * 1.- Carga catalogo de Municipios 2.- Carga catalogo de localidades 3.- Carga
 * catalogos de Socioeconomicos
 *
 * @author ElyyzZ BaRruEtA
 */
public class CargaCatalogoServlet extends HttpServlet {

    llenarBD bd = new llenarBD();
    List<BaseDatos> estado;
    List<BaseDatos> NivelEstudios;
    List<BaseDatos> Dependencia;
    List<BaseDatos> Ocupaciones;
    List<BaseDatos> cuartos;
    List<BaseDatos> casa ;
    List<BaseDatos> numero = bd.llenaNumero();
    List<BaseDatos> Ingresos;
    List<BaseDatos> zona;
    BaseDatos catalogo = new BaseDatos();
    List<BaseDatos> municipio;
    List<BaseDatos> Localidad;
    List<BaseDatos> Estados;

    Procedimientos p = new Procedimientos();
    BaseDatos cat = new BaseDatos();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opc = request.getParameter("opcion");

        switch (opc) {
            case "1": //consulta catalogo de  municipios 
                CatalogoMunicipios(request, response);
                break;
            case "2"://consulta catalogo de localidades
                CatalogoLocalidades(request, response);
                break;
            case "3"://consulta catalogos  para  llenar combos  de  Datos_Socioeconomicos.jsp
                CatalogoSocioeconomicos(request, response);
                break;
            case "4"://Carga estados al cambiar el pais
                CatalogoEstados(request, response);
                break;
        }

    }

  
    private void CatalogoMunicipios(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pk = request.getParameter("pk");
            int foranea = Integer.parseInt(pk.trim());
            response.setContentType("text/html;charset=UTF-8");
            municipio = p.getCatalogos(3, foranea);
            municipio = cat.AgregaS(municipio);
            String json = null;
            json = new Gson().toJson(municipio);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CatalogoLocalidades(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pk = request.getParameter("pk");
            int foranea = Integer.parseInt(pk);
            response.setContentType("text/html;charset=UTF-8");
            Localidad = p.getCatalogos(9, foranea);
            Localidad = cat.AgregaS(Localidad);
            String json = null;
            json = new Gson().toJson(Localidad);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CatalogoEstados(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            Estados = p.getCatalogos(2, 0);//opcion estados
            Estados = cat.AgregaS(Estados);
            String json = null;
            json = new Gson().toJson(Estados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        } catch (SQLException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CatalogoSocioeconomicos(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            estado = p.getCatalogos(2, 0);
            estado = catalogo.AgregaS(estado);
            NivelEstudios = p.getCatalogos(4, 0);
            NivelEstudios = catalogo.AgregaS(NivelEstudios);
            Ocupaciones = p.getCatalogos(6, 0);
            Ocupaciones = catalogo.AgregaS(Ocupaciones);
            Dependencia = p.getCatalogos(5, 0);
            Dependencia = catalogo.AgregaS(Dependencia);
            casa = p.getCatalogos(14, 0);
            casa = catalogo.AgregaS(casa);
            cuartos = p.getCatalogos(15, 0);
            cuartos = catalogo.AgregaS(cuartos);
            Ingresos = p.getCatalogos(17, 0);
            Ingresos = catalogo.AgregaS(Ingresos);
            zona = p.getCatalogos(18, 0);
            zona = catalogo.AgregaS(zona);

            session.setAttribute("estado", estado);
            session.setAttribute("numero", numero);
            session.setAttribute("Ingresos", Ingresos);
            session.setAttribute("Dependencia", Dependencia);
            session.setAttribute("Ocupaciones", Ocupaciones);
            session.setAttribute("NivelEstudios", NivelEstudios);
            session.setAttribute("cuartos", cuartos);
            session.setAttribute("casa", casa);
            session.setAttribute("zona", zona);
        } catch (SQLException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
