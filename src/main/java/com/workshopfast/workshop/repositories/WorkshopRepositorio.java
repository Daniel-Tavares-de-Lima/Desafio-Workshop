package com.workshopfast.workshop.repositories;

/*---------Imports----------- */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshopfast.workshop.models.Workshop;

@Repository
public interface WorkshopRepositorio extends JpaRepository<Workshop, Integer>{

    
}
