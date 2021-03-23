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

    @Lob
    @Column(name="pictures")
    private byte[] data;

    private String namePhoto ;

    @OneToMany
    private Set<Model> model =  new HashSet<Model>();

    public Marque(String markNam ,byte[] data) {
        this.markName = markName;
        this.data = data;
    }
}
