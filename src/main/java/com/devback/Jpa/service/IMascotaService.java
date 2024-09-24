package com.devback.Jpa.service;

import com.devback.Jpa.model.Mascota;


import java.util.List;

public interface IMascotaService {
    //lectura
    public List<Mascota> getMascota();
    //alta
    public void saveMascota(Mascota mascota);
    //baja
    public void deleteMascota (Long id_mascota);
    //leer 1 objeto
    public Mascota findMascota(Long id_mascota);
    //editar
    public void editMascota (Long idOriginal, Long id_mascotanueva,
                             String nuevoNombre,
                             String nuevaEspecie,
                             String nuevaRaza,
                             String nuevoColor);

}
