package com.GestionParc.Gestion_Parc.Services.ServiceImpl;


import com.GestionParc.Gestion_Parc.DTO.DTOConverter.MarqueDtoConverter;
import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import com.GestionParc.Gestion_Parc.Entity.Marque;
import com.GestionParc.Gestion_Parc.Repository.MarqueRepository;
import com.GestionParc.Gestion_Parc.Services.IService.IMarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class  MarqueServiceImpl implements IMarqueService {

    @Autowired
    private  MarqueRepository marqueRepository ;

    @Autowired
    private MarqueDtoConverter marqueDtoConverter;

    // add new marque
    @Override
    public MarqueDto save(MarqueDto marqueDto){
        Marque m = marqueDtoConverter.convertToEntity(marqueDto);
        m = marqueRepository.save(m);
        return marqueDtoConverter.convertToDTO(m);
    }
    // get list marque
    @Override
    public List<MarqueDto> findAll() {

        List<Marque> marqueList =marqueRepository.findAll();
        return marqueDtoConverter.convertToListDTO(marqueList);
    }

    // delete by id
    @Override
    @Transactional
    public void deleteMarkById(Long id){
        marqueRepository.deleteByIdMarque(id);
    }

    @Override
    public MarqueDto getMarqueById(Long id){
        Marque marque  = marqueRepository.findByIdMarque(id);
        return  marqueDtoConverter.convertToDTO(marque);
    }

    //check if marue exisste
    @Override
    public Boolean exists(Long id){
        return marqueRepository.existsById(id);
    }
     /**
      * Get IdMarque and MArkName
      * */
     @Override
     public List<MarqueDto> listIdMarqueAndMarqueName(){
         List<Marque> marqueList =marqueRepository.findAll();
         return marqueDtoConverter.convertToSimpleListDTO(marqueList);

     }
}
