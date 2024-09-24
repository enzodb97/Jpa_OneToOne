package com.devback.Jpa.service;

import com.devback.Jpa.model.Mascota;
import com.devback.Jpa.model.Persona;
import com.devback.Jpa.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{
    @Autowired
    private IMascotaRepository repoMasco;

    @Override
    public List<Mascota> getMascota() {
       List <Mascota> listaMascotas = repoMasco.findAll();
       return listaMascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        repoMasco.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        repoMasco.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return repoMasco.findById(id_mascota).orElse(null);
    }

    @Override
    public void editMascota(Long idOriginal, Long id_mascotanueva,
                            String nuevoNombre, String nuevaEspecie,
                            String nuevaRaza, String nuevoColor) {
        Mascota masco = this.findMascota(idOriginal);
        masco.setId_mascota(id_mascotanueva);
        masco.setNombre(nuevoNombre);
        masco.setRaza(nuevaRaza);
        masco.setColor(nuevoColor);
        masco.setEspecie(nuevaEspecie);

        //guardar
        this.saveMascota(masco);


    }
}
