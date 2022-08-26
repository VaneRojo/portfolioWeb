/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author vane_
 */

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private String logoE;
    
    @NotBlank
    private Date fechaInicioE;
    
    private Date fechaFinE;
    
    private boolean trabajoActualE;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String logoE, boolean trabajoActualE, Date fechaInicioE, Date fechaFinE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinE = fechaFinE;
        this.trabajoActualE = trabajoActualE;
    }
    
    //Getters And Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombrE) {
        this.nombreE = nombrE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getLogoE() {
        return logoE;
    }

    public void setLogoE(String logoE) {
        this.logoE = logoE;
    }

    public Date getFechaInicioE() {
        return fechaInicioE;
    }

    public void setFechaInicioE(Date fechaInicioE) {
        this.fechaInicioE = fechaInicioE;
    }

    public Date getFechaFinE() {
        return fechaFinE;
    }

    public void setFechaFinE(Date fechaFinE) {
        this.fechaFinE = fechaFinE;
    }

    public boolean isTrabajoActualE() {
        return trabajoActualE;
    }

    public void setTrabajoActualE(boolean trabajoActualE) {
        this.trabajoActualE = trabajoActualE;
    }
    
    
    
}
