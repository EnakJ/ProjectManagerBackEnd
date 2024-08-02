package sn.enak.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.entities.Activity;
import sn.enak.projectmanager.entities.Project;
import sn.enak.projectmanager.entities.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    List<Task> getAllByActivity(Activity activity);
    List<Task> getAllByActivityProject(Project project);
}
