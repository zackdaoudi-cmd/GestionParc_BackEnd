package com.GestionParc.Gestion_Parc.Services.IService;

import com.GestionParc.Gestion_Parc.DTO.ModelDto;

import java.util.List;

public interface IModelService {

    ModelDto save(ModelDto modelDto);

    void deleteByIdModel(Long id);

    List<ModelDto> listModel();
}
