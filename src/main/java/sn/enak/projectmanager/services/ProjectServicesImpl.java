package sn.enak.projectmanager.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.enak.projectmanager.dtos.*;
import sn.enak.projectmanager.entities.*;
import sn.enak.projectmanager.exceptions.*;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.repositories.*;
import sn.enak.projectmanager.security.entities.AppRole;
import sn.enak.projectmanager.security.entities.AppUser;
import sn.enak.projectmanager.security.repo.AppRoleRepository;
import sn.enak.projectmanager.security.repo.AppUserRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service @Transactional
public class ProjectServicesImpl implements ProjectServices {
    private DtoMapper dtoMapper;
    private ProjectRepository projectRepository;
    private ActivityRepository activityRepository;
    private TaskRepository taskRepository;
    private EvenementRepository evenementRepository;
    private CollaborateurRepository collaborateurRepository;
    private RessourceRepository ressourceRepository;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    public ProjectServicesImpl(
            DtoMapper dtoMapper,
            ProjectRepository projectRepository,
            ActivityRepository activityRepository,
            TaskRepository taskRepository,
            EvenementRepository evenementRepository,
            CollaborateurRepository collaborateurRepository,
            RessourceRepository ressourceRepository,
            AppUserRepository appUserRepository,
            AppRoleRepository appRoleRepository
            ) {
        this.dtoMapper = dtoMapper;
        this.projectRepository = projectRepository;
        this.activityRepository = activityRepository;
        this.taskRepository = taskRepository;
        this.evenementRepository = evenementRepository;
        this.collaborateurRepository = collaborateurRepository;
        this.ressourceRepository = ressourceRepository;
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }


    @Override
    public ProjectDTO addProject(ProjectDTO projectSTO) {

        Project save = projectRepository.save(dtoMapper.fromProjectDTO(projectSTO));
        return dtoMapper.fromProject(save);
    }

    @Override
    public ProjectDTO getProject(String projectId) throws ProjectNotFoundException {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project == null) throw new ProjectNotFoundException("Project with id : "+projectId+" is not found !");

