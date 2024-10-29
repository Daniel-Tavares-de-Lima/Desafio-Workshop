package com.workshopfast.workshop.services;

/*---------IMPORTS----------- */
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshopfast.workshop.models.AtaPresenca;
import com.workshopfast.workshop.models.Colaborador;
import com.workshopfast.workshop.models.Workshop;
import com.workshopfast.workshop.repositories.AtaPresencaRepositorio;
import com.workshopfast.workshop.repositories.ColaboradorRepositorio;
import com.workshopfast.workshop.repositories.WorkshopRepositorio;
import com.workshopfast.workshop.models.AtaPresencaDT;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class AtaPresencaService {
    
    @Autowired
    private AtaPresencaRepositorio ataPresencaRepositorio;

    @Autowired 
    private ColaboradorRepositorio colaboradorRepositorio;

    @Autowired
    private WorkshopRepositorio workshopRepositorio;

    //--- Busca Todos os Colaboradores que estão no Workshop
    public List<AtaPresenca> todosPresentes(){
        return (List<AtaPresenca>) ataPresencaRepositorio.findAll();
    }



    //-- Busca os Colabores pelo Id que estão no Workshop
    public AtaPresenca buscaPresentesId(int id){
        Optional<AtaPresenca> presentes = this.ataPresencaRepositorio.findById(id);
        if(presentes.isPresent()){
            return presentes.get();
        }else{
            throw new RuntimeException("Ata de Presença não encontrado: " + id);
        }
    }       

    
    //----METODO CRIAR ATA COM PROBLEMAS (EXPLICAÇÃO NA DOCUMENTAÇÃO FORNECIDA NO REPOSITORIO NO GITHUB EM PDF)
    public AtaPresenca criarAta(AtaPresencaDT dto) {
        // Verifica se os IDs de colaborador e workshop foram fornecidos
        if (dto.getColaboradorId() == null || dto.getWorkshopId() == null) {
            throw new IllegalArgumentException("IDs de colaborador e workshop são obrigatórios e não podem ser nulos");
        }

        // Busca o colaborador pelo ID; lança exceção se não encontrado
        Colaborador colaborador = colaboradorRepositorio.findById(dto.getColaboradorId()).orElseThrow(() -> new IllegalArgumentException("Colaborador com ID " + dto.getColaboradorId() + " não encontrado"));

        // Busca o workshop pelo ID; lança exceção se não encontrado
        Workshop workshop = workshopRepositorio.findById(dto.getWorkshopId()).orElseThrow(() -> new IllegalArgumentException("Workshop com ID " + dto.getWorkshopId() + " não encontrado"));

        // Verifica se o campo 'presente' é fornecido; caso contrário, atribui um valor padrão (como 'false')
        // Boolean presente = dto.getPresente() != null ? dto.getPresente() : false;

        // Cria uma nova instância de AtaPresenca e define os campos
        AtaPresenca ataPresenca = new AtaPresenca();
        ataPresenca.setColaboradores(Set.of(colaborador));
        ataPresenca.setWorkshops(Set.of(workshop));
        // ataPresenca.setPresente(presente);

        // Salva e retorna a nova ata de presença
        return ataPresencaRepositorio.save(ataPresenca);
    }
      
      
    public AtaPresenca salvarAtaPresenca(AtaPresenca presenca){
        return ataPresencaRepositorio.save(presenca);
    }

    //----Editar Ata de Presença Update
    public AtaPresenca editarAtaPresentes(AtaPresenca presentes){
        AtaPresenca novaAta = buscaPresentesId(presentes.getId());
        // novaAta.setNome(novaAta.getNome());
        return this.ataPresencaRepositorio.save(novaAta);
    }


    //-----Excluir Ata DELETE
    public void deletarAtaPresentes(int id){
        // Busca a ata de presença pelo ID para garantir que ela existe
        buscaPresentesId(id);

        //--- Caso a Entidade esteja relacionado com outra entidade(Tem chance de dar erro)
        try{
            this.ataPresencaRepositorio.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Não foi possível exlcuir a Ata de Presentes");
        }
    }


}
