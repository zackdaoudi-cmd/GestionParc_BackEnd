package com.GestionParc.Gestion_Parc.Services.IService;

import com.GestionParc.Gestion_Parc.DTO.ContratDTO;

import java.util.List;

public interface IContratService {

    List<ContratDTO> listContrat();


    ContratDTO save(ContratDTO contratDTO);

    void deletById(Long id);

    ContratDTO update(Long id, ContratDTO contratDTO);

    ContratDTO getContratById(Long id);
}
