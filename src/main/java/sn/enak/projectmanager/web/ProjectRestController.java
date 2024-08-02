package sn.enak.projectmanager.web;

import org.springframework.web.bind.annotation.*;
import sn.enak.projectmanager.dtos.ProjectDTO;
import sn.enak.projectmanager.entities.Project;
import sn.enak.projectmanager.exceptions.ProjectNotFoundException;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.services.ProjectServices;

import java.util.List;

@RestController
public class ProjectRestController {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;

    public ProjectRestController(ProjectServices projectServices, DtoMapper dtoMapper) {
        this.projectServices = projectServices;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getProjects(){
        return projectServices.getAllProject();
    }

    @GetMapping("/projects/{projectId}")
    public ProjectDTO getProject(@PathVariable String projectId) throws ProjectNotFoundException {
        return projectServices.getProject(projectId);
    }

    @PostMapping("/projects")
    public ProjectDTO newProject(@RequestBody ProjectDTO projectDTO){
        Project project = dtoMapper.fromProjectDTO(projectDTO);
        return projectServices.addProject(project);
    }
}
