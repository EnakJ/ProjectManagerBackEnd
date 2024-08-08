package sn.enak.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Categorie.Categorie;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.EtatEnum.TypeEnum;
import sn.enak.projectmanager.enums.Statut.Statut;
import sn.enak.projectmanager.security.entities.AppUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Project {
    @Id
    private String id;
    @Column(nullable = false, length = 150)
    private String intitule;
    private String description;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Statut statut;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private TypeEnum type;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Categorie categorie;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Etat etat = Etat.CREATED;
    private boolean timeConstraint;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate demarragePrevue;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deadline;
    @ManyToOne
    private AppUser owner;
    @OneToMany(mappedBy = "project")
    private List<Activity> activities;
    @OneToMany(mappedBy = "project")
    private List<Collaborateur> collaborateurs;
}
