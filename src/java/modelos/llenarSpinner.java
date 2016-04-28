/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import beans.Spinner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class llenarSpinner {

    //Obtenemos el promedio para los combos
    public List<Spinner> llenaPromedio() {
        List<Spinner> promedio = new ArrayList<>();
        Spinner b = new Spinner();
        b.setClave("--");
        b.setNombre("--Seleccione--");
        promedio.add(b);
        for (int i = 60; i <= 100; i++) {
            b = new Spinner();
            b.setClave(String.valueOf(i));
            b.setNombre(String.valueOf(i));
            promedio.add(b);
        }
        return promedio;
    }

    //Obtenemos el promedio para los combos
    public List<Spinner> llenaNumero() {
        List<Spinner> num = new ArrayList<>();
        Spinner b;
        b = new Spinner();
        b.setClave("--");
        b.setNombre("--Seleccione--");
        num.add(b);
        for (int i = 1; i < 10; i++) {
            b = new Spinner();
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

    public List<Spinner> llenames() {
        List<Spinner> mes = new ArrayList<>();
        int i = 0;
        while (i < 13) {

            switch (i) {
                case 0: {
                    Spinner f = new Spinner();
                    f.setClave("--");
                    f.setNombre("--");
                    mes.add(f);
                    i++;
                }
                break;
                case 1: {
                    Spinner f = new Spinner();
                    f.setClave("01");
                    f.setNombre("Ene");
                    mes.add(f);
                    i++;
                }
                break;
                case 2: {
                    Spinner f = new Spinner();
                    f.setClave("02");
                    f.setNombre("Feb");
                    mes.add(f);
                    i++;
                }
                break;
                case 3: {
                    Spinner f = new Spinner();
                    f.setClave("03");
                    f.setNombre("Mar");
                    mes.add(f);
                    i++;
                }
                break;
                case 4: {
                    Spinner f = new Spinner();
                    f.setClave("04");
                    f.setNombre("Abr");
                    mes.add(f);
                    i++;
                }
                break;
                case 5: {
                    Spinner f = new Spinner();
                    f.setClave("05");
                    f.setNombre("May");
                    mes.add(f);
                    i++;
                }
                break;
                case 6: {
                    Spinner f = new Spinner();
                    f.setClave("06");
                    f.setNombre("Jun");
                    mes.add(f);
                    i++;
                }
                break;
                case 7: {
                    Spinner f = new Spinner();
                    f.setClave("07");
                    f.setNombre("Jul");
                    mes.add(f);
                    i++;
                }
                break;
                case 8: {
                    Spinner f = new Spinner();
                    f.setClave("08");
                    f.setNombre("Ago");
                    mes.add(f);
                    i++;
                }
                break;
                case 9: {
                    Spinner f = new Spinner();
                    f.setClave("09");
                    f.setNombre("Sep");
                    mes.add(f);
                    i++;
                }
                break;
                case 10: {
                    Spinner f = new Spinner();
                    f.setClave("10");
                    f.setNombre("Oct");
                    mes.add(f);
                    i++;
                }
                break;
                case 11: {
                    Spinner f = new Spinner();
                    f.setClave("11");
                    f.setNombre("Nov");
                    mes.add(f);
                    i++;
                }
                break;
                case 12: {
                    Spinner f = new Spinner();
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

    public List<Spinner> llenadia() {
        List<Spinner> dia = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (i == 0) {
                Spinner f = new Spinner();
                f.setClave("--");
                f.setNombre("--");
                dia.add(f);

            } else if (i < 10) {
                Spinner f = new Spinner();
                f.setClave("0" + String.valueOf(i));
                f.setNombre(String.valueOf(i));
                dia.add(f);
            } else {
                Spinner f = new Spinner();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                dia.add(f);
            }
        }
        return dia;
    }

    public List<Spinner> llenaaño() {
        List<Spinner> anio = new ArrayList<>();
        //Obtenemos el año actual para lso combos
        Calendar date = Calendar.getInstance();
        for (int i = 1924; i <= date.get(Calendar.YEAR); i++) {
            if (i == 1924) {
                Spinner f = new Spinner();
                f.setClave("--");
                f.setNombre("--");
                anio.add(f);
            } else {
                Spinner f = new Spinner();
                f.setClave(String.valueOf(i));
                f.setNombre(String.valueOf(i));
                anio.add(f);
            }
        }
        return anio;
    }
}
