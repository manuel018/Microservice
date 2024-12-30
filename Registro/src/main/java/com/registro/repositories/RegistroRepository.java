package com.registro.repositories;

import com.registro.entities.Registro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistroRepository extends MongoRepository<Registro, String> {

}
