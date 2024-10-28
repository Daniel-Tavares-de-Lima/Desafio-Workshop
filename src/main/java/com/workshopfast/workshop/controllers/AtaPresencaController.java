package com.workshopfast.workshop.controllers;


/*----------Imports-------------- */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.models.AtaPresencaDT;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.repositories.AtaPresencaRepositorio;
import com.workshopfast.workshop.services.AtaPresencaService;
import com.workshopfast.workshop.services.ColaboradorService;
import com.workshopfast.workshop.services.WorkshopService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import java.util.Optional;



@RestController
//---Define o ENDPOINT para este controlador
@RequestMapping("/ata-de-presenca")
public class AtaPresencaController {
    
    @Autowired
    private AtaPresencaService ataPresencaService;

    @Autowired
    private AtaPresencaRepositorio ataPresencaRepositorio;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired 
    private WorkshopService workshopService;

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


    //----METODO CRIAR ATA COM PROBLEMAS (EXPLICAÇÃO NA DOCUMENTAÇÃO FORNECIDA NO REPOSITORIO NO GITHUB EM PDF)
    // @PostMapping
    // public ResponseEntity<AtaPresenca> salvar(@RequestBody @Valid AtaPresencaDT ataDePresenca) {
    //     // Valida e cria a ata de presença com a lógica de verificações
    //     AtaPresenca ataCriada = ataPresencaService.criarAta(ataDePresenca);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(ataCriada);
    // }



  // Método PUT para atualizar uma Ata de Presença existente
   @PutMapping("/{id}")
        public ResponseEntity<AtaPresenca> atualizarAta(@PathVariable Integer id, @RequestBody AtaPresencaDT ataPresencaDT) {
        // Busca a ata existente pelo ID
        Optional<AtaPresenca> existiAta = ataPresencaRepositorio.findById(id);

        // Verifica se a ata existe
        if (existiAta.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AtaPresenca ataPresenca = existiAta.get();

        // Atualiza o status de presença se fornecido
        if (ataPresencaDT.getPresente() != null) {
            ataPresenca.setPresente(ataPresencaDT.getPresente());
        } else {
            return ResponseEntity.badRequest().body(null); // Retorna erro caso `presente` esteja nulo
    }

        // Atualiza o colaborador e workshop se os IDs estiverem presentes
        if (ataPresencaDT.getColaboradorId() != null) {
            Colaborador colaborador = colaboradorService.buscaColaborador(ataPresencaDT.getColaboradorId());
            if (colaborador != null) {
                ataPresenca.setColaborador(colaborador);
            }
        }
    
        if (ataPresencaDT.getWorkshopId() != null) {
            Workshop workshop = workshopService.buscaWorkshop(ataPresencaDT.getWorkshopId());
            if (workshop != null) {
                ataPresenca.setWorkshop(workshop);
            }
        }

        // Salva as alterações no banco de dados
        AtaPresenca updatedAta = ataPresencaRepositorio.save(ataPresenca);
        return ResponseEntity.ok(updatedAta);
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
