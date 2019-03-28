/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.DepartamentoBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Departamento() throws SQLException{
    }
    
    public void IngresarDepartamento() throws SQLException{
       
    }
    
    public DepartamentoBean getDatos(String Departamento) {
        try {
            sql="select id_depto from departamentos where nombre_depto = ?";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, Departamento);
            departamentos = ps.executeQuery();
            if (departamentos.next()) {
                deptoB.setId_depto(departamentos.getInt(1));
                deptoB.setNombre_depto(Departamento);
            }
            return deptoB;
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
        
    public void MostrarDepartamento(){}
    
    private void UpdateDepartamento() throws SQLException{
        //Code
    }

    

    
        
}
