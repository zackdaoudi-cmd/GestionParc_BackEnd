package com.GestionParc.Gestion_Parc.DTO.DTOConverter;

import com.GestionParc.Gestion_Parc.DTO.Mapping.BaseDtoConvert.BaseDTOConverter;
import com.GestionParc.Gestion_Parc.DTO.ModelDto;
import com.GestionParc.Gestion_Parc.Entity.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelDtoConvert extends BaseDTOConverter<ModelDto, Model> {

    @Autowired
    private MarqueDtoConverter marqueDtoConverter;

    @Override
    public ModelDto convertToDTO(Model model) {
        ModelDto modelDto = new ModelDto();
        modelDto.setIdModel(model.getIdModel());
        modelDto.setMarque(marqueDtoConverter.convertToDTO(model.getMarque()));
        modelDto.setModelName(model.getModelName());
        modelDto.setTypeVehicule(model.getTypeVehicule());
        modelDto.setDataImg(model.getDataImg());
        return modelDto;
    }

    @Override
    public Model convertToEntity(ModelDto modelDto) {
        Model model = new Model();
        model.setIdModel(modelDto.getIdModel());
        model.setMarque(marqueDtoConverter.convertToEntity(modelDto.getMarque()));
        model.setModelName(modelDto.getModelName());
        model.setTypeVehicule(modelDto.getTypeVehicule());
        model.setDataImg(modelDto.getDataImg());

        return model ;
    }

    @Override
    public List<ModelDto> convertToListDTO(List<Model> listModel) {
        List<ModelDto> modelDtoList = new ArrayList<>(  );
        for(Model model : listModel){
            modelDtoList.add(convertToDTO(model));
        }
        return modelDtoList;
    }
}
