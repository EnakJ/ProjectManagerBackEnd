package sn.enak.projectmanager.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sn.enak.projectmanager.dtos.ActivityDTO;
import sn.enak.projectmanager.dtos.ProjectDTO;
import sn.enak.projectmanager.entities.Project;
import sn.enak.projectmanager.exceptions.ActivityNotFoundException;
import sn.enak.projectmanager.exceptions.ProjectNotFoundException;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.services.ProjectServices;

import java.util.List;

@RestController
public class ActivityRestController {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;

    public ActivityRestController(ProjectServices projectServices, DtoMapper dtoMapper) {
        this.projectServices = projectServices;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/activities")
    public List<ActivityDTO> getActivities(){
        return projectServices.getAllActivity();
    }

    @GetMapping("/activities/{activityId}")
    public ActivityDTO getActivity(@PathVariable Long activityId) throws ActivityNotFoundException {
        return projectServices.getActivity(activityId);
    }

    @GetMapping("/projects/{projectId}/activities")
    public List<ActivityDTO> getProjActivities(@PathVariable String projectId) throws ProjectNotFoundException {
        ProjectDTO projectDTO = projectServices.getProject(projectId);
        return projectServices.getActivityByProject(projectDTO);
    }

}
