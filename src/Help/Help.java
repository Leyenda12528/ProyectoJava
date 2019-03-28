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
    private String valor ="'%;(-)º<>¿?*//\\ª!·$&=^¨¡`+´ç";
    private boolean var = false;
    public boolean validarCorreo(String text){
        String correo = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        if (Pattern.compile(correo).matcher(text).matches()) return true;        
        else return false;
    }   

    public boolean CampoRestringuido(char keyChar) {
        for (int i = 0; i < valor.length(); i++) {
            if (keyChar == valor.charAt(i) || keyChar == '"') {
                //System.out.println("--> "+keyChar);
                var = true;
                break;
            }
            else var = false;
        }
        return var;
    }
}
