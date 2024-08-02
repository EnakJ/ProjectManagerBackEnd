package sn.enak.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.entities.Activity;
import sn.enak.projectmanager.entities.Project;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> getAllByProject(Project project);

    @Query("SELECT activ FROM Activity activ WHERE activ.intitule LIKE:intitule")
    List<Activity> searchActivities(@Param("intitule") String intitule);
}
