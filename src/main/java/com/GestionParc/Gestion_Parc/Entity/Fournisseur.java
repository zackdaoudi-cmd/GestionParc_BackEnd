package com.GestionParc.Gestion_Parc.Entity;

import lombok.*;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    @OneToMany
    private Set<Carburant> carburant = new HashSet<Carburant>();
    @OneToMany
    private Set<Entretien> entretien = new HashSet<Entretien>();
    private String fullName ;
    private Boolean part_society;
}
