/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.EmpleadoBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jorge
 */
public class Empleado {
    private Conexion con = new Conexion();
    private ResultSet empleados = null;
    private PreparedStatement ps;
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
    Conexion_c c4=new Conexion_c();
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
    
    public void getProgramadores(JList<String> listUtilidad, int idDepto, int tipo) {
        try {
            String sql = "select CONCAT(nombre_emp,' ',apellidos) from empleados where id_depto = ? and id_cargo = ?";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, idDepto);
            ps.setObject(2, tipo);
            empleados = ps.executeQuery();
            DefaultListModel modelo = new DefaultListModel();
            while (empleados.next()) {                
                modelo.addElement(empleados.getString(1));
            }
            listUtilidad.setModel(modelo);
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
    }
    
    public void getProTrabajando(String idDepto, JList<String> lista) throws ClassNotFoundException{
        try {
            String sql = "SELECT DISTINCT empleados.id_empleado, empleados.nombre_emp"
                    + " FROM            empleados INNER JOIN"
                    + "                         empleados_caso ON empleados.id_empleado = empleados_caso.id_empleado"
                    + " WHERE        (empleados.id_estado_emp = 0) AND (empleados.id_depto = ?) AND (empleados.id_cargo = 3)";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, idDepto);
            empleados = ps.executeQuery();
            
            DefaultListModel modelo = new DefaultListModel();
            while (empleados.next()) {
                modelo.addElement(empleados.getInt(1));
            }
            lista.setModel(modelo);
        } catch (SQLException e) {
            //System.out.println(""+e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
    }
    
    public boolean existUSer(String correo, String Contra, EmpleadoBean empB){
        try {
            String sql ="select count(*), id_empleado from empleados where correo = ? and password_emp = ? and id_estado_emp = 0";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, correo);
            ps.setObject(2, Contra);
            empleados = ps.executeQuery();            
            if (empleados.next()) {
                if (empleados.getInt(1) > 0) {
                    empB.setId_empleado(empleados.getInt(2));
                    return true;
                }
                else return false;
            }
            else return false;
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e.getMessage());
            return false;
        }
    }
    
    public void getLogin(EmpleadoBean empB){
        try {                        
            String sql1 = "SELECT  CONCAT(empleados.nombre_emp,' ',empleados.apellidos)"
                    + " ,empleados.id_cargo , cargo.nombre_cargo, empleados.id_depto, departamentos.nombre_depto "
                    + "FROM            empleados INNER JOIN"
                    + "                departamentos ON empleados.id_depto = departamentos.id_depto INNER JOIN"
                    + "                cargo ON empleados.id_cargo = cargo.id_cargo"
                    + " WHERE        empleados.id_empleado =  ?";
            
            ps = con.Obtener().prepareStatement(sql1);
            ps.setObject(1, empB.getId_empleado());
            empleados = ps.executeQuery();
            if (empleados.next()) {
                empB.setEmp_nombre(empleados.getString(1));
                empB.setCargo(empleados.getInt(2));
                empB.setNombreCargo(empleados.getString(3));
                if (!empleados.getString(3).equals("0")){ //Si no es Administrador
                    empB.setDepto(empleados.getInt(4));
                    empB.setNombreDepto(empleados.getString(5));                    
                }                
            }            
        } catch (Exception ex) {
           Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }
    
    
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
    
    
     
     public void iniciarValores(JTable JtableResultado) throws SQLException
    {

        Object[][] data =null;
        String [] columns= {
        "Codigo", "Nombre","Edad","Telefono","Correo","Cargo","Departamento","Estado"
        };
        modelo1=new DefaultTableModel(data,columns);
        JtableResultado.setModel(modelo1);
        String sql="SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,edad,telefono,correo,nombre_cargo,nombre_depto,estado FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto=emp.id_depto and emp.id_depto=dep.id_depto\n" +
            "INNER JOIN  cargo c ON c.id_cargo=emp.id_cargo  INNER JOIN estado_empleados ee ON ee.id_estado=emp.id_estado_emp";
          c4.setRs(sql);
        
        generarListado();
    }
    
     public void generarListado() throws SQLException
    {
        resultado =c4.getRs();
        while(resultado.next())
        {
            Object [] newRow= {
                resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),
                resultado.getString(6),resultado.getString(7),resultado.getString(8)
               };
            modelo1.addRow(newRow);
        }
        
        resultado.close();
    }
      
      

    



    
    
    
}
