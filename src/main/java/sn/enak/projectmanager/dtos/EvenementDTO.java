package sn.enak.projectmanager.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.time.Instant;
import java.util.Date;

@Data
public class EvenementDTO {
    private String idEvent;
    private String eventName;
    private String eventDesc;
    private Statut eventStatut;
    private Etat eventStat = Etat.TOBECOME;
    private Date eventDate;
    private Instant eventTime;
    private Instant eventEndTime;
}
