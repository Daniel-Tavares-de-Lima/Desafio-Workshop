package com.workshopfast.workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.workshopfast.workshop.DAO.ColaboradorInterface;
import com.workshopfast.workshop.models.Colaborador;
import java.util.List;


@RestController
public class ColaboradorController{
    
    @Autowired
    private ColaboradorInterface dao;

    //---ENDPOINT NESSE ENDEREÇO /COLABORADORES
    @GetMapping("/colaboradores")
    public List<Colaborador> listaColaboradores(){
        return (List<Colaborador>) dao.findAll(); //FEITO CASTTING
    }


}
