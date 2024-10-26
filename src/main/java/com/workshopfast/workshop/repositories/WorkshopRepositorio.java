package com.workshopfast.workshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workshopfast.workshop.models.Workshop;

@Repository
public interface WorkshopRepositorio extends CrudRepository<Workshop, Integer>{

    
}
