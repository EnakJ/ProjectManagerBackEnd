package sn.enak.projectmanager.services;

import org.springframework.data.domain.Page;
import sn.enak.projectmanager.dtos.*;
import sn.enak.projectmanager.entities.*;
import sn.enak.projectmanager.exceptions.*;
import sn.enak.projectmanager.security.entities.AppRole;
import sn.enak.projectmanager.security.entities.AppUser;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface ProjectServices {
    ProjectDTO addProject(ProjectDTO projectDTO);
    ProjectDTO getProject(String projectId) throws ProjectNotFoundException;
    List<ProjectDTO> getAllProject();
    List<ProjectDTO> searchProjects(String intitule);
    ActivityDTO addActivity(Activity activity);
    List<ActivityDTO> getAllActivity();
    ActivityDTO getActivity(Long activityId) throws ActivityNotFoundException;
    List<ActivityDTO> getActivityByProject(ProjectDTO projectDTO);
    List<ActivityDTO> searchActivities(String intitule);
    TaskDTO addTask(Task task);
    TaskDTO getTaskById(String taskId) throws TaskNotFoundException;
    List<TaskDTO> getAllTask();
    List<TaskDTO> getTasksByActivity(ActivityDTO activityDTO);
    List<TaskDTO> getTasksByProject(ProjectDTO projectDTO);
    List<TaskDTO> getTasksDay(LocalDate localDate);
    List<TaskDTO> getTasksWeek(Instant weekBegin, Instant weekEnd);
    CollaborateurDTO addCollaborateur(Collaborateur collaborateur);
    CollaborateurDTO getCollaborateur(String collaborateurId) throws CollaborateurNotFoundException;
    List<CollaborateurDTO> getAllCollaborateurs();
    List<CollaborateurDTO> getCollaborateursByProject(ProjectDTO projectDTO);
    List<CollaborateurDTO> getCollaborateursByActivity(ActivityDTO activityDTO);
    List<CollaborateurDTO> searchCollaborateurs(String name);
    EvenementDTO addEvenement(Evenement evenement);
    EvenementDTO getEvenement(String eventId) throws EvenementNotFoundException;
    List<EvenementDTO> searchEvenements(String eventName);
    List<EvenementDTO> getAllEvenements();
    List<EvenementDTO> getEvenementsOfWeek(Instant weekBegin, Instant weekEnd);
    RessourceDTO addRessource(Ressource ressource);
    RessourceDTO getRessource(String ressourceId) throws RessourceNotFoundException;
    List<RessourceDTO> searchRessource(String intitule);
    List<RessourceDTO> getAllRessources();
    List<RessourceDTO> getRessourceByProject(ProjectDTO projectDTO);
    List<RessourceDTO> getRessourceByActivity(ActivityDTO activityDTO);
    List<RessourceDTO> getRessourceByTask(TaskDTO taskDTO);
    AppUserDTO addAppUser(AppUserDTO appUserDTO);
    AppRoleDTO addAppROle(AppRoleDTO appRoleDTO);
    void addRoleToUser(String username, String roleName) throws AppUserNotFoundException, AppRoleNotFoundException;
    AppUser getAppUserByUsername(String username) throws AppUserNotFoundException;
    AppRole getAppRoleByRoleName(String roleName) throws AppRoleNotFoundException;
    Page<Task> getTasksPage(int page, int size);
}
