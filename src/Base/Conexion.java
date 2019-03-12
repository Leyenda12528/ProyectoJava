/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;
import org.apache.log4j.Logger;
/**
 *
 * @author usuario
 */
public class Conexion {

    private String url = "localhost/bd";
    private String usuario = "root";
    private String clave = "";

    private static Connection cnx = null;
    private static final Logger log = Logger.getLogger(Conexion.class);

    public Conexion() throws SQLException {
        try {
            Obtener();
        } catch (SQLException ex) {
            log.fatal("Fallo de SQL " + ex);
        } catch (ClassNotFoundException ex) {
            log.fatal("No se encontro el Driver " + ex);
        }
    }

    public Connection Obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://" + this.url, this.usuario, this.clave);
                System.out.println("Conectado Exitosament: \n");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
//                log.info("Error de info");
//        log.fatal("mjs fatal");
//        log.warn("mjs warn");
//        log.error("mjs error");
//        log.debug("mjs debug");
            }
        }
        return cnx;
    }

    public static void Cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }

    public static void Insertar(String sentencia) throws SQLException {
        PreparedStatement consulta = cnx.prepareStatement(sentencia);
        consulta.execute(sentencia);

    }

    public static void Eliminar(String sentencia) throws SQLException {
        PreparedStatement consulta = cnx.prepareStatement(sentencia);
        consulta.execute(sentencia);

    }

    public static void Actualizar(String sentencia) throws SQLException {
        PreparedStatement consulta = cnx.prepareStatement(sentencia);
        consulta.execute(sentencia);

    }

    public static ResultSet Buscar(String sentencia) throws SQLException {
        ResultSet resultado = null;
        PreparedStatement consulta = cnx.prepareStatement(sentencia);
        resultado = consulta.executeQuery();

        return resultado;
    }

}
