package com.GestionParc.Gestion_Parc.Services.ServiceImpl;

import com.GestionParc.Gestion_Parc.DTO.DTOConverter.MarqueDtoConverter;
import com.GestionParc.Gestion_Parc.DTO.DTOConverter.ModelDtoConvert;
import com.GestionParc.Gestion_Parc.DTO.ModelDto;
import com.GestionParc.Gestion_Parc.Entity.Model;
import com.GestionParc.Gestion_Parc.Repository.ModelRepository;
import com.GestionParc.Gestion_Parc.Services.IService.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelDtoConvert modelDtoConvert;

    @Autowired
    private MarqueDtoConverter marqueDtoConverter;

    /**
     * save new Model :*/
    @Override
    public ModelDto save(ModelDto modelDto){
        Model model = modelDtoConvert.convertToEntity(modelDto);
        model = modelRepository.save(model);
        return modelDtoConvert.convertToDTO(model);
    }

    @Override
    @Transactional
    public void deleteByIdModel(Long id){modelRepository.deleteById(id);}

    @Override
    public List<ModelDto> listModel(){
        List<Model> modelList = modelRepository.findAll();
        return modelDtoConvert.convertToListDTO(modelList);
    }

    @Override
    public ModelDto getById(Long id){
        Model model = modelRepository.findByIdModel(id);
        return modelDtoConvert.convertToDTO(model);
    }

    @Override
    public ModelDto update(Long id, ModelDto modelDto){
        Model model = modelRepository.findByIdModel(id);
        //model.setIdModel(modelDto.getIdModel( ));
        model.setMarque(marqueDtoConverter.convertToEntity(modelDto.getMarque()));
        model.setModelName(modelDto.getModelName());
        model.setTypeVehicule(modelDto.getTypeVehicule());
        model.setDataImg(modelDto.getDataImg());
        modelRepository.save(model);
        return modelDtoConvert.convertToDTO(model);
    }
    @Override
    public Model findById(Long id){
        return modelRepository.findByIdModel(id);
    }


}
