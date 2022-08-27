/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Controller;

import com.portfolioWeb.rvs.Dto.dtoEducacion;
import com.portfolioWeb.rvs.Entity.Educacion;
import com.portfolioWeb.rvs.Security.Controller.Mensaje;
import com.portfolioWeb.rvs.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getNombreInsti()) || StringUtils.isBlank(dtoeducacion.getTituloEdu()) ||
                dtoeducacion.getFechaInicioEdu() == null || dtoeducacion.getFechaFinEdu() == null){
            return new ResponseEntity(new Mensaje("Los campos con * son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreInsti(dtoeducacion.getNombreInsti())){
            return new ResponseEntity(new Mensaje("Esa institución ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(
                dtoeducacion.getNombreInsti(),
                dtoeducacion.getTituloEdu(),
                dtoeducacion.getFechaInicioEdu(),
                dtoeducacion.getFechaFinEdu(),
                dtoeducacion.getDescripcionEdu(),
                dtoeducacion.getNivelEdu(),
                dtoeducacion.getLogoEdu());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(sEducacion.existsByNombreInsti(dtoeducacion.getNombreInsti()) && 
                sEducacion.getByNombreInsti(dtoeducacion.getNombreInsti()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El nombre de la Institución ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoeducacion.getNombreInsti()) || StringUtils.isBlank(dtoeducacion.getTituloEdu()) ||
                dtoeducacion.getFechaInicioEdu() == null || dtoeducacion.getFechaFinEdu() == null){
            return new ResponseEntity(new Mensaje("Los campos con * son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getOne(id).get();
        
        educacion.setNombreInsti(dtoeducacion.getNombreInsti());
        educacion.setTituloEdu(dtoeducacion.getTituloEdu());
        educacion.setFechaInicioEdu(dtoeducacion.getFechaInicioEdu());
        educacion.setFechaFinEdu(dtoeducacion.getFechaFinEdu());
        educacion.setDescripcionEdu(dtoeducacion.getDescripcionEdu());
        educacion.setNivelEdu(dtoeducacion.getNivelEdu());
        educacion.setLogoEdu(dtoeducacion.getLogoEdu());
        
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("La educación se ha actualizado correctamente"),HttpStatus.OK);
                
    }
}
