/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ConexionBD.Constantes;
import DAO.CatalogosDAO;
import beans.Spinner;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.llenarSpinner;

/**
 * 1.- Carga catalogo de Municipios 2.- Carga catalogo de localidades 3.- Carga
 * catalogos de Socioeconomicos
 *
 * @author ElyyzZ BaRruEtA
 */
public class CargaCatalogoServlet extends HttpServlet {

    llenarSpinner bd = new llenarSpinner();
    List<Spinner> estado;
    List<Spinner> NivelEstudios;
    List<Spinner> Dependencia;
    List<Spinner> Ocupaciones;
    List<Spinner> cuartos;
    List<Spinner> casa ;
    List<Spinner> numero = bd.llenaNumero();
    List<Spinner> Ingresos;
    List<Spinner> zona;
    Spinner catalogo = new Spinner();
    List<Spinner> municipio;
    List<Spinner> Localidad;
    List<Spinner> Estados;

    Spinner cat = new Spinner();

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
            municipio = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,3, foranea);
            municipio = cat.AgregaS(municipio);
            String json = null;
            json = new Gson().toJson(municipio);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CatalogoLocalidades(HttpServletRequest request, HttpServletResponse response) {
        try {
            String pk = request.getParameter("pk");
            int foranea = Integer.parseInt(pk);
            response.setContentType("text/html;charset=UTF-8");
            Localidad = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,9, foranea);
            Localidad = cat.AgregaS(Localidad);
            String json = null;
            json = new Gson().toJson(Localidad);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IOException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CatalogoEstados(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            Estados = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,2, 0);//opcion estados
            Estados = cat.AgregaS(Estados);
            String json = null;
            json = new Gson().toJson(Estados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        } catch (IOException ex) {
            Logger.getLogger(CargaCatalogoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void CatalogoSocioeconomicos(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        estado = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,2, 0);
        estado = catalogo.AgregaS(estado);
        NivelEstudios = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,4, 0);
        NivelEstudios = catalogo.AgregaS(NivelEstudios);
        Ocupaciones = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,6, 0);
        Ocupaciones = catalogo.AgregaS(Ocupaciones);
        Dependencia = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,5, 0);
        Dependencia = catalogo.AgregaS(Dependencia);
        casa = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,14, 0);
        casa = catalogo.AgregaS(casa);
        cuartos = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,15, 0);
        cuartos = catalogo.AgregaS(cuartos);
        Ingresos = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,17, 0);
        Ingresos = catalogo.AgregaS(Ingresos);
        zona = CatalogosDAO.getCatalogos(Constantes.BD_NAME,Constantes.BD_PASS,18, 0);
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

    }
}
