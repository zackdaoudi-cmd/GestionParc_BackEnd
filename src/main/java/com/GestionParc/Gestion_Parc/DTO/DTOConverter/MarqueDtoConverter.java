package com.GestionParc.Gestion_Parc.DTO.DTOConverter;

import com.GestionParc.Gestion_Parc.DTO.Mapping.BaseDtoConvert.BaseDTOConverter;
import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import com.GestionParc.Gestion_Parc.Entity.Marque;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarqueDtoConverter extends BaseDTOConverter<MarqueDto, Marque> {

    /**
     * convert Entity To Dto
     * */
    @Override
    public MarqueDto convertToDTO(Marque marque) {
        MarqueDto marqueDto =  new MarqueDto();
        marqueDto.setIdMarque(marque.getIdMarque());
        marqueDto.setMarkName(marque.getMarkName());
        marqueDto.setData(marque.getData());

        return marqueDto;
    }
    /**
     * Convert Dto To Entity
     * */
    @Override
   public Marque convertToEntity(MarqueDto marqueDto) {
        Marque marque = new Marque( );

        marque.setIdMarque(marqueDto.getIdMarque());
        marque.setMarkName(marqueDto.getMarkName());
        marque.setData(marqueDto.getData());

        return marque;
    }

    /**
     * Convert List To List DTO
     *
     * **/
    @Override
    public List<MarqueDto> convertToListDTO(List<Marque> marqueList) {
        List<MarqueDto> marqueDtoList = new ArrayList<>();
        for(Marque marque : marqueList){
            marqueDtoList.add(convertToDTO(marque));
        }
        return marqueDtoList;
    }


    /**
     * pour convertir que deux column j'ai besoin*/
    public List<MarqueDto> convertToSimpleListDTO(List<Marque> marqueList){
        List<MarqueDto> marqueDtoList = new ArrayList<>();
        for(Marque marque : marqueList){
            MarqueDto marqueDto = new MarqueDto();
            marqueDto.setIdMarque(marque.getIdMarque());
            marqueDto.setMarkName(marque.getMarkName());
            marqueDtoList.add(marqueDto);
        }
        return marqueDtoList;
    }

}
