/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Controller;


import com.portfolioWeb.rvs.Dto.dtoProyecto;
import com.portfolioWeb.rvs.Entity.Proyecto;
import com.portfolioWeb.rvs.Security.Controller.Mensaje;
import com.portfolioWeb.rvs.Service.SProyecto;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vane_
 */
@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto){
        if(StringUtils.isBlank(dtoproyecto.getNombreP()) || StringUtils.isBlank(dtoproyecto.getDescripcionP()) ||
                StringUtils.isBlank(dtoproyecto.getUrlP())){
            return new ResponseEntity(new Mensaje("Los campos con * son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        if(sProyecto.existsByNombreP(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
                dtoproyecto.getNombreP(),
                dtoproyecto.getDescripcionP(),
                dtoproyecto.getUrlP(),
                dtoproyecto.getYearP(),
                dtoproyecto.getLogoP());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(sProyecto.existsByNombreP(dtoproyecto.getNombreP()) && 
                sProyecto.getByNombreP(dtoproyecto.getNombreP()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El nombre del Proyecto ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoproyecto.getNombreP()) || StringUtils.isBlank(dtoproyecto.getDescripcionP()) ||
                StringUtils.isBlank(dtoproyecto.getUrlP())){
            return new ResponseEntity(new Mensaje("Los campos con * son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        
        proyecto.setNombreP(dtoproyecto.getNombreP());
        proyecto.setDescripcionP(dtoproyecto.getDescripcionP());
        proyecto.setUrlP(dtoproyecto.getUrlP());
        proyecto.setYearP(dtoproyecto.getYearP());
        proyecto.setLogoP(dtoproyecto.getLogoP());
        
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("El Proyecto se ha actualizado correctamente"),HttpStatus.OK);
                
    }
}
