package com.workshopfast.workshop.controllers;

/*----------Imports-------------- */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.services.AtaPresencaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
//---Define o ENDPOINT para este controlador
@RequestMapping("/ata-de-presenca")
public class AtaPresencaController {
    
    @Autowired
    private AtaPresencaService ataPresencaService;

    //---Lista todas as atas de presença
    @GetMapping
    @Operation(description = "Lista todas as atas de presença")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Atas de presença listadas com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno ao listar as atas de presença")
    })
    //----ENDPOINT TESTADO OK
    public ResponseEntity<List<AtaPresenca>> listarPresencas(){
        return ResponseEntity.ok(ataPresencaService.todosPresentes());
    }

    
    //-----Lista por Id
    @GetMapping("/{id}")
    @Operation(description = "Busca uma ata de presença pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description =  "Ata de presença encontrada"),
        @ApiResponse(responseCode = "404", description = "Ata de presença não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno ao buscar a ata de presença")
    }) //-----ENDPOINT TESTADO OK
    public ResponseEntity<AtaPresenca> buscaAtaPresencaPorId(@PathVariable int id){
        AtaPresenca presentes = this.ataPresencaService.buscaPresentesId(id);
        return ResponseEntity.ok().body(presentes);
    }


   //----Deletar Ata de Presentes
    @DeleteMapping("/{id}")
    @Operation(description = "Deleta uma ata de presença pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Ata de presença deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ata de presença não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno ao deletar a ata de presença")
    })//---ENDPOINT TESTADO OK
   public ResponseEntity<Void> deleteAtaPresentes(@PathVariable int id){
        this.ataPresencaService.deletarAtaPresentes(id);
        return ResponseEntity.noContent().build();
   }


}
