package com.devback.Jpa.service;

import com.devback.Jpa.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    private IPersonaRepository personaRepo;
}
