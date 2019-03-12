/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author jorge
 */
public class Empleado_Caso {
    private Conexion con = new Conexion();
    private ResultSet empleadoCaso;
    private String id_caso;
    private int id_emp;

    public String getId_caso() {
        return id_caso;
    }

    public void setId_caso(String id_caso) {
        this.id_caso = id_caso;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }
    public Empleado_Caso() throws SQLException{
    }
    
    public void IngresarEmpleadoCaso() throws SQLException{
    }
    
    private void ConseguirEmpleadoCaso() throws SQLException{
        //Code
        
    }
    public void MostrarEmpleadoCaso(){}
    
    private void UpdateEmpleadoCaso() throws SQLException{
        //Code
    }
    
    private void ByeEmpleadoCaso() throws SQLException{
    }
    
    
     public void Asignar(int id_programador,int id_tester) throws SQLException, ClassNotFoundException{
          String sql="insert empledos_caso  values(?,?) ";
          
        try  {
            PreparedStatement psta = con.Obtener().prepareStatement(sql);
            PreparedStatement psta2 = con.Obtener().prepareStatement(sql);

            psta.setInt(1, id_programador);
            psta.setString(2,getId_caso());
            psta2.setInt(1, id_tester);
            psta2.setString(2,getId_caso());
            psta.execute();
            psta2.execute();
            
            JOptionPane.showMessageDialog(null,"La asignación se realizó con exito");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
     

    }
}
