package com.workshopfast.workshop.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.repositories.AtaPresencaRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AtaPresencaService {
    
    @Autowired
    private AtaPresencaRepositorio ataPresencaRepositorio;


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


    //----- CRIAR Ata de Presentes  C
    public AtaPresenca salvarAtaPresentes(AtaPresenca presentes){
        presentes.setId(null);
        return ataPresencaRepositorio.save(presentes);
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

}