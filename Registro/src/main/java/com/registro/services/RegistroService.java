package com.registro.services;

import com.registro.entities.Registro;
import com.registro.repositories.RegistroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepo;

    public List<Registro> getRegistros() {
        return registroRepo.findAll();
    }

    public Registro saveRegistro(Registro registro) {
        return registroRepo.save(registro);
    }

}
