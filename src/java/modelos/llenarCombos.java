/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import beans.Combos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class llenarCombos {

    //Obtenemos el promedio para los combos
    public List<Combos> llenaPromedio() {
        List<Combos> promedio = new ArrayList<>();
        Combos b = new Combos();
        b.setClave("--");
        b.setNombre("--Seleccione--");
        promedio.add(b);
        for (int i = 60; i <= 100; i++) {
            b = new Combos();
            b.setClave(String.valueOf(i));
            b.setNombre(String.valueOf(i));
            promedio.add(b);
        }
        return promedio;
    }

    //Obtenemos el promedio para los combos
    public List<Combos> llenaNumero() {
        List<Combos> num = new ArrayList<>();
        Combos b;
        b = new Combos();
        b.setClave("--");
        b.setNombre("--Seleccione--");
        num.add(b);
        for (int i = 1; i < 10; i++) {
            b = new Combos();
            b.setClave(String.valueOf(i));
            b.setNombre(String.valueOf(i));
            num.add(b);
        }
        return num;
    }

    public ArrayList<String> Formatea(String dats) {
        ArrayList<String> Datos = new ArrayList<>();
        int i = 0;
        StringTokenizer cad = new StringTokenizer(dats, "||", false);
        while (cad.hasMoreTokens()) {
            String h;
            h = cad.nextToken();
            System.out.println(h);
            Datos.add(h);
            i++;
        }
        System.out.println("El tama;o del array es: "+i);
        return Datos;
    }

    public List<Combos> llenames() {
        List<Combos> mes = new ArrayList<>();
        int i = 0;
        while (i < 13) {

            switch (i) {
                case 0: {
                    Combos f = new Combos();
                    f.setClave("--");
                    f.setNombre("--");
                    mes.add(f);
                    i++;
                }
                break;
                case 1: {
                    Combos f = new Combos();
                    f.setClave("01");
                    f.setNombre("Ene");
                    mes.add(f);
                    i++;
                }
                break;
                case 2: {
                    Combos f = new Combos();
                    f.setClave("02");
                    f.setNombre("Feb");
                    mes.add(f);
                    i++;
                }
                break;
                case 3: {
                    Combos f = new Combos();
                    f.setClave("03");
                    f.setNombre("Mar");
                    mes.add(f);
                    i++;
                }
                break;
                case 4: {
                    Combos f = new Combos();
                    f.setClave("04");
                    f.setNombre("Abr");
                    mes.add(f);
                    i++;
                }
                break;
                case 5: {
                    Combos f = new Combos();
                    f.setClave("05");
                    f.setNombre("May");
                    mes.add(f);
                    i++;
                }
                break;
                case 6: {
                    Combos f = new Combos();
                    f.setClave("06");
                    f.setNombre("Jun");
                    mes.add(f);
                    i++;
                }
                break;
                case 7: {
                    Combos f = new Combos();
                    f.setClave("07");
                    f.setNombre("Jul");
                    mes.add(f);
                    i++;
                }
                break;
                case 8: {
                    Combos f = new Combos();
                    f.setClave("08");
                    f.setNombre("Ago");
                    mes.add(f);
                    i++;
                }
                break;
                case 9: {
                    Combos f = new Combos();
                    f.setClave("09");
                    f.setNombre("Sep");
                    mes.add(f);
                    i++;
                }
                break;
                case 10: {
                    Combos f = new Combos();
                    f.setClave("10");
                    f.setNombre("Oct");
                    mes.add(f);
                    i++;
                }
                break;
                case 11: {
                    Combos f = new Combos();
                    f.setClave("11");
                    f.setNombre("Nov");
                    mes.add(f);
                    i++;
                }
                break;
                case 12: {
                    Combos f = new Combos();
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

    public List<Combos> llenadia() {
        List<Combos> dia = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (i == 0) {
                Combos f = new Combos();
                f.setClave("--");
                f.setNombre("--");
                dia.add(f);

            } else if (i < 10) {
                Combos f = new Combos();
                f.setClave("0" + String.valueOf(i));
                f.setNombre(String.valueOf(i));
                dia.add(f);
            } else {
                Combos f = new Combos();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                dia.add(f);
            }
        }
        return dia;
    }

    public List<Combos> llenaaño() {
        List<Combos> anio = new ArrayList<>();
        //Obtenemos el año actual para lso combos
        Calendar date = Calendar.getInstance();
        for (int i = 1924; i <= date.get(Calendar.YEAR); i++) {
            if (i == 1924) {
                Combos f = new Combos();
                f.setClave("--");
                f.setNombre("--");
                anio.add(f);
            } else {
                Combos f = new Combos();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                anio.add(f);
            }
        }
        return anio;
    }
}
