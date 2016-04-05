<%-- 
    Document   : AdvertenciaAgotado
    Created on : 24/09/2015, 11:18:36 AM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css"> 
    </head>
    <body>
        <div id="divMarcoNoFichas" class="modal fade" role="dialog" >
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnXNoFichas" type="button" class="close">&times;</button>
                        <h4>Aviso</h4>
                    </div>
                    <div class="modal-body">
                        <label style="text-align: justify">
                            Estimado aspirante, se le notifica que la demanda de fichas del Instituto
                            ha llegado a su l&iacute;mite por lo que queda en su resposabilidad realizar su registro
                            considerando que queda en lista de espera para recibir la ficha de pago que le servir&aacute; para
                            continuar el proceso de preinscripci&oacute;n.
                        </label>
                    </div>
                    <div class="modal-footer">
                        <button id="btnCancelarNoFichas" class="btn btn-default">Cancelar</button>
                        <button id="btnContinuaNoFichas" class="btn btn-info btn-default" style="background-color: #337ab7">Acepto</button>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>

<script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/PAES_js.js" type="text/javascript"></script>