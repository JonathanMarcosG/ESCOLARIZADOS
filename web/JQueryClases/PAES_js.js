

//****************Index.jsp**********************************************************************************************************
function EnviaCorreoInicio() {
    var correo = $('#InCorreoE').val();
    $.get('EnviaEmailInicio',
            {correo: correo.trim()},
            function (retorno) {
                $('#RetornoServlet').text(retorno);
                $('#divmarcoEnvCorreo').modal('hide');
                $('#divReturnCorreo').modal({
                    backdrop: "static"
                });
                $('#InCorreoE').val("");
                $('#cargandoDivAnimacion').hide();
            }
    );

}
//************************ASPIRANTE*************************************************************************************************
//******Confirmación_datos.jsp 

function UpperCase(nombre) {
    return nombre.substr(0, 1).toUpperCase() + nombre.substr(1, nombre.length).toLowerCase();
}

function IniCap(nombre) {
    var arrayWords;
    var returnString = "";
    var len;
    arrayWords = nombre.split(" ");
    len = arrayWords.length;
    for (var i = 0; i < len; i++) {
        if (i != (len - 1)) {
            returnString = returnString + UpperCase(arrayWords[i]) + " ";
        } else {
            returnString = returnString + UpperCase(arrayWords[i]);
        }
    }
    return returnString;
}
function ConfirmaDatos() {

    var correo = $('#caja_texto_email').val();
    var nombre = $('#inputnombre').val().toLowerCase();
    var paterno = $('#inputpaterno').val().toLowerCase();
    var materno = $('#inputmaterno').val().toLowerCase();
    var curp = $('#inputcurp').val();
    var carrera = $('#carreraopcion1 option:selected').html();
    nombre = IniCap(nombre);
    paterno = IniCap(paterno);
    materno = IniCap(materno);
//    $('#confirmanombre').text(paterno + " " + materno + " " + nombre);
//    $('#confirmacurp').text(curp);
//    $('#confirmacorreo').text(correo);
//    $('#confirmacarrera ').text(carrera);
    $('#confirmanombreAsp').text(paterno + " " + materno + " " + nombre);
    $('#confirmacurpAsp').text(curp);
    $('#confirmacorreoAsp').text(correo);
    $('#confirmacarreraAsp').text(carrera);
}
//*******Datos_Aspirante.jsp


//Función que valida el periodo en que estudió el aspirante la preparatoria
function ValidaPeriodoEscPro() {
    var valid = false;
    var inicio = "01/" + $('#mes_inicio option:selected').val() + "/" + $('#anio_inicio option:selected').val();
    //inicio = new Date(inicio);
    var fin = "01/" + $('#mes_fin option:selected').val() + "/" + $('#anio_fin option:selected').val();
    //fin = new Date(fin);

    $('#mes_inicio').css("border", "");
    $('#anio_inicio').css("border", "");
    if (inicio >= fin) {
        //if( new Date(fin).getTime() < new Date(inicio).getTime()){
        alert('La fecha de inicio puede ser mayor o igual, que la fecha fin');
        $('#mes_inicio').css("border", "1px solid red");
        $('#anio_inicio').css("border", "1px solid red");
        //document.getElementById('anio_fin').val('--');

        valid = false;
    } else {
        valid = true;
    }

    alert('lo que regresa el valida periodo escPRo : -' + valid);
    return  valid;
}

function valDate() {
    var monthB = $('#mes_inicio option:selected').val();
    var yearB = $('#anio_inicio option:selected').val();
    var monthF = $('#mes_fin option:selected').val();
    var yearF = $('#anio_fin option:selected').val();
    var ret = null;

    //alert('Entrando a valdar fechas con: M-Y B:' + monthB + '-' + yearB + ':M-Y F:' + monthF + '-' + yearF);

    if (isValid(monthB) && isValid(yearB) && isValid(monthF) && isValid(yearF)) {

        var inicio = $('#mes_inicio option:selected').val() + "-01-" + $('#anio_inicio option:selected').val();
        var fin = $('#mes_fin option:selected').val() + "-01-" + $('#anio_fin option:selected').val();

        var formatB = new Date(inicio);
        var formatE = new Date(fin);

        ret = (formatE < formatB) ? false : true;

        //alert('Fue valido la fecha : Ini:' + formatB + '-Fin:' + formatE);
    } else {
        ret = false;
        //alert('No valido');
    }
    //alert('Lo que retorna la funcion de fecha:' + ret);
    return ret;
}

function isValid(data) {
    return(data != '--');
}

