//Función que valida el periodo de registro en la página de inicio
window.onload = function () {
    $.ajax({
        type: 'POST',
        async: false,
        url: "ServletValPeriodo",
        success: function (data) {
            if (data === "si") {
                periodo("si");
                $.get("GetPeriodoRenueva", function (data) {
                    var codError;
                    var descError;
                    var fFin;
                    var fInicio;
                    $.each(data, function (index, item) {
                        fInicio = item.fechaIni;
                        fFin = item.fechaFin;
                        descError = item.descError;
                        codError = item.codError;
                    });
                        $('#dateIniRenov').text(fInicio);
                        $('#dateFinRenov').text(fFin);
                });
                
            } else {
                periodo(data);
            }
        }
    });

//funcion menu desplegable 
    $("#Menu_desplegable h3").click(function () {
        $("#Menu_desplegable ul ul").slideUp();
        if (!$(this).next().is(":visible"))
        {
            $(this).next().slideDown();
        }
    });
    
    $('#inicio').click(function () {
        $.get("GetPeriodoRenueva", function (data) {
                    var codError;
                    var descError;
                    var fFin;
                    var fInicio;
                    $.each(data, function (index, item) {
                        fInicio = item.fechaIni;
                        fFin = item.fechaFin;
                        descError = item.descError;
                        codError = item.codError;
                    });
                    $('#dateIniRenovIni').text(fInicio);
                    $('#dateFinRenovIni').text(fFin);
                });
        $("#Contenedor_Bienvenido").load("vistas/Inicio/inicio.jsp");
        $('#grande').css("height", "1209px");
        $('#Contenedor_Bienvenido').css("height", "1170px");
    });
    
    $('#renovar').click(function () {
        var codError;
        var descError = "";
        var fFin ="";
        var fInicio="";
        $.get("GetPeriodoRenueva", function (data) {
                    $.each(data, function (index, item) {
                        fInicio = item.fechaIni;
                        fFin = item.fechaFin;
                        descError = item.descError;
                        codError = item.codError;
                    });
                    $('#mjeRenovar').text(descError);
                            
                    if(codError === 0 ){
                $("#Contenedor_Bienvenido").load("vistas/Inicio/RenovarPreficha.jsp");
                $('#grande').css("height", "870px");
                $('#Contenedor_Bienvenido').css("height", "800px");
                 
            }else{
                $("#divNoRenovar").modal({
                    backdrop : "static"
                }); 
                
            }
        });
    });
    $('#btnAcepNoRenov').off().on('click', function(){
        $('#divNoRenovar').modal('hide');
    });
    $('#btnXNoRenovar').off().on('click', function(){
        $('#divNoRenovar').modal('hide');
    });
    
    $('#recuperar').click(function () {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/recuperarPreficha.jsp");
        $('#grande').css("height", "870px");
        $('#Contenedor_Bienvenido').css("height", "800px");
    });

    $('#preguntas').click(function () {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/preguntas.jsp");
        $('#grande').css("height", "1150px");
        $('#Contenedor_Bienvenido').css("height", "1105px");
    });

    $('#contacto').click(function () {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/contacto.jsp");
        $('#Contenedor_Bienvenido').css("height", "825px");
        $('#grande').css("height", "870px");
    });

    function periodo(per) {

        if (per === "si")
        {
            closeDialog('popup');
        }
        else
        {
            var resumen = per.split("&");
            $('#overlay').fadeIn(1000);
            $('#popup').fadeIn(1000);
            $('#popup').animate({'left': '30%'}, 500);
            $('#popup').append("<center id = \"pagoAviso\"> " + resumen[1] + "</center> <br><br>");
        }
    }

    //Valida  periodo
    function closeDialog(id) {
        $('#overlay').fadeOut(1000);
        $('#popup').fadeOut(1000);
    }
};