<%-- 
    Document   : NoRenovPreficha
    Created on : 25/10/2015, 05:28:28 PM
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
        <div id="divNoRenovar" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnXNoRenovar" type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4>Aviso</h4>
                    </div>
                    <div class="modal-body">
                        <label id="mjeRenovar"></label>
                    </div>
                    <div class="modal-footer">
                        <button id="btnAcepNoRenov"class="btn btn-info btn-default" style="background-color: #337ab7">Acepto</button>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
<script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/MenuInicio.js" type="text/javascript"></script>