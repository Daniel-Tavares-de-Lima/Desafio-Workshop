package com.workshopfast.workshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.services.WorkshopService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;

@RestController
//----ENDPOINT
@RequestMapping("/workshop")
public class WorkshopController {


    @Autowired
    private WorkshopService workshopService;

    //-----Busca Os Workshops READ--
     @Operation(summary = "Busca um workshop pelo ID", description = "Retorna os detalhes de um workshop específico com o ID fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna o workshop quando o ID é encontrado."),
        @ApiResponse(responseCode = "404", description = "Caso nenhum workshop for encontrado com o ID fornecido."),
        @ApiResponse(responseCode = "500", description = "Caso ocorrer um erro inesperado no servidor ao processar a solicitação.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Workshop> buscaWorkshop(@PathVariable int id){
        Workshop workshop = this.workshopService.buscaWorkshop(id);
        return ResponseEntity.ok(workshop);
    }

     //----Busca todos os Colaboradores READ
     @GetMapping()
     @Operation(summary = "Lista todos os workshops", description = "Retorna uma lista de todos os workshops.")
    public ResponseEntity<List<Workshop>> todosWorkshop(){
        List<Workshop> workshops = this.workshopService.todosWorkshop();
        return ResponseEntity.ok(workshops);
    }


    //---Criar Workshop CREATE
    @Operation(summary = "Cria um novo workshop", description = "Cria um novo workshop com os dados fornecidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Workshop criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Se a requisição estiver mal formatada ou os dados forem inválidos.")
    })
    @PostMapping
   public ResponseEntity<Workshop> criarWorkshop(@Valid @RequestBody Workshop workshop){
        Workshop novoWorkshop = workshopService.criarWorkshop(workshop);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoWorkshop);
   }


   //----EDITAR O WORKSHOP UPDATE
   @Operation(summary = "Edita um workshop existente", description = "Atualiza os dados de um workshop existente com o ID fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Workshop atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Retorna esse status se o workshop não for encontrado.")
    })
   @PutMapping("/{id}")
   public ResponseEntity<Void> editarWorkshop(@Valid @RequestBody Workshop workshop, @PathVariable int id){
        workshop.setId(id);
        this.workshopService.editarWorkshop(workshop);
        return ResponseEntity.noContent().build();
   }


   //--DELETAR WORKSHOP DELETE
   @Operation(summary = "Deleta um workshop", description = "Remove um workshop existente com o ID fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Workshop deletado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Retorna esse status se o workshop não for encontrado.")
    })
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deletarWorkshop(@PathVariable int id){
        this.workshopService.deletarWorkshop(id);
        return ResponseEntity.noContent().build();
   }
}
