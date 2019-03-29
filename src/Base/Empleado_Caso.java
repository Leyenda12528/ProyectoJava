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
          String sql="insert into empledos_caso  values(?,?) ";
          
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
     
        public void ModificarEmpleados(int id_programador,int id_tester,String nom_p,String nom_t,String id) throws SQLException, ClassNotFoundException{
            String nom1=nombreEmpleadoP(id);
            String nom2=nombreEmpleadoT(id);
            String sql="update empledos_caso ec INNER JOIN empleados emp ON  ec.id_empleado=emp.id_empleado set ec.id_empleado=? WHERE  CONCAT(emp.nombre_emp,' ',emp.apellidos)=? and ec.id_caso=?";
          
        try  {
            PreparedStatement psta = con.Obtener().prepareStatement(sql);
            psta.setInt(1,id_programador);
            psta.setString(2, nom1);
            psta.setString(3,id );
              psta.execute();
            PreparedStatement psta2 = con.Obtener().prepareStatement(sql);
            psta2.setInt(1,id_tester);
            psta2.setString(2, nom2);
            psta2.setString(3,id );   
            psta2.execute();           
            JOptionPane.showMessageDialog(null,"La modificación se realizó con exito");
        }
        catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     public Boolean verificarAsignacion(String id) throws SQLException{   //Si ya estan los dos empleados asignados no se insetaran mas solo se modificaran
         Boolean band=false;
        String sql="SELECT count(id_caso) from empledos_caso where id_caso='"+id+"'";
            ResultSet datos= con.Buscar(sql);
            datos.next();
           /// JOptionPane.showMessageDialog(null, datos.getInt(1));
            if(datos.getInt(1)>=2)
             band=true;   
            return band;
     }
     
     //para capturar nombre del empleado al que se modificara
     
     public String nombreEmpleadoP(String id) throws SQLException{
         String nombre;
       String sql="Select concat(nombre_emp,' ',apellidos) from empleados emp Inner Join empledos_caso ec ON ec.id_empleado=emp.id_empleado where id_cargo=3 and"
               + " ec.id_caso='"+id+"'";
          ResultSet datos= con.Buscar(sql);
            datos.next();
            //JOptionPane.showMessageDialog(null, datos.getString(1));
               nombre=datos.getString(1);
               
            return nombre;
     }
     
       
     public String nombreEmpleadoT(String id) throws SQLException{
         String nombre;
       String sql="Select concat(nombre_emp,' ',apellidos) from empleados emp Inner Join empledos_caso ec ON ec.id_empleado=emp.id_empleado where id_cargo=4 and"
               + " ec.id_caso='"+id+"'";
          ResultSet datos= con.Buscar(sql);
            datos.next();
            //JOptionPane.showMessageDialog(null, datos.getString(1));
               nombre=datos.getString(1);      
            return nombre;
     }
     
     public int idTester(String id) throws SQLException{
      int cod;
       String sql="Select ec.id_empleado from empleados emp Inner Join empledos_caso ec ON ec.id_empleado=emp.id_empleado where id_cargo=4 and"
               + " ec.id_caso='"+id+"'";
          ResultSet datos= con.Buscar(sql);
            datos.next();
            //JOptionPane.showMessageDialog(null, datos.getInt(1));
               cod=datos.getInt(1);    
            return cod;
     }
      public int idProgramador(String id) throws SQLException{
      int cod;
       String sql="Select ec.id_empleado from empleados emp Inner Join empledos_caso ec ON ec.id_empleado=emp.id_empleado where id_cargo=3 and"
               + " ec.id_caso='"+id+"'";
          ResultSet datos= con.Buscar(sql);
            datos.next();
           // JOptionPane.showMessageDialog(null, datos.getInt(1));
               cod=datos.getInt(1);    
            return cod;
     }
      
      
        public String fechaLimite(String id) throws SQLException{
      String cod;
       String sql="Select fecha_limite from caso where id_caso='"+id+"'";
          ResultSet datos= con.Buscar(sql);
            datos.next();
           // JOptionPane.showMessageDialog(null, datos.getInt(1));
               cod=datos.getString(1);    
            return cod;
     }
}
