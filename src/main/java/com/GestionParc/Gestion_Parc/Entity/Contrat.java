package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat ;
    private String reference ;
    private String libelleContrat;

    @ManyToOne
    @JoinColumn(name="idVehicule")
    private Vehicule vehicule ;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String agreementPictures;
    private Float cost;
    private String comment;
}
