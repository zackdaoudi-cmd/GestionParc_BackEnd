package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Reparation {


    @Id
    @GeneratedValue
    private Long idReparation;



    private String libelleReparation ;



    private String Commantaire;

    @ManyToOne
    @JoinColumn(name="idEntretien")
    private Entretien entretien;



}
