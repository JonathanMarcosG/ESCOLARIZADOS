<%-- 
    Document   : RegistroFinallizar
    Created on : 9/10/2015, 09:49:55 AM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Estilos/hexdots.css" type="text/css">
        <script src="../../JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../../JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../JQueryClases/PAES_js.js" type="text/javascript"></script>

    </head>
    <body>
        <div id="divMarcoFinReg" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <div class="modal-content">
                    <div class="modal-header">
                        <label id="aviso_label"> <img src="Imagenes/aler.png" width="40px" height="40px"> Aviso Importante</label>

                    </div>
                    <div class="modal-body">
                        <!--<div id="contenLoadingBar" class="container-fluid">
                            <div class="row-fluid label-primary label_socios2">
                                Procesando datos, por favor, espere...
                            </div>
                            <div class="row-fluid">
                                <div class="bar">
                                </div>
                            </div>
                        </div>-->
                        <div id="contenRespInsert" class="container-fluid">
                            <div class="row-fluid">
                                <label id="RetornoEnvioFinReg" style="text-align: justify"></label>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="/MODULO_ASPIRANTE/Index.jsp">
                            <input  id="btnFinRegAceptar" type="button" class="btn btn-default btn-primary hidden"  value="Aceptar">
                        </a>
                        <input  id="btnFinRegCancel" type="button" class="btn btn-default btn-primary hidden" value="Aceptar" >
                        <!--style="display: block">-->
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
