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

public class Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChauffeur;
    @OneToMany
    private Set<Carburant> carburants = new HashSet<Carburant>();
    private  String identityNumber ;
    private String fullName ;
    private LocalDateTime birthDate;
    @ManyToMany
    private Set<Vehicule> vehicules = new HashSet<Vehicule>(  );
}
