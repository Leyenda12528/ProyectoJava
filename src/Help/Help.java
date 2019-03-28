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
        String correo = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        if (Pattern.compile(correo).matcher(text).matches()) return true;        
        else return false;
    }
    
    
    public boolean verificarAnio(String fecha) {
        boolean valida = false;
        try {
            String[] datos = fecha.split("-");
            int ani = Integer.parseInt(datos[2] + "");
            if (ani < 2020) valida = true;
        } catch (Exception e) {
            valida = false;
        }
        return valida;
    }
    
     public boolean verificarFecha(String fechaEnviada) {      
        return (Pattern.matches("\\d{1,2}-\\d{1,2}-\\d{4}", fechaEnviada));
    } 
}
