/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import beans.BMail;

/**
 *
 * @author Jony
 */
public class CuerpoCorreos {

    BMail beanMail;

    public BMail inicioRegistro(String APP_HOME, String liga) {
        beanMail = new BMail();
        String mensaje = new StringBuffer()
                .append("<b><font size=4 face=\"arialblack\" >")
                .append(" Durante el proceso de registro recibirá los  siguientes  correos, por favor permanezca al pendiente: \n")
                .append("<br><br>")
                .append(" 1.-Correo  de generación de preficha, que se le enviará  al concluir el registro de sus datos. \n")
                .append("<br>")
                .append("2.-Correo de liberación de pago, en un periodo máximo de 3 a 4 días hábiles después de haber realizado el pago bancario. \n")
                .append("<br>")
                .append("3.-Correo de alta en Ceneval, máximo 2 días  hábiles después del correo anterior. Es importante que reciba estos dos últimos correos. \n ")
                .append("<br>")
                .append("4.-Correo de generación de ficha, que le será  enviado  al concluir el proceso de registro, esto  después de haber entregado sus papeles en el departamento de servicios escolares edif. X \n")
                .append("<br><br>")
                .append("En caso de no recibir alguno de ellos, comuníquese con nostros desde:  ")
                .append("<br>")
                .append("<a href=\"")
                .append(APP_HOME)
                .append("\" target=\"_blank\">")
                .append(APP_HOME)
                .append(" </a>  en el apartado de contacto.</font></b>")
                .append("<br><br>")
                .append("<b><ins>Importante:</ins><b> Para realizar cualquier cambio en los datos proporcionados deberá solicitarlo en ventanilla al")
                .append(" momento de entregar su documentación en el departamento de Servicios Escolares Edif. X. Así mismo deberá recordar que no habrá cambios en  las opciones de carrera.")
                .append("Tome en cuenta que es responsabilidad del aspirante cumplir con todas etapas del proceso\n")
                .append("para finalizar su registro de lo contrario su solicitud será rechazada.")
                .append("<br><br>")
                .append("<b><ins>Advertencia:</ins></b> ES IMPORTANTE QUE CONSIDERE QUE UNA VEZ FINALIZADO SU REGISTRO TENDRÁ DOS DÍAS HÁBILES PARA REALIZAR SU PAGO, DE LO CONTRARIO SU REFERENCIA EXPIRARÁ. \n")
                .append("En caso de que su referencia  expire usted podrá renovarla ingresando  a la liga de <a href=\"")
                .append(APP_HOME)
                .append("\" target=\"_blank\">")
                .append(APP_HOME)
                .append(" </a> en el apartado de \"Renovar referencia\" considerando que:")
                .append("<br><br>")
                .append("<u1>")
                .append("<li>Al realizar su registro y no realizar el pago oportuno de su preficha  su lugar en el tecnológico  no será contemplado.</li>")
                .append("<li>La renovación de  referencia  está sujeta a la disponibilidad de cupo en el tecnológico.</li>")
                .append("<li>El aspirante  tendrá hasta dos oportunidades para renovar su referencia.</li>")
                .append("<li>El aspirante tendrá un día hábil para realizar el pago de su preficha después de renovar su referencia. </li>")
                .append("</u1>")
                .append("<br><br>")
                .append("Para continuar con su registro por favor haga click en el siguiente enlace. ")
                .append("<a href=")
                .append(liga)
                .append(" >  Registro Aspirante </a></font>.")
                .append("<br><br>")
                .append("<b><ins>NOTA: </ins><b>")
                .append("Para fines prácticos le recomendamos revise el archivo anexo, ")
                .append("mismo que le servirá como guia para el proceso de registro en CENEVAL.")
                .toString();

        beanMail.setCuerpo(mensaje);
        return beanMail;
    }
    public BMail finRegistro(String APP_HOME, String liga) {
        beanMail = new BMail();
        String mensaje = new StringBuffer()
                .append("<b><font size=4 face=\"arialblack\" >")
                .append(" Durante el proceso de registro recibirá los  siguientes  correos, por favor permanezca al pendiente: \n")
                .append("<br><br>")
                .append(" 1.-Correo  de generación de preficha, que se le enviará  al concluir el registro de sus datos. \n")
                .append("<br>")
                .append("2.-Correo de liberación de pago, en un periodo máximo de 3 a 4 días hábiles después de haber realizado el pago bancario. \n")
                .append("<br>")
                .append("3.-Correo de alta en Ceneval, máximo 2 días  hábiles después del correo anterior. Es importante que reciba estos dos últimos correos. \n ")
                .append("<br>")
                .append("4.-Correo de generación de ficha, que le será  enviado  al concluir el proceso de registro, esto  después de haber entregado sus papeles en el departamento de servicios escolares edif. X \n")
                .append("<br><br>")
                .append("En caso de no recibir alguno de ellos, comuníquese con nostros desde:  ")
                .append("<br>")
                .append("<a href=\"")
                .append(APP_HOME)
                .append("\" target=\"_blank\">")
                .append(APP_HOME)
                .append(" </a>  en el apartado de contacto.</font></b>")
                .append("<br><br>")
                .append("<b><ins>Importante:</ins><b> Para realizar cualquier cambio en los datos proporcionados deberá solicitarlo en ventanilla al")
                .append(" momento de entregar su documentación en el departamento de Servicios Escolares Edif. X. Así mismo deberá recordar que no habrá cambios en  las opciones de carrera.")
                .append("Tome en cuenta que es responsabilidad del aspirante cumplir con todas etapas del proceso\n")
                .append("para finalizar su registro de lo contrario su solicitud será rechazada.")
                .append("<br><br>")
                .append("<b><ins>Advertencia:</ins></b> ES IMPORTANTE QUE CONSIDERE QUE UNA VEZ FINALIZADO SU REGISTRO TENDRÁ DOS DÍAS HÁBILES PARA REALIZAR SU PAGO, DE LO CONTRARIO SU REFERENCIA EXPIRARÁ. \n")
                .append("En caso de que su referencia  expire usted podrá renovarla ingresando  a la liga de <a href=\"")
                .append(APP_HOME)
                .append("\" target=\"_blank\">")
                .append(APP_HOME)
                .append(" </a> en el apartado de \"Renovar referencia\" considerando que:")
                .append("<br><br>")
                .append("<u1>")
                .append("<li>Al realizar su registro y no realizar el pago oportuno de su preficha  su lugar en el tecnológico  no será contemplado.</li>")
                .append("<li>La renovación de  referencia  está sujeta a la disponibilidad de cupo en el tecnológico.</li>")
                .append("<li>El aspirante  tendrá hasta dos oportunidades para renovar su referencia.</li>")
                .append("<li>El aspirante tendrá un día hábil para realizar el pago de su preficha después de renovar su referencia. </li>")
                .append("</u1>")
                .append("<br><br>")
                .append("Recibirá una  notificación cuando su  pago haya sido  procesado, permanezca al pendiente de  su correo. ")
                .append("Por favor haga click en el siguiente enlace para que pueda ver su preficha. ")
                .append("<a href=")
                .append(liga)
                .append(">Genera Preficha</a></font>.")
                .toString();

        beanMail.setCuerpo(mensaje);
        return beanMail;
    }

    public BMail contacto(BMail bMail) {
        beanMail =bMail;
        String nom = bMail.getNombre();
        String corr = bMail.getCorreo();
        String mens = bMail.getTexto();

        String mensaje = new StringBuffer()
                .append("Enviando un correo\n\n")
                .append("<br><br>")
                .append("Nombre: ")
                .append(nom)
                .append("<br><br>")
//                .append("\n")
                .append("Correo: ")
                .append(corr)
                .append("<br><br>")
//                .append("\n\n")
                .append("Mensaje:\n")
                .append("<br>")
                .append(mens)
                .append("\n").toString();
        beanMail.setCuerpo(mensaje);
        System.out.println(beanMail.getCuerpo());
        return beanMail;
    }

}
