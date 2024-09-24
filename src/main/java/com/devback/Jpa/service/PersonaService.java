package com.devback.Jpa.service;

import com.devback.Jpa.model.Persona;
import com.devback.Jpa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    private IPersonaRepository personaRepo;

    @Override
    public List<Persona> getPersonas() {
       List<Persona> listaPersonas =personaRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona person) {
        personaRepo.save (person);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = personaRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOrigin, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        //busco el objeto original
        Persona perso =this.findPersona(idOrigin);
        //perso trae tdos los valores, ahora seteo
        perso.setId(idNueva);
        perso.setEdad(nuevaEdad);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        //guardo los cambios
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
}
