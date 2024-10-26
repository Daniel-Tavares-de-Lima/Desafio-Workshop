package com.workshopfast.workshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "workshop")
public class Workshop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = true) // ---- Unico, NotNull
    private Integer id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = true)
    private Date data;

    @Column(name = "descricao")
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
