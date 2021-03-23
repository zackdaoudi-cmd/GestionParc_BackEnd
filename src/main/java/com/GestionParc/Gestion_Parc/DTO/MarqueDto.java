package com.GestionParc.Gestion_Parc.DTO;

import com.GestionParc.Gestion_Parc.Entity.Marque;
import lombok.Data;

@Data
public class MarqueDto {

    private Long idMarque;
    private String markName;
    private byte[] data;


    //convert entity to dto
   static public MarqueDto ConvertMarqueToDto(Marque marque){

        MarqueDto marqueDto =  new MarqueDto();
        marqueDto.setIdMarque(marque.getIdMarque());
        marqueDto.setMarkName(marque.getMarkName());
        marqueDto.setData(marque.getData());

        return marqueDto;
    }
        // convert dto to entity
   static public Marque ConvertDtoToMarque (MarqueDto marqueDto){
        Marque marque = new Marque( );

        marque.setIdMarque(marqueDto.getIdMarque());
        marque.setMarkName(marqueDto.getMarkName());
        marque.setData(marqueDto.getData());

        return marque;
    }

}