//Función que valida el Estado que selecciona el aspirante para la búsqueda de su escuela de procedencia
function Filtros(id, data) {
    $(id).html("");
    $.each(data, function (index, item) {
        var txt = item.Clave;
        var t = item.Nombre;
        $(id).append("<option value='" + txt + "'>" + t + "</option>");
    });
}
////Función que valida que las opciones de   Carreras  que selccione el aspirante  no se repitan 
function Limpiar(id, c1, c2, c3) {
    $("#carreraopcion option").each(function () {
        $(id).children('option[value=' + $(this).attr('value') + ']').css("display", "block");
    });
    if (c1 !== '--') {
        $('#carreraopcion2').children('option[value=' + c1 + ']').css("display", "none");
        $('#carreraopcion3').children('option[value=' + c1 + ']').css("display", "none");
    }
    if (c2 !== '--') {
        $('#carreraopcion1').children('option[value=' + c2 + ']').css("display", "none");
        $('#carreraopcion3').children('option[value=' + c2 + ']').css("display", "none");
    }
    if (c3 !== '--') {
        $('#carreraopcion1').children('option[value=' + c3 + ']').css("display", "none");
        $('#carreraopcion2').children('option[value=' + c3 + ']').css("display", "none");
    }
}
//Función que muestra las opciones de carrera
function Carreras(id, opcion) {
    var carrera1 = $('#carreraopcion1').val();
    var carrera2 = $('#carreraopcion2').val();
    var carrera3 = $('#carreraopcion3').val();
    if (opcion === 1 && carrera1 !== '--') {
        Limpiar("#carreraopcion2", carrera1, carrera2, carrera3);
        Limpiar("#carreraopcion3", carrera1, carrera2, carrera3);
        $("#carreraopcion2").children('option[value=' + carrera1 + ']').css("display", "none");
        $("#carreraopcion3").children('option[value=' + carrera1 + ']').css("display", "none");
    }
    if (opcion === 2 && carrera2 !== '--') {
        Limpiar("#carreraopcion1", carrera1, carrera2, carrera3);
        Limpiar("#carreraopcion3", carrera1, carrera2, carrera3);
        $('#carreraopcion1').children('option[value=' + carrera2 + ']').css("display", "none");
        $('#carreraopcion3').children('option[value=' + carrera2 + ']').css("display", "none");
    }
    if (opcion === 3 && carrera3 !== '--') {
        Limpiar("#carreraopcion1", carrera1, carrera2, carrera3);
        Limpiar("#carreraopcion2", carrera1, carrera2, carrera3);
        $('#carreraopcion1').children('option[value=' + carrera3 + ']').css("display", "none");
        $('#carreraopcion2').children('option[value=' + carrera3 + ']').css("display", "none");
    }
}
//Función que valida cada rango de los días que tienen los meses del año
function evaluar() {
//obtener  fecha 
    var fechaN;
    var bandera = true;
    var anio = $("#combo_anio  option:selected").val();
    var mes = $("#combo_mes option:selected").val();
    var dia = $("#combo_dia option:selected").val();
    var anio1 = anio;
    var mes1 = mes;
    var dia1 = dia;
//    alert(dia + "/" + mes + "/" + anio);
    if (dia.substring(0, 1 == "0")) {
        dia = dia.substring(1, 2);
    }
    if (mes.substring(0, 1) == "0") {
        mes = mes.substring(1, 2);
    }
    if (anio === '--' || mes === '--' || dia === '--') {
        $('#combo_anio').css("border", "1px solid red");
        $('#combo_mes').css("border", "1px solid red");
        $('#combo_dia').css("border", "1px solid red");
    } else {
//validar  
        if (anio !== false || mes !== false || dia !== false) {
            bandera = true;
            //es distinto  a 0 
            if (dia < 32 && (mes === '1' || mes === '3' || mes === '5' || mes === '7'
                    || mes === '8' || mes === '10' || mes === '12')) {
                bandera = true; //si es mes dia  valido de 31 dias 
            } else {
                if (dia < 31 && (mes === '4' || mes === '6' || mes === '9' || mes === '11')) {
                    bandera = true;
                }// si es mes dia valido
                else {
                    var modulo = anio % 4;
                    //febrero y bisiesto
                    if (dia < 30 && mes === '2' && modulo === 0) {
                        bandera = true;
                    } else {
                        if (dia < 29 && mes === '2') {
                            bandera = true;
                        } else {
                            bandera = false;
                        }
                    }
                }
            }
        } else {
            bandera = false;
        }
        if (bandera === false) {
            alert("La fecha no es valida");
            $('#combo_anio').css("border", "1px solid red");
            $('#combo_mes').css("border", "1px solid red");
            $('#combo_dia').css("border", "1px solid red");
            return  false;
        } else {
            if (bandera === true) {
                $('#combo_anio').css("border", "");
                $('#combo_mes').css("border", "");
                $('#combo_dia').css("border", "");
                return fechaN = dia1 + "/" + mes1 + "/" + anio1;
//                alert(fechaN);
            }
        }
    }
}
//Función que obtiene la clave CCT de la escuela que seleccione el aspirante y la pinte en la caja de texto
function ObtineneCCT() {
    var clave = $('.CCTs:checked').val();
    $('#clavesc').val(clave);
}
//Validaciones para la CURP
function curpvalida(id) {
    $(id).change(function () {
        var curp = $(id).val();
        if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
            $(id).css("border", "");
            return false;
        } else {
            $(id).css("border", "1px solid red");
            alert('curp incorrecta!');
            return false;
        }
    });
}
//Función que valida que se selecciono una opción distinta y hace aparecer un campo de texto para introducirla
function ValidaOtraOpcion(id) {
    $(id).change(function () {
        var valor = $(id).val();
        if (valor === '--Seleccione--' || valor === '--' || valor === 0 || valor === '0' || valor === '') {
            $(id).css("border", "1px solid red");
            alert("Seleccione una opcion");
        } else {
            $(id).css("border", "");
        }
    });
}
////Función que valida  que los datos ingresados sean solo numeros
function validar_numeros(id) {
    $(id).change(function () {
        var valor = $(id).val();
        var patron_numeros = /^[0-9]+$/;
        if (!patron_numeros.test(valor)) {
            $(id).css("border", "1px solid red");
            alert("Sólo números");
        } else {
            $(id).css("border", "");
        }
    });
}
//valida  numeros al continuar y pasar del 1° al 2° formulario
function validar_numerosContinuar(id) {
    var numeros = $(id).val();
//    $(id).change(function() {
    var valor = $(id).val();
    if (valor === "") {
        numeros = valor;
    } else {
        numeros = valor.trim();
        var patron_numeros = /^[0-9]+$/;
        var cumple = patron_numeros.test(valor);

        if (!cumple) {
            $(id).css("border", "1px solid red");
            alert("Sólo números");
            numeros = false;
        } else {
            $(id).css("border", "");
            numeros = valor;
        }
//    });
//    alert("retorno |" + numeros);
    }
    return numeros;
}
function validar_numerosContinuarint(id) {
    var numeros = $(id).val();
//    $(id).change(function() {
    var valor = $(id).val();
    numeros = valor.trim();
    var patron_numeros = /^[0-9]+$/;
    var cumple = patron_numeros.test(valor);
    if (valor !== "" || valor !== " ") {

    } else {
        if (!cumple) {
            $(id).css("border", "1px solid red");
            alert("Sólo números");
            numeros = false;
        } else {
            $(id).css("border", "");
            numeros = valor;
        }
    }
//    });
//    alert("retorno |" + numeros);
    return numeros;
}
//Verifica que haya solamente numeros en la entrada
function validar_SoloHaynumeros(id) {
    var numeros = $(id).val();
//    $(id).change(function() {
    var valor = $(id).val();
    numeros = valor.trim();
    var patron_numeros = /^[0-9]+$/;
    var cumple = patron_numeros.test(valor);
    if (valor !== "" || valor !== " ") {

    } else {
        if (cumple) {
            $(id).css("border", "1px solid red");
            numeros = true;
        } else {
            $(id).css("border", "");
            numeros = valor;
        }
    }
//    });
//    alert("retorno |" + numeros);
    return numeros;
}
////Función que valida que los caracteres introducidos en un campo de texto solo sean  letras 
function validar_letras(id) {
    $(id).off().on('change', function () {
        var letras = $(id).val();
        var patron_letra = /^[a-z ñäöüßÄÖÜáéíóúÁÉÍÓÚ ]+$/i;
        if (!patron_letra.test(letras)) {
            $(id).css("border", "1px solid red");
            alert("solo texto");
        } else {
            $(id).css("border", "");
        }
    });
}

////Función que valida que los caracteres introducidos en un campo de texto solo sean  letras y números
function validaAlfaNum(id) {
    $(id).change(function () {
        var patron = /^[0-9A-Za-z-ñäöüßÄÖÜáéíóúÁÉÍÓÚ\s]+$/;
        var txtcurp = $("#" + id).val();
        if (!patron.test(txtcurp)) {
            $(id).css("border", "1px solid red");
            alert("Símbolos no aceptados");
        } else {
            $(id).css("border", "");
        }
    });
}
//////Función que valida que los número telefonicos no exedan los 7 caracteres
function ValidaTel(id) {
    $().change(function () {
        var tel = ObtenerValor(id);
        if (tel.length < 7) {
            alert("Telefono no valido");
            $(id).css("border", "1px solid red");
        } else {
            $(id).css("border", "");
            return true;
        }
    });
}
//////Función que valida que los número telefonicos no exedan los 12 caracteres

function validaTelfijo(id) {
    $(id).change(function () {
        var lada = ObtenerValor(id);
        if (lada.length < 12) {
            alert("Telefono  fijo no válido");
            $(id).css("border", "1px solid red");
        } else {
            $(id).css("border", "");
            return true;
        }
    });
}
//validaciones no nulos  continuar
//no nulos  inputs
function  ObtenerValorTel(id) {

    var valor = $(id).val();
    var patron_numeros = /^[0-9]+$/;
    var patron_tel = /^\d{9}$/;
    var ceros = /^[0]+$/;
    var numeros = patron_numeros.test(valor);
    var numerostel = patron_tel.test(valor);
    var numeroscer = ceros.test(ceros);

    if (numeros !== true &&
            numerostel !== true && numeroscer !== true) {
        $(id).css("border", "1px solid red");
        alert("Sólo números");
        valor = false;
    } else {
        $(id).css("border", "");
        valor = $(id).val();

    }
    return valor;
}
function  ObtenerValor(id) {
    var novalido = false;
    var valor = $(id).val();
    if (valor === '' || valor === null || valor === undefined || valor === '-Seleccione-' || valor === '--Selecione--' || valor === '--' || valor === 0 || valor === '0' || valor === "null" || valor === "s/n" || valor === "S/N" || valor === "S/n" || valor === "s/N") {
        $(id).css("border", "1px solid red");
//        alert("retorna: " + novalido);
        return novalido;
    } else {
        $(id).css("border", "");
        return  valor;
    }
}

//Checa  si el  país  es  México activa  los combos de  estado, municipio y localidad
function Pais(id) {

    $(id).on('change', function () {
        var pais = $(id).val();
        if (pais === 'MEX') {
            var opcion = 4;
            $.getJSON("/MODULO_ASPIRANTE/CargaCatalogoServlet",
                    {opcion: opcion},
                    function (data) {
                        //limpiar el option value
                        Filtros("#selectedonacimiento", data);

                    });
            $('#selectedonacimiento').prop("disabled", false);
            $('#combompnacimiento').prop("disabled", false);
            $('#combocdnacimiento').prop("disabled", false);
        } else {
            $('#selectedonacimiento').html("");
            $('#combompnacimiento').html("");
            $('#combocdnacimiento').html("");
            $('#selectedonacimiento').prop("disabled", true);
            $('#combompnacimiento').prop("disabled", true);
            $('#combocdnacimiento').prop("disabled", true);
        }
    });
}

