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
public class BitacoraBean {

    /**
     * @return the fechaLimite
     */
    public String getFechaLimite() {
        return fechaLimite;
    }

    /**
     * @param fechaLimite the fechaLimite to set
     */
    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * @return the id_caso
     */
    public String getId_caso() {
        return id_caso;
    }

    /**
     * @param id_caso the id_caso to set
     */
    public void setId_caso(String id_caso) {
        this.id_caso = id_caso;
    }

    /**
     * @return the nombre_caso
     */
    public String getNombre_caso() {
        return nombre_caso;
    }

    /**
     * @param nombre_caso the nombre_caso to set
     */
    public void setNombre_caso(String nombre_caso) {
        this.nombre_caso = nombre_caso;
    }

    /**
     * @return the descripActiv
     */
    public String getDescripActiv() {
        return descripActiv;
    }

    /**
     * @param descripActiv the descripActiv to set
     */
    public void setDescripActiv(String descripActiv) {
        this.descripActiv = descripActiv;
    }

    /**
     * @return the porcentaje
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    private String id_caso;
    private String nombre_caso;
    private String descripActiv;
    private int porcentaje;
    private String observaciones;
    private String fechaLimite;
}
