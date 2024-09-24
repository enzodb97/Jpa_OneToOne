package com.devback.Jpa.controller;

import com.devback.Jpa.model.Persona;
import com.devback.Jpa.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService persoServ;


    @GetMapping ("/personas/traer")
    public List<Persona> getPersonas(){
        return persoServ.getPersonas();
    }
    @PostMapping("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return  "Creada con éxito";
    }
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "Eliminado con éxito";
    }
    @PutMapping("/personas/editar/{id_original}")
    public Persona editPersona (@PathVariable Long id_original,
                                @RequestParam (required = false, name="id")Long nuevaId,
                                @RequestParam (required = false, name="nombre")String nuevoNombre,
                                @RequestParam (required = false, name="apellido")String nuevaApellido,
                                @RequestParam (required = false, name="edad")int nuevaEdad){
    persoServ.editPersona(id_original, nuevaId, nuevoNombre, nuevaApellido, nuevaEdad);
    Persona perso = persoServ.findPersona(nuevaId);
    return perso;
    }
    @PutMapping("/personas/editar")
    public Persona editPersona (@RequestBody Persona per){
        persoServ.editPersona(per);
       return persoServ.findPersona(per.getId());

    }

}
