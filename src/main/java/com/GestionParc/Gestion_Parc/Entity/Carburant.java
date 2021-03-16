package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarbutant;
    @ManyToOne
    @JoinColumn(name="idChauffeur")
    private Chauffeur driver;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur provider;
    private LocalDateTime dateFuel;
    private Float kilometrate ;
    private Float nbrLitreGazoil;
    private Float litrePrice;
    private String agreementPicturesCarburant ;



}

