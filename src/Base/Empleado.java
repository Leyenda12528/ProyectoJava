/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jorge
 */
public class Empleado {
    private Conexion con = new Conexion();
    private ResultSet empleados;
    ResultSet resultado=null;
    DefaultTableModel modelo1=null;
    private int id_empleado;
    private String emp_nombre;
    private String emp_apellidos;
    private int cargo;
    private int depto;
    private int edad;
    private String direccion;
    private String telefono;
    private String correo;
    private String contraseña;
    private int id_estado;

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public String getEmp_apellidos() {
        return emp_apellidos;
    }

    public void setEmp_apellidos(String emp_apellidos) {
        this.emp_apellidos = emp_apellidos;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getDepto() {
        return depto;
    }

    public void setDepto(int depto) {
        this.depto = depto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    public Empleado() throws SQLException{
    }
    
    public void IngresarEmpleado() throws SQLException{
    }
    
    public String ConseguirEmpleadoLogin(String correo, String Contra){
        //Code
        try {
            String sql ="select id_empleado, nombre_emp, id_cargo from empleados where correo = '"+correo+"' and password = '"+Contra+"'";
            
            String sql1 = "SELECT  empleados.id_empleado, CONCAT(empleados.nombre_emp,' ',empleados.apellidos)"
                    + " ,empleados.id_cargo , cargo.nombre_cargo, departamentos.nombre_depto "
                    + "FROM            empleados INNER JOIN"
                    + "                departamentos ON empleados.id_depto = departamentos.id_depto INNER JOIN"
                    + "                cargo ON empleados.id_cargo = cargo.id_cargo"
                    + " WHERE        (empleados.correo = '" + correo + "') AND (empleados.password_emp = '" + Contra + "')";
            
            ResultSet dato = con.Buscar(sql1);
            if (dato.next()) {
                String mjs = "";
                if (dato.getString(3).equals("0")) //Administrador
                    mjs += dato.getInt(1) + "-" + dato.getString(2) + "-" + dato.getInt(3) + "-" + dato.getString(4); 
                else  //Cualquier otro empleado XDD
                    mjs += dato.getInt(1) + "-" + dato.getString(2) + "-" + dato.getInt(3) + "-" + dato.getString(4) + "-" + dato.getString(5);
                return mjs;
            }
            else return "";            
        } catch (SQLException ex) {
           Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL BUSCAR");
        }
        return "";
        
    }
    public void MostrarEmpleados(){}
    
    public void UpdateEmpleado() throws SQLException{
        //Code
    }
    
    public void ByeEmpleado() throws SQLException{
    }
    
    public void MostrarProgramadores(JTable programadores,int depto)
    {
         DefaultTableModel modelo = new DefaultTableModel();  
          modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre","Cargo","Departamento"});
        try {
            String sql="SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='"+depto+"' and emp.id_depto='"+depto+"'\n" +
            "INNER JOIN  cargo c ON c.id_cargo=4 and emp.id_cargo=4 where id_estado_emp=1";
            ResultSet datos= con.Buscar(sql);
            while (datos.next()) {
                modelo.addRow(new Object[]{
               datos.getInt("id_empleado"),
               datos.getString("nombre"),      
               datos.getString("nombre_cargo"),
               datos.getString("nombre_depto"),         
                });
            }
           programadores.setModel(modelo);
        } catch (SQLException ex) {
           Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR");
        }
    }
    
    public void MostrarProbadores(JTable tester,int depto)
    {
        
         DefaultTableModel modelo = new DefaultTableModel();  
          modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre","Cargo","Departamento"});
        try {
            String sql="SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='"+depto+"' and emp.id_depto='"+depto+"'\n" +
            "INNER JOIN  cargo c ON c.id_cargo=2 and emp.id_cargo=2 where id_estado_emp=1";
            ResultSet datos= con.Buscar(sql);
            while (datos.next()) {
               modelo.addRow(new Object[]{
               datos.getInt("id_empleado"),
               datos.getString("nombre"),      
               datos.getString("nombre_cargo"),
               datos.getString("nombre_depto"),         
                });
            }
           tester.setModel(modelo);
           
        } catch (SQLException ex) {
           Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR"+ex);
        }
    }
     Conexion con3=new Conexion();
    public ResultSet iniciarValoresProgramadores(JTable resultado) throws SQLException{
        Object[][] data =null;
        String [] columns= {
        "ID","Nombres","Apellidos"
        };
        modelo1=new DefaultTableModel(data,columns);
        resultado.setModel(modelo1);
        
        String sql="SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='"+depto+"' and emp.id_depto='"+depto+"'\n" +
            "INNER JOIN  cargo c ON c.id_cargo=4 and emp.id_cargo=4 where id_estado_emp=1";
            ResultSet datos= con3.Buscar(sql);
            return datos;
    }
    
    
}
