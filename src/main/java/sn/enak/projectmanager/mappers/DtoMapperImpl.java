package sn.enak.projectmanager.mappers;


import org.springframework.stereotype.Service;
import sn.enak.projectmanager.dtos.*;
import sn.enak.projectmanager.entities.*;
import sn.enak.projectmanager.security.entities.AppRole;
import sn.enak.projectmanager.security.entities.AppUser;
import sn.enak.projectmanager.security.repo.AppRoleRepository;
import sn.enak.projectmanager.security.repo.AppUserRepository;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class DtoMapperImpl implements DtoMapper {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    public DtoMapperImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public ProjectDTO fromProject(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();

        copyProperties(project, projectDTO);

        return projectDTO;
    }

    @Override
    public Project fromProjectDTO(ProjectDTO projectDTO) {
        Project project = new Project();

        copyProperties(projectDTO, project);

        return project;
    }

    @Override
    public ActivityDTO fromActivity(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();

        copyProperties(activity, activityDTO);

        return activityDTO;
    }

    @Override
    public Activity fromActivityDTO(ActivityDTO activityDTO) {
        Activity activity = new Activity();

        copyProperties(activityDTO, activity);

        return activity;
    }

    @Override
    public TaskDTO fromTask(Task task) {
        TaskDTO taskDTO = new TaskDTO();

        copyProperties(task, taskDTO);

        return taskDTO;
    }

    @Override
    public Task fromTaskDTO(TaskDTO taskDTO) {
        Task task = new Task();

        copyProperties(taskDTO, task);

        return task;
    }

    @Override
    public EvenementDTO fromEvenement(Evenement evenement) {
        EvenementDTO evenementDTO = new EvenementDTO();

        copyProperties(evenement, evenementDTO);

        return evenementDTO;
    }

    @Override
    public Evenement fromEvenementDTO(EvenementDTO evenementDTO) {
        Evenement evenement = new Evenement();

        copyProperties(evenementDTO, evenement);

        return evenement;
    }

    @Override
    public CollaborateurDTO fromCollaborateur(Collaborateur collaborateur) {
        CollaborateurDTO collaborateurDTO = new CollaborateurDTO();

        copyProperties(collaborateur, collaborateurDTO);

        return collaborateurDTO;
    }

    @Override
    public Collaborateur fromCollaborateurDTO(CollaborateurDTO collaborateurDTO) {
        Collaborateur collaborateur = new Collaborateur();

        copyProperties(collaborateurDTO, collaborateur);


        return collaborateur;
    }

    @Override
    public RessourceDTO fromResource(Ressource ressource) {
        RessourceDTO ressourceDTO = new RessourceDTO();

        copyProperties(ressource, ressourceDTO);

        return ressourceDTO;
    }

    @Override
    public Ressource fromRessourceDTO(RessourceDTO ressourceDTO) {
        Ressource ressource = new Ressource();

        copyProperties(ressourceDTO, ressource);

        return ressource;
    }

    @Override
    public AppUserDTO fromAppUser(AppUser appUser) {
        AppUserDTO appUserDTO = new AppUserDTO();
        copyProperties(appUser, appUserDTO);

        return appUserDTO;
    }

    @Override
    public AppUser fromAppUserDTO(AppUserDTO appUserDTO) {
        AppUser appUser = new AppUser();
        copyProperties(appUserDTO, appUser);

        return appUser;
    }

    @Override
    public AppRoleDTO fromAppRole(AppRole appRole) {
        AppRoleDTO appRoleDTO = new AppRoleDTO();
        copyProperties(appRole, appRoleDTO);

        return appRoleDTO;
    }

    @Override
    public AppRole fromAppRoleDTO(AppRoleDTO appRoleDTO) {
        AppRole appRole = new AppRole();
        copyProperties(appRoleDTO, appRole);

        return appRole;
    }
}
