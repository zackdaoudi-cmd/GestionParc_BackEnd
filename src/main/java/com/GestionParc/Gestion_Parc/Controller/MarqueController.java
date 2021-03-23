package com.GestionParc.Gestion_Parc.Controller;

import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import com.GestionParc.Gestion_Parc.Entity.Marque;
import com.GestionParc.Gestion_Parc.Repository.MarqueRepository;
import com.GestionParc.Gestion_Parc.Services.MarqueService;
import com.GestionParc.Gestion_Parc.Services.MarqueServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("/Marque")
public class MarqueController {

    @Autowired
    private MarqueServiceImpl marqueServiceImp;
    private byte[] bytes;

    @PostMapping("/uploadImg")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

         if(file.isEmpty()){
           this.bytes = null;
       }else{
           this.bytes = file.getBytes();

       }
    }
    @PostMapping("/addMarque")
    public void createNewMark(@RequestBody MarqueDto marquedto) throws IOException {
        // setData  =  last methode UploadImage
        if(this.bytes != null){
            marquedto.setData(this.bytes);
        }else{
            this.bytes = null ;
        }

        // then we save our Marque Object
        marqueServiceImp.save(marquedto);
        //then again bytes =  null to add more pictures if we want
        this.bytes = null;
    }

    // in Update am using first methode post to send bytes pic then update it in here :D how smart am i  :D
    @PutMapping("/UpdateMarque/{id}")
    public void UpdateMark(@PathVariable("id") Long id ,@RequestBody MarqueDto marqueDto) throws IOException {
        if(marqueServiceImp.exists(id)){
            MarqueDto m = marqueServiceImp.getMarqueById(id);
            if(this.bytes !=  null){
                m.setData(this.bytes);
            }
            m.setMarkName(marqueDto.getMarkName());
            marqueServiceImp.save(m);
            this.bytes = null;

        }
    }
    // get list of marks
    @GetMapping("/listeMarque")
    public List<MarqueDto> getMarque()
    {
        return marqueServiceImp.findAll();
    }

    // get mark by id
    @GetMapping("/markById/{id}")
    public ResponseEntity<MarqueDto> getMarqueById (@PathVariable Long id){
        if(marqueServiceImp.exists(id)){
            //return marqueService.getMarqueById(id);
            return new ResponseEntity<MarqueDto>(marqueServiceImp.getMarqueById(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<MarqueDto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteMarque(@PathVariable Long id){
         marqueServiceImp.deleteMarkById(id);
    }
}
