package sn.enak.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Evenement {
    @Id
    private String idEvent;
    @Column(nullable = false, length = 150)
    private String eventName;
    private String eventDesc;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Statut eventStatut;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Etat eventStat = Etat.TOBECOME;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate eventDate;
    private Instant eventTime;
    private Instant eventEndTime;
}