function ValidaTipos() {
//datos personales
    validaAlfaNum('inputcurp');
    curpvalida('#inputcurp');
    validar_letras('#inputpaterno');
    validar_letras('#inputmaterno');
//    validaCorreoElectronico('#caja_texto_email');
    validar_letras('#inputnombre');
    Pais('#combopaisnacimiento');
    //direccion
    validaAlfaNum('dircalle');
    validar_numeros('#cp');
    validar_numeros('#numcelular');
    ValidaTel('#numcelular');
    validar_numeros('#tel2');
    ValidaTel('#tel2');
    validar_numeros('#dirnumext');
    validar_numeros('#dirnumInt');
    //escuela de  procedencia
    validaAlfaNum('clavesc');
    //datos socieconomicos
    validar_letras('#nom_padre');
    validar_letras('#nom_madre');
    validar_letras('#contacto_emergencia');
    validaAlfaNum('colonia');
    validaAlfaNum('calle');
    validaAlfaNum('ciudad');
    validar_numeros('#tel_fijo');
    validar_numeros('#tel_cel');
    validar_numeros('#socionumInt');
    validar_numeros('#socionumext');
    validar_numeros('#sociocodpost');
    validaAlfaNum('cent_trabajo');
    validar_numeros('#tel_trabajo');
    validar_letras('#beca_tipo');
    validar_letras('#otroquiendepende');
    validar_letras('#otroviveinput');
}
//////Función que valida si el aspirante cuenta con una beca si sí activa una caja de texto para la descripción
function  ValidaBeca() {
    if ($('#beca').val() === 'S') {
        var valorBeca = ObtenerValor('#beca_tipo');
        // alert("dentro de validabeca con lo de beca_tipo : " + valorBeca);
        if (valorBeca !== false) {
            var patron_letra = /^[a-z ñäöüßÄÖÜáéíóúÁÉÍÓÚ ]+$/i;
            if (!patron_letra.test(valorBeca)) {
                return false;
            } else {
                return valorBeca;
            }

        } else {
            return false;
        }
    }
}
//////Función que valida si el aspirante elige otra opción  si sí activa una caja de texto para la descripción

function  ValidaDepende() {
    if ($('#quiendepende').val() === 'Otro') {
        var valorotro = ObtenerValor('#otroquiendepende');
        if (valorotro !== false) {
            return valorotro;
        } else {
            return false;
        }
    }
    return true;
}
//////Función que valida si el aspirante elige otra opción  si sí activa una caja de texto para la descripción

function ValidaOtroVive() {
    var OtroVive;
    if ($('#input_habitantes').val() === 'Otro') {
        OtroVive = ObtenerValor('#otroviveinput');
        if (OtroVive !== false) {
            return OtroVive;
        } else
            return false;
    }
    return  true;
}

//obtener  datos  y validar que no sean nulos
function personales() {
    var personalesDat;
    var paterno = ObtenerValor('#inputpaterno');
    var materno = ObtenerValor('#inputmaterno');
    var nombre = ObtenerValor('#inputnombre');
    var curp = ObtenerValor("#inputcurp");
    var correo = ObtenerValor('#caja_texto_email');
    var sexo = ObtenerValor('#sexo');
    var edocivil = ObtenerValor('#combo_edo_civil');
    var pais = ObtenerValor('#combopaisnacimiento');
    var capacidad = ObtenerValor('#capacidad_dif');
    var sangre = ObtenerValor('#combo_tipo_sangre');
    var fecha = evaluar();
    if (pais === 'MEX') {
        var municipio = ObtenerValor('#combompnacimiento');
        var ciudad = ObtenerValor('#combocdnacimiento');
        var estado = ObtenerValor('#selectedonacimiento');
        if (nombre !== false && paterno !== false &&
                materno !== false && curp !== false &&
                correo !== false &&
                sexo !== false &&
                edocivil !== false &&
                ciudad !== false &&
                pais !== false && municipio !== false
                && estado !== false &&
                capacidad !== false &&
                sangre !== false && fecha !== false) {
            personalesDat = curp + "||" + nombre + "||" + paterno + "||" + materno + "||" + fecha + "||" + pais + "||" + estado + "||" + municipio + "||" + ciudad
                    + "||" + sexo + "||" + edocivil + "||" + sangre + "||" + capacidad + "||" + correo;
            return  personalesDat;
        } else {
            alert("complete sus datos personales ya que son importantes para realizar su registro");
            return  false;
        }
    } else {
        if (nombre !== false && paterno !== false &&
                materno !== false && curp !== false &&
                correo !== false &&
                sexo !== false &&
                edocivil !== false &&
                pais !== false &&
                capacidad !== false &&
                sangre !== false && fecha !== false) {
            personalesDat = curp + "||" + nombre + "||" + paterno + "||" + materno + "||" + fecha + "||" + pais + "||" + null + "||" + null + "||" + null
                    + "||" + sexo + "||" + edocivil + "||" + sangre + "||" + capacidad + "||" + correo;
            return  personalesDat;
        } else {
            alert("complete sus datos personales ya que son importantes para realizar su registro");
            return  false;
        }
    }
}
function direccion() {
    var datosDir;
    var estado = ObtenerValor('#input_estado');
    var municipio = ObtenerValor('#dirmunicipio');
    var numExt = ObtenerValor('#dirnumext');
    var numInt = $('#dirnumInt').val();

    var localidad = ObtenerValor('#dirciudad');
    var dcalle = ObtenerValor('#dircalle');
    var dcolonia = ObtenerValor('#dircolonia');
    var codigopostal = ObtenerValor('#cp');
    var celular = ObtenerValor('#numcelular');
    var fijo = ObtenerValor('#tel2');
    if (estado !== false && localidad !== false && dcalle !== false && dcolonia !== false &&
            numExt !== false && municipio !== false && codigopostal !== false
            && fijo !== false && celular !== false) {

        if (fijo === celular) {
            alert("Los telefonos deben ser distintos. Si no cuenta con un teléfono fijo favor de colocar el de un familiar o vecino");

        } else {
            if (numInt == "") {
                numInt = null;
            }
            datosDir = estado + "||" + municipio + "||" + localidad + "||" + dcolonia + "||" + dcalle + "||" + numExt + "||" + numInt + "||" + codigopostal + "||" + celular + "||" + fijo;
            return datosDir;
        }
    } else {
        if (fijo === celular) {
            alert("Los telefonos deben ser distintos. Si no cuenta con un teléfono fijo favor de colocar el de un familiar o vecino");
            $('#tel2').css("border", "1px solid red");
        }
        alert("Es necesario que complete su dirección");
        return false;
    }
}
function escprocedencia() {
    var DatosEscProd;
    var estado = ObtenerValor('#inputestado');
    var municipio = "Municipio";//cambiar por el valor del select municipio  para filtrar la clave de la escuela
    var tipoescuela = ObtenerValor('#combo_tipoescuela');
    var otraescuela = ObtenerValor('#otraescuela');
    var escuela = ObtenerValor('#escuelaprocedencia');
    var clavescuela = ObtenerValor('#clavesc');
    var mesinicio = ObtenerValor('#mes_inicio');
    var anioinicio = ObtenerValor('#anio_inicio');
    var mesfin = ObtenerValor('#mes_fin');
    var aniofin = ObtenerValor('#anio_fin');
    var promedio = ObtenerValor('#inputpromedio');
    if (escuela === '20') {
        if (estado !== false && municipio !== false && tipoescuela !== false &&
                otraescuela !== false &&
                escuela !== false
                && clavescuela !== false && mesinicio !== false && anioinicio !== false && mesfin !== false && aniofin !== false
                && promedio !== false) {
            DatosEscProd = estado + "||" + municipio + "||" + tipoescuela + "||" + otraescuela + "||" + escuela +
                    "||" + clavescuela + "||" + mesinicio + "||" + anioinicio + "||" + mesfin + "||" + aniofin + "||" + promedio;
            return DatosEscProd;
        } else {
            alert("Complete datos de escuela de procedencia");
            return false;
        }
    } else {
        if (estado !== false && municipio !== false && tipoescuela !== false &&
                escuela !== false
                && clavescuela !== false && mesinicio !== false && anioinicio !== false && mesfin !== false && aniofin !== false
                && promedio !== false) {
            DatosEscProd = estado + "||" + municipio + "||" + tipoescuela + "||" + null + "||" + escuela +
                    "||" + clavescuela + "||" + mesinicio + "||" + anioinicio + "||" + mesfin + "||" + aniofin + "||" + promedio;
            return DatosEscProd;
        } else {
            alert("Complete datos de escuela de procedencia");
            return false;
        }
    }
}
function carreradeseada() {
    var DatCarrera;
    var carrera1 = ObtenerValor('#carreraopcion1');
    var carrera2 = ObtenerValor('#carreraopcion2');
    var carrera3 = ObtenerValor('#carreraopcion3');
    var curso = ObtenerValor('#propedeuticoSelect');
    if (carrera1 !== false && carrera2 !== false && carrera3 !== false && curso !== false) {
        DatCarrera = carrera1 + "||" + carrera2 + "||" + carrera3 + "||" + curso;
        return DatCarrera;
    } else {
        alert("Complete las opciones de carrera");
        return false;
    }
}
function nonulos() {
    var persoDatos = personales();
    var Datosdir = direccion();
    var Datosper = escprocedencia();
    var DatosCarr = carreradeseada();
    var DatosFor1;
    if (persoDatos !== false && Datosdir !== false
            && Datosper !== false && DatosCarr !== false
            ) {
        ConfirmaDatos();
        DatosFor1 = persoDatos + "||" + Datosdir + "||" + Datosper + "||" + DatosCarr;
        return DatosFor1;
    } else {
        return false;
    }
}

