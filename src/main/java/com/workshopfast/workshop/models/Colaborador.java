package com.workshopfast.workshop.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "colaborador")


public class Colaborador {
    
    @Id //---ESPECIFICAR QUE É PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //---AUTO INCREMENT
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100, nullable = true) // -- 100 Caracteres, NotNull
    private String nome;

    /*------GETS */
    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }


    /*------SETS */
    public void setId(Integer id){
        this.id  = id;
    }


    public void setNome(String nome){
        this.nome = nome;
    }
}
