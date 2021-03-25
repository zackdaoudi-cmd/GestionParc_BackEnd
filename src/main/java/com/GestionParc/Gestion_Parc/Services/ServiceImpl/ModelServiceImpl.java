package com.GestionParc.Gestion_Parc.Services.ServiceImpl;

import com.GestionParc.Gestion_Parc.DTO.DTOConverter.ModelDtoConvert;
import com.GestionParc.Gestion_Parc.DTO.ModelDto;
import com.GestionParc.Gestion_Parc.Entity.Model;
import com.GestionParc.Gestion_Parc.Repository.ModelRepository;
import com.GestionParc.Gestion_Parc.Services.IService.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelDtoConvert modelDtoConvert;

    /**
     * save new Model :*/
    @Override
    public ModelDto save(ModelDto modelDto){
        Model model = modelDtoConvert.convertToEntity(modelDto);
        model = modelRepository.save(model);
        return modelDtoConvert.convertToDTO(model);
    }

    @Override
    public void deleteByIdModel(Long id){modelRepository.deleteById(id);}

    @Override
    public List<ModelDto> listModel(){
        List<Model> modelList = modelRepository.findAll();
        return modelDtoConvert.convertToListDTO(modelList);
    }


}