//**********Datos_Socioeconomicos.jsp
function Datos_vive() {
    var DatosSocioeconomicos;
    var VivePadre = $('input:radio[name=VivePadre]:checked').val();
    var ViveMadre = $('input:radio[name=ViveMadre]:checked').val();

    if (ViveMadre === undefined) {
        alert("Selecione una opción es neseario para porder completar su registro");
        $('input:radio[name=ViveMadre]').css("border", "1px solid red");
        DatosSocioeconomicos = false;
    } else {
        if (VivePadre === undefined) {
            alert("Selecione una opción es neseario para porder completar su registro");
            $('input:radio[name=VivePadre]').css("border", "1px solid red");
            DatosSocioeconomicos = false;

        } else {
            DatosSocioeconomicos = VivePadre + "||" + ViveMadre;
        }
    }
    return DatosSocioeconomicos;
}
function datos_tutor() {
    var DatosTutor;//****************
    var padre = ObtenerValor('#nom_padre');
    var madre = ObtenerValor('#nom_madre');
    var contacto_emergencia = ObtenerValor('#contacto_emergencia');
    var ciudad = ObtenerValor('#ciudad');
    var estado = ObtenerValor('#estado');
    var colonia = ObtenerValor('#colonia');
    var calle = ObtenerValor('#calle');
    var tel_fijo = ObtenerValor('#tel_fijo');
    var tel_cel = ObtenerValor('#tel_cel');
    var cent_trabajo = ObtenerValor('#cent_trabajo');
    var tel_trabajo = ObtenerValor('#tel_trabajo');
    var numExt = ObtenerValor('#socionumext');
    var numInt = validar_numerosContinuar('#socionumInt');
    var codPost = ObtenerValor('#sociocodpost');
    //validando solo  numeros --> telefono  

    var tel_fijonum = ObtenerValorTel("#tel_fijo");//tel_fijo
    var tel_celnum = ObtenerValorTel("#tel_cel");//tel_cel
    var tel_trabajonum = ObtenerValorTel("#tel_trabajo");//tel_trabajo
    var numeroint = validar_numerosContinuar('#socionumext');

    var numeroExt = validar_numerosContinuarint('#socionumInt');
    var numeroCodPost = validar_numerosContinuarint('#sociocodpost');
    //    alert(numeroExt);
//    alert(numeroint);
    if ((numeroExt === false || numeroExt === "false") || (numeroint === false || numeroint === "false")
            || (numeroCodPost === false || numeroCodPost === "false")) {
        alert("Coloque  solo  números");
        return false;
    } else {
//        alert("paso  validación");
        if ((tel_fijonum !== false && tel_celnum !== false && tel_trabajonum !== false)
                ) {
            if (padre !== false && madre !== false
                    && contacto_emergencia !== false && ciudad !== false && estado !== false && colonia !== false
                    && calle !== false && tel_fijo !== false && tel_cel !== false && cent_trabajo !== false
                    && tel_trabajo !== false && numExt !== false && codPost !== false) {
                if (numInt == "") {
                    numInt = null;
                }
                DatosTutor = padre + "||" + madre + "||" + contacto_emergencia + "||" + ciudad + "||" + estado + "||" + colonia + "||" + calle +
                        "||" + tel_fijo + "||" + tel_cel + "||" + cent_trabajo + "||" + tel_trabajo + "||" + numExt + "||" + numInt + "||" + codPost;//********
                return  DatosTutor;//*************
            } else {
                alert("Complete los datos del tutor, ya que son necesarios para  su registro");
                return false;
            }
        } else {
            alert("En los telefonos coloque solo números");
            return false;
        }
    }
}

function datos_socioeconomicos() {
    var DatosBeca;
    var beca = ObtenerValor('#beca');
    var tipo = ValidaBeca();
    var zona = ObtenerValor('#zona');
    var estudios_padre = ObtenerValor('#estudios_padre');
    var estudios_madre = ObtenerValor('#estudios_madre');
    var ingresos = ObtenerValor('#input_ingresos');
    var ocupacionpadre = ObtenerValor('#input_ocpadre');
    var ocupacionmadre = ObtenerValor('#input_ocmadre');
    var quiendepende = ObtenerValor('#quiendepende');
//    var otroquien = ValidaDepende();
    var vivienda = ObtenerValor('#input_vivienda');
    var nopersonas = ObtenerValor('#input_nopersonas');
    var cuartos = ObtenerValor('#input_cuartos');
    var oportunidades = ObtenerValor('#input_oportunidades');
    var habitantes = ObtenerValor('#input_habitantes');
    var otrovive = ValidaOtroVive();
//    var otrovive = ObtenerValor('#otroviveinput');
    var dependientes_sustento = ObtenerValor('#dependientes_sustento');
    //alert("Resultado de valida beca: " + tipo);
    if (beca !== false && tipo !== false && zona !== false && estudios_padre !== false && estudios_madre !== false
            && ingresos !== false && ValidaDepende() !== false && ocupacionpadre !== false && ocupacionmadre !== false && quiendepende !== false
            && vivienda !== false && otrovive !== false && nopersonas !== false && cuartos !== false && oportunidades !== false && habitantes !== false
            && dependientes_sustento !== false) {
        DatosBeca = beca + "||" + tipo + "||" + zona + "||" + estudios_padre + "||" + estudios_madre + "||" + ingresos + "||" + ValidaDepende() + "||"
                + ocupacionpadre + "||" + ocupacionmadre + "||" + quiendepende + "||" + vivienda +
                "||" + otrovive + "||" + nopersonas + "||" + cuartos + "||" + oportunidades + "||" + habitantes + "||" + dependientes_sustento;////***********************
        return DatosBeca;
    } else {
        if (tipo === false) {
            $('#tipo_beca').css("border", "1px solid red");
            alert("Sólo letras");
        }
        alert("Complete sus datos socieconomicos ya que son importantes para su registro");
        return false;
    }
}

function nonulos_socioeconomicos() {

    var DatosSegForm;
    if (Datos_vive() !== false && datos_socioeconomicos() !== false && datos_tutor() !== false) {
        DatosSegForm = datos_tutor() + "||" + Datos_vive() + "||" + datos_socioeconomicos();//****************+
        return DatosSegForm;
    } else {
        return false;
    }
}


