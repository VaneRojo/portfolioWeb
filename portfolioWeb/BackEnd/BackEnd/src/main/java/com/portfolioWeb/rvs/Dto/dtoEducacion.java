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
public class dtoEducacion {
    @NotBlank
    private String nombreInsti;
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private Date fechaInicioEdu;
    @NotBlank
    private Date fechaFinEdu;
    
    private String descripcionEdu;
    private String nivelEdu;
    private String logoEdu;
    
    //Constructores

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreInsti, String tituloEdu, Date fechaInicioEdu, Date fechaFinEdu, 
            String descripcionEdu, String nivelEdu, String logoEdu) {
        this.nombreInsti = nombreInsti;
        this.tituloEdu = tituloEdu;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinEdu = fechaFinEdu;
        this.descripcionEdu = descripcionEdu;
        this.nivelEdu = nivelEdu;
        this.logoEdu = logoEdu;
    }
    
    //Getters And Setters

    public String getNombreInsti() {
        return nombreInsti;
    }

    public void setNombreInsti(String nombreInsti) {
        this.nombreInsti = nombreInsti;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public Date getFechaInicioEdu() {
        return fechaInicioEdu;
    }

    public void setFechaInicioEdu(Date fechaInicioEdu) {
        this.fechaInicioEdu = fechaInicioEdu;
    }

    public Date getFechaFinEdu() {
        return fechaFinEdu;
    }

    public void setFechaFinEdu(Date fechaFinEdu) {
        this.fechaFinEdu = fechaFinEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getNivelEdu() {
        return nivelEdu;
    }

    public void setNivelEdu(String nivelEdu) {
        this.nivelEdu = nivelEdu;
    }

    public String getLogoEdu() {
        return logoEdu;
    }

    public void setLogoEdu(String logoEdu) {
        this.logoEdu = logoEdu;
    }
    
    
}
