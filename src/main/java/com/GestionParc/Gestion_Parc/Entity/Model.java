package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import java.util.List;


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
    @OnDelete (action=OnDeleteAction.CASCADE)
    private Marque marque;

    @OneToMany
    private List<Vehicule> vehicule ;
    private String modelName;
    private String typeVehicule;

    @Lob
    private byte[] dataImg ;


}
