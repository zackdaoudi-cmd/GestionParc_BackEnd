package com.GestionParc.Gestion_Parc.Controller;

import com.GestionParc.Gestion_Parc.Entity.Marque;
import com.GestionParc.Gestion_Parc.Repository.MarqueRepository;
import com.GestionParc.Gestion_Parc.Services.MarqueService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("/Marque")
public class MarqueController {


    @Autowired
    private MarqueService marqueService ;

    @Autowired
    private MarqueRepository marqueRepository ;



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
    public void createNewMark(@RequestBody Marque marque) throws IOException {
        // setData  =  last methode UploadImage
        marque.setData(this.bytes);

        // then we save our Marque Object
        marqueService.save(marque);
        //then again bytes =  null to add more pictures if we want
        this.bytes = null;
    }


    // in Update am using first methode post to send bytes pic then update it in here :D how smart am i  :D
    @PutMapping("/UpdateMarque/{id}")
    public void UpdateMark(@PathVariable("id") Long id ,@RequestBody Marque marque) throws IOException {
        if(marqueRepository.existsById(id)){
            Marque m = marqueRepository.findByIdMarque(id);
            if(this.bytes !=  null){
                m.setData(this.bytes);
            }
            m.setMarkName(marque.getMarkName());
            marqueService.save(m);
            this.bytes = null;

        }
    }


    // get list of marks
    @GetMapping("/listeMarque")
    public List<Marque> getMarque(){
        return marqueService.getAllMarque();
    }


    // get mark by id
    @GetMapping("/markById/{id}")
    public ResponseEntity<Marque> getMarqueById (@PathVariable Long id){
        if(marqueService.existe(id)){
            //return marqueService.getMarqueById(id);
            return new ResponseEntity<Marque>(marqueService.getMarqueById(id), HttpStatus.OK);


        }else{
            return new ResponseEntity<Marque>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteMarque(@PathVariable Long id){
        marqueService.deleteMarkById(id);
    }


}
