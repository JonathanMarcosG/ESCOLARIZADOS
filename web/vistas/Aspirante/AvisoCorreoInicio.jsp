<%-- 
    Document   : AvisoCorreoInicio
    Created on : 29/09/2015, 11:18:08 AM
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
        <div id="divReturnCorreo" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnXAvisoCorreo" type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4>Aviso</h4>
                    </div>
                    <div class="modal-body">
                        <label id="RetornoServlet"></label>                       
                    </div>
                    <div class="modal-footer">
                        <button id="btnAvisoCorreoCont" class="btn btn-info btn-default" style="background-color: #337ab7">Acepto</button>
                    </div>
                </div>


            </div>
        </div>
    </body>
</html>
<script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/JQueryClases/PAES_js.js" type="text/javascript"></script>