package com.workshopfast.workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.models.Colaborador.AtualizaColaborador;
import com.workshopfast.workshop.services.ColaboradorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;



@RestController
//---------ENDPOINT
@RequestMapping("/colaboradores")
public class ColaboradorController{
    

    @Autowired
    private ColaboradorService colaboradorService;

    // ----- RETORNA TODOS OS COLABORADORES  R
    @Operation(summary = "Lista todos os colaboradores", description = "Retorna uma lista de todos os colaboradores.")
    @GetMapping
    public List<Colaborador> listaColaboradores(){ //----API TESTADA E FUNCIONANDO
        return colaboradorService.todosColaboradores(); //FEITO CASTTING
    };


    //-- localhost:8080/colaboradores/id
    @Operation(description = "O endpoint busca um colaborador específico pelo ID fornecido na URL e retorna os detalhes desse colaborador como resposta, ou gera um erro se não for encontrado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna um objeto Colaborador quando o colaborador com o ID especificado é encontrado."),
        @ApiResponse(responseCode = "404", description = "Retorna esse status se não for encontrado um colaborador com o ID fornecido."),
        @ApiResponse(responseCode = "500", description = " Retorna esse status se ocorrer um erro inesperado no servidor ao processar a solicitação.")
    })
    //-- Busca os Colaboradores
    @GetMapping("/{id}") //---ENDPOINT TESTADA E FUNCIONANDO
    public ResponseEntity<Colaborador> buscaColaborador(@PathVariable int id){
        Colaborador colaborador = this.colaboradorService.buscaColaborador(id);
        return ResponseEntity.ok().body(colaborador);
    }


    //----Busca todos os Colaboradores READ
    @GetMapping("/colaboradores/{id}")
    public ResponseEntity<List<Colaborador>> todosColaboradores(){
        List<Colaborador> colaboradores = this.colaboradorService.todosColaboradores();
        return ResponseEntity.ok(colaboradores);
    }
    

    //----Criar Colaborador CREATE

    @Operation(summary = "Cria um novo colaborador", description = "Cria um novo colaborador com os dados fornecidos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Colaborador criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Se a requisição estiver mal formatada ou os dados forem inválidos.")
    })
    @PostMapping //--ENDPOINT TESTADA E FUNCIONANDO
   public ResponseEntity<Colaborador> criarColaborador(@Valid @RequestBody Colaborador colaborador){
    Colaborador novoColaborador = colaboradorService.criarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoColaborador);
   }


   //----Editar Colaborador UPDATE
   @Operation(summary = "Edita um colaborador existente", description = "Atualiza os dados de um colaborador existente com o ID fornecido.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Colaborador atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Retorna esse status se o colaborador não for encontrado.")
    })
    @PutMapping("/{id}") //---ENDPOINT TESTADO E FUNCIONANDO
    @Validated(AtualizaColaborador.class)
    public ResponseEntity<Void> atualizaColaborador(@Valid @RequestBody Colaborador colaborador, @PathVariable int id){
        colaborador.setId(id);
        colaborador = this.colaboradorService.editarColaborador(colaborador);
        return ResponseEntity.noContent().build();
    }


   //---Deletar colaborador DELETE
   @Operation(summary = "Deleta um colaborador", description = "Remove um colaborador existente com o ID fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Colaborador deletado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Retorna esse status se o colaborador não for encontrado.")
    })
   @DeleteMapping("/{id}") //----ENDPOINT TESTADO E FUNCIONANDO
   public ResponseEntity<Void> delete(@PathVariable int id){
        this.colaboradorService.deletarColaborador(id);
        return ResponseEntity.noContent().build();
   }
   
};
