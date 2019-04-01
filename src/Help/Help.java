/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import Beans.CasoBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     
     public boolean validarTel(String tel)
     {
         return (Pattern.matches("\\d{4}-\\d{4}", tel));
     }
     public boolean exitsFecha(String fechaProd) {
        try {
            String formatoFecha = "dd-MM-yyyy";
            String fechaGenerada;
            Date fec = new SimpleDateFormat(formatoFecha).parse(fechaProd);
            fechaGenerada = new SimpleDateFormat(formatoFecha).format(fec);
            if (fechaProd.equals(fechaGenerada)) return true;
            else return false;
         } catch (Exception e) {
             return false;
         }
     }
    public boolean dateMaxNow(String fechaProd) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date now = new Date();
            String snow = formato.format(now);
            Date Fnow = formato.parse(snow);
            Date fProd = formato.parse(String.valueOf(fechaProd));
            if (fProd.compareTo(Fnow) < 0) return false;//si Produccion es menor que Ahora                
             else return true;            
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Plus7Days(CasoBean casoB) {
        try {
            String formatoFecha = "dd-MM-yyyy";
            String fechaGenerada;
            Date newDateLmit = new SimpleDateFormat(formatoFecha).parse(casoB.getFecha_limite());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(newDateLmit);
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            newDateLmit = calendar.getTime();
            String fecNew = new SimpleDateFormat(formatoFecha).format(newDateLmit);
            casoB.setFecha_limite(fecNew);
            return true;
        } catch (Exception e) {
            System.out.println(""+e);
            return false;
        }
    }
     
}
