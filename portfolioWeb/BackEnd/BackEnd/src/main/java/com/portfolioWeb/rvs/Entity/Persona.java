
package com.portfolioWeb.rvs.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author vane_
 */
@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El nombre debe tener de 1 a 50 carácteres máximo")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "El apellido debe tener de 1 a 50 carácteres máximo")
    private String apellido;
    
    @NotNull
    /*@Size(min = 11, max = 11, message = "El teléfono debe contener 11 caracteres")*/
    private String telefono;
    
    @NotNull
    /**@Size(min = 11, max = 11, message = "El teléfono debe contener 11 caracteres")*/
    private String mail;
    
    @NotNull
    /*@Size(min = 1, max = 50)*/
    private String img_perfil;
    

    @NotNull
    /*@Size(min = 1, max = 50)*/
    private String img_banner;
    
    
    @NotNull
    /*@Size(min = 1, max = 50)*/
    private int edad;
   
    @NotNull
    /*@Size(min = 1, max = 50)*/
    private String titulo;
    
    @NotNull
    private String introduccion;
    
    
    //Constructores

    public Persona() {
    }

    public Persona(String nombre, String apellido, String telefono, String mail, String img_perfil, String img_banner, int edad, String titulo, String introduccion) {
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
    
    
    
    
}
