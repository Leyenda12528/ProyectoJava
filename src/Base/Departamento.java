/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;
/**
 *
 * @author jorge
 */
public class Departamento {
    private Conexion con = new Conexion();
    private ResultSet departamentos;    
    private ResultSet resultado=null;
    private String sql="";
    
    public Departamento() throws SQLException{
    }
    
    public void IngresarDepartamento() throws SQLException{
       
    }
    
    public String ConseguirIdDepartamento(String departamento) {
        //Code
        try {
            sql = "Select id_depto from departamentos where  nombre_depto='" + departamento + "'";
            resultado = Conexion.Buscar(sql);
            if (resultado.next()) 
                return String.valueOf(resultado.getInt(1));
             else 
                return "";
        } catch (SQLException e) {
            return null;
        }
    }
    
    private void ConseguirDepartamento() throws SQLException{
        //Code        
    }
    public void MostrarDepartamento(){}
    
    private void UpdateDepartamento() throws SQLException{
        //Code
    }
        
}
