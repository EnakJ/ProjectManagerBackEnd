package sn.enak.projectmanager.mappers;

import sn.enak.projectmanager.dtos.*;
import sn.enak.projectmanager.entities.*;
import sn.enak.projectmanager.security.entities.AppRole;
import sn.enak.projectmanager.security.entities.AppUser;

public interface DtoMapper {
    ProjectDTO fromProject(Project project);
    Project fromProjectDTO(ProjectDTO projectDTO);
    ActivityDTO fromActivity(Activity activity);
    Activity fromActivityDTO(ActivityDTO activityDTO);
    TaskDTO fromTask(Task task);
    Task fromTaskDTO(TaskDTO taskDTO);
    EvenementDTO fromEvenement(Evenement evenement);
    Evenement fromEvenementDTO(EvenementDTO evenementDTO);
    CollaborateurDTO fromCollaborateur(Collaborateur collaborateur);
    Collaborateur fromCollaborateurDTO(CollaborateurDTO collaborateurDTO);
    RessourceDTO fromResource(Ressource ressource);
    Ressource fromRessourceDTO(RessourceDTO ressourceDTO);
    AppUserDTO fromAppUser(AppUser appUser);
    AppUser fromAppUserDTO(AppUserDTO appUserDTO);
    AppRoleDTO fromAppRole(AppRole appRole);
    AppRole fromAppRoleDTO(AppRoleDTO appRoleDTO);
}
