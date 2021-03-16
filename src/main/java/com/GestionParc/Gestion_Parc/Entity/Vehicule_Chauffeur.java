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
public class Vehicule_Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculeChauffeur;
    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;
    @ManyToOne
    @JoinColumn(name = "idChauffeur")
    private Chauffeur chauffeur;
    //Date D'affectation de la vehicule au chauffeur !
    private LocalDateTime assignmentDate;
}
