package com.GestionParc.Gestion_Parc.Services;


import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import com.GestionParc.Gestion_Parc.Entity.Marque;
import com.GestionParc.Gestion_Parc.Repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class  MarqueServiceImpl implements MarqueService {

    @Autowired
    private  MarqueRepository marqueRepository ;



    // add new marque
    @Override
    public MarqueDto save(MarqueDto marque){
        Marque m = new Marque();
        m.setIdMarque(marque.getIdMarque());
        m.setMarkName(marque.getMarkName());
        m.setData(marque.getData());
        m = marqueRepository.save(m);

        MarqueDto  marqueDto=  new MarqueDto();
        marqueDto.setIdMarque(m.getIdMarque());
        marqueDto.setMarkName(m.getMarkName());
        marqueDto.setData(m.getData());

        return marqueDto;
    }

    // get list marque
    @Override
    public List<MarqueDto> findAll() {

        List<Marque> marqueList =marqueRepository.findAll();
        List<MarqueDto> marqueDtoList = new ArrayList<>(  );
        for(int i = 0 ; i < marqueList.size() ; i++){

             MarqueDto marqueDto =  MarqueDto.ConvertMarqueToDto(marqueList.get(i));
             marqueDtoList.add(marqueDto);
        }
        return marqueDtoList;
    }



    // delete by id
    @Override
    @Transactional
    public void deleteMarkById(Long id){
        marqueRepository.deleteByidMarque(id);
    }

    @Override
    public MarqueDto getMarqueById(Long id){

        Marque marque  = marqueRepository.findByIdMarque(id);
        MarqueDto  marqueDto=  new MarqueDto();
        marqueDto.setIdMarque(marque.getIdMarque());
        marqueDto.setMarkName(marque.getMarkName());
        marqueDto.setData(marque.getData());

        return marqueDto;

    }

    //check if marue exisste
    @Override
    public Boolean exists(Long id){
        return marqueRepository.existsById(id);
    }

}
