<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">
        <link rel="stylesheet" href="Estilos/css/shadowbox.css" type="text/css">
        <link rel="stylesheet" href="Estilos/lookandfeel_tec.css" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap-theme.min.css.css" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css">   
        <link rel="stylesheet" href="Estilos/estandarDesarrollo.css" media="all" type="text/css">
        <title>--MÓDULO ASPIRANTE--</title>
    </head>
    <body style="background-color: #EAEAEA">         
        <header>
            <div class="encabezado">
                <img alt="la imagen" src="Imagenes/header_ittoluca.png" title="header">                
            </div>
        </header>  
        <div id="menuPrincipal">
            <%@include file="navbarGrupos.jsp"%><br><br>
        </div>
        <a name="InicioPag"></a>
        <div class="Contenido_menu" id="grande" >
            <div id="Contenedor_Bienvenido">
                <br>
                <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all tooltip-examples">
                    <div id="pestana_carrera">
                        <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                            <p id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                                <a class="ui-tabs-anchor" role="presentation" tabindex="-1"><b>Registro del Aspirante</b></a>
                            </p>
                        </ul>
                        <label id="centrar_inf"><h4>Le damos la más cordial bienvenida  a la página de registro para aspirantes del Instituto Tecnológico de Toluca, en esta sección podrá realizar su registro como aspirante a la convocatoria , para ello tenga a la mano los siguientes elementos que le facilitarán el llenado de los  formularios:
                            </h4></label>
                        <ul id="sangria">
                            <li>Clave CURP<a href="http://consultas.curp.gob.mx/CurpSP/"target="_blank"><div id="aqui">consultar aqu&iacute;</div></a></li>
                            <li>Clave de la escuela de procedencia<a href="http://www.snie.sep.gob.mx/SNIESC/" target="_blank"><div id="aqui_escuela">consultar aqu&iacute;</div></a></li>
                            <li>
                                <div id="link_toolt"><a data-toggle="tooltip" data-original-title="Federal, Estatal, Privada"  >Tipo de la escuela de procedencia</a></div></li>
                            <li>Tipo de sangre</li>
                            <li>Acta de nacimiento</li>
                        </ul>
                        <label id="centrar">
                            <h4>
                                Es importante recordarle que la cuenta de correo que ingrese deberá ser verídica y de uso personal debido a que durante la convocatoria  se le enviarán notificaciones e indicaciones relativas al proceso que está a punto de iniciar.<br>
                                <br>
                                <br>
                                <label>Para más información sobre la convocatoria consulte <a href="http://www.ittoluca.edu.mx/" target="_blank">aquí.</a></label><br>
                                <label>Para más información sobre el proceso de registro consulte <a href="ManualAspirante" target="_blank"> aqu&iacute;.</a></label>
                            </h4>
                        </label>
                        <div>
                            <center>
                                <h2>Importante.</h2> 
                            </center>
                            <div id="Contenido_atencion">
                                <div id="import">
                                    <label style="text-align: justify">
                                        <u1>
                                            <li>Es responsabilidad del aspirante  que los datos de su registro sean ver&iacute;dicos. </li>
                                            <li>Al iniciar su registro acepta que  ha le&iacute;do la informaci&oacute;n anterior  y  que est&aacute; conforme con sus t&eacute;rminos.</li>
                                            <li>Para cualquier duda o claraci&oacute;n  diríjase al apartado de "Contacto".</li>
                                            <li>Tome en cuenta que es responsabilidad del aspirante cumplir con todas las etapas de este proceso
                                                para finalizar su registro de lo contrario su solicitud ser&aacute; rechazada.</li>
                                            <li>Es importante considerar que una vez realizado su registro tendr&aacute; dos d&iacute;as h&aacute;biles para realizar su pago. Si desea conocer el costo
                                                de la preficha por favor consulte la convocatoria en la p&aacute;gina oficial del Tecnol&oacute;gico <a href="http://www.ittoluca.edu.mx" target="_blank">www.ittoluca.edu.mx</a></li>
                                            <li>
                                                En caso de que su referencia expire usted podr&aacute; renovarla contemplando que: 

                                                <ol id="sangria2">
                                                    <li>Al realizar su registro y no realizar el pago oportuno de su preficha, su lugar en el Instituto no 
                                                        ser&aacute; contemplado.</li>
                                                    <li>La renovaci&oacute;n de Prefichas est&aacute; sujeta a la disponibilidad de cupo en el Instituto.</li>
                                                    <li>El aspirante tendr&aacute; hasta dos oportunidades para renovar su referencia.</li>
                                                    <li>El aspirante tendr&aacute; un día h&aacute;bil para realizar el pago de su preficha despu&eacute;s de renovar su referencia. </li>
                                                </ol>
                                            </li>
                                            <li>En caso de que su referencia expire usted podr&aacute; renovarla en el apartado de "Renovar Referencia" durante un periodo h&aacute;bil, no obstante le recordamos que dicha renovaci&oacute;n est&aacute; sujeta a la disponibilidad de prefichas en el tecnol&oacute;gico. </li>
                                            <li id="pagoAviso">Es indispensable que el aspirante reflexione si realmente efectuar&aacute; el pago de su preficha dentro de los dos días h&aacute;biles correspondientes.</li>
                                        </u1>
                                    </label>
                                </div>
                            </div>    
                        </div>
                    </div>
                    <br>
                    <label>Por favor para iniciar con el proceso de registro seleccione  "He le&iacute;do esta informaci&oacute;n" y 
                        a continuaci&oacute;n de clic en el bot&oacute;n de "Aceptar".</label>

                    <div id="Contenedor_radioButton">                                        
                        <label>
                            <h5><input id="comprobar" type="checkbox"><b>He le&iacute;do esta informaci&oacute;n.</b> <br></h5>
                        </label>
                        <br>
                        <a href="#InicioPag">
                            <label><input id="heleido" type="button"  class="btn btn-info btn-default" 
                                          value="Aceptar" style="display: none;background-color: #337ab7;"></label>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <footer>
            <div class="pieDePagina"><br><br>
                <label class="texto_inferior">
                    Instituto Tecnol&oacute;gico de Toluca | www.ittoluca.edu.mx
                    <br>
                    Instituto Tecnol&oacute;gico de Toluca - Algunos derechos reservados ? 2014
                    <br>
                </label>
                <br>
                <img width="940" height="88" alt="" src="Imagenes/footer_ittoluca.png" title="footer">
                <br>
                <label class="texto_inferior">
                    Av. Tecnol&oacute;gico s/n. Fraccionamiento La Virgen
                    <br>
                    Metepec, Edo. De M&eacute;xico, M&eacute;xico C.P. 52149
                    <br>
                    tel. (52) (722) 2 08 72 00
                </label>
            </div>
        </footer>
        <div id="content">
            <div id="overlay" class="overlay">
            </div>
            <div id="popup" class="popup">
                <div>
                    <center><h2>Aviso al usuario</h2></center>
                    <div id="msgPeriodo">
                        <center>
                            Por el momento la p&aacute;gina del preregistro de aspirantes se encuentra indispuesta debido a que no estamos en un periodo h&aacute;bil para expedir prefichas.
                            Le recomendamos intentarlo en otra ocasi&oacute;n
                            Gracias.
                            <p>Tel&eacute;fono:</p>
                            <p>Desarrollo Acad&eacute;mico:  01 (722) 287 222 </p>
                            <p>Servicios Escolares: 01 (722) 208 7200  Ext.2505 </p>
                            <p>Envíe sus dudas y comentarios, nosotros le responderemos.</p>
                            <p>Email: aspirantes@ittoluca.edu.mx</p>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <!--${pageContext.request.contextPath}-->
</html>

<script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/PAES_js.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/MenuInicio.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/shadowbox.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootbox.js" type="text/javascript"></script>
<script type="text/javascript">
    $(window).unload(function () {
        $(".tooltip-examples a").tooltip({
            placement: 'top'
        });
    });
    $(document).ready(function () {
    //window.history.forward();
        $(".tooltip-examples a").tooltip({
            placement: 'top'
        });

    });
</script>
<%@include file="vistas/Aspirante/InicioEnviaCorreo.jsp" %>
<%@include file="vistas/Aspirante/AdvertenciaAgotado.jsp" %>
<%@include file="vistas/Aspirante/AvisoPagoExamen.jsp" %>
<%@include file="vistas/Aspirante/AvisoCorreoInicio.jsp" %>
<%@include file="vistas/Inicio/NoRenovPreficha.jsp" %>
