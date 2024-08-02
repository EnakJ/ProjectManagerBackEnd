package sn.enak.projectmanager.dtos;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import sn.enak.projectmanager.enums.Etat.Etat;
import sn.enak.projectmanager.enums.Statut.Statut;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TaskDTO {
    private String idTask;
    private String taskName;
    private String taskDesc;
    private Statut taskStatut;
    private Etat taskState = Etat.CREATED;
    private LocalDateTime createdAt;
    private boolean isIndependant;
    private LocalDateTime lastModified;
}
