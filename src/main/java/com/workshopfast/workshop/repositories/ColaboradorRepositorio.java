package com.workshopfast.workshop.repositories;

import org.springframework.data.repository.CrudRepository;

import com.workshopfast.workshop.models.Colaborador;

//-- CRUD TRAS ALGUNS METODOS IMPORTANTES PARA TER ACESSO AO BAMCO
public interface ColaboradorRepositorio extends CrudRepository<Colaborador, Integer>{
    
}
