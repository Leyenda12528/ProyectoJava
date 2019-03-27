/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.BitacoraBean;
import Beans.CasoBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jorge
 */
public class Casos {

    private Conexion con = new Conexion();
    private CasoBean casoB = new CasoBean();
    private ResultSet casos = null;
    private PreparedStatement ps = null;

//    public String getId_caso() {
//        return id_caso;
//    }
//
//    public void setId_caso(String id_caso) {
//        this.id_caso = id_caso;
//    }
//
//    public String getDescrip_req() {
//        return descrip_req;
//    }
//
//    public void setDescrip_req(String descrip_req) {
//        this.descrip_req = descrip_req;
//    }
//
//    public String getDescripcion_jefedes() {
//        return descripcion_jefedes;
//    }
//
//    public void setDescripcion_jefedes(String descripcion_jefedes) {
//        this.descripcion_jefedes = descripcion_jefedes;
//    }
//
//    public String getDescrip_rechazo() {
//        return descrip_rechazo;
//    }
//
//    public void setDescrip_rechazo(String descrip_rechazo) {
//        this.descrip_rechazo = descrip_rechazo;
//    }
//
//    public int getId_estado() {
//        return id_estado;
//    }
//
//    public void setId_estado(int id_estado) {
//        this.id_estado = id_estado;
//    }
//
//    public int getPorcentaje() {
//        return porcentaje;
//    }
//
//    public void setPorcentaje(int porcentaje) {
//        this.porcentaje = porcentaje;
//    }
//
//    public String getFecha_limite() {
//        return fecha_limite;
//    }
//
//    public void setFecha_limite(String fecha_limite) {
//        this.fecha_limite = fecha_limite;
//    }
//
//    public String getFecha_produccion() {
//        return fecha_produccion;
//    }
//
//    public void setFecha_produccion(String fecha_produccion) {
//        this.fecha_produccion = fecha_produccion;
//    }
//    private String id_caso;
//    private String nombre_caso;
//    private String descrip_req; //Descripción realizada por el jefe de área funcional
//    private String descripcion_jefedes;//Descripcion que realiza el jefe de desarrollo si acapta el proyecyo
//    private String descrip_rechazo; //el porq rechazo el caso
//    private int id_estado;
//    private int porcentaje; //porcentaje de avance de proyecto
//    private String fecha_limite;
//    private String fecha_produccion;
    
    private String sqlC;

    public Casos() throws SQLException {
    }

    public void IngresarCasoJF(CasoBean casoB) throws ClassNotFoundException {
        try {
            sqlC = "insert into caso values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = new Conexion().Obtener().prepareStatement(sqlC);
            Conexion.InsertarP(sqlC, ps, casoB.getId_caso(),casoB.getNombre_caso(),casoB.getDescrip_req(),casoB.getDescrip_rechazo(),casoB.getDescripcion_jefedes(),casoB.getId_estado(),casoB.getPorcentaje(),casoB.getFecha_limite(),casoB.getFecha_produccion());
        } catch (SQLException e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, "ERROR Caso Ingreso JF " + e);
        }
    }
    
    public void IngresarCaso() throws SQLException {
    }
        
    public void getSolicitudesJD(String DeptoCaso, JList<String> listUtilidad) {
        try {
            sqlC = "SELECT        id_caso"
                    + " FROM            caso"
                    + " WHERE        (id_estado = 1) AND (id_caso LIKE '%"+DeptoCaso+"%')";
            casos = Conexion.Buscar(sqlC);
            DefaultListModel modelo = new DefaultListModel();
            while (casos.next()) 
                modelo.addElement(casos.getString(1));
            
            listUtilidad.setModel(modelo);
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public CasoBean getDatosSolicitudJD(String idCaso){
        try {
            sqlC = "SELECT        nombre_caso, descrip_req, id_estado, porcentaje_avance"
                    + " FROM            caso"
                    + " WHERE        id_caso= "+idCaso+"";
            casos = Conexion.Buscar(sqlC);
            
            if (casos.next()) {
                casoB.setId_caso(idCaso);
                casoB.setNombre_caso(casos.getString(1));
                casoB.setDescrip_req(casos.getString(2));
                casoB.setId_estado(casos.getInt(3));
                casoB.setPorcentaje(casos.getInt(4));
            }
            return casoB;
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }        
    }
    
    private void ConseguirCaso() {
        
    }
    private String isVacia(String code) {
        try {
            sqlC = "select count(*) from caso where id_caso like '" + code + "%'";
            casos = Conexion.Buscar(sqlC);
            if (casos.next()) {
                int cant = casos.getInt(1);
                return cant+"";
            }
            else return "";
        } catch (SQLException e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, "ERROR Caso isVacia " + e);
            return null;
        }      
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

    //**************************************************************************************

    public CasoBean getNewIdCaso(String nombreDepartamento) {
        try {
            Calendar cal= Calendar.getInstance();
            int year= cal.get(Calendar.YEAR);            
            String code = nombreDepartamento.charAt(0)+ "" + nombreDepartamento.charAt(1)+ "" + nombreDepartamento.charAt(2) + "";
            String yer = String.valueOf(year).charAt(2)+ "" + String.valueOf(year).charAt(3) + "";
            String cant = String.valueOf(Integer.parseInt(isVacia(code)) + 1);
            while (cant.length() < 3)
                cant = "0" + cant;
            String newId = code + yer + cant;
            casoB.setId_caso(newId);
            return casoB;
        } catch (Exception e) {
            return null;
        }
    }

    public void getIDCaso(String idBeginCaso, JList<String> listUser) {
        try {
            sqlC = "SELECT        id_caso"
                    + " FROM            dbo.caso"
                    + " WHERE        (id_caso LIKE '%"+idBeginCaso+"%') and (id_estado <> 1) AND (id_estado <> 2) AND (id_estado <> 7)";
            casos = Conexion.Buscar(sqlC);
            DefaultListModel modelo = new DefaultListModel();
            while (casos.next()) {
                modelo.addElement(casos.getString(1));
                System.out.println(""+casos.getString(1));}
            listUser.setModel(modelo);
            
        } catch (Exception e) {
        }
    }

    

    

    

    
    
}
