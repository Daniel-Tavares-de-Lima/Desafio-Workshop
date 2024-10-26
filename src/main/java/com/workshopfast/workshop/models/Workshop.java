package com.workshopfast.workshop.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
public class Workshop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;


    private String descricao;


    /*---GETS */

    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }


    public Date getData(){
        return data;
    }

    public String getDescricao(){
        return descricao;
    }


    /*-------SETS */

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void SetData(Date data){
        this.data = data;
    }

    public void SetDescricao(String descricao){
        this.descricao = descricao;
    }
}
