package com.GestionParc.Gestion_Parc.Services;

import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import java.util.List;

public interface  MarqueService  {

    // add new marque
    MarqueDto save(MarqueDto marque);

    List<MarqueDto> findAll();

    // delete by id
    void deleteMarkById(Long id);

    MarqueDto getMarqueById(Long id);

    //check if marue exisste
    Boolean exists(Long id);
}
