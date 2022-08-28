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
public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String urlP;
    
    private String yearP;
    private String logoP;
    
    //Constructores

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descripcionP, String urlP, String yearP, String logoP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.yearP = yearP;
        this.logoP = logoP;
    }
    
    //Getters And Setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getYearP() {
        return yearP;
    }

    public void setYearP(String yearP) {
        this.yearP = yearP;
    }

    public String getLogoP() {
        return logoP;
    }

    public void setLogoP(String logoP) {
        this.logoP = logoP;
    }
    
}
