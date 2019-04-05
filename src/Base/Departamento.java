/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.DepartamentoBean;
import java.sql.*;
import org.apache.log4j.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author jorge
 */
public class Departamento {
    private Conexion con = new Conexion();
    private DepartamentoBean deptoB = new DepartamentoBean();
    private PreparedStatement ps = null;
    private ResultSet departamentos = null;    
    private String sql = "";
    private int id_depto;
    private String nombre_depto;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Departamento.class);

    public Departamento(int id_depto, String nombre_depto)  throws SQLException {
        this.id_depto = id_depto;
        this.nombre_depto = nombre_depto;
    }

    public int getId_depto() {
        return id_depto;
    }

    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    public String getNombre_depto() {
        return nombre_depto;
    }

    public void setNombre_depto(String nombre_depto) {
        this.nombre_depto = nombre_depto;
    }

    public Departamento() throws SQLException{
    }
    
    public void IngresarDepartamento() throws SQLException{
       
    }
    
    public void getDatos(DepartamentoBean Departamento) {
        try {
            sql="select nombre_depto from departamentos where id_depto = ?";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, Departamento.getId_depto());
            departamentos = ps.executeQuery();
            if (departamentos.next()) 
                Departamento.setNombre_depto(departamentos.getString(1));                       
        } catch (Exception e) {
            log.error(e);
        }
    }
        
    public void MostrarDepartamento(JComboBox <Departamento> comboDepto)throws SQLException{
         
        try {
            Conexion con = new Conexion();
            String sql = "select * from departamentos";
            ResultSet datos= con.Buscar(sql);
           
           while (datos.next()) {
                comboDepto.addItem(
                        new Departamento(
                                datos.getInt("id_depto"),
                                datos.getString("nombre_depto")                               
                        )
                );
            }
        } catch (Exception ex) {
            log.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DEPARTAMENTOS");
        }
    }
    
    private void UpdateDepartamento() throws SQLException{
        //Code
    }

    

        @Override
       public String toString(){
        return nombre_depto;
    }
        
}
