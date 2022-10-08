package com.demo.gestiondestock.dto;

import lombok.Builder;
import lombok.Data;
import javax.persistence.Embedded;
import java.util.List;

//le dto est l'objet final renvoyer au front
@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurs;
}
