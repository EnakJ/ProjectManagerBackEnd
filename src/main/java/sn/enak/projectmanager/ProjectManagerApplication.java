package sn.enak.projectmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import sn.enak.projectmanager.dtos.ActivityDTO;
import sn.enak.projectmanager.dtos.ProjectDTO;
import sn.enak.projectmanager.entities.Activity;
import sn.enak.projectmanager.entities.Project;
import sn.enak.projectmanager.entities.Task;
import sn.enak.projectmanager.enums.Categorie.Categorie;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.EtatEnum.TypeEnum;
import sn.enak.projectmanager.enums.Statut.Statut;
import sn.enak.projectmanager.mappers.DtoMapper;
import sn.enak.projectmanager.repositories.ActivityRepository;
import sn.enak.projectmanager.repositories.TaskRepository;
import sn.enak.projectmanager.services.ProjectServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication @Transactional
public class ProjectManagerApplication {
    private ProjectServices projectServices;
    private DtoMapper dtoMapper;

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

        };
    }
}
