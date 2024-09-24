package com.devback.Jpa.service;

import com.devback.Jpa.model.Persona;

import java.util.List;

public interface IPersonaService {
//metodo para traer todas las personas
    //leer
    public List<Persona> getPersonas();
    //guardar
    public void savePersona(Persona person);
    //borrar
    public void deletePersona (Long id);
    //buscar 1 objeto
    public Persona findPersona(Long id);
    //modificacion
    public void editPersona(Long idOrigin, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad);

   public void editPersona(Persona per);
}
