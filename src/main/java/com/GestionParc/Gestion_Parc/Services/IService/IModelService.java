package com.GestionParc.Gestion_Parc.Services.IService;

import com.GestionParc.Gestion_Parc.DTO.ModelDto;
import com.GestionParc.Gestion_Parc.Entity.Model;

import java.util.List;

public interface IModelService {

    ModelDto save(ModelDto modelDto);

    void deleteByIdModel(Long id);

    List<ModelDto> listModel();

    ModelDto getById(Long id);

    ModelDto update(Long id, ModelDto modelDto);

    Model findById(Long id);
}
