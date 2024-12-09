package org.sayari.examencroissant.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;
    private String nom;
    private String prenom;
    private String position ;


    @OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
    private List<Donation> donations;

    @ManyToOne()
    private Company company;

}
