package com.demo.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "client")
public class Client extends AbstractEntity{

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Embedded //veut dire que c'est un champ composer réutilisable dans plusieurs entité
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "numtel")
    private String numTel;

    @OneToMany(mappedBy = "client") //OneToMany c'est lorsque l'on part de class ou l on se trouve vers l'autre class ici client
    private List<CommandeClient>commandeClients;
}
