package sn.enak.projectmanager.web;

import org.springframework.web.bind.annotation.*;
import sn.enak.projectmanager.dtos.EvenementDTO;
import sn.enak.projectmanager.exceptions.EvenementNotFoundException;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.services.ProjectServices;

import java.util.List;

@RestController
public class EventRestController {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;

    public EventRestController(ProjectServices projectServices, DtoMapper dtoMapper) {
        this.projectServices = projectServices;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/evenements")
    public List<EvenementDTO> getEvenements(){
        return projectServices.getAllEvenements();
    }

    @GetMapping("/evenements/{evenementId}")
    public EvenementDTO getEvenement(@PathVariable String evenementId) throws EvenementNotFoundException {
        return projectServices.getEvenement(evenementId);
    }

    @PostMapping("/evenements")
    public EvenementDTO newEvenement(@RequestBody EvenementDTO evenementDTO){
        return projectServices.addEvenement(dtoMapper.fromEvenementDTO(evenementDTO));
    }
}
