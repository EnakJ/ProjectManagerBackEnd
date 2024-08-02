package sn.enak.projectmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.enak.projectmanager.entities.Evenement;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, String> {

    @Query("SELECT event FROM Evenement event WHERE event.eventName LIKE:name")
    List<Evenement> searchEvenements(@Param("name") String name);
}
