package sn.enak.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.entities.Activity;
import sn.enak.projectmanager.entities.Project;
import sn.enak.projectmanager.entities.Ressource;
import sn.enak.projectmanager.entities.Task;

import java.util.List;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, String> {

    @Query("SELECT resource FROM Ressource resource WHERE resource.intitule LIKE:name")
    List<Ressource> searchRessources(@Param("name") String intitule);
    List<Ressource> getAllByTaskActivityProject(Project project);
    List<Ressource> getAllByTaskActivity(Activity activity);
    List<Ressource> getAllByTask(Task task);
}