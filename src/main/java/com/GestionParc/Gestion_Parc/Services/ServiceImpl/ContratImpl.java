package com.GestionParc.Gestion_Parc.Services.ServiceImpl;

import com.GestionParc.Gestion_Parc.DTO.ContratDTO;
import com.GestionParc.Gestion_Parc.DTO.DTOConverter.ContratDTOConverter;
import com.GestionParc.Gestion_Parc.DTO.ModelDto;
import com.GestionParc.Gestion_Parc.Entity.Contrat;
import com.GestionParc.Gestion_Parc.Entity.Model;
import com.GestionParc.Gestion_Parc.Repository.ContratRepository;
import com.GestionParc.Gestion_Parc.Services.IService.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContratImpl implements IContratService {

        @Autowired
        private ContratRepository contratRepository;

        @Autowired
        private ContratDTOConverter contratDTOConverter;

        /**
         * List Contrat */
        @Override
        public List<ContratDTO> listContrat(){
            List<Contrat> contratList = contratRepository.findAll();
            return contratDTOConverter.convertToListDTO(contratList);
        }

        /**
         * Save new Contract*/
        @Override
        public ContratDTO save(ContratDTO contratDTO){
            Contrat contrat = contratDTOConverter.convertToEntity(contratDTO);
            contrat = contratRepository.save(contrat);
            return contratDTOConverter.convertToDTO(contrat);
        }
        @Override
        @Transactional
        public void deletById(Long id ){
            contratRepository.deleteById(id);
        }
}
