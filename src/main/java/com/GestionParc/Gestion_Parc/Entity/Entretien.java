package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entretien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntretien ;
    @ManyToOne
    @JoinColumn(name="idFournisseur")
    private Fournisseur fournisseur;
    @OneToMany
    private Set<Reparation> reparation =  new HashSet<Reparation>();
    private String description;
    private LocalDateTime dateArrival ;
    private Float cost ;
    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;
}