//************Mostrar_Manual.jsp 
function MostrarManual() {
    $(function () {
        var picture = $('#manual_aspirante');
        picture.on('load', function () {
//            alert("Funcion  guillotin");
            picture.guillotine({eventOnChange: 'guillotinechange'});
            var data = picture.guillotine('getData');
            for (var key in data) {
                $('#' + key).html(data[key]);
            }
            picture.guillotine('fit');
            $('#fit').click(function () {
                picture.guillotine('fit');
            });
            $('#zoom_in').click(function () {
                alert("btn zoom in ");
                picture.guillotine('zoomIn');
            });
            $('#zoom_out').click(function () {
                picture.guillotine('zoomOut');
            });
            picture.on('guillotinechange', function (ev, data, action) {
                data.scale = parseFloat(data.scale.toFixed(4));
                for (var k in data) {
                    $('#' + k).html(data[k]);
                }
            });
        });
    });
}
//*************************INICIO****************************************************************************************************

//****************recuperarPreficha.jsp

$('#crp').submit(function (event) {
    var cur = document.getElementById("curp").value;
    if (!cur.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
        alert('Por favor revise su curp!');
        event.preventDefault();
    }
});

//****************Renovar Preficha.jsp
/*
 $('#curpFormRenovar').submit(function (event) {
 var curp = document.getElementById("curpRenovar").value;
 if (!curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
 alert('Por favor revise su curp!');
 event.preventDefault();
 }
 });*/

//*****Contacto.jsp
function recarga() {
    $('#txtCaptcha').val("");
    $('#captcha').attr('src', 'imgCaptcha.png?' + new Date().getTime());
}
function lightbox_open_correo() {
    window.scrollTo(0, 0);
    $('#light_correo').fadeIn(1000);
    $('#fade_correo').fadeIn(1000);
}
function lightbox_close_correo() {
    $('#light_correo').fadeOut(1000);
    $('#fade_correo').fadeOut(1000);
}
//--------------------->
function lightbox_open() {
    window.scrollTo(0, 0);
    $('#light').fadeIn(1000);
    $('#fade').fadeIn(1000);
}
function lightbox_close() {
    $('#light').fadeOut(1000);
    $('#fade').fadeOut(1000);
}
window.document.onkeydown = function (e) {
    if (!e) {
        e = event;
    }
    if (e.keyCode == 27) {
        lightbox_close();
    }
};

