/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author less_
 */
public class Estados {
    private int id_estado;
    private String nombre_estado;
    private Conexion con = new Conexion();

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public Estados(int id_estado, String nombre_estado) throws SQLException{
        this.id_estado = id_estado;
        this.nombre_estado = nombre_estado;
    }

    public Estados() throws SQLException{
    }
     public void mostrarEstados(JComboBox <Estados> comboEstados)throws SQLException{
         
        try {
             con = new Conexion();
            String sql = "select * from estados";
            ResultSet datos= con.Buscar(sql);
           
           while (datos.next()) {
                comboEstados.addItem(
                        new Estados(datos.getInt("id_estado"),
                                datos.getString("nombre_estado")
                                                            
                        )
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Estados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS ESTADOS EXISTENTES");
        }
    }
         
          @Override
       public String toString(){
        return nombre_estado;
    }
       
       
       
}
