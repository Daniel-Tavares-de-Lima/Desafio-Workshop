package com.workshopfast.workshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ata_de_presenca")
public class AtaPresenca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @ManyToOne
    private Workshop workshop;

    @ManyToOne
    private Colaborador colaborador;


    private Boolean presente;

    public AtaPresenca(Colaborador colaborador, Workshop workshop, Boolean presente){
        this.workshop = workshop;
        this.colaborador = colaborador;
        this.presente = presente;
    }


    /*----GETS */
    public Integer getId() {
        return this.id;
    }

    public Colaborador getColaborador() {
        return this.colaborador;
    }

    public Workshop getWorkshop() {
        return this.workshop;
    }


    public Boolean getPresente() {
        return this.presente;
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
