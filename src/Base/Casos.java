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
    private String sqlC;

    public Casos() throws SQLException {
    }

    public void IngresarCasoJF(CasoBean casoB) throws ClassNotFoundException {
        try {
            sqlC = "insert into caso values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = new Conexion().Obtener().prepareStatement(sqlC);
            Conexion.InsertarP(sqlC, ps, casoB.getId_caso(), casoB.getNombre_caso(), casoB.getDescrip_req(), casoB.getDescrip_rechazo(), casoB.getDescripcion_jefedes(), casoB.getId_estado(), casoB.getPorcentaje(), casoB.getFecha_limite(), casoB.getFecha_produccion());
        } catch (SQLException e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, "ERROR Caso Ingreso JF " + e);
        }
    }

    public void getSolicitudesJD(String DeptoCaso, JList<String> listUtilidad) {
        try {
            sqlC = "SELECT        id_caso"
                    + " FROM            caso"
                    + " WHERE        (id_estado = 1) AND (id_caso LIKE '%" + DeptoCaso + "%')";
            casos = Conexion.Buscar(sqlC);
            DefaultListModel modelo = new DefaultListModel();
            while (casos.next()) {
                modelo.addElement(casos.getString(1));
            }

            listUtilidad.setModel(modelo);
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public CasoBean getDatosSolicitudJD(String idCaso) {
        try {
            sqlC = "SELECT        nombre_caso, descrip_req, id_estado, porcentaje_avance"
                    + " FROM            caso"
                    + " WHERE        id_caso= '" + idCaso + "'";
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

    private String isVacia(String code) {
        try {
            sqlC = "select count(*) from caso where id_caso like '" + code + "%'";
            casos = Conexion.Buscar(sqlC);
            if (casos.next()) {
                int cant = casos.getInt(1);
                return cant + "";
            } else {
                return "";
            }
        } catch (SQLException e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public void MostrarCaso(JTable casos) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Descripción", "Motivo Rechazo", "Descripción Jefe", "Estado",
            "Porcentaje", "Fecha Limite", "Fecha Produccion"});
        try {
            String sql = "Select * from caso";
            ResultSet datos = con.Buscar(sql);
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

    public void UpdateCasoToFinalizar(BitacoraBean bitaB) {
        try {
            sqlC = "update caso set id_estado = 4 where id_caso = ? ";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, bitaB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void UpdateCasoPorcent(BitacoraBean bitaB) {
        try {
            sqlC = "update caso set porcentaje_avance = ? where id_caso = ? ";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, bitaB.getPorcentaje());
            ps.setObject(2, bitaB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void UpdateCasoDescrpDes(CasoBean bitaB) {
        try {
            sqlC = "update caso set descripcion_jefedes = ?  where id_caso = ? ";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, bitaB.getDescripcion_jefedes());                        
            ps.setObject(2, bitaB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void UpdateCasoFechaLimite(CasoBean bitaB) {
        try {
            sqlC = "update caso set fecha_limite = ?, id_estado = ? where id_caso = ? ";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, bitaB.getFecha_limite());
            ps.setObject(2, bitaB.getId_estado());
            ps.setObject(3, bitaB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void UpdateDevolucion(CasoBean bitaB, String obser) {
        try {
            sqlC = "update caso set fecha_limite = ?, id_estado = 6 where id_caso = ? ";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, bitaB.getFecha_limite());
            ps.setObject(2, bitaB.getId_caso());
            ps.executeUpdate();
            updateObservacionesBitacora(bitaB, obser);
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void updateObservacionesBitacora(CasoBean bitaB, String obser){
        try {
            //JOptionPane.showMessageDialog(null, "obser "+obser+"\n id "+bitaB.getId_caso());
            sqlC = "update bitacoras set observaciones = ? where id_caso = ?";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, obser);
            ps.setObject(2, bitaB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    //**************************************************************************************
    public CasoBean getNewIdCaso(String nombreDepartamento) {
        try {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            String code = nombreDepartamento.charAt(0) + "" + nombreDepartamento.charAt(1) + "" + nombreDepartamento.charAt(2) + "";
            String yer = String.valueOf(year).charAt(2) + "" + String.valueOf(year).charAt(3) + "";
            String cant = String.valueOf(Integer.parseInt(isVacia(code)) + 1);
            while (cant.length() < 3) {
                cant = "0" + cant;
            }
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
                    + " FROM            caso"
                    + " WHERE        (id_caso LIKE '%" + idBeginCaso + "%') and (id_estado <> 1) AND (id_estado <> 2) AND (id_estado <> 7)";
            casos = Conexion.Buscar(sqlC);
            DefaultListModel modelo = new DefaultListModel();
            while (casos.next()) {
                modelo.addElement(casos.getString(1));
            }
            listUser.setModel(modelo);

        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getEstado(CasoBean casoB) {
        try {
            sqlC = "select id_estado from caso where id_caso = '" + casoB.getId_caso() + "'";
            casos = Conexion.Buscar(sqlC);
            if (casos.next()) {
                casoB.setId_estado(casos.getInt(1));
            }
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void listarCasosPorEstado(Estados estado,JTable estadoCasos,String depto) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Descripción", "Motivo Rechazo", "Descripción Jefe",
            "Porcentaje", "Fecha Limite", "Fecha Produccion"});
        try {
            String sql = "Select * from caso where id_caso like '"+depto+"%' and id_estado="+estado.getId_estado()+"";
            ResultSet datos = con.Buscar(sql);
            while (datos.next()) {
                modelo.addRow(new Object[]{
                    datos.getString("id_caso"),
                    datos.getString("nombre_caso"),
                    datos.getString("descrip_req"),
                    datos.getString("descrip_rechazo"),
                    datos.getString("descripcion_jefedes"),
                  
                    datos.getInt("porcentaje_avance"),
                    datos.getString("fecha_limite"),
                    datos.getString("fecha_produccion")

                });
            }
            estadoCasos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
          
    }

    public void FinCaso(CasoBean casoB) {
        try {
            sqlC = "update caso set fecha_produccion = ?, id_estado = ? where id_caso = ? ";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, casoB.getFecha_produccion());
            ps.setObject(2, casoB.getId_estado());
            ps.setObject(3, casoB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("" + e);
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getDateLimit(CasoBean casoB) {
        try {
            sqlC = "select fecha_limite from caso where id_caso = '" + casoB.getId_caso() + "'";
            casos = Conexion.Buscar(sqlC);
            if (casos.next()) 
                casoB.setFecha_limite(casos.getString(1));            
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void firstBitacora(CasoBean casoFecha) {
        try {
            sqlC = "select  count(*) from bitacoras";
            casos = Conexion.Buscar(sqlC);
            casos.next();
            sqlC = "insert into bitacoras values (?,?,?,?)";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, casos.getInt(1) + 1);
            ps.setObject(2, casoFecha.getId_caso());
            ps.setObject(3, "");
            ps.setObject(4, "");
            ps.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void rechazarCaso(CasoBean casoB) {
        try {
            sqlC="update caso set id_estado = ?, descrip_rechazo = ? where id_caso = ?";
            ps = con.Obtener().prepareStatement(sqlC);
            ps.setObject(1, casoB.getId_estado());
            ps.setObject(2, casoB.getDescrip_rechazo());
            ps.setObject(3, casoB.getId_caso());
            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void getCasosVencidos(String DeptoCaso, JList<String> listUtilidad) {
        try {
            sqlC = "SELECT        id_caso"
                    + " FROM            caso"
                    + " WHERE        ((id_estado = 3) or(id_estado = 4)or(id_estado = 5)or(id_estado = 6) ) AND (id_caso LIKE '%" + DeptoCaso + "%')";
            casos = Conexion.Buscar(sqlC);
            DefaultListModel modelo = new DefaultListModel();
            while (casos.next()) 
                modelo.addElement(casos.getString(1));            
            listUtilidad.setModel(modelo);
        } catch (Exception e) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
