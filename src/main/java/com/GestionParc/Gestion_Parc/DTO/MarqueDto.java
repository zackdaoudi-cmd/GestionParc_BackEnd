package com.GestionParc.Gestion_Parc.DTO;

import com.GestionParc.Gestion_Parc.Entity.Marque;
import lombok.Data;

import java.util.List;

@Data
public class MarqueDto  {

    private Long idMarque;
    private String markName;
    private byte[] data;


}
