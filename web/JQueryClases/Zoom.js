/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Función para el  zoom en  MuestrManual
$(document).ready(function() {
    jQuery(function() {
        var picture = $('#manual_aspirante');
        picture.on('load', function() {
            picture.guillotine({eventOnChange: 'guillotinechange'});
            var data = picture.guillotine('getData');
            for (var key in data) {
                $('#' + key).html(data[key]);
            }
            picture.guillotine('fit');
            $('#fit').click(function() {
                picture.guillotine('fit');
            });
            $('#zoom_in').click(function() {
                picture.guillotine('zoomIn');
            });
            $('#zoom_out').click(function() {
                picture.guillotine('zoomOut');
            });
            picture.on('guillotinechange', function(ev, data, action) {
                data.scale = parseFloat(data.scale.toFixed(4));
                for (var k in data) {
                    $('#' + k).html(data[k]);
                }
            });
        });
    });

});

