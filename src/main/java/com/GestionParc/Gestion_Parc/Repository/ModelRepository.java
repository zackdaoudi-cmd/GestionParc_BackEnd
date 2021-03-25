package com.GestionParc.Gestion_Parc.Repository;

import com.GestionParc.Gestion_Parc.Entity.Model;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {

//    List<Model> findAll(Model idModel,Model modelName);
}
