/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import Beans.BitacoraBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author jorge
 */
public class Bitacora {
    private Conexion con = new Conexion();
    private ResultSet bitacora;
    private PreparedStatement ps = null;
    private String sql;
    
    public Bitacora() throws SQLException{
    }
    
    public void IngresarBitacora() throws SQLException{
        
    }
    
    public void getBitacoraProgramador(int idProgramador, ArrayList<BitacoraBean> listbitaB) {
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
            System.out.println(""+e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void MostrarBitacora(){}
    
    private void UpdateBitacora() throws SQLException{
        
        //Code
    }
    
    private void ByeBitcora() throws SQLException{
        
    }
}
