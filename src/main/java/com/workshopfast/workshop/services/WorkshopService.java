package com.workshopfast.workshop.services;

import java.util.Optional;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.repositories.WorkshopRepositorio;

@Service
public class WorkshopService {
    
    @Autowired
    private WorkshopRepositorio workshopRepositorio;

    @Autowired 
    private ColaboradorService colaboradorService;

    //----Buscar Workshop READ
    public Workshop buscaWorkshop(int id){
        Optional<Workshop> workshop = this.workshopRepositorio.findById(id);
        if(workshop.isPresent()){
            return workshop.get();
        }else{
            throw new RuntimeException("Workshop não encontrado: " + id);
        }
    }

    //----Criar Workshop CREATE
    public Workshop criarWorkshop(Workshop workshop){
        workshop.setId(null);
        workshop = this.workshopRepositorio.save(workshop);
        return workshop;
    }


    //---- Editar Workshop Update
    public Workshop editarWorkshop(Workshop workshop){
        Workshop novoWorkshop = buscaWorkshop(workshop.getId());
        novoWorkshop.SetDescricao(workshop.getDescricao());
        return this.workshopRepositorio.save(novoWorkshop);
    }


    //------ Deletar Workshop Delete
    public void deletarWorkshop(int id){
        buscaWorkshop(id);
        try{
            this.workshopRepositorio.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não foi possivel deletar o workshop(ENTIDADE RELACIONADAS)");
        }
    }
}
