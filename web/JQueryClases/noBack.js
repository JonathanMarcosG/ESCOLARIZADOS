/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

jQuery(document).ready(function ($) {

    if (window.history && window.history.pushState) {

        window.history.pushState('forward', null, './#forward');

        $(window).on('popstate', function () {
            window.location.href = "manualAspirante";
        });
    }
});