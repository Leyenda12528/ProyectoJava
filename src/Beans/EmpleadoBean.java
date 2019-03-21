/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author jorge
 */
public class EmpleadoBean {
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

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public String getEmp_apellidos() {
        return emp_apellidos;
    }

    public int getCargo() {
        return cargo;
    }

    public int getDepto() {
        return depto;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public void setEmp_apellidos(String emp_apellidos) {
        this.emp_apellidos = emp_apellidos;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public void setDepto(int depto) {
        this.depto = depto;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    
}
