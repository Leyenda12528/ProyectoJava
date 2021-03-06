/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.EmpleadoBean;
import java.sql.*;
import java.util.Random;
import org.apache.log4j.Logger;
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
    ResultSet resultado = null;
    DefaultTableModel modelo1 = null;
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
    Conexion_c c4 = new Conexion_c();
    private String sqlC;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Empleado.class);

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

    public Empleado() throws SQLException {
    }

    public void IngresarEmpleado() throws SQLException {
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
            log.error(e);
        }
    }

    public void getProTrabajando(String idDepto, JList<String> lista) throws ClassNotFoundException {
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
            log.error(e);
        }
    }

    public boolean existUSer(String correo, String Contra, EmpleadoBean empB) {
        try {
            String sql = "select count(*), id_empleado from empleados where correo = ? and password_emp = SHA2(?,256) and id_estado_emp = 0";
            //String sql = "select id_empleado from empleados where correo = ? and password_emp = SHA2(?,256) and id_estado_emp = 0";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, correo);
            ps.setObject(2, Contra);
            empleados = ps.executeQuery();
            if (empleados.next()) {
                if (empleados.getInt(1) > 0) {
                    empB.setId_empleado(empleados.getInt(2));
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
// if(empleados.next()){
// empB.setId_empleado(empleados.getInt(1));
// return true;
// }
// else return false;
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    public void getLogin(EmpleadoBean empB) {
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
                if (!empleados.getString(3).equals("0")) { //Si no es Administrador
                    empB.setDepto(empleados.getInt(4));
                    empB.setNombreDepto(empleados.getString(5));
                }
            }
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    public void MostrarProgramadores(JTable programadores, int depto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Cargo", "Departamento"});
        try {
            String sql = "SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='" + depto + "' and emp.id_depto='" + depto + "'\n"
                    + "INNER JOIN  cargo c ON c.id_cargo=3 and emp.id_cargo=3 where id_estado_emp=0";
            ResultSet datos = con.Buscar(sql);
            while (datos.next()) {
                modelo.addRow(new Object[]{
                    datos.getInt("id_empleado"),
                    datos.getString("nombre"),
                    datos.getString("nombre_cargo"),
                    datos.getString("nombre_depto"),});
            }
            programadores.setModel(modelo);
        } catch (SQLException ex) {
            log.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR");
        }
    }

    public void MostrarProbadores(JTable tester, int depto) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Cargo", "Departamento"});
        try {
            String sql = "SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='" + depto + "' and emp.id_depto='" + depto + "'\n"
                    + "INNER JOIN  cargo c ON c.id_cargo=4 and emp.id_cargo=4 where id_estado_emp=0";
            ResultSet datos = con.Buscar(sql);
            while (datos.next()) {
                modelo.addRow(new Object[]{
                    datos.getInt("id_empleado"),
                    datos.getString("nombre"),
                    datos.getString("nombre_cargo"),
                    datos.getString("nombre_depto"),});
            }
            tester.setModel(modelo);

        } catch (SQLException ex) {
            log.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR" + ex);
        }
    }
    Conexion con3 = new Conexion();

    public ResultSet iniciarValoresProgramadores(JTable resultado) throws SQLException {
        Object[][] data = null;
        String[] columns = {
            "ID", "Nombres", "Apellidos"
        };
        modelo1 = new DefaultTableModel(data, columns);
        resultado.setModel(modelo1);

        String sql = "SELECT id_empleado,CONCAT(nombre_emp,' ',apellidos) nombre,nombre_cargo,nombre_depto FROM empleados emp INNER JOIN departamentos dep ON dep.id_depto='" + depto + "' and emp.id_depto='" + depto + "'\n"
                + "INNER JOIN  cargo c ON c.id_cargo=3 and emp.id_cargo=3 where id_estado_emp=0";
        ResultSet datos = con3.Buscar(sql);
        return datos;
    }

    public void AgregarEmpleado(EmpleadoBean emp) throws SQLException, ClassNotFoundException {
        String sql = "insert into empleados  values(?,?,?,?,?,?,?,?,?,SHA2(?,256),?) ";

        try {
            PreparedStatement psta = con.Obtener().prepareStatement(sql);

            psta.setInt(1, emp.getId_empleado());
            psta.setString(2, emp.getEmp_nombre());
            psta.setString(3, emp.getEmp_apellidos());
            psta.setInt(4, emp.getCargo());
            psta.setInt(5, emp.getDepto());
            psta.setInt(6, emp.getEdad());
            psta.setString(7, emp.getDireccion());
            psta.setString(8, emp.getTelefono());
            psta.setString(9, emp.getCorreo());
            psta.setString(10, emp.getContraseña());
            psta.setInt(11, emp.getId_estado());
            psta.execute();

            JOptionPane.showMessageDialog(null, "Empleado Ingresado con exito");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar");
            log.error(e);
        }

    }

    public void ModifcarEmpleado(EmpleadoBean emp) throws SQLException {
        String sql = "update  empleados set nombre_emp=?,apellidos=?,id_cargo=?,id_depto=?,"
                + "edad=?,direccion=?,telefono=?,correo=?,password_emp=SHA2(?,256),id_estado_emp=? where id_empleado=? ";

        try {
            PreparedStatement psta = con.Obtener().prepareStatement(sql);
            psta.setString(1, emp.getEmp_nombre());
            psta.setString(2, emp.getEmp_apellidos());
            psta.setInt(3, emp.getCargo());
            psta.setInt(4, emp.getDepto());
            psta.setInt(5, emp.getEdad());
            psta.setString(6, emp.getDireccion());
            psta.setString(7, emp.getTelefono());
            psta.setString(8, emp.getCorreo());
            psta.setString(9, emp.getContraseña());
            psta.setInt(10, emp.getId_estado());
            psta.setInt(11, emp.getId_empleado());
            psta.execute();

            JOptionPane.showMessageDialog(null, "Empleado Modificado con exito");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al actualizar empleado");
            log.error(e);
        }
    }

    public void EliminarEmpleado(EmpleadoBean emp) throws SQLException {
        String sql = "update  empleados set id_estado_emp=1 where id_empleado=?";

        try {
            PreparedStatement psta = con.Obtener().prepareStatement(sql);

            psta.setInt(1, emp.getId_empleado());
            psta.execute();

            JOptionPane.showMessageDialog(null, "Empleado Inactivo");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al deshabilitar empleado");
            log.error(e);
        }

    }

    public int generarId() {
        Random aleatorio = new Random();
        int numeros = (int) (aleatorio.nextDouble() * 99 + 1000);
        return numeros;
    }

    public void ChangePass(EmpleadoBean userb) {
        try {
            sqlC="update empleados set password_emp = SHA2(?,256) where id_empleado = ?";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, userb.getContraseña());
            ps.setObject(2, userb.getId_empleado());
            ps.executeUpdate();            
        } catch (Exception e) {
            log.error(e);
        }
    }

    public boolean SamePass(EmpleadoBean userb) {
        try {
            sqlC = "select count(*) from empleados where id_empleado = ? and password_emp = SHA2(?,256)";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, userb.getId_empleado());
            ps.setObject(2, userb.getContraseña());
            empleados = ps.executeQuery();
            empleados.next();
            if (empleados.getInt(1) == 1) 
                return true;
            else return false;            
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }

}
