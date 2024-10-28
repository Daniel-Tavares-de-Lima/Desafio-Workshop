package com.workshopfast.workshop.models;

/*-------Imports--------- */
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
    @Column(name = "id", nullable = true) // ---- NotNull
    private Integer id;

    @Column(name = "nome", nullable = true)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "dataRealizacao", nullable = true)
    private Date dataRealizacao;

    @Column(name = "descricao")
    private String descricao;


    public Workshop(){

    }

    public Workshop(String nome, Date dataRealizacao, String descricao){
        this.nome = nome;
        this.dataRealizacao = dataRealizacao;
        this.descricao = descricao;
    }
    /*---GETS */

    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }


    public Date getDataRealizacao(){
        return dataRealizacao;
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

    public void SetDataRealizacao(Date dataRealizacao){
        this.dataRealizacao = dataRealizacao;
    }

    public void SetDescricao(String descricao){
        this.descricao = descricao;
    }
}
