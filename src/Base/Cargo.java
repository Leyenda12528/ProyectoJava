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
public class Cargo {
    private int id_cargo;
    private String nombre_cargo;
     private Conexion con = new Conexion();

    public Cargo(int id_cargo, String nombre_cargo)throws SQLException {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
    }

    public Cargo()throws SQLException {
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public void mostrarCargo(JComboBox<Cargo> comboEstados) throws SQLException {

        try {
            con = new Conexion();
            String sql = "select * from cargo";
            ResultSet datos = con.Buscar(sql);

            while (datos.next()) {
                comboEstados.addItem(
                        new Cargo(
                                datos.getInt("id_cargo"),
                                datos.getString("nombre_cargo")
                        )
                );
            }
        } catch (Exception ex) {
            Logger.getLogger(Cargo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS CARGOS EXISTENTES");
        }
    }
         
          @Override
       public String toString(){
        return nombre_cargo;
    }
}
