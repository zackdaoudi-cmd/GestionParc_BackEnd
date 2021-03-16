package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMarque;
    private String markName;
    private String markPictures;
    
  @OneToMany
    private Set<Model> model =  new HashSet<Model>();
}
