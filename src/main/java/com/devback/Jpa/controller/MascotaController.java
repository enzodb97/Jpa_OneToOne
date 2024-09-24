package com.devback.Jpa.controller;

import com.devback.Jpa.model.Mascota;
import com.devback.Jpa.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {
    @Autowired
    private IMascotaService mascoServ;

    @GetMapping("/mascota/traer")
    public List<Mascota> getMascota(){
        return mascoServ.getMascota();
    }
    @PostMapping("/mascota/crear")
    public String saveMascota(@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);
        return  "Creada con éxito la mascota";
    }
    @DeleteMapping("/mascota/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascoServ.deleteMascota(id);
        return "Eliminado con éxito la mascota";
    }
    @PutMapping("/mascota/editar/{id_original}")
    public Mascota editMascota (@PathVariable Long id_original,
                                @RequestParam (required = false, name="id")Long nuevaId,
                                @RequestParam (required = false, name="nombre")String nuevoNombre,
                                @RequestParam (required = false, name="especie")String nuevaEspecie,
                                @RequestParam (required = false, name="raza")String nuevaRaza,
                                @RequestParam (required = false, name="color")String nuevoColor){
        mascoServ.editMascota(id_original, nuevaId, nuevoNombre, nuevaEspecie, nuevaRaza,nuevoColor );
        Mascota masco = mascoServ.findMascota(nuevaId);
        return masco;
    }
}
