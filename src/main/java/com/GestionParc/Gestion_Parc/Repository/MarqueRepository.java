package com.GestionParc.Gestion_Parc.Repository;

import com.GestionParc.Gestion_Parc.DTO.MarqueDto;
import com.GestionParc.Gestion_Parc.Entity.Marque;
import com.GestionParc.Gestion_Parc.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarqueRepository extends JpaRepository<Marque,Long> {

    void deleteByIdMarque(Long id);
    Marque findByIdMarque(Long id);

   // List<Model> findAll(Marque idMarque, Marque markName);
}
