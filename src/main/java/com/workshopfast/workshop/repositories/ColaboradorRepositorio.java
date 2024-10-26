package com.workshopfast.workshop.repositories;

import org.springframework.data.repository.CrudRepository;

import com.workshopfast.workshop.models.Colaborador;

//-- CRUD TRAS ALGUNS MÉTODOS IMPORTANTES PARA TER ACESSO AO BANCO
public interface ColaboradorRepositorio extends CrudRepository<Colaborador, Integer>{
    
}
