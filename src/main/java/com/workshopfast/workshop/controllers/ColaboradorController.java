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
//---------ENDPOINT
@RequestMapping("/colaboradores")
public class ColaboradorController{
    
    @Autowired
    private ColaboradorRepositorio repositorioColaborador;

    //----- CRIAR COLABORADOR  C
    @PostMapping
    public Colaborador criarColaborador(@RequestBody Colaborador colaborador){
        Colaborador colaboradorNovo = repositorioColaborador.save(colaborador);
        return colaboradorNovo;
    };


    // ----- RETORNA TODOS OS COLABORADORES  R
    @GetMapping
    public List<Colaborador> listaColaboradores(){
        return (List<Colaborador>) repositorioColaborador.findAll(); //FEITO CASTTING
    };

    //---- RETORNA DE UM COLABORADOR ESPECIFICO
    @GetMapping("/{id}")
    public Optional<Colaborador> buscaColaborador(@PathVariable int id){
        Optional<Colaborador> colaborador = repositorioColaborador.findById(id);
        return colaborador;
    }

    //---- EDITAR USUÁRIO UM COLABORADOR ESPECIFICO
    @PutMapping
    public Colaborador alterarTodosColaboradores(@RequestBody Colaborador colaborador){
        Colaborador colaboradorNovo = repositorioColaborador.save(colaborador);
        return colaboradorNovo;
    };


    // @PutMapping("/{id}")
    // public Optional<Colaborador> alteraColaborador(@PathVariable int id){
    //     Optional<Colaborador> 
    // }
    
    // ----- APAGAR COLABORADOR  D
    @DeleteMapping("/{id}")
    public Optional<Colaborador> excluirColaborador(@PathVariable Integer id){
        Optional<Colaborador> colaborador = repositorioColaborador.findById(id);
        repositorioColaborador.deleteById(id);
        return colaborador;
    };

};
