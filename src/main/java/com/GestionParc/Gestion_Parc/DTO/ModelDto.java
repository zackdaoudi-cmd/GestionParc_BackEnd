package com.GestionParc.Gestion_Parc.DTO;

import com.GestionParc.Gestion_Parc.Entity.Marque;
import lombok.Data;


@Data
public class ModelDto {

    private Long idModel;

    private MarqueDto marque;
    private String modelName;
    private String typeVehicule;
    private byte[] dataImg ;
}