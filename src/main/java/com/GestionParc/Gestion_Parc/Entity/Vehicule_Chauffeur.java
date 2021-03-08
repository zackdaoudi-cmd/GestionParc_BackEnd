package com.GestionParc.Gestion_Parc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Vehicule_Chauffeur {

    @Id
    @GeneratedValue
    private Long vehiculeChauffeur;

    @ManyToOne
    @JoinColumn(name = "idVehicule")


    private Vehicule vehicule;

    @ManyToOne
    @JoinColumn(name = "idChauffeur")
    private Chauffeur chauffeur;

    private LocalDateTime dateAffectation;
}
