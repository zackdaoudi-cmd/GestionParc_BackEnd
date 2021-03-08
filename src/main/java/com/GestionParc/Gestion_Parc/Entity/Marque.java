package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Marque {

    @Id
    @GeneratedValue
    private Long idMarque;
    private String libelleMarque;
    private String photoMarque;

    @OneToMany
    private Set<Model> model =  new HashSet<Model>();
}
