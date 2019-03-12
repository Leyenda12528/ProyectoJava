/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class Casos {

    private Conexion con = new Conexion();
    private ResultSet casos;

    public String getId_caso() {
        return id_caso;
    }

    public void setId_caso(String id_caso) {
        this.id_caso = id_caso;
    }

    public String getDescrip_req() {
        return descrip_req;
    }

    public void setDescrip_req(String descrip_req) {
        this.descrip_req = descrip_req;
    }

    public String getDescripcion_jefedes() {
        return descripcion_jefedes;
    }

    public void setDescripcion_jefedes(String descripcion_jefedes) {
        this.descripcion_jefedes = descripcion_jefedes;
    }

    public String getDescrip_rechazo() {
        return descrip_rechazo;
    }

    public void setDescrip_rechazo(String descrip_rechazo) {
        this.descrip_rechazo = descrip_rechazo;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getFecha_produccion() {
        return fecha_produccion;
    }

    public void setFecha_produccion(String fecha_produccion) {
        this.fecha_produccion = fecha_produccion;
    }
    private String id_caso;
    private String nombre_caso;
    private String descrip_req; //Descripción realizada por el jefe de área funcional
    private String descripcion_jefedes;//Descripcion que realiza el jefe de desarrollo si acapta el proyecyo
    private String descrip_rechazo; //el porq rechazo el caso
    private int id_estado;
    private int porcentaje; //porcentaje de avance de proyecto
    private String fecha_limite;
    private String fecha_produccion;

    public Casos() throws SQLException {
    }

    public void IngresarCaso() throws SQLException {

    }

    private void ConseguirCaso() throws SQLException {

        //Code
    }

    public void MostrarCaso(JTable casos) {
          DefaultTableModel modelo = new DefaultTableModel();  
          modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre","Descripción","Motivo Rechazo","Descripción Jefe","Estado",
              "Porcentaje","Fecha Limite","Fecha Produccion"});
        try {
            String sql="Select * from caso";
            ResultSet datos= con.Buscar(sql);
            while (datos.next()) {
                modelo.addRow(new Object[]{
               datos.getString("id_caso"),
               datos.getString("nombre_caso"),
               datos.getString("descrip_req"),
               datos.getString("descrip_rechazo"),
               datos.getString("descripcion_jefedes"),
               datos.getInt("id_estado"),
               datos.getInt("porcentaje_avance"),
               datos.getString("fecha_limite"),
               datos.getString("fecha_produccion")
               
                });
            

            }
           casos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UpdateCaso() throws SQLException {

    }

    public void ByeCaso() throws SQLException {

    }
}
