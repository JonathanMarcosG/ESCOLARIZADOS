<%-- 
    Document   : datos_socioeconomicos
    Created on : 8/07/2014, 11:41:05 AM
    Author     : ElyyzZ BaRruEtA
--%>

<%@page language="java" contentType="text/html" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/JQueryClases/PAES_js.js" type="text/javascript"></script>
<link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">

<title>DATOS|SOCIOECONOMICO</title>
<form>
    <div id="tutor">
        <div id="datostutor" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" style="background-color: #fff">
            <div id="pestana_tutor">
                <ul id="ul_tutor" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                <p id="li_tutor" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                <a id="ui_tutor" class="ui-tabs-anchor" role="presentation" tabindex="-1">Datos del tutor</a>
                </p>
                </ul>
                <section  id="datos_padres">
                <fieldset class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" >
                <p id="izquierdo_padres"><label id="etq_nompa" class="labels_socioeconomicos">Nombre Completo del Padre:</label>
                <input type="text" name="nom_padre" id="nom_padre" class="inputs_socioeconomicos" maxlength="70">
                <label  id="etq_nomma" class="labels_socioeconomicos">Nombre Completo de la Madre:</label>                           
                <input type="text" name="nom_madre" id="nom_madre" class="inputs_socioeconomicos" maxlength="70" ></p>                      
                <label id="etq_vivema" class="vive">Vive:</label>
                <input id="padre_viveSi" name="VivePadre" class="RadiosVive"  type="radio" value="S">                       
                <label id="etq_vivema" class="SiNo">Si</label>
                <input id="padre_viveNo" name="VivePadre" class="RadiosVive" type="radio" value="N">                       
                <label id="etq_vivema" class="SiNo">No</label>
                <label id="etq_vivepa" class="vive">Vive:</label>
                <input id="madre_viveSi" name="ViveMadre"  class="RadiosVive" type="radio" value="S">                        
                <label id="etq_vivema" class="SiNo" >Si</label>
                <input id="madre_viveNo"  name="ViveMadre"  class="RadiosVive" type="radio" value="N">                       
                <label id="etq_vivema" class="SiNo">No</label>
                </p>  
                </fieldset>
                </section>                
                <div>
                    <section id="datos_emergencia" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                    <fieldset>
                    <p>
                    <label id="etq_emergencia" class="labels_socioeconomicos">En Emergencia Llamar a 
                    (Nombre y Apellidos):</label> 
                    <input type="text" name="contacto_emergencia" id="contacto_emergencia" class="inputs_socioeconomicos" maxlength="150">                                             
                    <label id="etq_estado" class="labels_socioeconomicos">Estado:</label>
                    <select  id="estado" class="Selects_socioeconomicos">
                    <c:forEach items="${estado}" var="estado">                                     
                    <option value="${estado.getClave()}"><c:out value="${estado.getNombre()}"/></option>                                                                           
                    </c:forEach>
                    </select>
                    <label id="etq_ciudad"  class="labels_socioeconomicos">Municipio:</label> 
                    <select  id="ciudad" type="text"name=" input_ciudad" class="Selects_socioeconomicos" >
                    <option value="--">--Seleccione--</option>
                    </select>
                    <label id="eq_colonia" class="labels_socioeconomicos">Colonia:</label>
                    <input type="text" name="colonia" id="colonia" class="inputs_socioeconomicos" maxlength="45">
                    <label id="etq_calle" class="labels_socioeconomicos">Calle:</label>
                    <input type="text" name="calle" id="calle" class="inputs_socioeconomicos" maxlength="45">
                    <label name="socio_numext" class="labels_socioeconomicos">Núm. Exterior:</label>
                    <input type="text" id="socionumext" name="input_numExt" class="inputs_socioeconomicos" maxlength="5">
                    <label name="socionumInt" class="labels_socioeconomicos">Núm. Interior:</label>
                    <input type="text" id="socionumInt" name="input_numInt" class="inputs_socioeconomicos" maxlength="5">
                    <label name="socio_codpos" class="labels_socioeconomicos">Código Postal:</label>
                    <input type="text" id="sociocodpost" name="input_codpost" class="inputs_socioeconomicos" maxlength="5">
                    <label id="etq_telfijo" class="labels_socioeconomicos">Teléfono Fijo (LADA incluida):</label>
                    <input type="text" name="tel_fijo" id="tel_fijo" class="inputs_socioeconomicos" maxlength="13" placeholder="(01-714)-1438193">
                    <label id="etq_telcel" class="labels_socioeconomicos">Teléfono Celular (LADA incluida):</label>
                    <input type="text" name="tel_cel" id="tel_cel" class="inputs_socioeconomicos" maxlength="13" placeholder="(044)-7225586956">                        
                    <label id="etq_teltrabajo" class="labels_socioeconomicos">Teléfono del Centro de Trabajo:</label>
                    <input type="text" name="tel_trabajo" id="tel_trabajo" class="inputs_socioeconomicos" maxlength="13" placeholder="(01-714)-1438193"></p>
                    <label id="etq_centrab" class="labels_socioeconomicos">Nombre del Centro de Trabajo:</label>
                    <input type="text" name="cent_trabajo" id="cent_trabajo" class="inputs_socioeconomicos" maxlength="200">
                    </fieldset>
                    </section>
                </div>
            </div>
        </div>
        <br>
        <div id="datosbeca" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" style="background-color: #fff">
            <div id="pestana_beca">
                <ul id="ul_beca" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                <p id="li_beca" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                <a id="ui-beca" class="ui-tabs-anchor" role="presentation" tabindex="-1">Datos Socioeconomicos</a>
                </p>
                </ul>
                <section id="socioeconomicos_superior" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" >
                <fieldset id="beca_superior">
                <label id="etq_beca" class="labels_socioeconomicos">¿Cuentas con Alguna Beca?</label>
                <Select type="text" name="beca" id="beca" class="inputs_socioeconomicos" onblur="tipobeca()">
                <option value="">--Seleccione--</option>
                <option value="S">Si</option>
                <option value="N">No</option>
                </select>                                           
                </fieldset>
                <fieldset id="beca_cual" style="display: none">
                <label id="etq_becacual" class="labels_socioeconomicos">Tipo de Beca</label>
                <input type="text" name="beca" id="beca_tipo" class="inputs_socioeconomicos" maxlength="50">
                </fieldset>
                </section>
                <section id="socioeconomicos_inferior" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all"> 
                <fieldset>
                <p>
                <label id="etq_zona" class="labels_socioeconomicos">Zona de Procedencia:</label>
                <select type="text" name="zona" id="zona" class="inputs_socioeconomicos">
                <c:forEach items="${zona}" var="zona">                                     
                <option value="${zona.getClave()}"><c:out value="${zona.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_estudios_padre" class="labels_socioeconomicos">Máximo Nivel Estudios del Padre:</label>
                <select type="text" name="estudios_padre" id="estudios_padre" class="inputs_socioeconomicos">
                <c:forEach items="${NivelEstudios}" var="NivelEstudios">                                     
                <option value="${NivelEstudios.getClave()}"><c:out value="${NivelEstudios.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_estudios_madre" class="labels_socioeconomicos">Máximo Nivel de Estudios de la Madre:</label>
                <select type="text" name="estudios_madre" id="estudios_madre" class="inputs_socioeconomicos">
                <c:forEach items="${NivelEstudios}" var="NivelEstudios">                                     
                <option value="${NivelEstudios.getClave()}"><c:out value="${NivelEstudios.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="Ingresos" class="labels_socioeconomicos">Ingresos Familiares Mensuales:</label>
                <select id="input_ingresos" type="text"  class="inputs_socioeconomicos" >
                <c:forEach items="${Ingresos}" var="Ingresos">                                     
                <option value="${Ingresos.getNombre()}"><c:out value="${Ingresos.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_ocpadre" class="labels_socioeconomicos">Ocupación del Padre:</label>
                <select class="Selects_economico" id="input_ocpadre"> 
                <c:forEach items="${Ocupaciones}" var="Ocupaciones">                                     
                <option value="${Ocupaciones.getClave()}"><c:out value="${Ocupaciones.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_ocmadre" class="labels_socioeconomicos">Ocupación de la Madre:</label>
                <select class="Selects_economico" id="input_ocmadre"> 
                <c:forEach items="${Ocupaciones}" var="Ocupaciones">                                     
                <option value="${Ocupaciones.getClave()}"><c:out value="${Ocupaciones.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_economicamente" class="labels_socioeconomicos">¿De Quién Dependes Económicamente?:</label>
                <select  id="quiendepende" >
                <c:forEach items="${Dependencia}" var="Dependencia">                                     
                <option value="${Dependencia.getNombre()}"><c:out value="${Dependencia.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="otroeconomicamente" class="labels_socioeconomicos" style='display: none'>Especifique Quién:</label>
                <input class="inputs_socioeconomicos" id="otroquiendepende" style="display: none" maxlength="30">
                </p>
                </fieldset>                               
                <fieldset>
                <p>
                <label id="etq_vivienda" class="labels_socioeconomicos">La Casa donde Vives es:</label>
                <select class="Selects_economico" id="input_vivienda"> 
                <c:forEach items="${casa}" var="casa">                                     
                <option value="${casa.getNombre()}"><c:out value="${casa.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_nopersonas" class="labels_socioeconomicos">No. de Personas que Viven en esa Casa:</label>
                <select  id="input_nopersonas">  
                <c:forEach items="${numero}" var="numero">                                     
                <option value="${numero.getClave()}"><c:out value="${numero.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_cuartos" class="labels_socioeconomicos">No. de Cuartos de la Casa(no Baños):</label>
                <select class="Selects_economico" id="input_cuartos">  
                <c:forEach items="${cuartos}" var="cuartos">                                     
                <option value="${cuartos.getNombre()}"><c:out value="${cuartos.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select>
                <label id="etq_oportunidades" class="labels_socioeconomicos">Pertenece al Programa Oportunidades:</label>
                <select class="Selects_economico" id="input_oportunidades"> 
                <option value="">--Seleccione--</option>
                <option value="Y">Si</option>
                <option value="N">No</option></select>
                <label id="etq_cohabitantes" class="labels_socioeconomicos">¿Con Quién Vives Actualmente?</label>
                <select class="Selects_economico" id="input_habitantes" >
                <c:forEach items="${Dependencia}" var="Dependencia">                                     
                <option value="${Dependencia.getNombre()}"><c:out value="${Dependencia.getNombre()}"/></option>                                                                           
                </c:forEach> 
                </select>                            
                <label id="otrovive" class="labels_socioeconomicos" style='display: none' >Especifique Quién:</label>
                <input class="inputs_socioeconomicos" id="otroviveinput" style='display: none' maxlength="30">
                <label id="etq_mismosustento" class="labels_socioeconomicos">No. de Personas(Incluyendote a ti) que<br>
                Dependen Económicamente del Principal Sustento:</label>
                <select class="Selects_economico" name="dependientes_sustento"  id="dependientes_sustento">
                <c:forEach items="${numero}" var="numero">                                     
                <option value="${numero.getClave()}"><c:out value="${numero.getNombre()}"/></option>                                                                           
                </c:forEach>
                </select></p>
                </fieldset>
                </section>             
            </div>           
        </div>      
        <input id="ObjetoPersonales" value="${aspirante}" style="display: none">
        <div id="continuarsocioeconomicos">
            <center>
            <fieldset id="botones_continuar">
            <a href="#InicioPag"><input type="button" id="continuar_socioeconomicos" title="CONTINUAR" value="Finalizar"></a>
            <input type="reset" id="borrar_socioeconomicos" title="borrar" value="Borrar Datos" >
            </fieldset>
            </center>
        </div>
        <div id="contenLoadingBar" class="container-fluid hidden">
                            <div class="row-fluid label-primary label_socios2">
                                <div class="col-sm-4"></div>
                                <div class="col-sm-4">
                                <div class="loader">
                                
                                </div>
                                </div>
                                <div class="col-sm-4"></div>
                            </div>
    </div>
</form>