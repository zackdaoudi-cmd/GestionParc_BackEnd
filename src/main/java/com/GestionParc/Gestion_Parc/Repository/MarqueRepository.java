package com.GestionParc.Gestion_Parc.Repository;

import com.GestionParc.Gestion_Parc.Entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque,Long> {

    void deleteByidMarque(Long id);
    Marque findByIdMarque(Long id);
}
