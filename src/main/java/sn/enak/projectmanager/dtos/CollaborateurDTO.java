package sn.enak.projectmanager.dtos;


import lombok.Data;

@Data
public class CollaborateurDTO {
    private String id;
    private String prenom;
    private String nom;
    private String jobTitle;
    private String description;
    private String telephone;
    private String email;
    private String adresse;
}
