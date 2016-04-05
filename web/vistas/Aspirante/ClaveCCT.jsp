<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="content" >
    <div>
        <div   id="FondoSeleccionaClave" style="display: none">
        </div>
        <div id="SelecionaClave" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" style="display: none">
            <div id="contenidoCCT">
                <center> <h4><label style="color: black">Seleccione la  Escuela de Procedencia.</label></h4></center>
                <div id="listaCCT">
                    <table  id="tablaCCT"    
                    class="display nowrap dataTable dtr-inline" 
                    width="80%" cellspacing="0" 
                    role="grid" 
                    aria-describedby="example_info" 
                    style="width: 80%;">
                    <thead>
                    <th> </th>
                    <th >Clave</th>
                    <th>Nombre de la Escuela</th>
                    <th>Turno</th>
                    <th>Domicilio</th>
                    </thead>
                    </table>
                    <br>
                    <input id="aceptarCCT" type="button" value="Aceptar">
                    <input id="cancelarCCT" type="button" value="Cancelar">
                </div>
            </div>
        </div>
    </div>
</div>

