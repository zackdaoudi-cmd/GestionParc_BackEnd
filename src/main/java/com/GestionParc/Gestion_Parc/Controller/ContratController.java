package com.GestionParc.Gestion_Parc.Controller;

import com.GestionParc.Gestion_Parc.DTO.ContratDTO;
import com.GestionParc.Gestion_Parc.Services.IService.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Contrats")
public class ContratController {

    @Autowired
    private IContratService contratService;

    private byte[] bytes  ;

    @GetMapping(path = "ListDesContrats")
    List<ContratDTO> listContrats(){
        return contratService.listContrat();
    }


    @PostMapping("/addImg")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            this.bytes = null;
        }else{
            this.bytes = file.getBytes();
        }
    }

    @PostMapping("/addNewContract")
    public void addNewContract(@RequestBody ContratDTO contratDTO) {
        if(this.bytes != null){
            contratDTO.setAgreementPicturesData(this.bytes);
        }else{
            this.bytes = null ;
        }
        this.bytes = null;
        contratService.save(contratDTO);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){ contratService.deletById(id);}
}
