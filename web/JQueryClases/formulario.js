/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* # Validando Formulario de  apartado de contacto para  enviar  email
 ============================================*/
$(document).ready(function () {
    $('#formulario_inicio').validate({
        errorElement: "span",
        rules: {
            txtNombre: {
                minlength: 2,
                required: true
            },
            txtEmail: {
                required: true,
                email: true
            },
            txtTitulo: {
                minlength: 2,
                required: true
            },
            txtDescripcion: {
                minlength: 2,
                required: true
            },
            txtCaptcha: {
                minlength: 2,
                required: true
            }
        },
        highlight: function (element) {
            $(element).closest('.control-group')
                    .removeClass('success').addClass('error');
        },
        success: function (element) {
            element
                    .text('OK!').addClass('help-inline')
                    .closest('.control-group')
                    .removeClass('error').addClass('success');
        }
    });
});