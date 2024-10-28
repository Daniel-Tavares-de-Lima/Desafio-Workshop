package com.workshopfast.workshop.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.repositories.AtaPresencaRepositorio;
import com.workshopfast.workshop.repositories.ColaboradorRepositorio;
import com.workshopfast.workshop.repositories.WorkshopRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AtaPresencaService {
    
    @Autowired
    private AtaPresencaRepositorio ataPresencaRepositorio;

    @Autowired 
    private ColaboradorRepositorio colaboradorRepositorio;

    @Autowired
    private WorkshopRepositorio workshopRepositorio;

    //--- Busca Todos os Colaboradores que estão no Workshop
    public List<AtaPresenca> todosPresentes(){
        return (List<AtaPresenca>) ataPresencaRepositorio.findAll();
    }



    //-- Busca os Colabores pelo Id que estão no Workshop
    public AtaPresenca buscaPresentesId(int id){
        Optional<AtaPresenca> presentes = this.ataPresencaRepositorio.findById(id);
        if(presentes.isPresent()){
            return presentes.get();
        }else{
            throw new RuntimeException("Ata de Presença não encontrado: " + id);
        }
    }       


    //------CRIAR ATA
    public AtaPresenca criarAta(AtaPresenca ataPresenca) {
        
        Integer colaboradorId = ataPresenca.getColaborador().getId();
        Integer workshopId = ataPresenca.getWorkshop().getId();
        Boolean presente = ataPresenca.getPresente();


        // Verificar se o colaborador existe
        Colaborador colaborador = colaboradorRepositorio.findById(colaboradorId)
                .orElseThrow(() -> new EntityNotFoundException("Colaborador não encontrado"));
    
        // Verificar se o workshop existe
        Workshop workshop = workshopRepositorio.findById(workshopId)
                .orElseThrow(() -> new EntityNotFoundException("Workshop não encontrado"));
    
        // Criar a nova ata de presença
        AtaPresenca novaAta = new AtaPresenca();

        novaAta.setColaborador(colaborador);
        novaAta.setWorkshop(workshop);
        novaAta.setPresente(presente);
    
        // Salvar a ata no repositório e retornar a instância salva
        return ataPresencaRepositorio.save(novaAta);
    }

   //-----Editar colaborador Update
    // public AtaPresenca editarAta(AtaPresenca ataNova){
    //     // ataNova.setId(id);
    //     // return ataPresencaRepositorio.save(ataNova);

    //     if (ataNova.getId() == null || !ataPresencaRepositorio.existsById(ataNova.getId())){
    //         throw new EntityNotFoundException("Ata de Presença não encontrada");
    //     }

    //     return ataPresencaRepositorio.save(ataNova);
    // }


    public AtaPresenca editarAtaPresentes(AtaPresenca presentes){
        AtaPresenca novaAta = buscaPresentesId(presentes.getId());
        // novaAta.setNome(novaAta.getNome());
        return this.ataPresencaRepositorio.save(novaAta);
    }


    //-----Excluir Ata DELETE
    public void deletarAtaPresentes(int id){
        buscaPresentesId(id);

        //--- Caso a Entidade esteja relacionado com outra entidade(Tem chance de dar erro)
        try{
            this.ataPresencaRepositorio.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não foi possível exlcuir a Ata de Presentes");
        }
    }



    // // Método para buscar colaboradores presentes em um workshop específico
    // public List<AtaPresenca> buscarPorWorkshopId(int workshopId) {
    //     return ataPresencaRepositorio.findByWorkshopId(workshopId);
    // }


}
