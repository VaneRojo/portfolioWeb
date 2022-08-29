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
public class dtoPersona {
    @NotBlank
    
    private String nombre;
    @NotBlank
    
    private String apellido;
    
    @NotBlank
    /*@Size(min = 11, max = 11, message = "El teléfono debe contener 11 caracteres")*/
    private String telefono;
    
    @NotBlank
    /**@Size(min = 11, max = 11, message = "El teléfono debe contener 11 caracteres")*/
    private String mail;
    
    @NotBlank
    /*@Size(min = 1, max = 50)*/
    private String img_perfil;
    

    @NotBlank
    /*@Size(min = 1, max = 50)*/
    private String img_banner;
    
    
    @NotBlank
    /*@Size(min = 1, max = 50)*/
    private int edad;
   
    @NotBlank
    /*@Size(min = 1, max = 50)*/
    private String titulo;
    
    @NotBlank
    private String introduccion;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String telefono, String mail, String img_perfil, String img_banner, int edad, String titulo, String introduccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.img_perfil = img_perfil;
        this.img_banner = img_banner;
        this.edad = edad;
        this.titulo = titulo;
        this.introduccion = introduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImg_perfil() {
        return img_perfil;
    }

    public void setImg_perfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    public String getImg_banner() {
        return img_banner;
    }

    public void setImg_banner(String img_banner) {
        this.img_banner = img_banner;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }
    
    
    
    
}
