package com.workshopfast.workshop.models;

/*-------Imports------ */
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
    
    //---Coluna Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    //-----Coluna ColaboradorID
    @ManyToOne
    @JoinColumn(name = "colaborador_id", nullable = false)//---nome Da Coluna, NotNull = False
    private Colaborador colaborador;

    //----Coluna WorkshopId
    @ManyToOne
    @JoinColumn(name = "workshop_id", nullable = false) //---nome Da Coluna, NotNull = False
    private Workshop workshop;

    //-----Coluna esta Presente
    @Column(name = "presente", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
    private Boolean presente;

    

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
