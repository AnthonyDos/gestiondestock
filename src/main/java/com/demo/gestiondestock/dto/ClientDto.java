package com.demo.gestiondestock.dto;

import com.demo.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String email;

    private String numTel;

    private List<CommandeClientDto> commandeClients;
}
