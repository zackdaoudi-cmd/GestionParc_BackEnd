//package com.GestionParc.Gestion_Parc.DTO.DTOConverter;
//
//import com.GestionParc.Gestion_Parc.DTO.ContratDTO;
//import com.GestionParc.Gestion_Parc.DTO.Mapping.BaseDtoConvert.BaseDTOConverter;
//import com.GestionParc.Gestion_Parc.Entity.Contrat;
//import org.assertj.core.util.DateUtil;
//import org.springframework.stereotype.Component;
//
//import org.apache.commons.lang3.time.DateUtils;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class ContratDTOConverter extends BaseDTOConverter<ContratDTO, Contrat> {
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//    /**
//     * do not forget to conver getVehicule to DTO...
//     * :)
//     * */
//    @Override
//    public ContratDTO convertToDTO(Contrat contrat) {
//        ContratDTO contratDTO = new ContratDTO();
//        contratDTO.setIdContrat(contrat.getIdContrat());
//        contratDTO.setReference(contrat.getReference());
//        contratDTO.setLibelleContrat(contrat.getLibelleContrat());
//        //contratDTO.setVehicule(contrat.getVehicule());
//        contratDTO.setStartDate(contrat.getStartDate());
//        contratDTO.setEndDate(contrat.getEndDate());
//        contratDTO.setAgreementPicturesData(contrat.getAgreementPicturesData());
//        contratDTO.setCost(contrat.getCost());
//        contratDTO.setComment(contrat.getComment());
//
//        return  contratDTO;
//    }
//
//    @Override
//    public Contrat convertToEntity(ContratDTO contratDTO) {
//        Contrat contrat = new Contrat(  );
//        contrat.setIdContrat(contratDTO.getIdContrat());
//        contrat.setReference(contratDTO.getReference());
//        contrat.setLibelleContrat(contratDTO.getLibelleContrat());
//       // contrat.setVehicule(contratDTO.getVehicule());
//
//        /**
//         * Convert String To Date */
//        contrat.setStartDate(contratDTO.getStartDate());
//        contrat.setEndDate(contratDTO.getStartDate());
//
//        contrat.setAgreementPicturesData(contratDTO.getAgreementPicturesData());
//        contrat.setCost(contratDTO.getCost());
//        contrat.setComment(contratDTO.getComment());
//
//        return contrat;
//    }
//
//    @Override
//    public List<ContratDTO> convertToListDTO(List<Contrat> contratList) {
//        List<ContratDTO> contratDTOList = new ArrayList<>();
//        for(Contrat contrat : contratList){
//            contratDTOList.add(convertToDTO(contrat));
//        }
//        return contratDTOList;
//    }
//}
package com.GestionParc.Gestion_Parc.DTO.DTOConverter;

import com.GestionParc.Gestion_Parc.DTO.ContratDTO;
import com.GestionParc.Gestion_Parc.DTO.Mapping.BaseDtoConvert.BaseDTOConverter;
import com.GestionParc.Gestion_Parc.Entity.Contrat;
import org.assertj.core.util.DateUtil;
import org.springframework.stereotype.Component;

import org.apache.commons.lang3.time.DateUtils;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContratDTOConverter extends BaseDTOConverter<ContratDTO, Contrat> {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    /**
     * do not forget to conver getVehicule to DTO...
     * :)
     * */
    @Override
    public ContratDTO convertToDTO(Contrat contrat) {
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setIdContrat(contrat.getIdContrat());
        contratDTO.setReference(contrat.getReference());
        contratDTO.setLibelleContrat(contrat.getLibelleContrat());
        contratDTO.setVehicule(contrat.getVehicule());
        contratDTO.setStartDate(contrat.getStartDate());
        contratDTO.setEndDate(contrat.getEndDate());

        if(contrat.getAgreementPicturesData() == null ){
            contratDTO.setAgreementPicturesData(null);

        }else{
            contratDTO.setAgreementPicturesData(contrat.getAgreementPicturesData());

        }
        contratDTO.setCost(contrat.getCost());
        contratDTO.setComment(contrat.getComment());

        return  contratDTO;
    }

    @Override
    public Contrat convertToEntity(ContratDTO contratDTO) {
        Contrat contrat = new Contrat(  );
        contrat.setIdContrat(contratDTO.getIdContrat());
        contrat.setReference(contratDTO.getReference());
        contrat.setLibelleContrat(contratDTO.getLibelleContrat());
        contrat.setVehicule(contratDTO.getVehicule());

        /**
         * Convert String To Date */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime dtoStartDate = contratDTO.getStartDate();
        LocalDateTime dateTimeStartDate =dtoStartDate;
        contrat.setStartDate(dateTimeStartDate);

        LocalDateTime dtoEndtDate = contratDTO.getStartDate();
        LocalDateTime dateTimeEndDate = dtoStartDate;
        contrat.setEndDate(dateTimeEndDate);

        contrat.setAgreementPicturesData(contratDTO.getAgreementPicturesData());
        contrat.setCost(contratDTO.getCost());
        contrat.setComment(contratDTO.getComment());

        return contrat;
    }

    @Override
    public List<ContratDTO> convertToListDTO(List<Contrat> contratList) {

        List<ContratDTO> contratDTOList = new ArrayList<>();
        for(Contrat contrat : contratList){
            contratDTOList.add(convertToDTO(contrat));
        }
        return contratDTOList;
    }
}
