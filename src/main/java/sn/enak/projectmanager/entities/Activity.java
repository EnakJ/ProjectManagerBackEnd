package sn.enak.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Activity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String intitule;
    private String description;
    @Column(nullable = false)
    private String goal;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Statut statut;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Etat state = Etat.CREATED;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate deadline;
    @ManyToOne
    private Project project;
    @OneToMany(mappedBy = "activity")
    private List<Task> tasks;
    @OneToMany(mappedBy = "activity")
    private List<Collaborateur> collaborateurs;
}
