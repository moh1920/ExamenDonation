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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campanyId;

    private String nomCampanya;
    private String address;

    @OneToMany(mappedBy = "company")
    private List<Employe> employes ;
}
