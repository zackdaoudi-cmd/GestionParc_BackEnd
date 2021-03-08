package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Carburant {
    @Id
    @GeneratedValue

    private Long idCarbutant;

    @ManyToOne
    @JoinColumn(name="idChauffeur")

    private Chauffeur chauffeur;

    @ManyToOne
    @JoinColumn(name = "idFournisseur")

    private Fournisseur fournisseur;


    private LocalDateTime dateCarburant;


    private Float kilometrate ;


    private Float nbrLitreGazoil;


    private Float prixLitre;


    private String photoRecu ;
}
