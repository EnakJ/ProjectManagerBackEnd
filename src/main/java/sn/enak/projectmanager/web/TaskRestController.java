package sn.enak.projectmanager.web;

import org.springframework.web.bind.annotation.*;
import sn.enak.projectmanager.dtos.ActivityDTO;
import sn.enak.projectmanager.dtos.ProjectDTO;
import sn.enak.projectmanager.dtos.TaskDTO;
import sn.enak.projectmanager.exceptions.ActivityNotFoundException;
import sn.enak.projectmanager.exceptions.ProjectNotFoundException;
import sn.enak.projectmanager.exceptions.TaskNotFoundException;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.services.ProjectServices;

import java.util.List;

@RestController
public class TaskRestController {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;

    public TaskRestController(ProjectServices projectServices, DtoMapper dtoMapper) {
        this.projectServices = projectServices;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/tasks")
    public List<TaskDTO> getTasks(){
        return projectServices.getAllTask();
    }

    @GetMapping("/tasks/{taskId}")
    public TaskDTO getTask(@PathVariable String taskId) throws TaskNotFoundException {
        return projectServices.getTaskById(taskId);
    }

    @GetMapping("/activities/{activityId}/tasks")
    public List<TaskDTO> getActivityTasks(@PathVariable Long activityId) throws ActivityNotFoundException {
        ActivityDTO activityDTO = projectServices.getActivity(activityId);
        return projectServices.getTasksByActivity(activityDTO);
    }

    @GetMapping("/projects/{projectId}/tasks")
    public List<TaskDTO> getProjectTasks(@PathVariable String projectId) throws ProjectNotFoundException {
        ProjectDTO projectDTO = projectServices.getProject(projectId);

        return projectServices.getTasksByProject(projectDTO);
    }

    @PostMapping("/tasks")
    public TaskDTO newTask(@RequestBody TaskDTO taskDTO){
        return projectServices.addTask(dtoMapper.fromTaskDTO(taskDTO));
    }


}