//********Ayuda.jsp
function lightbox_open_ayuda() {
    window.scrollTo(0, 0);
    document.getElementById('light_imagen_pop').style.display = 'block';
    document.getElementById('fade_im_pop').style.display = 'block';
}
function lightbox_close_adyuda() {
    document.getElementById('light_imagen_pop').style.display = 'none';
    document.getElementById('fade_im_pop').style.display = 'none';
}
///////////////////////////////////////////////////////////////////////////////////////////AL  CARGAR LA  PÁGINA ////////////////////////////////////////////////////////////////
$(document).ready(function () {
    ValidaTipos();
    MostrarManual();
//***Contacto 
    $('#captcha_btn').click(function () {
        recarga();
    });
    $('#formulario_inicio').submit(function (event) {
        var captcha = document.getElementById("txtCaptcha").value;
        $.ajax({
            type: "POST",
            async: false,
            url: "ValidaCap",
            data: {code: captcha},
            success: function (data) {
                if (data === "si") {
                    $.ajax({
                        type: "GET",
                        async: false,
                        url: "servlet/EnviaMailContacto",
                        data: $('#formulario_inicio').serialize(),
                        success: function (data) {
                            if (data === "s") {
                                alert("Su mensaje se ha enviado exitosamente. Espere una respuesta.");
                                lightbox_close();
                            } else {
                                alert("Se tuvieron problemas para enviar el correo.");
                                event.preventDefault();
                            }
                        }
                    });
                } else {
                    alert("Captcha inválido");
                    event.preventDefault();
                    recarga();
                }
            }
        });
    });

//**************RenovarPreficha.jsp
    $('#btnCurpRenovar').off().on('click', function (event) {
        event.preventDefault();
        //alert('En boton de renovar');
        var curp = $('#curpRenovar').val().toString().trim();

        //alert('Dentro del boton de recuperar para la curp: ' + curp);
        if (!curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
            // $('#divLoading').modal('hide'); 
            alert('Curp invalida, porfavor verifíquela');
        } else {
            //event.preventDefault();
            //$('#divLoading').modal(); 
            //$('#divContainerRenovRef').load('vistas/Inicio/Loading.jsp');
            //alert('Llamando servlet con:' + curp);
            /*$('#divRenovarRef').hide();
             $('#divCargandoRenov').show();*/
            $(this).attr("disabled", true);
            window.open('ValidaRenovar' + '?curpR=' + curp, '_blank');
            $(this).attr("disabled", false);
            //event.preventDefault();
            /*$('#divRenovarRef').show();
             $('#divCargandoRenov').hide();*/
            //$('#divLoading').hide();
            //$('#divContainerRenovRef').load('/MODULO_ASPIRANTE/Vistas/Inicio/.jsp');
            //$('#divLoading').modal('hide'); 
        }

    });

    /*$('#curpFormRenovar').on('success.form.fv', function(ev){
     
     var curp = $('#curpRenovar').val;
     
     //alert('Dentro del boton de recuperar para la curp: ' + curp);
     if (!curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
     // $('#divLoading').modal('hide'); 
     alert('Curp invalida, porfavor verifíquela');
     
     }
     ev.preventDefault();
     });*/

    //*************** recuperarPreficha.jsp
    $('#btn_crp').off().on('click', function () {
        var curp = $('#curp').val().trim();

        if (!curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
            // $('#divLoading').modal('hide'); 
            alert('Curp invalida, porfavor verifíquela');
        } else {

            //$('#divLoading').modal(); 
            //$('#divContainerRenovRef').load('vistas/Inicio/Loading.jsp');
            $('#elem_recupera').hide();
            $('#divContainerRecuperaPre').show();
            window.open('PrefichaPDF' + '?curp=' + curp, '_blank');
            $('#elem_recupera').show();
            $('#divContainerRecuperaPre').hide();
            //$('#divLoading').hide();
            //$('#divContainerRenovRef').load('/MODULO_ASPIRANTE/Vistas/Inicio/.jsp');
            //$('#divLoading').modal('hide'); 
        }
    });


//**************INDEX.JSP
//Muestra  Aceptar 
    $("#comprobar").click(function ()
    {
        if ($("#comprobar").is(':checked')) {
            $('#heleido').css("display", "block");
        } else {
            $('#heleido').css("display", "none");
        }
    });

    /*/Regresa a Index.jsp cuanto el boton de home es pulsado
     $("#inicio").click(function()
     {
     ("#Contenedor_Bienvenido").load("/MODULO_ASPIRANTE/Vistas/Inicio/inicio.jsp");
     });
     */
//*** Enviar correo  de verificación
    $('#heleido').off().on('click', function () {

        $.get("CapPrefichas", function (data) {
            if (data === "disponible") {
                $('#divAvisoPago').modal({
                    backdrop: "static"
                });
            } else {
                prefichas(data);
//                $('#divMarcoNoFichas').modal({
//                    backdrop: "static"
//                });
            }
        });

        //$('#divMarcoNoFichas').modal({backdrop: "static"});
        //$('#cargandoDivAnimacion').hide();
        //$('#divmarcoEnvCorreo').modal();
    });
    function prefichas(per) {

        var resumen = per.split("&");
        if (resumen[0] != -10)
        {
            $('#divMarcoNoFichas').modal({
                    backdrop: "static"
            });
        } else
        {
            alert(resumen[1]);
            hideBtnInicio();
        }
    }

    $('#btnAvisoPagoAcep').off().on('click', function () {
        $('#divAvisoPago').modal('hide');
        $('#divmarcoEnvCorreo').modal({
            backdrop: "static"
        });
    });
    $('#btnAvisoPagoCancel').off().on('click', function () {
        hideBtnInicio();
        $('#divAvisoPago').modal('hide');
    });
    $('#btnXPagoExa').off().on('click', function () {
        hideBtnInicio();
        $('#divAvisoPago').modal('hide');
    });

    $('#btnCancelarNoFichas').off().on('click', function () {
        hideBtnInicio();
        $('#divMarcoNoFichas').modal('hide');
    });
    $('#btnContinuaNoFichas').off().on('click', function () {
        $('#divMarcoNoFichas').modal('hide');
        $('#divmarcoEnvCorreo').modal({
            backdrop: "static"
        });
    });
    $('#btnXNoFichas').off().on('click', function () {
        hideBtnInicio();
        $('#divMarcoNoFichas').modal('hide');
    });

    $('#btnCorreoCancel').off().on('click', function () {
        $('#InCorreoE').val("");
        $('#RespuestaServlet').hide();
        $('#contenedor_inCorreo').show();
        hideBtnInicio();
        $('#divmarcoEnvCorreo').modal('hide');
    });
    $('#btnCorreoAcep').off().on('click', function () {
        var Email = $('#InCorreoE').val().trim();
        if ((Email === "" || Email === undefined || Email === null)) {
            alert("Por  favor  introduzca  una  dirección de correo");
            $('#InCorreoE').css("border", "1px solid red");
        } else {
            var p = validaCorreoElectronico('#InCorreoE');
            if (p === true) {
                $("#cargandoDivAnimacion").show();
                EnviaCorreoInicio();
            }
        }
    });
    $('#btnAvisoCorreoCont').off().on('click', function () {
        $('#divReturnCorreo').modal('hide');
        $('#cargandoDivAnimacion').hide();
        $('#InCorreoE').val("");
        $('#heleido').hide();
        $("#comprobar").removeAttr("checked");
    });
    $('#btnXAvisoCorreo').off().on('click', function () {
        hideBtnInicio();
        $('#divReturnCorreo').modal('hide');
    });
    $('#btnXIngresCorreo').off().on('click', function () {
        hideBtnInicio();
        $('#divmarcoEnvCorreo').modal('hide');
    });


    function hideBtnInicio() {
        $('#heleido').hide();
        $("#comprobar").removeAttr("checked");
    }

//**************DATOS_ASPIRANTE.JSP
//
    $('#iniciobtn').off().on('click', function () {
        var home = confirm("Los  datos no  han sido guardados  y se  perderán. ¿Desea salir de la página? ");
        if (home == true) {
            location.href = "/MODULO_ASPIRANTE/Index.jsp";
        } else {

        }
    });
    //Limpia el input cada vez que se cambia el select de estado de la escuela de procedencia
    $('#inputestado').change(function () {
        $('#clavesc').val('');
    });


//combos de  municipio  y  localidad  que son dependientes
    $('#selectedonacimiento').change(function () {
        var pk = $('#selectedonacimiento option:selected').val();
        var opcion = 1;
        $.getJSON("/MODULO_ASPIRANTE/CargaCatalogoServlet",
                {pk: pk, opcion: opcion},
                function (data) {
                    //limpiar el option value
                    Filtros("#combompnacimiento", data);
                });
    });
    $('#input_estado').change(function () {
        var pk = $('#input_estado option:selected').val();
        var opcion = 1;
        $.getJSON("/MODULO_ASPIRANTE/CargaCatalogoServlet",
                {pk: pk, opcion: opcion},
                function (data) {
                    //limpiar el option value
                    Filtros("#dirmunicipio", data);
                });
    });
    $('#inputestado').change(function () {
        $('#buscar_clave').prop("disabled", false);
    });
    $('#estado').change(function () {
        var pk = $('#estado option:selected').val();
        var opcion = 1;
        $.getJSON("/MODULO_ASPIRANTE/CargaCatalogoServlet",
                {pk: pk, opcion: opcion},
                function (data) {
                    //limpiar el option value
                    Filtros("#ciudad", data);
                });
    });
    $('#combompnacimiento').change(function () {
        var pk = $('#combompnacimiento option:selected').val();
        $('#combocdnacimiento').prop("disabled", false);
        var opcion = 2;
        $.getJSON("/MODULO_ASPIRANTE/CargaCatalogoServlet",
                {pk: pk, opcion: opcion},
                function (data) {
                    //limpiar el option value
                    Filtros("#combocdnacimiento", data);
                });
    });
    $('#dirmunicipio').change(function () {
        var pk = $('#dirmunicipio option:selected').val();
        var opcion = 2;
        $.getJSON("/MODULO_ASPIRANTE/CargaCatalogoServlet",
                {pk: pk, opcion: opcion},
                function (data) {
                    //limpiar el option value
                    Filtros("#dirciudad", data);
                });
    });
    //Boton de  ayuda 
    $('#ayudabtn').on('click', function () {
    });
    //Botón buscar clave
    var table;
    $('#buscar_clave').off().on('click', function () {

        $("#cargandoCCT").show();
        $("#tablaCCT").find("tr:gt(0)").remove();
        var estado = $('#inputestado option:selected').val();
        $("#buscar_clave").prop("disabled", true);
        $.get('/MODULO_ASPIRANTE/Servlet_ClaveCCT',
                {estado: estado},
                function (retorno) {
                    var $ul = $('<tbody id="ListaClave"></tbody>').appendTo($('#tablaCCT'));
                    $.each(retorno, function (index, item) {
                        var txt = item.clave;
                        var t = item.CentroEducativo;
                        var c = txt + "-" + t;
                        $('#ListaClave').append("<tr><td><input  type='radio' name='RadioClave' class='CCTs' value='"
                                + item.clave + "'/></td>\n\
                  <td>" + item.clave + "</td><td>" + item.CentroEducativo + "</td>\n\
                  <td>" + item.turno + "</td><td>" + item.Domicilio + "</td></tr><br>");
                    });
                    $('#FondoSeleccionaClave').show();
                    $('#SelecionaClave').show();
                    table = $('#tablaCCT').DataTable();
                });

    });


    $('#FondoSeleccionaClave').on('click', function () {
        $('#FondoSeleccionaClave').hide();
        $('#SelecionaClave').hide();
    });
    $('#aceptarCCT').on('click', function () {
        ObtineneCCT();
        $('#SelecionaClave').hide();
        $('#FondoSeleccionaClave').hide();
        $('#cargandoCCT').hide();
        table.destroy();
    });
    $('#cancelarCCT').on('click', function () {
        $('#SelecionaClave').hide();
        $('#FondoSeleccionaClave').hide();
        $('#cargandoCCT').hide();
        table.destroy();

    });
    //CAMBIO EN OTRO TIPO DE ESCUELA REVALIDACION/ACUERDO 286
    $('#otraescuela').change(function () {
        var e = document.getElementById("otraescuela");
        var strUser = e.options[e.selectedIndex].value;
        if (strUser === 'Re') {
            //Asigna el esado de mexico
            document.getElementById('inputestado').selectedIndex = 15;
            $('#clavesc').val('REVSEP');
        }
        if (strUser === 'Ac') {
            //Asigna el esado de mexico
            document.getElementById('inputestado').selectedIndex = 15;
            $('#clavesc').val('ACD286RVDN');
        } else {

        }
    });
    //validar  fecha
    $('#combopaisnacimiento').change(function () {
        evaluar();
    });
    //Validar  opcion otro en escuela de procedencia
    $('#escuelaprocedencia').change(function () {
        var tipo_otra = ObtenerValor('#escuelaprocedencia');
        if (tipo_otra === "20") {
            $('#opcion_otraescuela_aparece').show();
        } else {
            $('#opcion_otraescuela_aparece').hide();
        }
    });
    //tipo beca
    $('#beca').change(function () {
        var beca = $('#beca').val();
        if (beca === 'S') {
            $('#beca_cual').show();
            ValidaOtraOpcion('#beca_tipo');
        } else {
            $('#beca_cual').hide();
        }
    });
    //otro depende economicamente 
    $('#quiendepende').change(function () {
        var depende = $('#quiendepende').val();
        if (depende.trim() === 'Otro') {
            $('#datosbeca').css("height", "430px");
            $('#otroeconomicamente').show();
            $('#otroquiendepende').show();
            ValidaOtraOpcion('#otroquiendepende');
        } else {
            $('#datosbeca').css("height", "");
            $('#otroeconomicamente').hide();
            $('#otroquiendepende').hide();
        }
    });
    //otro vive
    $('#input_habitantes').change(function () {
        var depende = $('#input_habitantes').val();
        if (depende.trim() === 'Otro') {
            $('#datosbeca').css("height", "430px");
            $('#socioeconomicos_inferior').css("height", "335px");
            $('#otrovive').show();
            $('#otroviveinput').show();
            ValidaOtraOpcion('#otroviveinput');
        } else {
            $('#datosbeca').css("height", "");
            $('#socioeconomicos_inferior').css("height", "");
            $('#otrovive').hide();
            $('#otroviveinput').hide();
        }
    });
    $('#carreraopcion1').change(function () {
        $('#carreraopcion2').prop("disabled", false);
        Carreras('#carreraopcio1', 1);
    });
    $('#carreraopcion2').change(function () {
        $('#carreraopcion3').prop("disabled", false);
        Carreras('#carreraopcion2', 2);
    });
    $('#carreraopcion3').change(function () {
        Carreras('#carreraopcion3', 3);
    });
    $('#anio_fin').change(function () {
        //ValidaPeriodoEscPro();
        //valDate();
//        document.getElementById('anio_fin').selectedIndex = 0;
    });
    $('#mes_fin').change(function () {
        //valDate();
    });
    function hideBtnsPersonal() {
        $('#divLoadingPersonal').addClass('hidden');
        $('#divMarcoBtnsPersonalData').removeClass('hidden');
    }
//Botón Continuar 
    $('#continuar_datos').off().on('click', function () {
        //event.preventDefault();
        //$(this).attr("disabled", true);
        //$(this).hide();
        $('#divMarcoBtnsPersonalData').addClass('hidden');
        $('#divLoadingPersonal').removeClass('hidden');
        var op1carre = $('#carreraopcion1').val();
        var op2carre = $('#carreraopcion2').val();
        var op3carre = $('#carreraopcion3').val();
//        alert("Op1:  "+op1carre);
//        alert("Op2:  "+op2carre);
//        alert("Op3:  "+op3carre);
        var opcion = 1;
        //var periodoEsc = ValidaPeriodoEscPro();
        var periodoEsc = valDate();
        //alert('lo que nos dio de calida perioso: ' + periodoEsc);
        ValidaTipos();
        var SoloNumerosExt = validar_numerosContinuar('#dirnumext');
//        alert(SoloNumerosExt +"Exterior");
        var SoloNumerosInt = validar_numerosContinuar('#dirnumInt');
//        alert(SoloNumerosInt +"Interior");
        var codPostal = validar_numerosContinuar('#cp');
        var telefonofijo = $('#tel2').val();
        var telefonopersonal = $('#numcelular').val();
        var TodNulos = nonulos();
        //alert("Resultado todos nulos" + TodNulos);
        if (TodNulos !== false || TodNulos !== '' || TodNulos !== 0) {
            if (periodoEsc !== false || periodoEsc !== '' || periodoEsc !== "false") {
                if (SoloNumerosExt.trim() === false || SoloNumerosExt.trim() === "false") {
                    hideBtnsPersonal();
                } else {
                    if (SoloNumerosInt.trim() === false || SoloNumerosInt.trim() === "false") {
                        hideBtnsPersonal();
                    } else {

                        $.get('/MODULO_ASPIRANTE/DatosPersonalesAsp',
                                {TodNulos: TodNulos, opcion: opcion, telefonofijo: telefonofijo, telefonopersonal: telefonopersonal
                                    , op1carre: op1carre, op2carre: op2carre, op3carre: op3carre, zipCode: codPostal, periodoEsc: periodoEsc},
                                function (data) {
                                    //alert("info del servlet: data = " + data);
                                    if (data == 0) {
                                        ConfirmaDatos();
                                        //alert("Termina confirmaDatos con data=" + data +"\n intentando modal de confirmacion");
                                        //$('#div_fondomarco').show();
                                        //$('#divmarco').show();
                                        $('#divMarcoContinuaSocioecon').modal({
                                            backdrop: "static"
                                        });
                                    }
                                    if (data > 0 && data != 3 && data != 5 && data != 6 && data != 7 && data != 8) {
                                        alert("La curp y/o el correo ya  han sido  registrados en esta convocatoria");
                                        $('#divmarco').hide();
                                        $('#div_fondomarco').hide();
                                    }
                                    if (data == 3) {
                                        alert("La fecha de nacimiento seleccionada no correspode con la fecha de nacimiento en la curp.");
                                    }
                                    if (data == 5) {
                                        //alert("Los números telefónicos deben ser distintos de ceros.");
                                        alert("Verifíque los números telefónicos, ya que deben ser distintos de cero y solo pueden contener digitos.");
                                    }
                                    if (data == 6) {
                                        alert("Las opciones de carrera se repiten, para continuar asegurese de elegir opciones distintas.");

                                    }
                                    if (data == 7) {
                                        alert("El codigo postal solo puede contener números");
                                    }
                                    if (data == 8) {
                                        alert("Porfavor verifique el periodo en el apartado de escuela de procedencia.");
                                        $('#mes_fin').css("border", "1px solid red");
                                        $('#anio_fin').css("border", "1px solid red");
                                    }
                                    hideBtnsPersonal();

                                });

                    }
                }
            } else {
                alert("La  fecha inicial no  puede ser menor a la  fecha  final");
                hideBtnsPersonal();
            }
        } else {
            alert("Complete todos los campos");
            hideBtnsPersonal();

        }
        hideBtnsPersonal();
        //$(this).show();
    });
    $('#cancelar').on('click', function () {
        $('#divmarco').hide();
        $('#div_fondomarco').hide();
    });
    $('#btnCancelAspData').off().on('click', function () {
        $('#divMarcoContinuaSocioecon').modal('hide');
    });

    $('#confirmar').off().on('click', function () {
        var opcion = 3;
        $.get('/MODULO_ASPIRANTE/CargaCatalogoServlet',
                {opcion: opcion},
                function () {
                    $('#divmarco').hide();
                    $('#div_fondomarco').hide();
                    $("#contenido").load("/MODULO_ASPIRANTE/vistas/Aspirante/Datos_Socioeconomicos.jsp");
                });
    });
    $('#btnConfirmaAspData').off().on('click', function () {
        var opcion = 3;
        $.get('/MODULO_ASPIRANTE/CargaCatalogoServlet',
                {opcion: opcion},
                function () {
                    $("#contenido").load("/MODULO_ASPIRANTE/vistas/Aspirante/Datos_Socioeconomicos.jsp");
                    $('#divMarcoContinuaSocioecon').modal('hide');
                });
    });

//*******************DATOS SOCIOECONOMICOS.JSP 
//    $('#regresar_socioeconomicos').click(function() {
//        var DatosFormu1 = $('#ObjetoPersonales').text();
//        var opcion = 3;
//        $.get('/MODULO_ASPIRANTE/DatosPersonalesAsp',
//                {DatosFormu1: DatosFormu1, opcion: opcion},
//        function(data) {
//            window.location.reload();
//            $('#dirmunicipio').val("México");
//        });
//    });

    $('#continuar_socioeconomicos').off().on('click', function () {
        //event.preventDefault();
        $('#continuarsocioeconomicos').addClass('hidden');
        $('#contenLoadingBar').removeClass('hidden');
        $(this).attr("disabled", true);
        /*$('#divMarcoFinReg').modal({
         backdrop: "static"
         });*/
        //$('#borrar_socioeconomicos').attr("disabled", true);
        var DatosSoc = nonulos_socioeconomicos();
        if (DatosSoc === false || DatosSoc === '') {
            $('#contenLoadingBar').addClass('hidden');
            $('#continuarsocioeconomicos').removeClass('hidden');
        } else {
            $.get('/MODULO_ASPIRANTE/InsertandoDatos',
                    {DatosSoc: DatosSoc},
                    function (RespuestaDatosAsp) {
                        alert("ESTA ES LA RESPUESTA " + RespuestaDatosAsp);
                        var res;
                        var op;
                        $.each(RespuestaDatosAsp, function (index, item) {
                            res = item.Nombre;
                            op = item.Clave;
                        });
                        $('#RetornoEnvioFinReg').text(res);

                        switch (op) {
                            case "0"://registro exitoso
//                        $('#btnFinRegAceptar').show();
//                        $('#btnFinRegAceptar').prop("disabled", false);
//                        $('#btnFinRegCancel').hide();
                                $('#btnFinRegAceptar').removeClass('hidden');
                                break;

                            case "-1": //algun error
                                //$('#btnFinRegAceptar').hide();
                                //$('#btnFinRegCancel').show();
                                //$('#btnFinRegAceptar').prop("disabled", false);
                                $('#btnFinRegCancel').removeClass('hidden');
                                break;

                            case "2"://no se  puede enviar correo 
                                //$('#btnFinRegCancel').show();
                                //$('#btnFinRegAceptar').hide();
                                //$('#btnFinRegAceptar').prop("disabled", false);
                                $('#btnFinRegAceptar').removeClass('hidden');
                                break;

                            case "-2"://el aspirante  ya esta  registrado
                                //$('#btnFinRegAceptar').prop("disabled", false);
                                //$('#btnFinRegCancel').hide();
                                //$('#btnFinRegCancel').show();
                                $('#btnFinRegAceptar').removeClass('hidden');
                                break;

                            case "4":
                                //$('#btnFinRegAceptar').show();
                                //$('#btnFinRegAceptar').prop("disabled", false);
                                //$('#btnFinRegCancel').hide();
                                $('#btnFinRegAceptar').removeClass('hidden');
                                break;

                            case "5":
                                //$('#btnFinRegAceptar').prop("disabled", false);
                                //$('#btnFinRegCancel').hide();
                                //$('#cancelarfinalizado').show();
                                $('#btnFinRegCancel').removeClass('hidden');
                                break;

                            default:
                                $('RetornoEnvioFinReg').text('Ha ocurrido un error y no se  han  podido guardar sus datos.'
                                        + 'Por favor vuelva a intentarlo y si el error persiste favor de '
                                        + 'contactarnos desde la  página  principal en el  apartado de contacto.');
                                //$('#btnFinRegAceptar').prop("disabled", true);
                                //$('#btnFinRegCancel').hide();
                                //$('#btnFinRegCancel').show();
                                $('#btnFinRegCancel').removeClass('hidden');


                                break;
                        }
                        $('#contenLoadingBar').addClass('hidden');
                        $('#continuarsocioeconomicos').removeClass('hidden');
                        $('#divMarcoFinReg').modal({
                            backdrop: "static"
                        });
                        //   $('#fondofinalizado').show();
                        //   $('#finalizado').show();


                    });
        }
        $(this).attr("disabled", false);
        //$('#borrar_socioeconomicos').attr("disabled", false);
    });
//Registro  finalizado  vuelve  a 
    //$('#aceptarfinalizado').off().on('click', function () {
    $('#btnFinRegAceptar').off().on('click', function () {
        //event.preventDefault();
        //llama  servlet  que  limpia  variables  
        //$(this).attr("disabled", true);
        var opcion = 2;
        $.get('/MODULO_ASPIRANTE/DatosPersonalesAsp',
                {opcion: opcion},
                function (data) {
                    $('#divMarcoFinReg').modal('hide');
                    $(this).addClass('hidden');
                    //$('#contenLoadingBar').removeClass('hidden');
                    //$('#contenRespInsert').addClass('hidden');
                    //window.history.forward(1);
                });
        jQuery(document).ready(function ($) {

            if (window.history && window.history.pushState) {

                window.history.pushState('forward', null, './#forward');

                $(window).on('popstate', function () {
                    window.location.href = "/manualAspirante";
                    //window.location.replace("/manualAspirante");
                });
            }
        });
        // $(this).attr("disabled",false);
    });
    //$('#cancelarfinalizado').off().on('click', function () {
    $('#btnFinRegCancel').off().on('click', function () {
        /*$('#fondofinalizado').hide();
         $('#finalizado').hide();
         */
        $('#divMarcoFinReg').modal('hide');
        $(this).addClass('hidden');
        $('#RetornoEnvioFinReg').text("");
        //$('#contenRespInsert').addClass('hidden');
        //$('#continuarsocioeconomicos').removeClass('hidden');
    });
    /*Pruebas Para mondostrar ocultar barra carg
     $('#btnPruebaLoad').off().on('click', function () {
     
     $('#contenLoadingBar').addClass('hidden');
     $('#contenLabelPago').removeClass('hidden');
     $('#btnAvisoPagoAcep').addClass('hidden');
     $('#btnAvisoPagoCancel').addClass('hidden');
     });*/


    ////////////////////////////*********************************/////////////////////////////////////////////////
    //carga correcta
    $('#cerrar').on('click', function () {
        $('#content').hide();
    });
    //**************SUBIR  FOTOGRAFIA ----En construcción 
    $('#subirfoto').change(function (e) {
        addImage(e);
        ValidaImagen();
    });
    function addImage(e) {
        var file = e.target.files[0];
        var imageType = /image.*/;
        if (!file.type.match(imageType)) {
            return;
        }
        var reader = new FileReader();
        reader.onload = fileOnload;
        reader.readAsDataURL(file);
    }
    function fileOnload(e) {
        var result = e.target.result;
        $('#fotografia').attr("src", result);
    }
    $('input.cargafoto').click(function () {
//validar  al subir el archivo
        $('#divmarco').hide();
        $('#div_fondomarco').hide();
        $("#contenido").load("vistas/Aspirante/CargarFoto.jsp");
//        validaImagen();
    });
    $('#subirdespues , #confirmarcarga').click(function () {
        $('#div_marco').hide();
        $('#div_fondomarco').hide();
        $("#contenido").load("/MODULO_ASPIRANTES/vistas/Aspirante/Datos_Socioeconomicos.jsp");
    });
});
/////////////////////////////////////////////////////////////////////////////////////// fin cargar  la  página /////////////////////////////////////////////////////

