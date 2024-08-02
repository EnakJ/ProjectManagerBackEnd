package sn.enak.projectmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Collaborateur {
    @Id
    private String id;
    @Column(nullable = false, length = 150)
    private String prenom;
    @Column(nullable = false, length = 100)
    private String nom;
    @Column(length = 150)
    private String jobTitle;
    private String description;
    @Column(length = 20)
    private String telephone;
    @Column(length = 150)
    private String email;
    @Column(length = 150)
    private String adresse;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Activity activity;
}
