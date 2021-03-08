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
public class User {
    @Id
    @GeneratedValue
    private Long idUser;

    @OneToMany
    private Set<Vehicule> vehicule = new HashSet<Vehicule>(  );
    private String nomComplet;
    private String email ;
    private String motDePasse;
}
