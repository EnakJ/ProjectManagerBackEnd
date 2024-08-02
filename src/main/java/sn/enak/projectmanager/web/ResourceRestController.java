package sn.enak.projectmanager.web;

import org.springframework.web.bind.annotation.*;
import sn.enak.projectmanager.dtos.RessourceDTO;
import sn.enak.projectmanager.exceptions.RessourceNotFoundException;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.services.ProjectServices;

import java.util.List;

@RestController
public class ResourceRestController {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;

    public ResourceRestController(ProjectServices projectServices, DtoMapper dtoMapper) {
        this.projectServices = projectServices;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/ressources")
    public List<RessourceDTO> getResources(){
        return projectServices.getAllRessources();
    }

    @GetMapping("/ressources/{resourceId}")
    public RessourceDTO getRessource(@PathVariable String resourceId) throws RessourceNotFoundException {

        return projectServices.getRessource(resourceId);
    }

    @PostMapping("/ressources")
    public RessourceDTO newRessource(@RequestBody RessourceDTO ressourceDTO){

        return projectServices.addRessource(dtoMapper.fromRessourceDTO(ressourceDTO));
    }
}
