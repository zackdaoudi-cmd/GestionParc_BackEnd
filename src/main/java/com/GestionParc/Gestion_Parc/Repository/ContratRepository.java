package com.GestionParc.Gestion_Parc.Repository;

import com.GestionParc.Gestion_Parc.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository  extends JpaRepository<Contrat,Long> {

}
