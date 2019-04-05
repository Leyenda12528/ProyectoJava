/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.BitacoraBean;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;
/**
 *
 * @author jorge
 */
public class Bitacora {
    private Conexion con = new Conexion();
    private ResultSet bitacora;
    private PreparedStatement ps = null;
    private String sql;
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Bitacora.class);
    
    public Bitacora() throws SQLException{
    }
    
    public void getBitacorasProgramadorToEmp(int idProgramador, ArrayList<BitacoraBean> listbitaB) {
        try {///SOLO CASOS EN DESARROLLO O DEVUELTOS CON CORREPCIONES o ESPERANDO RESPUESTA
            sql = "SELECT        bitacoras.id_caso, caso.nombre_caso, bitacoras.descripcion_actividad, caso.porcentaje_avance, bitacoras.observaciones"
                    + " FROM            bitacoras INNER JOIN"
                    + "                         caso ON bitacoras.id_caso = caso.id_caso INNER JOIN"
                    + "                         empleados_caso ON caso.id_caso = empleados_caso.id_caso"
                    + " WHERE        (empleados_caso.id_empleado = ?) AND ((caso.id_estado = 3) or (caso.id_estado = 4) or (caso.id_estado = 6))";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, idProgramador);
            bitacora = ps.executeQuery();
            BitacoraBean bitaB = null;
            while (bitacora.next()) {
                bitaB = new BitacoraBean();
                bitaB.setId_caso(bitacora.getString(1));
                bitaB.setNombre_caso(bitacora.getString(2));
                bitaB.setDescripActiv(bitacora.getString(3));
                bitaB.setPorcentaje(bitacora.getInt(4));
                bitaB.setObservaciones(bitacora.getString(5));
                listbitaB.add(bitaB);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conseguir las bitacoras");
            log.error(" no se pudo conseguir las bitcaors de programador para el empleado");
        }
    }
    
    public void getBitacorasProgramadorToPro(int idProgramador, ArrayList<BitacoraBean> listbitaB) {
        try {///SOLO CASOS EN DESARROLLO O DEVUELTOS CON CORREPCIONES
            sql = "SELECT        bitacoras.id_caso, caso.nombre_caso, bitacoras.descripcion_actividad, caso.porcentaje_avance, bitacoras.observaciones"
                    + " FROM            bitacoras INNER JOIN"
                    + "                         caso ON bitacoras.id_caso = caso.id_caso INNER JOIN"
                    + "                         empleados_caso ON caso.id_caso = empleados_caso.id_caso"
                    + " WHERE        (empleados_caso.id_empleado = ?) AND ((caso.id_estado = 3) or (caso.id_estado = 6))";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, idProgramador);
            bitacora = ps.executeQuery();
            BitacoraBean bitaB = null;
            Casos CasoFechaFin = new Casos();
            while (bitacora.next()) {
                if (CasoFechaFin.noFin(bitacora.getString(1))) {
                    bitaB = new BitacoraBean();
                    bitaB.setId_caso(bitacora.getString(1));
                    bitaB.setNombre_caso(bitacora.getString(2));
                    bitaB.setDescripActiv(bitacora.getString(3));
                    bitaB.setPorcentaje(bitacora.getInt(4));
                    bitaB.setObservaciones(bitacora.getString(5));
                    listbitaB.add(bitaB);
                }
                else
                    JOptionPane.showMessageDialog(null, "El caso " + bitacora.getString(1) + " ha expirado su fecha Limite");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro al conseguir bitacoras");
            log.error("error al conseguir las bitacoras " + e);
        }
    }
    
    public void getBitacorasProgramadorToJD(int idProgramador, ArrayList<BitacoraBean> listbitaB) {
        try {
            sql = "SELECT        bitacoras.id_caso, caso.nombre_caso, bitacoras.descripcion_actividad, caso.porcentaje_avance, bitacoras.observaciones"
                    + " FROM            bitacoras INNER JOIN"
                    + "                         caso ON bitacoras.id_caso = caso.id_caso INNER JOIN"
                    + "                         empleados_caso ON caso.id_caso = empleados_caso.id_caso"
                    + " WHERE        (empleados_caso.id_empleado = ?) AND (caso.id_estado <> 1) AND (caso.id_estado <> 2) AND (caso.id_estado <> 7)";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, idProgramador);
            bitacora = ps.executeQuery();
            BitacoraBean bitaB = null;
            while (bitacora.next()) {
                bitaB = new BitacoraBean();
                bitaB.setId_caso(bitacora.getString(1));
                bitaB.setNombre_caso(bitacora.getString(2));
                bitaB.setDescripActiv(bitacora.getString(3));
                bitaB.setPorcentaje(bitacora.getInt(4));
                bitaB.setObservaciones(bitacora.getString(5));
                listbitaB.add(bitaB);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al get bitacoras para el JD");
            log.error(e);
        }
    }
    
    public void getBitacoraCaso(String idCaso, BitacoraBean bitaBsend) {
        try {///CONSEGUIR BITACORA DE UN CASO ESPECIFICO
            sql = "SELECT        bitacoras.id_caso, caso.nombre_caso, bitacoras.descripcion_actividad, caso.porcentaje_avance, bitacoras.observaciones"
                    + " FROM            caso INNER JOIN"
                    + "                         bitacoras ON caso.id_caso = bitacoras.id_caso"
                    + " WHERE        caso.id_caso = ?";
            ps = con.Obtener().prepareStatement(sql);
            ps.setObject(1, idCaso);
            bitacora = ps.executeQuery();
            while (bitacora.next()) {
                bitaBsend.setId_caso(bitacora.getString(1));
                bitaBsend.setNombre_caso(bitacora.getString(2));
                bitaBsend.setDescripActiv(bitacora.getString(3));
                bitaBsend.setPorcentaje(bitacora.getInt(4));
                bitaBsend.setObservaciones(bitacora.getString(5));                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al get bitacoras del caso");
            log.error(e);
        }
    }
        
    
    public void UpdateBitacora(BitacoraBean bitaB){
        try {
            sql="update bitacoras set descripcion_actividad = ?, observaciones = ? where id_caso = ? ";
            ps= con.Obtener().prepareStatement(sql);
            ps.setObject(1, bitaB.getDescripActiv());
            ps.setObject(2, bitaB.getObservaciones());
            ps.setObject(3, bitaB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al actualizar bitacora");
            log.error(e);
        }
    }    

    public void loadCasosToList(ArrayList<BitacoraBean> listaBitaBean, JList<String> listUtilidad, JScrollPane ScrollList) {
        if (!listaBitaBean.isEmpty()) {
            DefaultListModel modelo = new DefaultListModel();
            for (BitacoraBean bitacoraBean : listaBitaBean) 
                modelo.addElement(bitacoraBean.getId_caso());
            listUtilidad.setModel(modelo);
        } else{ 
            JOptionPane.showMessageDialog(null, "No tienen casos activos a su cargo");
            ScrollList.setVisible(false);
        }
    }    

    
}

