/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Dto;

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
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombrE, String descripcionE, String logoE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.logoE = logoE;
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
    
    
}
