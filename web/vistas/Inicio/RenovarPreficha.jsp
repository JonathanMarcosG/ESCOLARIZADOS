<%-- 
    Document   : RenovarPreficha
    Created on : 20/10/2015, 09:49:55 AM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link rel="stylesheet" href="Estilos/hexdots.css" type="text/css"> 
        <link rel="stylesheet" href="Estilos/loading2.css" media="all" type="text/css">
    </head>
    <body>
        <br>
        <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all">
            <div id="pestana_carrera">
                <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                    <p id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                        <a class="ui-tabs-anchor" tabindex="-1"><b>Renovar Referencia</b></a>
                    </p>
                </ul>
                <br>
                <div id="text_seguimiento_renovar"> 
                    <div>
                        <div id="text_renovar">
                            <br>
                            <h1>
                                Introduzca correctamente su <u>CURP</u> y de clic en el bot&oacute;n 'Preficha' para poder renovar su referencia bancaria.
                            </h1>
                        </div>
                        <br>
                        <div id="divCargandoRenov" class="container-fluid" style="display: none">
                                <div class="row-fluid">
                                    <br>
                                    <br>
                                    <center>
                                        <div class="loader" >
                                            Cargando...
                                        </div>
                                    </center>
                                    <br>
                                    <br>
                                </div>
                            </div>
                        <div id="divContainerRenovRef" class="container-fluid">
                            
                            <div id="divRenovarRef" >
                                <!--<form target="_blank" name="crp" id="curpFormRenovar" action="ServletValidaRenovar" >-->
                                <!--<form target="_blank" name="crpRenov" id="curpFormRenovar" action="ValidaRenovar" >-->
                                <center>
                                    <!--<input type="text" size="24" name="curpRenov" id="curpReno" maxlength="18" onkeyup="this.value = this.value.toUpperCase()" placeholder="Introduce tu CURP"/>-->
                                    <input type="text" size="24" name="curpRenovar" id="curpRenovar" maxlength="18" onkeyup="this.value = this.value.toUpperCase()" placeholder="Introduce tu CURP"/>
                                    <button id="btnCurpRenovar" type=button value=enviar class="btn btn-default" style="background-color: #337ab7; color: white; font-family: arial">Preficha</button>
                                    <!--<button type=submit value=enviar class="btn btn-default" style="background-color: #337ab7; color: white; font-family: arial">Preficha</button>-->
                                </center>
                                <!--</form>-->
                            </div>
                        </div>
                    </div> 
                    <br>
                    <br>
                    <h1>
                        <b>IMPORTANTE</b>
                        <br>
                        <br>
                        Estimado aspirante, se le recuerda que al renovar su referencia bancaria, solo contar&aacute; con 
                        1 d&iacute;a h&aacute;bil para efectuar su pago, pudiendo renovar su referencia hasta 2 veces 
                        de modo que es importante que reflexione si realmente efectuar&aacute; el pago.
                    </h1>
                    <br>
                    <br>
                    <br>
                </div>
                <br>
            </div>
    </body>

</html>
<script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
