package com.GestionParc.Gestion_Parc.Entity;

import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Chauffeur {

    @Id
    @GeneratedValue

    private Long idChauffeur;

    @OneToMany

    private Set<Carburant> carburants = new HashSet<Carburant>();

    private  String cin ;
    private String nomComplet ;
    private LocalDateTime dateNaissance;

    @ManyToMany
    private Set<Vehicule> contrat = new HashSet<Vehicule>(  );
}
