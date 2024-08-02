package sn.enak.projectmanager.dtos;

import lombok.Data;
import sn.enak.projectmanager.enums.Categorie.Categorie;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.EtatEnum.TypeEnum;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ProjectDTO {
    private String id;
    private String intitule;
    private String description;
    private Statut statut;
    private TypeEnum type;
    private Categorie categorie;
    private Etat etat = Etat.CREATED;
    private boolean timeConstraint;
    private LocalDateTime createdAt;
    private LocalDate demarragePrevue;
    private Date deadline;
}
