
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import ConexionBD.Constantes;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author ElyyzZ BaRruEtA
 */
public class Encripta {
     //encriptar
    public static String encrypt(String cadena, String clave) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword(clave);
        return s.encrypt(cadena);
    }

    public String encrypt(String cadena) {
        return encrypt(cadena, Constantes.CLAVE_ENCRYPT);
    }

//desencritar
    public static String decrypt(String cadena, String clave) {
  
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword(clave);
        String devuelve = "";
        try {
            devuelve = s.decrypt(cadena);
           
        } catch (Exception e) {
          
        }
        return devuelve;
    }

    public String decrypt(String cadena) {
       
        return decrypt(cadena, Constantes.CLAVE_ENCRYPT);
    }

    //encriptar  con para  enviar  por  URL
    public String encryptURL(String cadena) {
        String encrypt = encrypt(cadena, Constantes.CLAVE_ENCRYPT);
        String encode = "";
        try {
            encode = URLEncoder.encode(encrypt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }
}
