/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioWeb.rvs.Controller;

import com.portfolioWeb.rvs.Dto.dtoSkill;
import com.portfolioWeb.rvs.Entity.Skill;
import com.portfolioWeb.rvs.Security.Controller.Mensaje;
import com.portfolioWeb.rvs.Service.SSkill;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill {
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        sSkill.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreS()) || StringUtils.isBlank(dtoskill.getPorcentajeS())){
            return new ResponseEntity(new Mensaje("Los campos con * son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        if(sSkill.existsByNombreS(dtoskill.getNombreS())){
            return new ResponseEntity(new Mensaje("Ese Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = new Skill(
                dtoskill.getNombreS(),
                dtoskill.getPorcentajeS(),
                dtoskill.getUrlImagenS(),
                dtoskill.isMostrarImagenS());
        sSkill.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        
        if(sSkill.existsByNombreS(dtoskill.getNombreS()) && 
                sSkill.getByNombreS(dtoskill.getNombreS()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El nombre del Skill ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskill.getNombreS()) || StringUtils.isBlank(dtoskill.getPorcentajeS())){
            return new ResponseEntity(new Mensaje("Los campos con * son obligatorios"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = sSkill.getOne(id).get();
        
        skill.setNombreS(dtoskill.getNombreS());
        skill.setPorcentajeS(dtoskill.getPorcentajeS());
        skill.setUrlImagenS(dtoskill.getUrlImagenS());
        skill.setMostrarImagenS(dtoskill.isMostrarImagenS());
        
        sSkill.save(skill);
        
        return new ResponseEntity(new Mensaje("El Skill se ha actualizado correctamente"),HttpStatus.OK);
                
    }
}
