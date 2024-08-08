package sn.enak.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import sn.enak.projectmanager.dtos.ActivityDTO;
import sn.enak.projectmanager.dtos.AppRoleDTO;
import sn.enak.projectmanager.dtos.AppUserDTO;
import sn.enak.projectmanager.entities.Project;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.repositories.ActivityRepository;
import sn.enak.projectmanager.repositories.ProjectRepository;
import sn.enak.projectmanager.repositories.TaskRepository;
import sn.enak.projectmanager.security.entities.AppRole;
import sn.enak.projectmanager.security.entities.AppUser;
import sn.enak.projectmanager.services.ProjectServices;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication @Transactional
public class ProjectManagerApplication {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectManagerApplication(ProjectServices projectServices, DtoMapper dtoMapper) {
        this.projectServices = projectServices;
        this.dtoMapper = dtoMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args -> {
            AppUser appUser = projectServices.getAppUserByUsername("Enak Junior");
            projectServices.getAllProject().stream().map(projectDTO -> {
               Project project = dtoMapper.fromProjectDTO(projectDTO);
               project.setOwner(appUser);
               projectRepository.save(project);
               return null;
            });
        };
    }
}
