package com.workshopfast.workshop.DAO;

import org.springframework.data.repository.CrudRepository;

import com.workshopfast.workshop.models.Colaborador;

//-- CRUD TRAS ALGUNS METODOS IMPORTANTES PARA TER ACESSO AO BAMCO
public interface ColaboradorInterface extends CrudRepository<Colaborador, Integer>{
    
}
