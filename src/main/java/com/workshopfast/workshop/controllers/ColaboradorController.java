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
    
    @Autowired
    private ColaboradorService colaboradorService;

    // ----- RETORNA TODOS OS COLABORADORES  R
    @GetMapping
    public List<Colaborador> listaColaboradores(){
        return colaboradorService.todosColaboradores(); //FEITO CASTTING
    };


    //-- localhost:8080/colaboradores/id
    //-- Busca os Colaboradores
    @GetMapping("/{id}") 
    public ResponseEntity<Colaborador> buscaColaborador(@PathVariable int id){
        Colaborador colaborador = this.colaboradorService.buscaColaborador(id);
        return ResponseEntity.ok().body(colaborador);
    }


    //----Busca todos os Colaboradores READ
    @GetMapping("/colaboradores/{id}")
    public ResponseEntity<List<Colaborador>> todosColaboradores(){
        List<Colaborador> colaboradores = this.colaboradorService.todosColaboradores();
        return ResponseEntity.ok(colaboradores);
    }
    

    //----Criar Colaborador CREATE
    @PostMapping
   public ResponseEntity<Colaborador> criarColaborador(@Valid @RequestBody Colaborador colaborador){
    Colaborador novoColaborador = colaboradorService.criarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoColaborador);
   }


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
