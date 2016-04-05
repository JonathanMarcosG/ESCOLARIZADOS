/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import beans.BaseDatos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;


/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class llenarBD {

    public List<BaseDatos> llenaPromedio() {
        List<BaseDatos> promedio = new ArrayList<>();
        BaseDatos b;
        b = new BaseDatos();
        b.setClave("--");
        b.setNombre("--Seleccione--");
        promedio.add(b);
        for (int i = 60; i <= 100; i++) {
            b = new BaseDatos();
            b.setClave(String.valueOf(i));
            b.setNombre(String.valueOf(i));
            promedio.add(b);
        }
        return promedio;
    }

   
    public List<BaseDatos> llenaNumero() {
        List<BaseDatos> num = new ArrayList<>();
        BaseDatos b;
        b = new BaseDatos();
        b.setClave("--");
        b.setNombre("--Seleccione--");
        num.add(b);
        for (int i = 1; i < 10; i++) {
            b = new BaseDatos();
            b.setClave(String.valueOf(i));
            b.setNombre(String.valueOf(i));
            num.add(b);
        }
        return num;
    }

    public ArrayList <String> Formatea(String dats) {
     ArrayList <String> Datos = new  ArrayList<>();
       int i=0;
        StringTokenizer cad = new StringTokenizer(dats, "||", false);
        while (cad.hasMoreTokens()) {
            String h;
                    h=cad.nextToken();
            Datos.add(h);          
        }        
           return Datos;
    }

    public List<BaseDatos> llenames() {
        List<BaseDatos> mes = new ArrayList<>();
        int i = 0;
        while (i < 13) {

            switch (i) {
                case 0: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("--");
                    f.setNombre("--");
                    mes.add(f);
                    i++;
                }
                break;
                case 1: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("01");
                    f.setNombre("Ene");
                    mes.add(f);
                    i++;
                }
                break;
                case 2: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("02");
                    f.setNombre("Feb");
                    mes.add(f);
                    i++;
                }
                break;
                case 3: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("03");
                    f.setNombre("Mar");
                    mes.add(f);
                    i++;
                }
                break;
                case 4: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("04");
                    f.setNombre("Abr");
                    mes.add(f);
                    i++;
                }
                break;
                case 5: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("05");
                    f.setNombre("May");
                    mes.add(f);
                    i++;
                }
                break;
                case 6: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("06");
                    f.setNombre("Jun");
                    mes.add(f);
                    i++;
                }
                break;
                case 7: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("07");
                    f.setNombre("Jul");
                    mes.add(f);
                    i++;
                }
                break;
                case 8: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("08");
                    f.setNombre("Ago");
                    mes.add(f);
                    i++;
                }
                break;
                case 9: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("09");
                    f.setNombre("Sep");
                    mes.add(f);
                    i++;
                }
                break;
                case 10: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("10");
                    f.setNombre("Oct");
                    mes.add(f);
                    i++;
                }
                break;
                case 11: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("11");
                    f.setNombre("Nov");
                    mes.add(f);
                    i++;
                }
                break;
                case 12: {
                    BaseDatos f = new BaseDatos();
                    f.setClave("12");
                    f.setNombre("Dic");
                    mes.add(f);
                    i++;
                }
                break;

            }

        }
       
        return mes;
    }

    public List<BaseDatos> llenadia() {
        List<BaseDatos> dia = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (i == 0) {
                BaseDatos f = new BaseDatos();
                f.setClave("--");
                f.setNombre("--");
                dia.add(f);

            } else {
                
                if(i<10){
                 BaseDatos f = new BaseDatos();
                f.setClave("0"+String.valueOf(i));
                f.setNombre(String.valueOf(i));
                dia.add(f);
                }else{
                BaseDatos f = new BaseDatos();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                dia.add(f);}
            }
        }
        return dia;
    }

    public List<BaseDatos> llenaaño() {
        List<BaseDatos> anio = new ArrayList<>();
        //Obtenemos el año actual para lso combos
        Calendar date = Calendar.getInstance();
        //for (int i = 1924; i <= 2015; i++) {
        for (int i = 1924; i <= date.get(Calendar.YEAR); i++) {
            if (i == 1924) {
                BaseDatos f = new BaseDatos();
                f.setClave("--");
                f.setNombre("--");
                anio.add(f);
            } else {
                BaseDatos f = new BaseDatos();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                anio.add(f);
            }
        }
        return anio;
    }

    public List<BaseDatos> llenapromedio() {
        List<BaseDatos> prom = new ArrayList<>();
        for (int i = 59; i < 101; i++) {
            if (i == 59) {
                BaseDatos f = new BaseDatos();
                f.setClave("0");
                f.setNombre("--");
                prom.add(f);
            } else {
                BaseDatos f = new BaseDatos();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                prom.add(f);
            }
        }
        return prom;
    }
     public List<BaseDatos> llenaCarrera() {
        List<BaseDatos> Carrera = new ArrayList<>();
        BaseDatos bd;
        bd = new BaseDatos();
        bd.setClave("--");
        bd.setNombre("--Seleccione--");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("1");
        bd.setNombre("Ingeniería Electrónica");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("2");
        bd.setNombre("Ingeniería Electromecánica");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("3");
        bd.setNombre("Ingeniería Industrial");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("4");
        bd.setNombre("Ingeniería Química");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("5");
        bd.setNombre("Ingeniería en Sistemas Computacionales");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("6");
        bd.setNombre("Ingeniería Mecatrónica");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("7");
        bd.setNombre("Ingeniería en Gestión Empresarial");
        Carrera.add(bd);
        bd = new BaseDatos();
        bd.setClave("8");
        bd.setNombre("Ingeniería Industrial a Distancia");
        Carrera.add(bd);
        return Carrera;
    }
     
     /*public static void main(String[] args) {
         llenarBD bd = new llenarBD();
         
        for (BaseDatos llenaaño : bd.llenaaño()) {
        }
         
    }*/
}
