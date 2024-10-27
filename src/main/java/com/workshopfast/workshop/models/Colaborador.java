package com.workshopfast.workshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "colaborador")


public class Colaborador {
    
    public interface AtualizaColaborador{}
    
    @Id //---ESPECIFICAR QUE É PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //---AUTO INCREMENT
    @Column(name = "id", unique = true, nullable = true) // ---- Unico, NotNull
    private Integer id;


    @Column(name = "nome", length = 100, nullable = true) // -- 100 Caracteres, NotNull
    @NotNull
    @NotEmpty
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
