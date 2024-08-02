package sn.enak.projectmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.enak.projectmanager.enums.Disponibilite;
import sn.enak.projectmanager.enums.LocatRessource;
import sn.enak.projectmanager.enums.RessourceType;

import java.util.List;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Ressource {
    @Id
    private String id;
    @Column(nullable = false, length = 150)
    private String intitule;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private RessourceType ressourceType;
    private String url;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private LocatRessource location;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 50)
    private Disponibilite disponibilite;
    @ManyToOne
    private Task task;
}
