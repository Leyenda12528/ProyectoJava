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
 * @author jorge
 */
public class Conexion1 {
    private Connection conexion=null;
    private Statement s=null;
    private ResultSet rs=null;
    private String query="";
    
    private static final Logger log = Logger.getLogger(Conexion1.class);
    //constructor
    public Conexion1() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Se obtiene una conexión con la base de datos.
            conexion = DriverManager.getConnection ( "jdbc:mysql://localhost/guia6poo1?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "123456"); // Permite ejecutar sentencias SQL sin parámetros
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String connectionBD="jdbc:sqlserver://localhost;databaseName=PRUEBA;user=sa;password=123456;";
            //conexion = DriverManager.getConnection (connectionBD);
            s = conexion.createStatement();
        } catch (ClassNotFoundException e) {
            log.fatal("No se encontro el Driver " + e);
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(String consulta) {
        try {
            this.rs = s.executeQuery(consulta);
        } catch (SQLException e) {
            log.fatal("Fallo de SQL " + e);
        }
    }
    public void setQuery(String query) throws SQLException{
        this.s.executeUpdate(query);
    }
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
}
