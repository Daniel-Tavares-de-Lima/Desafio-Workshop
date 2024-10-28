package com.workshopfast.workshop.repositories;

/*---------Imports--------- */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.workshopfast.workshop.models.AtaPresenca;
import java.util.List;

@Repository
public interface AtaPresencaRepositorio extends JpaRepository<AtaPresenca,Integer> {
   
    // List<AtaPresenca> findByWorkshopId(int workshopId);
}
