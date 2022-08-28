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
public class dtoSkill {
    @NotBlank
    private String nombreS;
    
    @NotBlank
    private String porcentajeS;
    
    private String urlImagenS;
    
    //Constructores

    public dtoSkill() {
    }

    public dtoSkill(String nombreS, String porcentajeS, String urlImagenS) {
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
        this.urlImagenS = urlImagenS;
    }
    
    //Getters And Setters

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(String porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

    public String getUrlImagenS() {
        return urlImagenS;
    }

    public void setUrlImagenS(String urlImagenS) {
        this.urlImagenS = urlImagenS;
    }
}
