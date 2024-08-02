package sn.enak.projectmanager.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.util.Date;

@Data
public class ActivityDTO {
    private Long idActivity;
    private String activityIntitule;
    private String activityDesc;
    private String goal;
    private Statut activityStatut;
    private Etat activityState = Etat.CREATED;
    private Date deadline;
}
