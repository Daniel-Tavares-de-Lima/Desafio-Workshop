package com.workshopfast.workshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workshopfast.workshop.models.Colaborador;

@Repository
public interface ColaboradorRepositorio extends CrudRepository<Colaborador, Integer>{
    
}
