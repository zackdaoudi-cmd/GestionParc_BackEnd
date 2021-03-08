package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;


import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Model {
    @Id
    @GeneratedValue
    private Long idModel;

    @ManyToOne
    @JoinColumn(name = "idMarque")

    private Marque marque;

    @OneToMany
    private Set<Vehicule> vehicule = new HashSet<Vehicule>();

    private String libelleModel;
    private String typeVehicule;
    private String photo;
}
