package com.workshopfast.workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.services.ColaboradorService;

import java.util.List;



@RestController
//---------ENDPOINT
@RequestMapping("/colaboradores")
public class ColaboradorController{
    
    // @Autowired
    // private ColaboradorRepositorio repositorioColaborador;

    // //----- CRIAR COLABORADOR  C
    // @PostMapping
    // public Colaborador criarColaborador(@RequestBody Colaborador colaborador){
    //     Colaborador colaboradorNovo = repositorioColaborador.save(colaborador);
    //     return colaboradorNovo;
    // };


    // ----- RETORNA TODOS OS COLABORADORES  R
    @GetMapping
    public List<Colaborador> listaColaboradores(){
        return colaboradorService.todosColaboradores(); //FEITO CASTTING
    };

    // //---- RETORNA DE UM COLABORADOR ESPECIFICO
    // @GetMapping("/{id}")
    // public Optional<Colaborador> buscaColaborador(@PathVariable int id){
    //     Optional<Colaborador> colaborador = repositorioColaborador.findById(id);
    //     return colaborador;
    // }

    // //---- EDITAR USUÁRIO UM COLABORADOR ESPECIFICO
    // @PutMapping
    // public Colaborador alterarTodosColaboradores(@RequestBody Colaborador colaborador){
    //     Colaborador colaboradorNovo = repositorioColaborador.save(colaborador);
    //     return colaboradorNovo;
    // };


    // // @PutMapping("/{id}")
    // // public Optional<Colaborador> alteraColaborador(@PathVariable int id){
    // //     Optional<Colaborador> 
    // // }
    
    // // ----- APAGAR COLABORADOR  D
    // @DeleteMapping("/{id}")
    // public Optional<Colaborador> excluirColaborador(@PathVariable Integer id){
    //     Optional<Colaborador> colaborador = repositorioColaborador.findById(id);
    //     repositorioColaborador.deleteById(id);
    //     return colaborador;
    // };


    @Autowired
    private ColaboradorService colaboradorService;

    //-- localhost:8080/colaboradores/id
    @GetMapping("/{id}") 
    public ResponseEntity<Colaborador> buscaColaborador(@PathVariable int id){
        Colaborador colaborador = this.colaboradorService.buscaColaborador(id);
        return ResponseEntity.ok().body(colaborador);
    }

    //----Criar Colaborador CREATE
    @PostMapping
   public ResponseEntity<Colaborador> criarColaborador(@Valid @RequestBody Colaborador colaborador){
    Colaborador novoColaborador = colaboradorService.criarColaborador(colaborador);
    return ResponseEntity.status(HttpStatus.CREATED).body(novoColaborador);
   }


   //-----Editar Colaborador
//    @PutMapping
//    public ResponseEntity<Colaborador> editarColaborador(@Valid @RequestBody Colaborador colaborador){
//         try{
//             Colaborador colaboradorAtualizado = colaboradorService.editarColaborador(colaborador);
//             return ResponseEntity.ok(colaboradorAtualizado);
//         } catch(RuntimeException e){
//             return ResponseEntity.notFound().build();
//         }
//    }

   //----Editar Colaborador UPDATE
   @PutMapping("/{id}")
   public ResponseEntity<Void> update(@Valid Colaborador colaborador, @PathVariable int id){
        colaborador.setId(id);
        this.colaboradorService.editarColaborador(colaborador);
        return ResponseEntity.noContent().build();
   }

   //---Deletar colaborador DELETE
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable int id){
        this.colaboradorService.deletarColaborador(id);
        return ResponseEntity.noContent().build();
   }
   
};
