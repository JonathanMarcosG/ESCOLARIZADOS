<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <script src="JQueryClases/Map.js" type="text/javascript"></script>
        <link href="Estilos/css/bootstrap.min.css.css" rel="stylesheet">
        <link href="Estilos/css/bootstrap1.css" rel="stylesheet">
        <link href="Estilos/css/style.css" rel="stylesheet">
        <link href="styles.css" type="text/css" rel="stylesheet"/>
        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <script src="JQueryClases/jquery-1.9.1.min.js"></script>      
        <script src="JQueryClases/jquery.validate.min.js"></script>        
        <script src="JQueryClases/formulario.js"></script>
        <style type="text/css" media="screen">
            html,body{
                height:120%;
                margin:0%;
                padding:0%;
            }
            #map{
                height:80%;
            }
            #paraMapa{
                position: relative;
            }
        </style>

        <script type="text/javascript">
            $(document).ready(function () {
                $(".tooltip-examples a").tooltip({
                    placement: 'top'
                });
            });
        </script>
    </head>
    <body>
        <br>
        <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all">
            <div id="pestana_carrera">
                <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                    <p id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                        <a class="ui-tabs-anchor" tabindex="-1"><b>Contacto</b></a>
                    </p>
                </ul>
                <div id="mapa">
                    <h5>
                        <b>Direcci&oacute;n: Av. Tecnol&oacute;gico S/N, Fraccionamiento la Virgen, Metepec, Edo. De M&eacute;xico, C.P. 52149</b></h5>
                    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=es&callback=iniciar">
                    </script>
                    <div id="map">
                        <div id="paraMapa">
                            <img src="Imagenes/mapaImagen.PNG" alt="ico_Correo" width="100%" height="102%">
                        </div>
                    </div>
                </div>
                <div id="telefono">
                    <div id="panelizquierda"><h4><b>Tel&eacute;fono:</b><br> Desarrollo Académico:  01 (722) 287 222 </h4>
                        <h4><b>Servicios Escolares:</b><br>01 (722) 208 7200  Ext.2505 </h4>
                    </div>
                    <div id="panelderecha">
                        <img src="Imagenes/Phone-icon.png" alt="Teléfono" width="50" height="50">
                    </div> 
                </div>
                <div id="mail" class="ui-corner-all tooltip-examples">
                    <div id="panelizquierda">
                        <h4><b>Email:</b><br><a data-toggle="tooltip" data-original-title="Envianos tus dudas y comentarios. Nosotros te responderemos"  href="#" onclick="lightbox_open_correo();">aspirantes@ittoluca.edu.mx</a></h4>
                        <!--<h4><b>Email:</b><br><a id="btnLinkMailCon" data-toggle="tooltip" data-original-title="Envianos tus dudas y comentarios. Nosotros te responderemos"  href="#" >aspirantes@ittoluca.edu.mx</a></h4>-->
                    </div>
                    <div id="panelderecha">
                        <a data-toggle="tooltip" data-original-title="Envíanos tus dudas y comentarios. Nosotros te responderemos" href="#" onclick="lightbox_open_correo();">
                            <img src="Imagenes/email.jpg" alt="Correo" width="50" height="50">
                        </a>
                    </div> 
                </div>
            </div>
            <div id="light_correo">
                <!--<form action="servlet/SendMail-->
                <form name="formulario_inicio" method="GET" class="form-horizontal" id="formulario_inicio" onsubmit="return validarMail()">
                    <div class="control-group">
                        <label class="control-label" for="inputNombre">Nombre :</label>
                        <div class="controls">
                            <input type="text" name="txtNombre" id="txtNombre"  size="32" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Email :</label>
                        <div class="controls">
                            <input type="text" name="txtEmail" id="txtEmail" size="32" placeholder="Email">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputDescripcion">Descripci&oacute;n :</label>
                        <div class="controls">
                            <textarea name="txtDescripcion" id="txtDescripcion" style="overflow:auto; resize:none" rows="10" cols="30" placeholder="Inserte aquí el cuerpo de su mensaje."></textarea>
                        </div>
                    </div>
                    <div class="img_correo_pop">
                        <img src="Imagenes/ico_correo.gif" alt="ico_Correo" width="110" height="110">
                    </div>
                    <div id="imgCaptchaDiv" class="control-group">
                        <img id="captcha" class="captcha" src="imgCaptcha.png" width="175" height="60" alt="Imagen CAPTCHA" title="Imagen CAPTCHA" /> 
                        <button type="button" class="btn btn-default" id="captcha_btn">Recarga</button>
                        <br>
                        <div id="txtCampCaptcha" class="controls">
                            <input type="text" name="txtCaptcha" id="txtCaptcha" size="32" placeholder="Captcha">
                        </div>                        
                        <br>
                        <button type="submit"class="btn btn-success">Enviar</button>
                        <button type="button" class="btn btn-danger" onClick="lightbox_close_correo();">Cancelar</button>
                    </div>
                </form>
            </div>
            <div id="fade_correo" onClick="lightbox_close();">
            </div>  
        </div>
    </body>
   

</html>