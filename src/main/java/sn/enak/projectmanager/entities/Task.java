package sn.enak.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Task {
    @Id
    private String idTask;
    @Column(nullable = false, length = 200)
    private String taskName;
    private String taskDesc;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Statut taskStatut;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Etat taskState = Etat.CREATED;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;
    private boolean isIndependant;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime lastModified;
    @ManyToOne
    private Activity activity;
    @OneToMany
    private List<Ressource> ressources;
}
