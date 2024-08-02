package sn.enak.projectmanager.dtos;

import lombok.Data;

import sn.enak.projectmanager.enums.Disponibilite;
import sn.enak.projectmanager.enums.LocatRessource;
import sn.enak.projectmanager.enums.RessourceType;


@Data
public class RessourceDTO {

    private String id;
    private String intitule;
    private RessourceType ressourceType;
    private String url;
    private LocatRessource location;
    private Disponibilite disponibilite;
}
