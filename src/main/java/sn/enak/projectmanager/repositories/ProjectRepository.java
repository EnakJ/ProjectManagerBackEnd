package sn.enak.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.entities.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    @Query("SELECT proj FROM Project proj WHERE proj.intitule LIKE:intitule")
    List<Project> searchProject(@Param("intitule") String intitule);
}
