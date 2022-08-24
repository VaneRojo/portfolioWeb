/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Security.Service;

import com.portfolioWeb.rvs.Security.Entity.Rol;
import com.portfolioWeb.rvs.Security.Enums.RolNombre;
import com.portfolioWeb.rvs.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vane_
 */
@Service
@Transactional //Mantiene lo mismo acá que en la base de datos. Asegura que lo mismo que tenemos acá es loq ue vamos a tener en la base de datos (Persistencia)
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
