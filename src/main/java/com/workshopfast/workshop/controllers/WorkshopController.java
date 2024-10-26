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




import javax.validation.Valid;

@RestController
//----ENDPOINT
@RequestMapping("/workshop")
public class WorkshopController {


    @Autowired
    private WorkshopService workshopService;

    //-----Busca Os Workshops READ--
    @GetMapping("/{id}")
    public ResponseEntity<Workshop> buscaWorkshop(@PathVariable int id){
        Workshop workshop = this.workshopService.buscaWorkshop(id);
        return ResponseEntity.ok(workshop);
    }

     //----Busca todos os Colaboradores READ
     @GetMapping()
    public ResponseEntity<List<Workshop>> todosWorkshop(){
        List<Workshop> workshops = this.workshopService.todosWorkshop();
        return ResponseEntity.ok(workshops);
    }


    //---Criar Workshop CREATE
    @PostMapping
   public ResponseEntity<Workshop> criarWorkshop(@Valid @RequestBody Workshop workshop){
        Workshop novoWorkshop = workshopService.criarWorkshop(workshop);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoWorkshop);
   }


   //----EDITAR O WORKSHOP UPDATE
   @PutMapping("/{id}")
   public ResponseEntity<Void> editarWorkshop(@Valid @RequestBody Workshop workshop, @PathVariable int id){
        workshop.setId(id);
        this.workshopService.editarWorkshop(workshop);
        return ResponseEntity.noContent().build();
   }


   //--DELETAR WORKSHOP DELETE
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deletarWorkshop(@PathVariable int id){
        this.workshopService.deletarWorkshop(id);
        return ResponseEntity.noContent().build();
   }
}