        return dtoMapper.fromProject(project);
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        return projectRepository.findAll().stream().map(project -> dtoMapper.fromProject(project)).toList();
    }

    @Override
    public List<ProjectDTO> searchProjects(String intitule) {
        return projectRepository.searchProject("%"+intitule+"%")
                .stream().map(project ->
                        dtoMapper.fromProject(project)).toList();
    }

    @Override
    public ActivityDTO addActivity(Activity activity) {
        Activity savedActivity = activityRepository.save(activity);

        return dtoMapper.fromActivity(savedActivity);
    }

    @Override
    public List<ActivityDTO> getAllActivity() {
        return activityRepository.findAll()
                .stream().map(activity ->
                        dtoMapper.fromActivity(activity)).toList();
    }

    @Override
    public ActivityDTO getActivity(Long activityId) throws ActivityNotFoundException {
        Activity activity = activityRepository.findById(activityId).orElse(null);
        if (activity == null) throw new ActivityNotFoundException("Activity with id : "+activityId+" not fount");

        return dtoMapper.fromActivity(activity);
    }

    @Override
    public List<ActivityDTO> getActivityByProject(ProjectDTO projectDTO) {
        Project project = dtoMapper.fromProjectDTO(projectDTO);
        return activityRepository.getAllByProject(project)
                .stream().map(activity ->
                        dtoMapper.fromActivity(activity)).toList();
    }

    @Override
    public List<ActivityDTO> searchActivities(String intitule) {
        return activityRepository.searchActivities("%"+intitule+"%")
                .stream().map(activity ->
                        dtoMapper.fromActivity(activity)).toList();
    }

    @Override
    public TaskDTO addTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return dtoMapper.fromTask(savedTask);
    }

    @Override
    public TaskDTO getTaskById(String taskId) throws TaskNotFoundException {
        Task task = taskRepository.findById(taskId).orElse(null);

        if (task == null) throw new TaskNotFoundException("Task with id : "+taskId+" is not found !");

        return dtoMapper.fromTask(task);
    }

    @Override
    public List<TaskDTO> getAllTask() {
        return taskRepository.findAll()
                .stream().map(task ->
                        dtoMapper.fromTask(task)).toList();
    }

    @Override
    public List<TaskDTO> getTasksByActivity(ActivityDTO activityDTO) {
        Activity activity = dtoMapper.fromActivityDTO(activityDTO);

        return taskRepository.getAllByActivity(activity)
                .stream().map(task -> dtoMapper.fromTask(task)).toList();
    }

    @Override
    public List<TaskDTO> getTasksByProject(ProjectDTO projectDTO) {
        Project project = dtoMapper.fromProjectDTO(projectDTO);

        return taskRepository.getAllByActivityProject(project)
                .stream().map(task -> dtoMapper.fromTask(task)).toList();
    }

    @Override
    public List<TaskDTO> getTasksDay(LocalDate localDate) {
        return null;
    }

    @Override
    public List<TaskDTO> getTasksWeek(Instant weekBegin, Instant weekEnd) {
        return null;
    }

    @Override
    public CollaborateurDTO addCollaborateur(Collaborateur collaborateur) {
        Collaborateur save = collaborateurRepository.save(collaborateur);

        return dtoMapper.fromCollaborateur(save);
    }

    @Override
    public CollaborateurDTO getCollaborateur(String collaborateurId) throws CollaborateurNotFoundException {
        Collaborateur collaborateur = collaborateurRepository.findById(collaborateurId).orElse(null);

        if (collaborateur == null) throw new CollaborateurNotFoundException("Collaborateur with id : "+collaborateurId+" is not found !");

        return dtoMapper.fromCollaborateur(collaborateur);
    }

    @Override
    public List<CollaborateurDTO> getAllCollaborateurs() {

        return collaborateurRepository.findAll().stream().map(collaborateur ->
                dtoMapper.fromCollaborateur(collaborateur)).toList();
    }

    @Override
    public List<CollaborateurDTO> getCollaborateursByProject(ProjectDTO projectDTO) {

        return null;
    }

    @Override
    public List<CollaborateurDTO> getCollaborateursByActivity(ActivityDTO activityDTO) {
        return null;
    }

    @Override
    public List<CollaborateurDTO> searchCollaborateurs(String name) {

        return collaborateurRepository.searchCollaborateur("%"+name+"%").stream().map(
                collaborateur -> dtoMapper.fromCollaborateur(collaborateur)
        ).toList();
    }

    @Override
    public EvenementDTO addEvenement(Evenement evenement) {
        Evenement save = evenementRepository.save(evenement);

        return dtoMapper.fromEvenement(save);
    }

    @Override
    public EvenementDTO getEvenement(String eventId) throws EvenementNotFoundException {
        Evenement evenement = evenementRepository.findById(eventId).orElse(null);

        if (evenement == null) throw new EvenementNotFoundException("Evenement with id : "+eventId+" is not found !");

        return dtoMapper.fromEvenement(evenement);
    }

    @Override
    public List<EvenementDTO> searchEvenements(String eventName) {

        return evenementRepository.searchEvenements("%"+eventName+"%").stream().map(
                event -> dtoMapper.fromEvenement(event)).toList();
    }

    @Override
    public List<EvenementDTO> getAllEvenements() {

        return evenementRepository.findAll().stream().map(
                evenement -> dtoMapper.fromEvenement(evenement)
        ).toList();
    }

    @Override
    public List<EvenementDTO> getEvenementsOfWeek(Instant weekBegin, Instant weekEnd) {
        return null;
    }

    @Override
    public RessourceDTO addRessource(Ressource ressource) {
        Ressource save = ressourceRepository.save(ressource);

        return dtoMapper.fromResource(save);
    }

    @Override
    public RessourceDTO getRessource(String ressourceId) throws RessourceNotFoundException {
        Ressource ressource = ressourceRepository.findById(ressourceId).orElse(null);
        if (ressource == null) throw new RessourceNotFoundException("Ressource with id : "+ressourceId+" is not found !");

        return dtoMapper.fromResource(ressource);
    }

    @Override
    public List<RessourceDTO> searchRessource(String intitule) {

        return ressourceRepository.searchRessources("%"+intitule+"%")
                .stream().map(resource -> dtoMapper.fromResource(resource))
                .toList();
    }

    @Override
    public List<RessourceDTO> getAllRessources() {

        return ressourceRepository.findAll().stream().map(
                resource -> dtoMapper.fromResource(resource))
                .toList();
    }

    @Override
    public List<RessourceDTO> getRessourceByProject(ProjectDTO projectDTO) {
        Project project = dtoMapper.fromProjectDTO(projectDTO);

        return ressourceRepository.getAllByTaskActivityProject(project)
                .stream().map(
                        ressource -> dtoMapper.fromResource(ressource)
                ).toList();
    }

    @Override
    public List<RessourceDTO> getRessourceByActivity(ActivityDTO activityDTO) {
        Activity activity = dtoMapper.fromActivityDTO(activityDTO);

        return ressourceRepository.getAllByTaskActivity(activity)
                .stream().map(ressource -> dtoMapper.fromResource(ressource)).toList();
    }

    @Override
    public List<RessourceDTO> getRessourceByTask(TaskDTO taskDTO) {
        Task task = dtoMapper.fromTaskDTO(taskDTO);

        return ressourceRepository.getAllByTask(task).stream().map(
                ressource -> dtoMapper.fromResource(ressource)).toList();
    }

    @Override
    public AppUserDTO addAppUser(AppUserDTO appUserDTO) {
        AppUser appUser = dtoMapper.fromAppUserDTO(appUserDTO);

        AppUser savedAppUser = appUserRepository.save(appUser);
        return dtoMapper.fromAppUser(savedAppUser);
    }

    @Override
    public AppRoleDTO addAppROle(AppRoleDTO appRoleDTO) {
        AppRole appRole = dtoMapper.fromAppRoleDTO(appRoleDTO);

        AppRole savedAppRole = appRoleRepository.save(appRole);
        return dtoMapper.fromAppRole(savedAppRole);
    }

    @Override
    public void addRoleToUser(String  username, String roleName) throws AppUserNotFoundException, AppRoleNotFoundException {
        AppUser appUser = this.getAppUserByUsername(username);
        AppRole appRole = this.getAppRoleByRoleName(roleName);

        List<AppRole> roles = appUser.getRoles();
        roles.add(appRole);
        appUser.setRoles(roles);
    }

    @Override
    public AppUser getAppUserByUsername(String username) throws AppUserNotFoundException {
        AppUser appUser = appUserRepository.getAppUserByUsername(username).orElse(null);
        if (appUser == null) throw new AppUserNotFoundException("AppUser with username : "+username+" not found !");

        return appUser;
    }

    @Override
    public AppRole getAppRoleByRoleName(String roleName) throws AppRoleNotFoundException {
        AppRole appRole = appRoleRepository.getAppRoleByRoleName(roleName).orElse(null);
        if (appRole == null) throw new AppRoleNotFoundException("AppRole with roleName : "+roleName+" not found !");

        return appRole;
    }

    @Override
    public Page<Task> getTasksPage(int page, int size) {
        return taskRepository.getTasksPerPage(PageRequest.of(page, size));
    }

}
