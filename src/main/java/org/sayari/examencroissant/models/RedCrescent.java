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
public class RedCrescent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resDId;
    private String area;

    @OneToMany()
    private List<Donation> donations;


}
