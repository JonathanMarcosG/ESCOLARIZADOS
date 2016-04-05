<%-- 
    Document   : pasosDelProceso
    Created on : 12/08/2014, 11:17:43 AM
    Author     : Chavitta
--%>
<!--En construcción-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="JQuery/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQuery/bootstrap.min.js" type="text/javascript"></script>
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Css/lookandfeel_tec.css" type="text/css">
        <link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css" type="text/css">
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css" type="text/css">
        <style type="text/css">
            .bgimg {
                background-image: url(Imagenes/fondoLookandfeel.PNG);
            }
        </style>
        <title>Modulo inicio aspirante</title>
    </head>
    <body>
        <header>
            <div class="encabezado">
                <img alt="la imagen" src="Imagenes/header-ittoluca1.png" title="footer">                
            </div>
        </header>
        <div  id="avance">
                <section id="letrero_pasos"><label>Pasos del proceso para el registro del aspirante</label>
                <a  rel="shadowbox;" href="ver.jsp"> <input type="button" value="Ver" id="ver_proceso" style="cursor: pointer"   ></a></section>
                <label id="labelenproceso">En proceso</label>
                <section id="botones_pasos">
                <label  id="paso1" class="avances_botones" >1</label>
                <label id="paso2" class="avances_botones" >2</label>
                <label id="paso3" class="avances_botones" >3</label>
                <label  id="paso4" class="avances_botones">4</label>
                <label id="paso5" class="avances_botones" >5</label>
                <label id="paso6" class="avances_botones" >6</label>
                <label  id="paso7" class="avances_botones">7</label>
                </section>
        </div>
        <div id="pasosproceso_botones" class="bgimg">
            <button type="button" class="btn btn-default">Ayuda</button>
            <button type="button" class="btn btn-default">Inicio</button>
        </div>
        <div id="pasosproceso_externo">
            <div id="pasosproceso_nombre">
                <h2>Bienvenido(a): Susana Anahí Torres Cruz</h2>
                <div id="pasosproceso_izquierda">
                    <div  class="bgimg" id="pasosproceso_boton">
                        <div id="blanco">
                            <h4>Pasos</h4>
                        </div>
                    </div>
                    <div class="vacio">
                    </div>
                    <div id="p3" class="espacios">
                        <div id="pasos3" class="imagen_pasos">
                            <div id="blanco_numeros">
                                <h6>3</h6>
                            </div>
                            <div id="blanco_texto">
                                <h6>Imprime tu preficha y el voucher de pago.</h6>
                            </div>
                        </div>
                        <div class="espacio_descripcion">
                            <ul>
                            <li>Para imprimir la ficha entra a la liga que fue enviada a tu correo cuando elaboraste tu solicitud. Asegurate de contar con tu clave CURP.</li>
                            <li>Entra a la siguiente liga para imprimir tu voucher de pago: <a href="http://www.ittoluca.edu.mx/" target="_blank">ITToluca</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="vacio">
                    </div>
                    <div id="p4" class="espacios">
                        <div id="pasos4" class="imagen_pasos">
                            <div id="blanco_numeros">
                                <h6>4</h6>
                            </div>
                            <div id="blanco_texto">
                                <h6>Realiza el pago para tu admision de examen.</h6>
                            </div>
                        </div>
                        <div class="espacio_descripcion">
                            <ul>
                            <li>Realiza tu pago en cualquier sucursal BANAMEX.</li>
                            </ul>
                        </div>
                    </div>
                    <div class="vacio">
                    </div>
                    <div id="p5" class="espacios">
                        <div id="pasos5" class="imagen_pasos">
                            <div id="blanco_numeros">
                                <h6>5</h6>
                            </div>
                            <div id="blanco_texto">
                                <h6>Acude a las instalaciones del ITToluca para el canje del recibo oficial.</h6>
                            </div>
                        </div>
                        <div class="espacio_descripcion">
                            <ul>
                            <li>Acude al depto. de RECURSOS FINANCIEROS (edif. "A" de lunes a viernes  de 9:00 a 18:00 hrs.)</li>
                            <li>Canjea el recibo bancario por el recibo oficial de pago.</li>
                            </ul>
                        </div>
                    </div>
                    <div class="vacio">
                    </div>
                    <div id="p6" class="espacios">
                        <div id="pasos6" class="imagen_pasos">
                            <div id="blanco_numeros">
                                <h6>6</h6>
                            </div>
                            <div id="blanco_texto">
                                <h6>Acude a las instalaciones del ITToluca para entregar tu documentaci&oacute;n.</h6>
                            </div>
                        </div>
                        <div class="espacio_descripcion">
                                <ul>
                                <li>Acude al depto. de SERVICIOS ESCOLARES(edif. "X" Planta Alta de lunes a viernes de 9:00 a 18:00 hrs.</li>
                                <li>Entrega tu <a href="#">recibo oficial</a> y tu <a href="#">preficha</a></li>
                                <li>Recibe tu matrícula para poder registrarte en el CENEVAL. (Ubicacion de tu matr&iacute;cula en el recibo oficial.)</li>
                                </ul>
                        </div>
                    </div>
                </div>
                <div id="pasosproceso_derecha">
                    <div class="bgimg" id="pasosproceso_boton">
                        <div id="blanco">
                            <h4>Descripcion</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="vacio">
        </div>
        <br>
    </body>
</html>
