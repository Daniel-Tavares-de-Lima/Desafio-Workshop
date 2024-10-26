package com.workshopfast.workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.repositories.WorkshopRepositorio;

import java.util.List;
import java.util.Optional;

@RestController
//----ENDPOINT
@RequestMapping("/workshop")
public class WorkshopController {
    

    @Autowired
    private WorkshopRepositorio repositorioWorkshop;

    //----- CRIAR COLABORADOR  C
    @PostMapping
    public Workshop criarWorkshop(@RequestBody Workshop workshop){
        Workshop colaboradorNovo = repositorioWorkshop.save(workshop);
        return colaboradorNovo;
    };


    // ----- RETORNA TODOS OS COLABORADORES  R
    @GetMapping
    public List<Workshop> listaWorkshop(){
        return (List<Workshop>) repositorioWorkshop.findAll(); //FEITO CASTTING
    };
    
    //---- RETORNA UM WORKSHOP ESPECIFICO
    @GetMapping("/{id}")
    public Optional<Workshop> buscaWorkshop(@PathVariable int id){
        Optional<Workshop> colaborador = repositorioWorkshop.findById(id);
        return colaborador;
    }

    //---- EDITAR USUÁRIO   U
    @PutMapping
    public Workshop alterarWorkshop(@RequestBody Workshop workshop){
        Workshop colaboradorNovo = repositorioWorkshop.save(workshop);
        return colaboradorNovo;
    };


    
    // ----- APAGAR COLABORADOR  D
    @DeleteMapping("/{id}")
    public Optional<Workshop> excluirWorkshop(@PathVariable Integer id){
        Optional<Workshop> workshop = repositorioWorkshop.findById(id);
        repositorioWorkshop.deleteById(id);
        return workshop;
    };

    
}
