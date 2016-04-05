<%-- 
    Document   : Loading
    Created on : 16/12/2015, 11:16:09 AM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<script src="../../JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>-->
        <script src="${pageContext.request.contextPath}/JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/JQueryClases/MenuInicio.js" type="text/javascript"></script>

        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css"> 
        <link rel="stylesheet" href="Estilos/hexdots.css" type="text/css"> 
    </head>
    <body>

        <div id="divLoading"class="container-fluid">
            <div class="row-fluid">
                
                <br>
                <center>
                    <div class="hexdots-loader" >
                        Cargando...
                    </div>
                </center>
                <br>
                
            </div>
        </div>

    </body>
</html>
