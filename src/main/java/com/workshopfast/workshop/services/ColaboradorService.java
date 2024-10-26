package com.workshopfast.workshop.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.repositories.ColaboradorRepositorio;


@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepositorio repositorioColaborador;


    //----Construtor
    public ColaboradorService(ColaboradorRepositorio repositorioColaborador){
        this.repositorioColaborador = repositorioColaborador;
    }


    //--- Busca Todos os Colaboradores
    public  List<Colaborador> todosColaboradores(){
        return (List<Colaborador>) repositorioColaborador.findAll();
    }


    //-- Busca os Colabores pelo Id
    public Colaborador buscaColaborador(int id){
        Optional<Colaborador> colaborador = this.repositorioColaborador.findById(id);
        if(colaborador.isPresent()){
            return colaborador.get();
        }else{
            throw new RuntimeException("Usuário não encontrado: " + id);
        }
    }

    //----- CRIAR COLABORADOR  C
    public Colaborador criarColaborador(Colaborador colaborador){
        colaborador.setId(null);
        return repositorioColaborador.save(colaborador);
    }

    ///-----Editar colaborador Update
    public Colaborador editarColaborador(Colaborador colaborador){
        Colaborador novoColaborador = buscaColaborador(colaborador.getId());
        novoColaborador.setNome(novoColaborador.getNome());
        return this.repositorioColaborador.save(novoColaborador);
    }

   
    //----- Excluir o Colaborador - DELETE
    public void deletarColaborador(int id){
        buscaColaborador(id);

        //--- Caso a Entidade esteja relacionado com outra entidade(Tem chance de dar erro)
        try{
            this.repositorioColaborador.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não foi possível exlcuir o colaborador");
        }
    }



    // // ----- APAGAR COLABORADOR  D
    // @DeleteMapping("/{id}")
    // public Optional<Colaborador> excluirColaborador(@PathVariable Integer id){
    //     Optional<Colaborador> colaborador = repositorioColaborador.findById(id);
    //     repositorioColaborador.deleteById(id);
    //     return colaborador;
    // };
}
