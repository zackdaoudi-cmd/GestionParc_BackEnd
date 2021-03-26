package com.GestionParc.Gestion_Parc.Controller;

import com.GestionParc.Gestion_Parc.DTO.DTOConverter.MarqueDtoConverter;
import com.GestionParc.Gestion_Parc.DTO.DTOConverter.ModelDtoConvert;
import com.GestionParc.Gestion_Parc.DTO.ModelDto;
import com.GestionParc.Gestion_Parc.Entity.Model;
import com.GestionParc.Gestion_Parc.Services.IService.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import java.io.IOException;

@RestController
@RequestMapping("/Model")
public class ModelController {

    @Autowired
    private IModelService modelService;
    private byte[] bytes;

    @Autowired
    private ModelDtoConvert modelDtoConvert;

    @Autowired
    private MarqueDtoConverter marqueDtoConverter;


    @PostMapping("/uploadImg")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            this.bytes = null;
        }else{
            this.bytes = file.getBytes();
        }
    }
    @PostMapping("/addModel")
    public void createNewModel(@RequestBody ModelDto modelDto) throws IOException {
        // setData  =  last methode UploadImage
        if(this.bytes != null){
            modelDto.setDataImg(this.bytes);
        }else{
            this.bytes = null ;
        }
        // then we save our Marque Object
        modelService.save(modelDto);
        //then again bytes =  null to add more pictures if we want
        this.bytes = null;
    }

    /**
     * delete by id*/
    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id){ modelService.deleteByIdModel(id);}

    /**
     * ListDes Model*/
    @GetMapping("ListDesModel")
    public List<ModelDto> modelDtoList(){return modelService.listModel();}
    /**
     * get Model by id */
    @GetMapping("modelById/{id}")
    public ModelDto modelById(@PathVariable Long id){
        return modelService.getById(id);
    }

    @PutMapping("/updateByIdd/{id}")
    public ModelDto UpdateByI(@PathVariable Long id , @RequestBody ModelDto modelDto){

        return modelService.update(id,modelDto);
    }

    @PutMapping("/updateById/{id}")
    public ModelDto UpdateById(@PathVariable Long id , @RequestBody ModelDto modelDto){
        Model model = modelService.findById(id);
        model.setMarque(marqueDtoConverter.convertToEntity(modelDto.getMarque()));
        model.setModelName(modelDto.getModelName());
        model.setTypeVehicule(modelDto.getTypeVehicule());
        if(bytes ==  null){
            model.setDataImg(null);
        }else{
            model.setDataImg(this.bytes);
        }
        modelService.save(modelDtoConvert.convertToDTO(model));
        this.bytes = null ;
        return modelDtoConvert.convertToDTO(model);
    }



}
