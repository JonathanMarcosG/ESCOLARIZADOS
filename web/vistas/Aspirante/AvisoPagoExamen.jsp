<%-- 
    Document   : AvisoPagoExamen
    Created on : 29/09/2015, 10:44:11 AM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css"> 
        <link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">
        <link rel="stylesheet" href="Estilos/hexdots.css" type="text/css">
    </head>
    <body>
        <div id="divAvisoPago" class="modal fade" role="dialog" >
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnXPagoExa" type="button" class="close">&times;</button>
                        <h4>Aviso</h4>
                    </div>
                    <div class="modal-body">
                        <div id="contenLabelPago" class="container-fluid">
                            <div class="row-fluid">
                                <label id="centrar_inf">
                                    <!--Es imperativo que el aspirante reflexione si realmente efectuar&aacute; el pago,
                                    ya que s&oacute;lo contar&aacute; con dos d&iacute;as h&aacute;biles posteriores a
                                    su registro para efectuar el pago. -->
                                    Es indispensable que el aspirante reflexione si realmente efectuar&aacute; el pago de su 
                                    preficha dentro de los dos d&iacute;as h&aacute;biles correspondientes. 
                                </label>
                            </div>
                        </div><!--
                        <div id="contenLoadingBar" class="container-fluid">
                            <div class="row-fluid">
                                <div class="bar">
                                </div>
                            </div>
                        </div> -->

                    </div>
                    <div class="modal-footer">
                        <!--<button id="btnPruebaLoad" class="btn btn-danger" href>Show Label</button>-->
                        <button id="btnAvisoPagoCancel" class="btn btn-default" >Cancelar</button>
                        <button id="btnAvisoPagoAcep" class="btn btn-info btn-primary" style="background-color: #337ab7">Aceptar</button>
                        
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
<script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/PAES_js.js" type="text/javascript"></script>