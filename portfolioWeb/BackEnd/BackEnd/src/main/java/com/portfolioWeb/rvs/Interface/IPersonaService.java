/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioWeb.rvs.Interface;

import com.portfolioWeb.rvs.Entity.Persona;
import java.util.List;


/**
 *
 * @author vane_
 */


public interface IPersonaService {
    //Traer una persona
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto/usuario pero lo buscamos por ID
    public void deletePersona(Long id);
    
    //Buscar una Persona por ID
    public Persona findPersona(Long id);
}
