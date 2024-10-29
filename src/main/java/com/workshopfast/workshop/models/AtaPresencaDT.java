package com.workshopfast.workshop.models;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtaPresencaDT {
    
    @NotNull(message = "O ID do colaborador é obrigatório.")
     @JsonProperty("colaboradorId")
    private Integer colaboradorId;

    @NotNull(message = "O ID do workshop é obrigatório.")
    @JsonProperty("workshopId")
    private Integer workshopId;

    // @JsonProperty("presente")
    // private Boolean presente;

    // Getters e Setters
    public Integer getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Integer colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Integer getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Integer workshopId) {
        this.workshopId = workshopId;
    }

    // public Boolean getPresente() {
    //     return presente;
    // }

    // public void setPresente(Boolean presente) {
    //     this.presente = presente;
    // }
}
