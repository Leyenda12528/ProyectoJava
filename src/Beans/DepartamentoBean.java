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
public class DepartamentoBean {

    /**
     * @return the id_depto
     */
    public int getId_depto() {
        return id_depto;
    }

    /**
     * @param id_depto the id_depto to set
     */
    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    /**
     * @return the nombre_depto
     */
    public String getNombre_depto() {
        return nombre_depto;
    }

    /**
     * @param nombre_depto the nombre_depto to set
     */
    public void setNombre_depto(String nombre_depto) {
        this.nombre_depto = nombre_depto;
    }
    private int id_depto;
    private String nombre_depto;
    
}
