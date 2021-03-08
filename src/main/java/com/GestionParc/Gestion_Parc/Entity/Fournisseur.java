package com.GestionParc.Gestion_Parc.Entity;

import lombok.*;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Fournisseur {
    @Id
    @GeneratedValue

    private Long idFournisseur;

    @OneToMany

    private Set<Carburant> carburant = new HashSet<Carburant>();

    @OneToMany

    private Set<Entretien> entretien = new HashSet<Entretien>();




    private String libelleFournisseur ;


    private Boolean part_society;
}
