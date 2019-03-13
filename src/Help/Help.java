/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import java.util.regex.Pattern;

/**
 *
 * @author jorge
 */
public class Help {
    public boolean validarCorreo(String text){
        String correo = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        if (Pattern.compile(correo).matcher(text).matches()) return true;        
        else return false;
    }
}