///*****************En construccion
//function curpvalida() {
//    var curp = document.forms['crp'].elements['curp'].value;
//    if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
//        alert('curp válida!');
//        return false;
//    } else {
//        alert('curp incorrecta!');
//        return false;
//    }
//}
///Validar  foto ---En construcción
function ValidaImagen() {
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
    $('#fondocarga').show();
    $('#carga').show();
}

//function  ValidaImage() {
//    var imagen = $('#subirfoto');
//    var foto = imagen.val();
//    var ext = foto.substr(-4, 4);
//    var img = document.createElement("IMG");
//    img.src = $('#subirfoto').val();
//    img.id = "final";
//    setTimeout(1000000000);
//    var tam = $('#final').fileSize;
//    alert(tam);
//    document.appendChild(img);
//    setTimeout("alert(Math.round((document.getElementById('final').fileSize / 1024)*Math.pow(10,2)) / Math.pow(10,2)); ", 1000);
//    alert(img);
//    alert(img.ATTRIBUTE_NODE);
//    var tam = $("#final").fileSize;
//    alert(tam);
//    alert(imagen.fileSize);
//    if(ext!=='.png' || ext!== '.jpg'){
////        if(){}
//       
//    }
//}

function validarMail() {
    var nombre = document.getElementById("txtNombre").value;
    var correo = document.getElementById("txtEmail").value.indexOf("@");
    var descripcion = document.getElementById("txtDescripcion").value;

    if (nombre.length == 0) {
        alert("Es obligatorio indicar un nombre");
        return false;
    }

    if (correo == -1) {
        alert("Dirección de correo electrónico no válida");
        return false;
    }
    if (descripcion.lenght == 0) {
        alert("Por favor introduzca un mensaje para el administrador");
        return false;
    }
    if (nombre.lenght !== 0 && correo !== -1 && descripcion.lenght !== 0)
    {
        $("#Contenedor_Bienvenido").load("contacto.jsp", function (responseTxt, statusTxt, xhr) {
            var frame = document.getElementById('grande');
            frame.style.height = "100%";
        });
    }
}
function validaCorreoElectronico(id) {
//    $(id).change(function() {
    //var patron = /^([A-z]+[A-z0-9._-]+)*@{1}([A-Za-z0-9\.]{2,})\.([a-z]{2,})$/;
    var patron = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
    var email = $(id).val();
    if (!patron.test(email)) {
        $(id).css("border", "1px solid red");
        alert("El correo " + email + " no  tiene el formato especificado"
                + " ejemplo@smtp.com");
        $(id).val("");
        return false;
    } else {
        $(id).css("border", "");
        return true;
    }
//    });
}




