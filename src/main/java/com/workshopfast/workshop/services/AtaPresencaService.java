package com.workshopfast.workshop.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.repositories.AtaPresencaRepositorio;

@Service
public class AtaPresencaService {
    
    @Autowired
    private AtaPresencaRepositorio ataPresencaRepositorio;


    //--- Busca Todos os Colaboradores que estão no Workshop
    public List<AtaPresenca> todosPresentes(){
        return (List<AtaPresenca>) ataPresencaRepositorio.findAll();
    }



    //-- Busca os Colabores pelo Id que estão no Workshop
    public AtaPresenca buscaPresentes(int id){
        Optional<AtaPresenca> presentes = this.ataPresencaRepositorio.findById(id);
        if(presentes.isPresent()){
            return presentes.get();
        }else{
            throw new RuntimeException("Usuário não encontrado: " + id);
        }
    }       


    //----- CRIAR Ata de Presentes  C
    public AtaPresenca salvarAta(AtaPresenca presentes){
        presentes.setId(null);
        return ataPresencaRepositorio.save(presentes);
    }



   //-----Editar colaborador Update
    public AtaPresenca editarAta(int id, AtaPresenca ataNova){
        ataNova.setId(id);
        return ataPresencaRepositorio.save(ataNova);
    }

    //-----Excluir Ata DELETE
    public void deletarColaborador(int id){
        buscaPresentes(id);

        //--- Caso a Entidade esteja relacionado com outra entidade(Tem chance de dar erro)
        try{
            this.ataPresencaRepositorio.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não foi possível exlcuir a Ata de Presentes");
        }
    }

}
