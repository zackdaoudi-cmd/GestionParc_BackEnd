package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;


import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModel;
    @ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;
    @OneToMany
    private Set<Vehicule> vehicule = new HashSet<Vehicule>();
    private String modelName;
    private String typeVehicule;
    private String modelPicture;
}
