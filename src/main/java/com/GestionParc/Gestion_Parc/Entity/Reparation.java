package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reparation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReparation;
    private String labelSupplier ;
    private String comments;

    @ManyToOne
    @JoinColumn(name="idEntretien")
    private Entretien entretien;



}
