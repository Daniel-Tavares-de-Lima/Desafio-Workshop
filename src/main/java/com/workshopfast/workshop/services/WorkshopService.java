package com.workshopfast.workshop.services;


/*----------Imports--------- */
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.repositories.WorkshopRepositorio;

@Service
public class WorkshopService {
    
    @Autowired
    private WorkshopRepositorio workshopRepositorio;

   
    //----Buscar Workshop READ
    public Workshop buscaWorkshop(int id){
        Optional<Workshop> workshop = this.workshopRepositorio.findById(id);
        if(workshop.isPresent()){
            return workshop.get();
        }else{
            throw new RuntimeException("Workshop não encontrado: " + id);
        }
    }

    //---Buscar Todos os Workshops
    public List<Workshop> todosWorkshop(){
        return (List<Workshop>) workshopRepositorio.findAll();
    }

    //----Criar Workshop CREATE
    public Workshop criarWorkshop(Workshop workshop){
        // Salva o novo workshop no repositório
        workshop = this.workshopRepositorio.save(workshop);
        return workshop;
    }

    public Workshop editarWorkshop(Workshop workshop) {
        // Busca o workshop existente pelo ID
        Workshop workshopExistente = buscaWorkshop(workshop.getId());
    
        // Verifica se o workshop foi encontrado
        if (workshopExistente == null) {
            throw new RuntimeException("Colaborador não encontrado");
        }
    
        // Atualiza os campos necessários
        workshopExistente.setNome(workshop.getNome());
        

        return this.workshopRepositorio.save(workshopExistente);
    }

    //------ Deletar Workshop Delete
    public void deletarWorkshop(int id){
        //--Busca o workshop pelo ID para garantir que ele existe
        buscaWorkshop(id);
        try{
            this.workshopRepositorio.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não foi possivel deletar o workshop(ENTIDADE RELACIONADAS)");
        }
    }

    
}
