/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vane_
 */
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombreS;
    
    @NotNull
    private String porcentajeS;
    
    private String urlImagenS;
    
    //Constructores 

    public Skill() {
    }

    public Skill(String nombreS, String porcentajeS, String urlImagenS) {
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
        this.urlImagenS = urlImagenS;
    }
    
    //Getters And Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
