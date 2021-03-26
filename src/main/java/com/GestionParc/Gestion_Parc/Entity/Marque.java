package com.GestionParc.Gestion_Parc.Entity;
import lombok.*;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

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

    @OneToMany
    private List<Model> model;

    public Marque(String markName ,byte[] data) {
        this.markName = markName;
        this.data = data;
    }


}
