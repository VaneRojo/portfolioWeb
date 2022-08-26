/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author vane_
 */
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private String logoE;
    private Date fechaInicioE;
    private Date fechaFinE;
    private boolean trabajoActualE;
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String logoE, Date fechaInicioE, Date fechaFinE, boolean trabajoActualE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
        this.fechaInicioE = fechaInicioE;
        this.fechaFinE = fechaFinE;
        this.trabajoActualE = trabajoActualE;
        
    }
    
    //Getters And Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
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
