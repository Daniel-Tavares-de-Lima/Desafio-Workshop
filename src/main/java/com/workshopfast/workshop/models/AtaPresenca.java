package com.workshopfast.workshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ata_de_presenca")
public class AtaPresenca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "id_colaborador", nullable = true) //---nome Da Coluna, NotNull = False
    private Colaborador colaborador;

    @JoinColumn(name = "id_workshop", nullable = true) //---nome Da Coluna, NotNull = False
    @ManyToOne
    private Workshop workshop;

    @Column(nullable = true)
    private Boolean presente;

    //---Construtor Padrão para evitar o erro:"No default constructor for entity 'com.workshopfast.workshop.models.AtaPresenca'"
    public AtaPresenca(){

    }
    public AtaPresenca(Colaborador colaborador, Workshop workshop, Boolean presente){
        this.workshop = workshop;
        this.colaborador = colaborador;
        this.presente = presente;
    }


    /*----GETS */
    public Integer getId() {
        return id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public Workshop getWorkshop() {
        return workshop;
    }


    public Boolean getPresente() {
        return presente;
    }


    /*----SETS */
    public void setId(Integer id) {
        this.id = id;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }


}
