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
    @GeneratedValue
    private Long idContrat ;
    private String reference ;

    @ManyToOne
    @JoinColumn(name="idVehicule")
    private Vehicule vehicule ;

    private LocalDateTime dateDeDebut;
    private LocalDateTime dateDeFin;
    private String photoContrat;
    private Float cout;
    private String commantaire;
}
