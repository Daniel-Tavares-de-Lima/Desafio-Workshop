package com.workshopfast.workshop.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workshopfast.workshop.models.AtaPresenca;

@Repository
public interface AtaPresencaRepositorio extends CrudRepository<AtaPresenca,Integer> {

}
