<%-- 
    Document   : CargarFoto
    Created on : 24/07/2014, 10:29:03 AM
    Author     : ElyyzZ BaRruEtA
--%>
<!--En construcción-->
<script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
<script src="JQueryClases/CargarFoto.js" type="text/javascript"></script>
<script src="JQueryClases/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="JQueryClases/js/additional-methods.min.js" type="text/javascript"></script>
<script>
    jQuery.validator.setDefaults({
        debug: true,
        success: "valid"
    });
    $("#formulario").validate({
        rules: {
            field: {
                accept: "image/jpg, image/png",
                maxSize: '1.5m',
                resolution: '3ppp'
            }
        }
    });
</script>
<form id="formulario">
    <div id="cargarfotografia" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
        <div id="areafotografia" class=" ui-tabs ui-widget ui-widget-content ui-corner-all">
            <img id="fotografia">
        </div>
        <br>
        <input id="subirfoto" type="file"  value="Selecionar foto" class="left">
        <input  id="subirdespues" type="button" value="Cargar foto mas tarde">
    </div>
</form>
    <br>
    <div id="caracteisticasfoto" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
        <div id="pestana_informacion_personal" >
             <ul id="ul_informacion_personal" class=" ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
             <li id="li_informacion_personal" class="ui-state-default ui-corner-t
             p ui-state-active ">
             <a id="etiqueta_reqfotos" class="ui-tabs-anchor" tabindex="-1">Caracteristicas  y requisitos de la fotografia</a>
             </li>
             </ul>
             <p><label id="correctas_label">Correctas</label></p>
            <div id="correctas" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                <img id="correcta1"  src="Imagenes/correcta1.jpg" >
                <img  id="correcta2"  src="Imagenes/correcta2.jpg">
                <img  id="correcta3" src="Imagenes/correcta3.jpg">
            </div>
            <p><label id="incorrectas_label">Incorrectas</label></p>
            <div id="incorrectas" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                <img id="incorrecta1" src="Imagenes/incorrecta1.jpg">
                <img id="incorrecta2" src="Imagenes/incorrecta2.jpg">
                <img id="incorrecta3" src="Imagenes/incorrecta3.jpg">
            </div>
            <ul  id="listaReq">Puedes adjuntar tu foto siempre y cuando cumpla con los siguientes requisitos
                <li>No deber ser descargada de alguna de las redes sociales(Facebook, Twitter, etc.)</li>
                <li>Debe estar en formato JPG o PNG</li>
                <li>No debe pasar de mas de 1.5 Megabytes</li>
                <li>La foto no debe ser escaneada </li>
                <li>Debe tener una resolucion mínima de 3 megapíxeles</li>
                <li>Debe ser reciente a color o blanco y negro</li>
            </ul>
            <p>Es  responsabilidad del aspirante que la foto sea correcta y cumpla con los  requisitos y caracteristicas 
            descritas, para que su solicitud sea valida</p>
        </div>
    </div>

    <%--<%@include file="CargaCorrecta.jsp" %>--%>
