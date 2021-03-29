package com.GestionParc.Gestion_Parc.DTO;

import com.GestionParc.Gestion_Parc.Entity.Vehicule;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class ContratDTO {

    private Long idContrat ;
    private String reference ;
    private String libelleContrat;
    private Vehicule vehicule ;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private byte [] agreementPicturesData;
    private Float cost;
    private String comment;
}
