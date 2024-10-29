// package com.workshopfast.workshop.models;

// import java.util.Set;

// /*-------Imports------ */
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "ata_de_presenca")
// public class AtaPresenca {
    
//     //---Coluna Id
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY) 
//     private Integer id;

//     //-----Coluna ColaboradorID
//     // @ManyToMany
//     // @JoinColumn(name = "colaborador_id", nullable = false)//---nome Da Coluna, NotNull = False
//     // private Colaborador colaborador;
//     @ManyToMany 
//     @JoinTable( name = "colaborador_ata_presenca", joinColumns = @JoinColumn(name = "ata_presenca_id"), inverseJoinColumns = @JoinColumn(name = "colaborador_id") ) 
//     private Set<Colaborador> colaboradores;
//     //----Coluna WorkshopId
//     // @ManyToMany
//     // @JoinColumn(name = "workshop_id", nullable = false) //---nome Da Coluna, NotNull = False
//     // private Workshop workshop;
//     @ManyToMany 
//     @JoinTable( name = "workshop_ata_presenca", joinColumns = @JoinColumn(name = "ata_presenca_id"), inverseJoinColumns = @JoinColumn(name = "workshop_id") ) 
//     private Set<Workshop> workshops;

//     //-----Coluna esta Presente
//     // @Column(name = "presente", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
//     // private Boolean presente;


//     public Integer getId() {
//         return this.id;
//     }

//     public void setId(Integer id) {
//         this.id = id;
//     }

//     public Set<Colaborador> getColaboradores() {
//         return this.colaboradores;
//     }

//     public void setColaboradores(Set<Colaborador> colaboradores) {
//         this.colaboradores = colaboradores;
//     }

//     public Set<Workshop> getWorkshops() {
//         return this.workshops;
//     }

//     public void setWorkshops(Set<Workshop> workshops) {
//         this.workshops = workshops;
//     }

//     // public Boolean isPresente() {
//     //     return this.presente;
//     // }

//     // public Boolean getPresente() {
//     //     return this.presente;
//     // }

//     // public void setPresente(Boolean presente) {
//     //     this.presente = presente;
//     // }
    

    


// }


package com.workshopfast.workshop.models;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ata_de_presenca")
public class AtaPresenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "colaborador_ata_presenca", 
        joinColumns = @JoinColumn(name = "ata_presenca_id"), 
        inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private Set<Colaborador> colaboradores;

    @ManyToMany
    @JoinTable(
        name = "workshop_ata_presenca",
        joinColumns = @JoinColumn(name = "ata_presenca_id"),
        inverseJoinColumns = @JoinColumn(name = "workshop_id")
    )
    private Set<Workshop> workshops;

    @Column(name = "presente", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
    private Boolean presente;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Set<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Set<Workshop> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Set<Workshop> workshops) {
        this.workshops = workshops;
    }

    // public Boolean getPresente() {
    //     return presente;
    // }

    // public void setPresente(Boolean presente) {
    //     this.presente = presente;
    // }
}
