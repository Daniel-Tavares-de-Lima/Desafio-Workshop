package com.workshopfast.workshop.controllers;

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
import javax.validation.Valid;
import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.services.AtaPresencaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/ata-de-presenca")
public class AtaPresencaController {
    
    @Autowired
    private AtaPresencaService ataPresencaService;


    //---Lista todas as atas de presença
    @GetMapping //----API OK
    public ResponseEntity<List<AtaPresenca>> listarPresencas(){
        return ResponseEntity.ok(ataPresencaService.todosPresentes());
    }

    //---Busca a ata de presença atraves do ID
    /*!-- ERROR: O METODO MAP ESTÁ INDEFINIDO NA CLASSE ATAPRESENCA */
    // @GetMapping("/{id}")
    // public ResponseEntity<AtaPresenca> listaPresencaPorId(@PathVariable int id){
    //     return ataPresencaService.buscaPresentesId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    // }


    @GetMapping("/{id}")  //-----API OK
    public ResponseEntity<AtaPresenca> buscaAtaPresencaPorId(@PathVariable int id){
        AtaPresenca presentes = this.ataPresencaService.buscaPresentesId(id);
        return ResponseEntity.ok().body(presentes);
    }


    //---Criar nova Ata de Presentes CREATE
    @PostMapping
    public ResponseEntity<AtaPresenca> criarAtaPresentes(@Valid @RequestBody AtaPresenca presentes){
    AtaPresenca novaAtaPresentes = ataPresencaService.salvarAtaPresentes(presentes);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAtaPresentes);
   }


   //---Editar ata de Presentes
   @PutMapping("/{id}")
   public ResponseEntity<AtaPresenca> editarAtaPresentes(@PathVariable int id, @RequestBody AtaPresenca ataAtualizada){
        ataAtualizada.setId(id);
        AtaPresenca atualizaAta = ataPresencaService.editarAtaPresentes(ataAtualizada);
        return ResponseEntity.ok(atualizaAta);
   }

   //----Deletar Ata de Presentes
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteAtaPresentes(@PathVariable int id){
        this.ataPresencaService.deletarAtaPresentes(id);
        return ResponseEntity.noContent().build();
   }
}
