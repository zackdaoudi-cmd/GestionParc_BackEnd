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
@Table
public class Entretien {

    @Id
    @GeneratedValue
    private Long idEntretien ;

    @ManyToOne
    @JoinColumn(name="idFournisseur")

    private Fournisseur fournisseur;

    @OneToMany
    @Getter
    @Setter
    private Set<Reparation> reparation =  new HashSet<Reparation>();


    private String Description;


    private LocalDateTime dateEntre ;


    private Float cout ;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;
}
