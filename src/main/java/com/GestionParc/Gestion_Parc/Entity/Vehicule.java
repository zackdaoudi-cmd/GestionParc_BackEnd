package com.GestionParc.Gestion_Parc.Entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String registrationNumber;
    private LocalDateTime dateFirstCirculation ;
    private String destination;
    private String numberChassis ;
    private Float tvaValue ;
    // valeur d'achat
    private Float purchasValue;
    //valeur Residuelle
    private Float residualValue;


}
