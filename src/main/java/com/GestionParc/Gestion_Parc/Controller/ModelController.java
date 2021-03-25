package com.GestionParc.Gestion_Parc.Controller;

import com.GestionParc.Gestion_Parc.DTO.ModelDto;
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

}
