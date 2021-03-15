package com.GestionParc.Gestion_Parc.Entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Vehicule {
    @Id
    @GeneratedValue
    private Long idVehicule;

    //Utilisateur qui vas s'authentifier
    @ManyToOne
    @JoinColumn(name="idUser")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Utilisateur utilisateur;

    //Contrat
    @OneToMany
    private Set<Contrat> contrat = new HashSet<Contrat>(  );


    //model
    @ManyToOne
    @JoinColumn(name="idModel")
    private Model model ;

    //Chauffeur
    @ManyToMany
    private Set<Chauffeur> chauffeur = new HashSet<Chauffeur>(  );

    //Entretien
    @ManyToMany

    private Set<Entretien> entretien = new HashSet<Entretien>();


    private String matricule;


    private LocalDateTime datePremierCirculation ;


    private String destination;


    private String numeroChassis ;


    private Float valeurTva ;


    private Float valeurDachat;


    private Float valeurResiduelle;


}
