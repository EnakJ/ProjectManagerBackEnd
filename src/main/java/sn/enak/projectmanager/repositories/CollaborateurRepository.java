package sn.enak.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.entities.Collaborateur;

import java.util.List;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, String> {
    @Query("SELECT collab FROM Collaborateur collab WHERE collab.prenom LIKE:name OR collab.nom LIKE:name")
    List<Collaborateur> searchCollaborateur(@Param("name") String name);
}
