/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.sql.*;

/**
 *
 * @author less_
 */
public class Conexion_c {
    private Connection conexion =null;
    private Statement s =null;
    private ResultSet rs=null;
private String query="";
//Contructor
public Conexion_c() throws SQLException{
    try
     {
        //obtenemos el driver de para mysql
        Class.forName("com.mysql.jdbc.Driver");
        // Se obtiene una conexión con la base de datos.
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/jproyecto","root", "");
        // Permite ejecutar sentencias SQL sin parámetros
        s = conexion.createStatement();
           //  System.err.println("exito");
         }
    catch (ClassNotFoundException e1) {
        System.out.println("ERROR:No encuentro el driver de la BD:"+e1.getMessage());
         }
 }

        public ResultSet getRs() {
            return rs;
        }
        //Metodo que permite fijar la tabla resultado de la pregunta
        //SQL realizada
        public void setRs(String consulta) {
            try {
                this.rs = s.executeQuery(consulta);
            } catch (SQLException e2) {
                System.out.println("ERROR:Fallo en SQL: "+e2.getMessage());
                 }
         }
        //Metodo que recibe un sql como parametro que sea un update,insert.delete
        public void setQuery(String query) throws SQLException {
                this.s.executeUpdate(query);
         }
        //Metodo que cierra la conexion
        public void cerrarConexion() throws SQLException {
            conexion.close();
         }

}
