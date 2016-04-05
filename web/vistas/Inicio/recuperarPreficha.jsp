
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="Estilos/hexdots.css" type="text/css">
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
    </head>
    <body>
        <br>
        <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all">
            <div id="pestana_carrera">
                <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                    <p id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                        <a class="ui-tabs-anchor" tabindex="-1"><b>Recuperar Preficha</b></a>
                    </p>
                </ul>
                <br><br><br><br>
                <div id="text_seguimiento_recupera"> 
                    <div>
                        <div id="text_recupera_recupera">
                            <br>
                            <h1>
                                Introduzca correctamente su <u>CURP</u> y de clic en el bot&oacute;n 'Preficha' para poder obtener/recuperar su solicitud de registro.
                            </h1>
                        </div>

                        <div id="divContainerRecuperaPre" class="container-fluid">
                            <div id="divCargando" class="container-fluid" style="display: none">
                                <div class="row-fluid">
                                    <br>
                                    <br>
                                    <center>
                                        <div class="hexdots-loader" >
                                            Cargando...
                                        </div>
                                    </center>
                                    <br>
                                    <br>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div id="elem_recupera" >
                            <!-- <form target="_blank" name="crp" id="crp" action="PrefichaPDF" >-->
                            <center>
                                <input type="text" size="24" name="curp" id="curp" maxlength="18" onkeyup="this.value = this.value.toUpperCase()" placeholder="Introduce tu CURP"/>
                                <!--<button id="btn_crp" type=submit value=enviar class="btn btn-default" style="background-color: #337ab7; color: white; font-family: arial">Preficha</button>-->
                                <button id="btn_crp" type=button value=enviar class="btn btn-default" style="background-color: #337ab7; color: white; font-family: arial">Preficha</button>
                            </center>
                            <!--</form>-->
                        </div>
                    </div> 
                    <br>
                    <br>
                    <br> 
                    <br>
                    <h1>
                        <b>IMPORTANTE</b>
                        <br>
                        <br>
                        Es importante tener la preficha a la mano 
                        para cualquier tr&aacute;mite previo a su examen de 
                        admisi&oacute;n, ya que la preficha es la identificaci&oacute;n 
                        oficial que lo acredita como aspirante preinscrito.
                    </h1>
                    <br>
                    <br>
                    <br>
                </div>
            </div>
            <br>
        </div>
    </body>
</html>