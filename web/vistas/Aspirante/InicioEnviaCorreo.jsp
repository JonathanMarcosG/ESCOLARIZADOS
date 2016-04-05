<%-- 
    Document   : InicioEnviaCorreo
    Created on : 12/11/2014, 11:13:17 AM
    Author     : Desarrollo de sistem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilos/DivCargando.css" media="all" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" media="all" type="text/css">

    </head>
    <body>
        <div id="divmarcoEnvCorreo" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnXIngresCorreo" type="button" class="close" >&times;</button>
                        <h4>Ingresa tu correo</h4>
                    </div>
                    <div class="modal-body">

                        <div id="contenedor_inCorreo">
                            <fieldset>
                                <br>
                                <label id="etq_CorreoI">Ingrese su Correo Electrónico: </label>
                                <p class="bg-info text-justify ">Si desea conocer el costo de la preficha por favor consulte la convocatoria en la p&aacute;gina oficial del Tecnol&oacute;gico <a href="http://www.ittoluca.edu.mx" target="_blank">www.ittoluca.edu.mx</a></p>
                                <input id="InCorreoE" placeholder="ejemplo@smtp.com" type="text">
                                <input id="btnCorreoAcep" type="button" class="btn btn-info btn-default" value="Enviar" style="background-color: #337ab7">

                                <center>
                                    <label id="labelVerifica">Por favor verif&iacute;que que su correo que est&eacute; escrito correctamente, ya que ser&aacute;
                                        el medio de comunicaci&oacute;n entre el instituto y usted.</label>
                                </center>                
                                <div id="cargandoDivAnimacion">
                                    <center>
                                        <img src="Imagenes/loading.gif"/> 
                                    </center>
                                </div>
                            </fieldset>                    
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button id="btnCorreoCancel" class="btn btn-default">Cancelar</button>
                    </div>
                </div>

            </div> 
        </div>
    </body>
</html>

<script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/PAES_js.js" type="text/javascript"></script>
