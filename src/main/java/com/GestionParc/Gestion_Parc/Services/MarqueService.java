package com.GestionParc.Gestion_Parc.Services;


import com.GestionParc.Gestion_Parc.Entity.Marque;
import com.GestionParc.Gestion_Parc.Repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class MarqueService {

    @Autowired
    private  MarqueRepository marqueRepository ;


    // add new marque
    public Marque save(Marque marque){
        return marqueRepository.save(marque);
    }

    // get list marque
    public List<Marque> getAllMarque(){
        return marqueRepository.findAll();
    }


    // delete by id
    @Transactional
    public void deleteMarkById(Long id){
        marqueRepository.deleteByidMarque(id);
    }

    public Marque getMarqueById(Long id){
        return marqueRepository.findByIdMarque(id);
    }

    //check if marue exisste
    public Boolean existe(Long id){
        return marqueRepository.existsById(id);
    }
}
