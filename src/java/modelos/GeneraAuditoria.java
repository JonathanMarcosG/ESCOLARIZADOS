/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 *
 * @author susi
 */
public class GeneraAuditoria {

    //Obtiene la Fecha y La Hora para auditar el error
    Calendar fecha = Calendar.getInstance();
    Calendar hora = Calendar.getInstance();
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    int mes = fecha.get(Calendar.MONTH) + 1;
    int año = fecha.get(Calendar.YEAR);
    String d = String.valueOf(dia);
    String m = String.valueOf(mes);
    String a = String.valueOf(año);
    String F = d + "/" + m + "/" + a;
    int hrs = hora.get(Calendar.HOUR);
    int min = hora.get(Calendar.MINUTE);
    int seg = hora.get(Calendar.SECOND);
    String h = String.valueOf(hrs);
    String mi = String.valueOf(min);
    String s = String.valueOf(seg);
    String H = h + ":" + mi + ":" + s;

    //Crea el archivo o lo sobreescribe sin perder su contenido anterior para grabar la descripción de la auditoria
    public void crea_archivo(String cod, String error, String mensage) {
        File file = new File("Auditorias_PAES_2015.txt");
        try {
            FileWriter w = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("\n______________________________________________________________________________________________________________________________________________________________________________________________ ");
            wr.append("\nAuditoría PAES.    Fecha: " + F + "             Hora: " + H +"                                                                                                                                                                                                                                                         ");
            wr.append("\nCódigo de Error: " + cod + "                                        ");
            wr.append("\nDescripción: " + error + "                                                                                      ");
            wr.append("\nMensaje: " + mensage + "                                                                                        ");
            wr.close();
            bw.close();
            w.close();
            System.out.println();
        } catch (IOException ex) {
            
        }
       
    }
}
