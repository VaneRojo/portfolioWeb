
package com.portfolioWeb.rvs.Controller;

import com.portfolioWeb.rvs.Dto.dtoPersona;
import com.portfolioWeb.rvs.Entity.Persona;
import com.portfolioWeb.rvs.Interface.IPersonaService;
import com.portfolioWeb.rvs.Security.Controller.Mensaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vane_
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired 
    IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @GetMapping("personas/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!ipersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ese registro"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = ipersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //URL:PUERTO/personas/editar/4/nombre & apellido & telefono & mail & img_perfil & img_banner
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public ResponseEntity<?> editPersona(@PathVariable Long id,@RequestBody dtoPersona dtopersona){
        Persona persona = ipersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setTelefono(dtopersona.getTelefono());
        persona.setMail(dtopersona.getMail());
        persona.setImg_perfil(dtopersona.getImg_perfil());
        persona.setImg_banner(dtopersona.getImg_banner());
        persona.setEdad(dtopersona.getEdad());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setIntroduccion(dtopersona.getIntroduccion());
        
        ipersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("La información se ha actualizado correctamente"),HttpStatus.OK);
    }
    
    @GetMapping("personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    

}
