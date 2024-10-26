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

import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.repositories.ColaboradorRepositorio;

import java.util.List;
import java.util.Optional;


@RestController
//ENDPOINT
@RequestMapping("/colaboradores")
public class ColaboradorController{
    
    @Autowired
    private ColaboradorRepositorio repositorio;

    //----- CRIAR COLABORADOR  C
    @PostMapping
    public Colaborador criarColaborador(@RequestBody Colaborador colaborador){
        Colaborador colaboradorNovo = repositorio.save(colaborador);
        return colaboradorNovo;
    };


    // ----- RETORNA TODOS OS COLABORADORES  R
    @GetMapping
    public List<Colaborador> listaColaboradores(){
        return (List<Colaborador>) repositorio.findAll(); //FEITO CASTTING
    };

    
    // @GetMapping("/{id}")
    // public Optional<Colaborador> buscaColaborador(@PathVariable int id){
    //     Optional<Colaborador> colaborador = repositorio.findById(id);
    //     return colaborador;
    // }

    //---- EDITAR USUÁRIO   U
    @PutMapping
    public Colaborador alterarColaborador(@RequestBody Colaborador colaborador){
        Colaborador colaboradorNovo = repositorio.save(colaborador);
        return colaboradorNovo;
    };


    
    // ----- APAGAR COLABORADOR  D
    @DeleteMapping("/{id}")
    public Optional<Colaborador> excluirColaborador(@PathVariable Integer id){
        Optional<Colaborador> colaborador = repositorio.findById(id);
        repositorio.deleteById(id);
        return colaborador;
    };

};
