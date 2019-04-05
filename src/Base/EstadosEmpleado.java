/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author less_
 */
public class EstadosEmpleado {

    private Conexion con = new Conexion();
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(EstadosEmpleado.class);

    public EstadosEmpleado(int codigo, String estado) throws SQLException {
        this.codigo = codigo;
        this.estado = estado;
    }

    public EstadosEmpleado()throws SQLException {
    }
    
 
     private int codigo;
     private String estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
     public void mostrarEstados(JComboBox <EstadosEmpleado> comboEstados)throws SQLException{
         
        try {
             con = new Conexion();
            String sql = "select * from estado_empleados";
            ResultSet datos= con.Buscar(sql);
           
           while (datos.next()) {
                comboEstados.addItem(
                        new EstadosEmpleado(
                                datos.getInt("id_estado"),
                                datos.getString("estado")                               
                        )
                );
            }
        } catch (Exception ex) {
            log.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR ESTADOS");
        }
    }
     

     
      @Override
       public String toString(){
        return estado;
    }
}
