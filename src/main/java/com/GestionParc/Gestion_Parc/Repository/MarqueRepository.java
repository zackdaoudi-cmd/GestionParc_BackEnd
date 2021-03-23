package com.GestionParc.Gestion_Parc.Repository;

import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import com.GestionParc.Gestion_Parc.Entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MarqueRepository extends JpaRepository<Marque,Long> {

    void deleteByidMarque(Long id);
    Marque findByIdMarque(Long id);
    //List<MarqueDto> findAll();
}
